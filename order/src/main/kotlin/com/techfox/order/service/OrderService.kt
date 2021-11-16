package com.techfox.order.service

import com.techfox.order.model.MenuItem
import com.techfox.order.model.Order
import com.techfox.order.model.QOrder.order
import com.techfox.order.repository.OrderRepository
import org.aspectj.lang.annotation.Around
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.*
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.updateFirst
import org.springframework.stereotype.Service

@Service
class OrderService(
    var orderRepository: OrderRepository,
    val mongoTemplate: MongoTemplate
){
    fun order_menu(table_id:String, menuItem: MenuItem){
        //현재 주문에 들어간 테이블이 있는지 체크
        var ex_order = orderRepository.findOne(
            order.status.eq(1).and(order.table.eq(table_id))
        )
        //없으면 첫 주문, 추후 list로 주문을 받는 형식으로 수정 예정
        if(ex_order.isEmpty){
            var table_order = Order()
            table_order.status = 1
            table_order.items = mutableListOf(menuItem)
            table_order.table = table_id
            table_order.extendedPrice = menuItem.price*menuItem.count
            orderRepository.save(table_order)
        }
        else
        {
            var table_order = ex_order.get()
            var found : Boolean = false
            for(item in table_order.items){
                if(item.menu_id==menuItem.menu_id){
                    //수량은 추가 주문 수량이 들어옴, 수량 수정 및 최종 가격 sum
                    item.count += menuItem.count
                    table_order.extendedPrice +=menuItem.price * menuItem.count
                    //저장
                    orderRepository.save(table_order)
                    found=true
                }
            }
            if(found==false){
                //새 메뉴 추가
                var extendedPrice = table_order.extendedPrice + menuItem.price*menuItem.count
                val updatedCount = mongoTemplate.updateFirst<Order>(
                    query(
                        where(Order::table).`is`(table_id)
                    ),
                    Update()
                        .set("extendedPrice",extendedPrice)
                        .addToSet("items",menuItem)
                ).modifiedCount
                println(updatedCount)
            }
        }
        println("one")
    }
}
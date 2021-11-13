package com.techfox.order.Controller

import com.techfox.order.model.MenuItem
import com.techfox.order.model.Order
import com.techfox.order.repository.OrderRepository
import com.techfox.order.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
class OrderController(
    var orderService: OrderService,
    var orderRepository: OrderRepository
) {

    @PostMapping("/store/name/table/{table_id}/order")
    fun order_menu(@PathVariable table_id : String, @RequestBody item: MenuItem){
        orderService.order_menu(table_id,item)
    }
    @GetMapping("/store/name/orders")
    fun get_all_order():List<Order>{
        return orderRepository.findAll()
    }

    @DeleteMapping("/store/name/orders/all")
    fun delete_all(){
        orderRepository.deleteAll()
    }
}
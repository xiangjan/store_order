package com.techfox.order.repository

import com.techfox.order.model.Order
import com.techfox.order.model.QOrder.order
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: MongoRepository<Order,String>, QuerydslPredicateExecutor<Order>


@Repository
class OrderRepositorySupport(
    private val orderRepository: OrderRepository,
    private val mongoTemplate: MongoTemplate
){
    fun findAllActiveOrder(): List<Order> {
        return orderRepository
            .findAll()
    }
}
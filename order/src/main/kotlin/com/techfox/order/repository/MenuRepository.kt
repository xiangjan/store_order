package com.techfox.order.repository

import com.techfox.order.model.Menu
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

@Repository
interface MenuRepository: MongoRepository<Menu,String>, QuerydslPredicateExecutor<Menu>


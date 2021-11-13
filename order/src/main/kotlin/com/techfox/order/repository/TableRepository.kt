package com.techfox.order.repository

import com.techfox.order.model.Table
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository


@Repository
interface TableRepository: MongoRepository<Table,String>, QuerydslPredicateExecutor<Table>
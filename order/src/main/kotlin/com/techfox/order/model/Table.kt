package com.techfox.order.model

import com.querydsl.core.annotations.QueryEntity
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@QueryEntity
@Document(collection = "table")
class Table {
    @Id
    var id: String? = null

    @Field(name="title")
    var title: String =""

    @Field(name="type")
    var t_type: String =""
}
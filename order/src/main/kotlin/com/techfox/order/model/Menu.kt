package com.techfox.order.model

import com.querydsl.core.annotations.QueryEntity
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@QueryEntity
@Document(collection = "menu")
class Menu {

    @Id
    var id: String? = null

    @Field(name="category")
    var category: String =""

    @Field(name="Title")
    var title: String = ""

    @Field(name="price")
    var price:Int = 0

    @Field(name="description")
    var descripption: String= ""
}
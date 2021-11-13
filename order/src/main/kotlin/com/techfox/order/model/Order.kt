package com.techfox.order.model
import com.querydsl.core.annotations.QueryEntity
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
//import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@QueryEntity
@Document(collection = "orders")
class Order {
    @Id
    var id: String? = null

//    @Field(name="transcationId")
//    var transcationId: String =""

    @Field(name="order_date")
    var order_date: LocalDateTime = LocalDateTime.now()

    @Field(name="extendedPrice")
    var extendedPrice: Int = 0

    @Field(name="table")
    var table:String = ""

    @Field(name="menus")
    var items: List<MenuItem> = mutableListOf()

    @Field(name="status")
    var status: Int = 0
}

@Entity
@QueryEntity
class MenuItem {

    var category: String =""

    var menu_id: String = ""

    var title: String = ""

    var price:Int = 0

    var count:Int = 0
//    @Field(name="description")
//    var descripption: String= ""
}

package com.techfox.order.Controller

import com.techfox.order.model.Table
import com.techfox.order.repository.TableRepository
import org.springframework.web.bind.annotation.*


@RestController
class TableController(
    var tableRepository: TableRepository
) {

    @PostMapping("/store/name/table")
    fun insert_table(@RequestBody table: Table):Table{
        return tableRepository.save(table)
    }

    @GetMapping("/store/name/table/all")
    fun get_all_table():List<Table>{
        return tableRepository.findAll()
    }

    @DeleteMapping("/store/name/table/{table_id}")
    fun delete_tabel(@PathVariable table_id: String){
        tableRepository.deleteById(table_id)
    }
}
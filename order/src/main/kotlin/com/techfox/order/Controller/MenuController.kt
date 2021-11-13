package com.techfox.order.Controller

import com.techfox.order.model.Menu
import com.techfox.order.repository.MenuRepository
import com.techfox.order.service.MenuService
import org.springframework.web.bind.annotation.*

@RestController
class MenuController(
    var menuService: MenuService,
    var menuRepository: MenuRepository
) {
    @PostMapping("/store/name/menu")
    fun create_menu(@RequestBody menu: Menu): Menu?{

        return menuService.insert_menu(menu)
    }

    @GetMapping("/store/name/menu/all")
    fun get_all_menu(): List<Menu>{
        return menuRepository.findAll()
    }
}
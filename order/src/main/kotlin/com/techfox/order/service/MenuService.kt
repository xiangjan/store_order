package com.techfox.order.service

import com.techfox.order.model.Menu
import com.techfox.order.model.QMenu.menu
import com.techfox.order.repository.MenuRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuService(
    var menuRepository: MenuRepository
) {
    fun insert_menu(in_menu:Menu):Menu?{
        //check if the menu already in the repository
        val is_exists = menuRepository.exists(
            menu.title.eq(in_menu.title)
        )
        if(is_exists==false){
            return menuRepository.save(in_menu)
        }
        return null
    }
}
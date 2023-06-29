package com.example.springacg.service;

import com.example.springacg.entity.Menu;
import com.example.springacg.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenuList(String name) {

        List<Menu> result = menuMapper.getMenuList(name);
        ArrayList<Menu> firstMenuList = new ArrayList<Menu>();
        ArrayList<Menu> secondMenuList = new ArrayList<Menu>();
        for (int i = 0; i < result.size(); i++) {
            Menu menu = result.get(i);
            if (menu.getParentId() == null) {
                firstMenuList.add(menu);
            } else {
                secondMenuList.add(menu);
            }
        }
        for (Menu firstMenu : firstMenuList) {
            ArrayList <Menu> children = new ArrayList<Menu>();
            for (Menu secondMenu : secondMenuList) {
                if (firstMenu.getId() == secondMenu.getParentId()) {
                    children.add(secondMenu);
                }
            }
            firstMenu.setChildren(children);
        }
        return firstMenuList;
    }
    public Integer addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }

    public Integer updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }
    public Integer deleteMenuById(Integer id) {
        return menuMapper.deleteMenuById(id);
    }
}

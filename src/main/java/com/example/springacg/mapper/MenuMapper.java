package com.example.springacg.mapper;

import com.example.springacg.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MenuMapper {

    List<Menu> getMenuList(String name);
    Integer addMenu(Menu menu);
    Integer updateMenu(Menu menu);
    Integer deleteMenuById(Integer id);
}

package com.example.springacg.controller;

import com.example.springacg.entity.Menu;
import com.example.springacg.service.MenuService;
import com.example.springacg.utils.ResponseStatus;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/getMenuList", method = RequestMethod.GET)
    public ResponseStatus getMenuList(@RequestParam(required = false) String name,
                                      @RequestParam(defaultValue = "0") int pageNo,
                                      @RequestParam(defaultValue = "30") int pageSize) {
        List<Menu> result = menuService.getMenuList(name);

        return ResponseStatus.ok("success", result);
    }
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    public ResponseStatus addMenu(@RequestBody Menu menu) {
        Integer result = menuService.addMenu(menu);
        return ResponseStatus.ok("保存成功！");
    }

    @RequestMapping(value = "/updateMenu", method = RequestMethod.PATCH)
    public ResponseStatus updateMenu(@RequestBody Menu menu) {
        Integer result = menuService.updateMenu(menu);
        if (result == 1) {
            return ResponseStatus.ok("保存成功!");
        }
        return ResponseStatus.error("保存失败!");
    }

    @RequestMapping(value = "/deleteMenuById/{id}", method = RequestMethod.DELETE)
    public ResponseStatus deleteMenuById(@PathVariable Integer id) {
        Integer result = menuService.deleteMenuById(id);
        if (result == 1) {
            return ResponseStatus.ok("删除成功!");
        }
        return ResponseStatus.error("删除失败!");
    }
}


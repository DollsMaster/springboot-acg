package com.example.springacg.controller;

import com.example.springacg.entity.PersonInfo;
import com.example.springacg.service.PersonInfoService;
import com.example.springacg.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonInfoController {
    @Autowired
    PersonInfoService personInfoService;

    @RequestMapping(value = "/findPersonInfoByUserId", method = RequestMethod.GET)
    public ResponseStatus findPersonInfoByUserId(@RequestParam Integer userId) {
        PersonInfo personInfoResult = personInfoService.findPersonInfoByUserId(userId);
        return ResponseStatus.ok("success", personInfoResult);
    }
}

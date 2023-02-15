package com.works.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/note")
public class NoteRestController {
    @GetMapping("list")
    public Map list() {
        Map map = new HashMap();
        map.put("name"," Cengiz");
        map.put("age"," 27");
        map.put("stutus"," true");
        return map;

    }

}

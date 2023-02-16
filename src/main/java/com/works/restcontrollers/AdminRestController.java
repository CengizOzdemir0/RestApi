package com.works.restcontrollers;

import com.works.entities.Admin;
import com.works.entities.Note;
import com.works.services.AdminDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminRestController {

    final AdminDetailService adminDetailService;
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Admin admin) {

        return adminDetailService.register(admin);
    }
    /* admin save Json input
     {
    "username" : "ali@gmail.com",
    "password" : "12345",
    "enable" : true,
    "roles" :[
        {
            "rid":1
        }
    ]

}*/
}

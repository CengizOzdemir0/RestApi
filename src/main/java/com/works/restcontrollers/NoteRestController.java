package com.works.restcontrollers;

import com.works.entities.Note;
import com.works.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteRestController {
   final NoteService noteService;

    @GetMapping("list")
    public Map list() {
        Map map = new HashMap();
        map.put("name"," Cengiz");
        map.put("age"," 27");
        map.put("stutus"," true");
        return map;

    }
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Note note){
       return noteService.save(note);
    }

}

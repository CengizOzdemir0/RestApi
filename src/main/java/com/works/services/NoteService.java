package com.works.services;

import com.works.Utils.RestEnum;
import com.works.entities.Note;
import com.works.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NoteService {
    final NoteRepository noteRepository;

    public ResponseEntity save(Note note){
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            noteRepository.save(note);
            hm.put(RestEnum.status,true);
            hm.put(RestEnum.result,note);
            return new ResponseEntity(note, HttpStatus.OK);
        }catch (Exception ex){
            hm.put(RestEnum.status,false);
            hm.put(RestEnum.errors,ex.getMessage());
            return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);

        }
    }



}

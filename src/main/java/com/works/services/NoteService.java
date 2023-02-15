package com.works.services;

import com.works.entities.Note;
import com.works.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {
    final NoteRepository noteRepository;

    public ResponseEntity save(Note note){
        try {
            noteRepository.save(note);
            return new ResponseEntity(note, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity("",HttpStatus.BAD_REQUEST);
        }
    }



}

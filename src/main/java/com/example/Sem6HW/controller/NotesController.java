package com.example.Sem6HW.controller;

import com.example.Sem6HW.model.Note;
import com.example.Sem6HW.repository.NotesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NotesController {

    private final NotesRepo repo;

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(repo.save(note), HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Note> findNoteById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(repo.findById(id).orElseThrow(), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
        Optional<Note> noteOptional = repo.findById(id);
        if (noteOptional.isPresent()) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

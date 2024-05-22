package com.example.Sem6HW.repository;

import com.example.Sem6HW.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotesRepo extends JpaRepository<Note, Long> {
//    Optional<Note> findById(Long id);
}

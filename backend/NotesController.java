package com.syllabusflow.controller;

import com.syllabusflow.entity.NoteEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*")
public class NotesController {

    private List<NoteEntity> notesDatabase = new ArrayList<>();

    public NotesController() {
        NoteEntity note1 = new NoteEntity();
        note1.setId(1L);
        note1.setSubjectCode("CS3401");
        note1.setSubjectName("Database Management Systems");
        note1.setTitle("Unit 1 to 5 Hand-Written Notes");
        note1.setDownloadLink("https://drive.google.com/file/d/mock1");
        note1.setUpvotes(15);
        note1.setDownvotes(1);

        NoteEntity note2 = new NoteEntity();
        note2.setId(2L);
        note2.setSubjectCode("CS3401");
        note2.setSubjectName("Database Management Systems");
        note2.setTitle("DBMS Solved University Question Papers");
        note2.setDownloadLink("https://drive.google.com/file/d/mock2");
        note2.setUpvotes(32); // High upvotes, dynamic top ranking
        note2.setDownvotes(0);

        notesDatabase.add(note1);
        notesDatabase.add(note2);
    }

    // Dynamic Priority Sorting Concept - Orders dynamically based on Upvote Ratings
    @GetMapping("/subject/{subjectCode}")
    public ResponseEntity<List<NoteEntity>> getNotesBySubject(@PathVariable String subjectCode) {
        List<NoteEntity> sortedNotes = notesDatabase.stream()
                .filter(note -> note.getSubjectCode().equalsIgnoreCase(subjectCode))
                .sorted((n1, n2) -> Integer.compare(n2.getUpvotes(), n1.getUpvotes()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(sortedNotes);
    }

    @PostMapping("/{id}/upvote")
    public ResponseEntity<NoteEntity> upvoteNote(@PathVariable Long id) {
        for (NoteEntity note : notesDatabase) {
            if (note.getId().equals(id)) {
                note.setUpvotes(note.getUpvotes() + 1);
                return ResponseEntity.ok(note);
            }
        }
        return ResponseEntity.notFound().build();
    }
}

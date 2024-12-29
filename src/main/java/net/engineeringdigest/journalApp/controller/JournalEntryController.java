package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntity;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<List<JournalEntity>> getAllJournal() {
        List<JournalEntity> journalEntityList = journalEntryService.getAllJournal();
        if (journalEntityList != null) {
            return new ResponseEntity<>(journalEntityList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<JournalEntity> addJournal(@RequestBody JournalEntity journalEntity) {
        try {
            return new ResponseEntity<>(journalEntryService.addJournal(journalEntity), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntity> getJournal(@PathVariable String id) {

       JournalEntity journalEntity = journalEntryService.getJournal(id);
        if (journalEntity != null) {
            return new ResponseEntity<>(journalEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JournalEntity> deleteJournal(@PathVariable String id) {
        journalEntryService.deleteJournal(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntity> updateJournal(@PathVariable String id, @RequestBody JournalEntity journalEntity) {
        JournalEntity journalEntity1 = journalEntryService.updateJournal(id, journalEntity);
        if (journalEntity1 != null) {
            return new ResponseEntity<>(journalEntity1, HttpStatus.OK);
        }
        return new ResponseEntity<>(journalEntity1, HttpStatus.NO_CONTENT);
    }

}

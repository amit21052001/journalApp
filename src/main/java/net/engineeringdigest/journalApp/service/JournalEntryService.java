package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntity;
import net.engineeringdigest.journalApp.repository.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public JournalEntity addJournal(JournalEntity journalEntity) {
        journalEntity.setDate(LocalDate.now());
        journalEntryRepo.save(journalEntity);
        return journalEntity;
    }

    public JournalEntity  getJournal(String id) {
        return journalEntryRepo.findById(id).orElse(null);
    }

    public List<JournalEntity> getAllJournal() {
        return journalEntryRepo.findAll();
    }

    public void deleteJournal(String id) {
         journalEntryRepo.deleteById(id);
    }

    public JournalEntity updateJournal(String id, JournalEntity journalEntity) {
        journalEntity.setId(id);
        JournalEntity oldJournal = journalEntryRepo.findById(id).orElse(null);
        if (oldJournal != null) {
            oldJournal.setTitle(journalEntity.getTitle() != null && !journalEntity.getTitle().isEmpty() ? journalEntity.getTitle() : oldJournal.getTitle());
            oldJournal.setContent(journalEntity.getContent() != null && !journalEntity.getContent().isEmpty() ? journalEntity.getContent() : oldJournal.getContent());
            return journalEntryRepo.save(oldJournal);
        }
        return null;
    }

}

//controller -> service -> repository
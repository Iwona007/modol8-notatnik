package iwona.pl.modol8notatnik.service;

import iwona.pl.modol8notatnik.exception.NoteBookException;
import iwona.pl.modol8notatnik.model.NoteBook;
import iwona.pl.modol8notatnik.repository.NoteBookRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoteBookService {
    private NoteBookRepo noteBookRepo;

    private List<NoteBook> notice;

    @Autowired
    public NoteBookService(NoteBookRepo noteBookRepo) {
        this.noteBookRepo = noteBookRepo;
        this.notice = new ArrayList<>();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        NoteBook noteBook = new NoteBook("title1", "text");
        NoteBook noteBook2 = new NoteBook("title2", "text1");
        noteBookRepo.save(noteBook);
        noteBookRepo.save(noteBook2);
    }

    public List<NoteBook> getAll() {
        return noteBookRepo.findAll();
    }

    public void saveNotice(NoteBook noteBook) {
        noteBookRepo.save(noteBook);
    }

    public NoteBook getById(Long id) {
        return noteBookRepo.findById(id).orElseThrow(() -> new NoteBookException(id));

    }

    public boolean edit(Long id, NoteBook noteBook) {
        getById(id);
        noteBookRepo.save(noteBook);
        return false;
    }

    public void editTitle(String title, String text, Long id) {
        noteBookRepo.editNoteBook(title, text, id);
    }

    public void editText(String text, Long id) {
        noteBookRepo.editText(text, id);
    }

    public void delete(long id) {
        noteBookRepo.deleteById(id);
    }
}

package iwona.pl.modol8notatnik.controller;


import iwona.pl.modol8notatnik.model.NoteBook;
import iwona.pl.modol8notatnik.service.NoteBookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/notice")
public class NoteBookController {

    private NoteBookService noteBookService;

    @Autowired
    public NoteBookController(NoteBookService noteBookService) {
        this.noteBookService = noteBookService;
    }

    @GetMapping
    public List<NoteBook> getAll() {
        return noteBookService.getAll();
    }

    @GetMapping("/{id}")
    public NoteBook getById(@PathVariable Long id) {
        return noteBookService.getById(id);
    }

    @PostMapping("/new")
    public void save(@RequestBody NoteBook noteBook) {
        noteBookService.saveNotice(noteBook);
    }

    @PutMapping("/edit/{id}") // z baza
    public void editNoteBook(@RequestBody NoteBook noteBook, @PathVariable Long id) {
        noteBookService.editNoteBook(noteBook.getTitle(), noteBook.getNotice(),
                  noteBook.getDate(), noteBook.getId());
    }

    @PatchMapping("/notice/{id}")
    public void editNotice(@RequestBody NoteBook noteBook, @PathVariable Long id) {
        noteBookService.editNotice(noteBook.getNotice(), id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        noteBookService.delete(id);
    }
}


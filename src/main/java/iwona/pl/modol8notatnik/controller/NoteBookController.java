package iwona.pl.modol8notatnik.controller;


import iwona.pl.modol8notatnik.model.NoteBook;
import iwona.pl.modol8notatnik.service.NoteBookService;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @PatchMapping("/title/{id}")
    public void editTitle(@RequestBody NoteBook noteBook, @PathVariable Long id) {
        noteBookService.editTitle(noteBook.getTitle(), noteBook.getText(), noteBook.getId());
    }

    @PatchMapping("/text/{id}")
    public void editText(@RequestBody NoteBook noteBook, @PathVariable Long id) {
        noteBookService.editText(noteBook.getText(), id);
    }

    @PutMapping("/edit/{id}")
    public void editNote(@PathVariable Long id, @RequestBody NoteBook noteBook) {
        noteBookService.edit(id, noteBook);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteBookService.delete(id);
    }
}

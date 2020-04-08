package iwona.pl.modol8notatnik.exception;

public class NoteBookException extends RuntimeException{
    public NoteBookException(Long id) {
        super(String.format("NoteBook with given id: %s  doesn't exist", id));
    }
}

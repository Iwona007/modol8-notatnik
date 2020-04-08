package iwona.pl.modol8notatnik.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NoteBookExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NoteBookException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String NoteBookExceptionHandler(NoteBookException ex) {
        return ex.getMessage();
    }
}

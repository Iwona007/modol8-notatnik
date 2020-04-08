package iwona.pl.modol8notatnik.model;

import java.time.LocalDate;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "note_books")
public class NoteBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String title;
    private String notice;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name ="date")
    private LocalDate date;

    public NoteBook(String title , String notice, LocalDate date) {
        this.title = title;
        this.notice = notice;
        this.date = date;
    }

    public NoteBook() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNotice() {
        return notice;
    }

    public NoteBook setNotice(String notice) {
        this.notice = notice;
        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", notice='" + notice + '\'' +
                ", date=" + date +
                '}';
    }
}

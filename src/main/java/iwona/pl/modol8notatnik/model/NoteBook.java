package iwona.pl.modol8notatnik.model;

import javax.persistence.*;

@Entity
@Table(name = "note_books")
public class NoteBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String title;
    private String text;

    public NoteBook(String title , String text) {
        this.title = title;
        this.text = text;
    }
    public NoteBook() {
    }

    public long getId() {
        return id;
    }

    public void setTextId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public NoteBook setText(String text) {
        this.text = text;
        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return "NoteBook {"
                + "textId=" + id
                + "title= " + title + '\''
                + "text= " + text + '\''
                +'}';
    }
}

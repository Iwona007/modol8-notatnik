package iwona.pl.modol8notatnik.repository;


import iwona.pl.modol8notatnik.model.NoteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NoteBookRepo extends JpaRepository<NoteBook, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE note_books SET note_books.title = :title, " +
            " note_books.text = :text WHERE note_books.id = :id", nativeQuery = true)
    void editNoteBook(@Param("title") String title,
              @Param("text") String text, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE note_books SET note_books.text = :text" +
    " WHERE note_books.id = :id", nativeQuery = true)
    void editText(@Param("text") String title, @Param("id") Long id);

//    @Query(value = "SELECT * FROM cars WHERE cars.model = :model", nativeQuery = true)
//    List<Car> findCarsByModelMyImpl(@Param("model") String model);

}

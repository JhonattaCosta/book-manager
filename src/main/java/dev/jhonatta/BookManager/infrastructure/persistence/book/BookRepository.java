package dev.jhonatta.BookManager.infrastructure.persistence.book;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository< BookEntity, Long> {

    List<BookEntity> findByNameContainingIgnoreCase (String name);

    @Query("SELECT DISTINCT b FROM BookEntity b JOIN b.author a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :authorName, '%'))")
    List<BookEntity> findBooksByAuthorNameContaining(@Param("authorName") String authorName);

}

package dev.jhonatta.BookManager.infrastructure.persistence.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository< BookEntity, Long> {

    List<BookEntity> findByNameContainingIgnoreCase (String name);

}

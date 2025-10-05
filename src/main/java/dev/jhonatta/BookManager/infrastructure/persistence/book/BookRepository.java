package dev.jhonatta.BookManager.infrastructure.persistence.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository< BookEntity, Long> {
}

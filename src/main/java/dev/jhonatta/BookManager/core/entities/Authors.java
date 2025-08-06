package dev.jhonatta.BookManager.core.entities;

import java.time.LocalDate;
import java.util.List;

public record Authors(Long  id,
                      String name,
                      LocalDate birtDate,
                      List<Books> books) {
}

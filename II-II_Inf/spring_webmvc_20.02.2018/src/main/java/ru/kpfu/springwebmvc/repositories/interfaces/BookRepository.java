package ru.kpfu.springwebmvc.repositories.interfaces;

import ru.kpfu.springwebmvc.models.Book;

/**
 * Created by Roman on 24.02.2018.
 */
public interface BookRepository {
    Book findById(Long id);
}

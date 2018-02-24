package ru.kpfu.springwebmvc.services.interfaces;

import ru.kpfu.springwebmvc.models.Book;

/**
 * Created by Roman on 24.02.2018.
 */
public interface BookService {
    Book getBookById(Long id);
}

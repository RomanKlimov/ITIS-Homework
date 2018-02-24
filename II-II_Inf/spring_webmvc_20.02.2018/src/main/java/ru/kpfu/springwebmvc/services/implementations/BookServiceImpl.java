package ru.kpfu.springwebmvc.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.springwebmvc.models.Book;
import ru.kpfu.springwebmvc.repositories.implementations.BookRepositoryImpl;
import ru.kpfu.springwebmvc.repositories.interfaces.BookRepository;
import ru.kpfu.springwebmvc.services.interfaces.BookService;

/**
 * Created by Roman on 24.02.2018.
 */
@Service
public class BookServiceImpl implements BookService{



    @Autowired
    BookRepositoryImpl bookRepository;

    @Override
    public Book getBookById(Long id) {
        return this.bookRepository.findById(id);
    }
}

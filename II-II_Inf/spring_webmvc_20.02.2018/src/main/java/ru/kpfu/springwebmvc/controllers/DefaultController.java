package ru.kpfu.springwebmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.springwebmvc.models.Book;
import ru.kpfu.springwebmvc.services.implementations.BookServiceImpl;
import ru.kpfu.springwebmvc.services.interfaces.BookService;

/**
 * 
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
@Controller
public class DefaultController {

  private BookServiceImpl bookService;

  @Autowired
  public DefaultController(BookServiceImpl bookService){
    this.bookService = bookService;
  }

  @RequestMapping("/getStaticBook")
  @ResponseBody
  public String getSimpleMessage(){

    Book book = new Book();
    book.setName("Harry Potter");
    book.setAuthor("Rolling");


    return book.toString();

  }

  @RequestMapping("/getBookFromDB")
  @ResponseBody
  public String getComplexMessage(){
    return this.bookService.getBookById(2L).toString();
  }
}
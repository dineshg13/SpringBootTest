package controller;

import dao.BookDao;
import model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import util.MyUtils;

import java.util.List;

/**
 * Created by Dinesh on 7/19/2015.
 */
@RestController
public class BookController {

    private Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/books", produces = "application/json")
    @ResponseBody
    public List<Book> get() {
        LOGGER.info("Received the request");
        List<Book> books = MyUtils.makeList(bookDao.findAll());
        LOGGER.info("returning the books:" + books.size());
        return books;
    }
}

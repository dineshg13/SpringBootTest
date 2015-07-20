package controller;

import dao.AuthorDao;
import model.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import util.MyUtils;

import java.util.List;

/**
 * Created by Dinesh on 7/19/2015.
 */
@RestController
public class AuthorController {

    private Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorDao authorDao;

    @RequestMapping(value = "/author", produces = "application/json")
    @ResponseBody
    public List<Author> get() {
        LOGGER.info("Received the request");
        List<Author> authors = MyUtils.makeList(authorDao.findAll());
        LOGGER.info("returning the authors:" + authors.size());
        return authors;
    }
}

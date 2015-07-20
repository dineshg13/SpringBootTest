package dao;

import model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookDao extends CrudRepository<Book, Integer> {

}

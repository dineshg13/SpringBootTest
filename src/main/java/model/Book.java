package model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@Column(name = "bookId")
	private int bookId;

	private String bookName;

	private Date created;
	private Date updated;

	@PrePersist
	protected void onCreate() {
		created = new Date(System.currentTimeMillis());
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date(System.currentTimeMillis());
	}

	@JsonManagedReference
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "bookId") }, inverseJoinColumns = { @JoinColumn(name = "authorId") })
	private List<Author> bookAuthors;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;

	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<Author> getBookAuthors() {
		return bookAuthors;
	}

	public void setBookAuthors(List<Author> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookAuthors=" + bookAuthors + "]";
	}

}

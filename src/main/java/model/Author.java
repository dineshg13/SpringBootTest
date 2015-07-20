package model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table(name = "authors")
@Entity
public class Author {

	@Id
	@Column(name = "authorId")
	private int authorId;
	private String authorName;

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

	@ManyToMany(mappedBy = "bookAuthors")
	@JsonBackReference
	private List<Book> books;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName
				+ "]";
	}

}

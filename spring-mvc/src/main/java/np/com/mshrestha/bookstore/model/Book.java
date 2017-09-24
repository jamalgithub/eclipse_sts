package np.com.mshrestha.bookstore.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "book")
public class Book {

	private Long id;
	private String name;
	private String code;
	private String price;
	private String authors;
	private String isbn;
	private String publisher;
	private Date publishedOn;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@NotNull
	@Column(nullable = false)
	public String getName() {
		return name;
	}

	@NotNull
	@Size(min=5,max=15)
	@Column(length = 15, nullable = false)
	public String getCode() {
		return code;
	}

	@NotNull
	@Size(min=2,max=10,message="{book.price.size.message}")
	@Column(length = 10)
	public String getPrice() {
		return price;
	}

	@NotNull
	@Column(nullable = false)
	public String getAuthors() {
		return authors;
	}

	@NotNull
	@Column
	public String getIsbn() {
		return isbn;
	}

	@NotNull
	@Column
	public String getPublisher() {
		return publisher;
	}

	@NotNull
	@Column(name = "published_date")
	public Date getPublishedOn() {
		return publishedOn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

}

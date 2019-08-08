package models;


import io.ebean.Model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class BookModel extends Model{

    @Id
    @Column(name = "isbn")
    private int isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "sector")
    private String sector;

    @Column(name = "publicationDate")
    private String publicationDate;

    @Column(name = "borrowedDate")
    private String borrowedDate;

    @Column(name = "borrowedTime")
    private int borrowedTime;

    @ManyToOne
    @JoinColumn(name = "reader", referencedColumnName = "readerId")
    private ReaderModel reader;

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "authorId")
    private AuthorModel author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "totalnoPages")
    private int totalnoPages;

    @ManyToMany(mappedBy = "books")
    private List<AuthorModel> authors;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public int getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(int borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    public ReaderModel getReader() {
        return reader;
    }

    public void setReader(ReaderModel reader) {
        this.reader = reader;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getTotalnoPages() {
        return totalnoPages;
    }

    public void setTotalnoPages(int totalnoPages) {
        this.totalnoPages = totalnoPages;
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorModel> authors) {
        this.authors = authors;
    }
}

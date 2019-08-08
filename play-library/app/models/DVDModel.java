package models;

import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name = "dvds")
public class DVDModel extends Model {

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

    @Column(name = "avail_languages")
    private String avail_languages;

    @Column(name = "avail_subtitiles")
    private String avail_subtitiles;


    @Column(name = "producer")
    private String producer;

    @ManyToOne
    @JoinColumn(name = "actor", referencedColumnName = "actorId")
    private ActorModel actor;

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

    public String getAvail_languages() {
        return avail_languages;
    }

    public void setAvail_languages(String avail_languages) {
        this.avail_languages = avail_languages;
    }

    public String getAvail_subtitiles() {
        return avail_subtitiles;
    }

    public void setAvail_subtitiles(String avail_subtitiles) {
        this.avail_subtitiles = avail_subtitiles;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public ActorModel getActor() {
        return actor;
    }

    public void setActor(ActorModel actor) {
        this.actor = actor;
    }
}

package services;

import dto.Book;
import dto.DVD;
import dto.Reader;
import dto.Report;

import java.text.ParseException;
import java.util.List;

public interface LibraryManager {

    // GET Methods
    List<Book> getAllBooks();

    List<DVD> getAllDVDs();

    List<Reader> getAllReaders();

    //Generate Report

    List<Report> getReport();

    //POST Methods
    String addBook(int isbn, String title, String sector, String publicationDate, String borrowedDate, String readerName,
                   String authorName, String publisher, int totalnoPages);

    String addDvd(int isbn, String title, String sector, String publicationDate, String borrowedDate, String readerName,
                  String avail_languages, String avail_subtitiles, String producer, String actorName);

    //AddReader
    String addReader(String readerName);

    //BorrowItem
    String borrowItem(int isbn, String readerName);

    String returnItem(int isbn) throws ParseException;

    //DeleteItems
    String deleteItem(int isbn);
}

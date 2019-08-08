package services;


import dto.Actor;
import dto.Author;
import dto.DVD;
import dto.Report;
import dto.Book;
import dto.Reader;

import io.ebean.Ebean;
import models.*;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class WestminsterLibraryManager implements LibraryManager {


    private String displaymessage;
    private boolean authorAvailable, actorAvailable, readerAvailable, bookAvailable, dvdAvailable;
    private boolean BookIsbnAvailable, DvdIsbnAvailable;
    private AuthorModel authorCheck;
    private ActorModel actorCheck;
    private ReaderModel readerCheck;
    private BookModel bookCheck;
    private DVDModel dvdCheck;
    private double fee;


    //BorrowDate = todayDate
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    String todayDate = formatter.format(date);


    LocalDateTime currentTime = LocalDateTime.now();
    int hours = currentTime.getHour();

    @Override
    public String addBook(int isbn, String title, String sector, String publicationDate, String borrowedDate, String readerName,
                          String authorName, String publisher, int totalnoPages) {
        BookModel book = new BookModel();
        int bookCount = Ebean.find(BookModel.class).findCount();

        if (String.valueOf(isbn).length() == 4) {
            //ISBN OK
            //Check ISBN
            List<BookModel> bookIsbn = Ebean.find(BookModel.class).findList();
            for (BookModel chkList : bookIsbn) {
                if (isbn == chkList.getIsbn()) {
                    BookIsbnAvailable = true;
                    break;
                }
            }

            List<DVDModel> dvdIsbn = Ebean.find(DVDModel.class).findList();
            for (DVDModel chkList : dvdIsbn) {
                if (isbn == chkList.getIsbn()) {
                    DvdIsbnAvailable = true;
                    break;
                }
            }
            //Check Author Details
            List<AuthorModel> chkAuthor = Ebean.find(AuthorModel.class).findList();
            for (AuthorModel chkList : chkAuthor) {
                if (authorName.equals(chkList.getAuthorName())) {
                    actorAvailable = true;
                    authorCheck = chkList;
                    break;
                }
            }
            if (BookIsbnAvailable || DvdIsbnAvailable) {
                displaymessage = "BookIsbnAvailable";
                BookIsbnAvailable = false;
                DvdIsbnAvailable = false;
            } else {
                if (bookCount <= 100) {
                    book.setIsbn(isbn);
                    book.setTitle(title);
                    book.setSector(sector);
                    book.setPublicationDate(publicationDate);
                    book.setBorrowedDate("Not Borrowed");
                    book.setBorrowedTime(0);
                    book.setReader(null);

                    if (authorAvailable) {
                        book.setAuthor(authorCheck);
                        authorAvailable = false;
                    } else {
                        AuthorModel author = new AuthorModel();
                        author.setAuthorName(authorName);
                        Ebean.save(author);
                        book.setAuthor(author);
                    }
                    book.setPublisher(publisher);
                    book.setTotalnoPages(totalnoPages);
                    Ebean.save(book);
                    displaymessage = "AddBook";
                } else {
                    displaymessage = "BookFull";
                }
            }
        } else {
            displaymessage = "BIsbnNotValid";
        }
        return displaymessage;
    }

    @Override
    public String addDvd(int isbn, String title, String sector, String publicationDate, String borrowedDate, String readerName,
                         String avail_languages, String avail_subtitiles, String producer, String actorName) {
        DVDModel dvds = new DVDModel();
        int dvdsCount = Ebean.find(DVDModel.class).findCount();

        if (String.valueOf(isbn).length() == 4) {
            //Check ISBN
            List<BookModel> bookIsbn = Ebean.find(BookModel.class).findList();
            for (BookModel chkList : bookIsbn) {
                if (isbn == chkList.getIsbn()) {
                    BookIsbnAvailable = true;
                    break;
                }
            }

            List<DVDModel> dvdIsbn = Ebean.find(DVDModel.class).findList();
            for (DVDModel chkList : dvdIsbn) {
                if (isbn == chkList.getIsbn()) {
                    DvdIsbnAvailable = true;
                    break;
                }
            }
            if (BookIsbnAvailable || DvdIsbnAvailable) {
                displaymessage = "DvDvdIsbnAvailable";
                BookIsbnAvailable = false;
                DvdIsbnAvailable = false;
            } else {
                if (dvdsCount <= 50) {
                    dvds.setIsbn(isbn);
                    dvds.setSector(sector);
                    dvds.setTitle(title);
                    dvds.setPublicationDate(publicationDate);
                    dvds.setBorrowedDate("Not Borrowed");
                    dvds.setBorrowedTime(0);
                    dvds.setReader(null);
                    dvds.setAvail_languages(avail_languages);
                    dvds.setAvail_subtitiles(avail_subtitiles);
                    dvds.setProducer(producer);

                    //Check Author Details
                    List<ActorModel> chkCreator = Ebean.find(ActorModel.class).findList();
                    for (ActorModel chkList : chkCreator) {
                        if (actorName.equals(chkList.getActorName())) {
                            actorAvailable = true;
                            actorCheck = chkList;
                            break;
                        }
                    }
                    if (actorAvailable) {
                        dvds.setActor(actorCheck);
                        actorAvailable = false;
                    } else {
                        ActorModel actor = new ActorModel();
                        actor.setActorName(actorName);
                        Ebean.save(actor);
                        dvds.setActor(actor);
                    }
                    //---

                    Ebean.save(dvds);
                    displaymessage = "AddDvd";
                } else {
                    displaymessage = "DvdFull";
                }
            }
        } else {
            displaymessage = "DvdIsbnNotValid";
        }
        return displaymessage;

    }

    //Add Reader
    @Override
    public String addReader(String reader_name) {
        List<ReaderModel> chkReader = Ebean.find(ReaderModel.class).findList();
        for (ReaderModel chkRList : chkReader) {
            if (reader_name.equals(chkRList.getReaderName())) {
                readerAvailable = true;
                break;
            }
        }
        if (readerAvailable) {
            displaymessage = "ReaderAvailable";
            readerAvailable = false;
        } else {
            ReaderModel reader = new ReaderModel();
            reader.setReaderName(reader_name);
            Ebean.save(reader);
            displaymessage = "AddReader";
        }
        return (displaymessage);
    }

    //GET Data
    @Override
    public List<Book> getAllBooks() {

        List<BookModel> bookModels = Ebean.find(BookModel.class).findList();
        List<Book> books = new ArrayList<>();

        for (BookModel bookModel : bookModels) {
            Book book = getBookObjectbyModel(bookModel);
            books.add(book);
        }
        return books;
    }

    //GET DVDs Data
    @Override
    public List<DVD> getAllDVDs() {

        List<DVDModel> dvdModels = Ebean.find(DVDModel.class).findList();
        List<DVD> dvds = new ArrayList<>();

        for (DVDModel dvdModel : dvdModels) {
            DVD dvd = getDVDObjectbyModel(dvdModel);
            dvds.add(dvd);
        }
        return dvds;
    }

    //SQL Data Get to the Object Files
    //DVD Objects
    private DVD getDVDObjectbyModel(DVDModel dvdModel) {
        DVD dvd = new DVD();
        dvd.setIsbn(dvdModel.getIsbn());
        dvd.setTitle(dvdModel.getTitle());
        dvd.setSector(dvdModel.getSector());
        dvd.setPublicationDate(dvdModel.getPublicationDate());
        dvd.setBorrowed_Date(dvdModel.getBorrowedDate());

        Reader reader = getReaderObjectbyModel(dvdModel.getReader());
        dvd.setReaderName(reader);

        dvd.setAvail_languages(dvdModel.getAvail_languages());
        dvd.setAvail_subtitiles(dvdModel.getAvail_subtitiles());
        dvd.setProducer(dvdModel.getProducer());


        Actor actor = getActorObjectbyModel(dvdModel.getActor());
        dvd.setActors(actor);

        return dvd;
    }

    @Override
    public List<Reader> getAllReaders() {

        List<ReaderModel> readerModels = Ebean.find(ReaderModel.class).findList();
        List<Reader> readers = new ArrayList<>();

        for (ReaderModel readerModel : readerModels) {
            Reader reader = getReaderObjectbyModel(readerModel);
            readers.add(reader);
        }
        return readers;
    }


    @Override
    public List<Report> getReport() {
        List<ReportModel> reportModels = Ebean.find(ReportModel.class).findList();
        List<Report> report = new ArrayList<>();
        for(ReportModel reportModel : reportModels){
            Report reports = getReportObjectbyModel(reportModel);
            report.add(reports);
        }
        return report;
    }


    private Book getBookObjectbyModel(BookModel bookModel) {
        Book book = new Book();
        book.setIsbn(bookModel.getIsbn());
        book.setTitle(bookModel.getTitle());
        book.setSector(bookModel.getSector());
        book.setPublicationDate(bookModel.getPublicationDate());
        book.setBorrowed_Date(bookModel.getBorrowedDate());

        Reader reader = getReaderObjectbyModel(bookModel.getReader());
        book.setReaderName(reader);

        Author author = getAuthorObjbyModel(bookModel.getAuthor());
        book.setAuthors(Arrays.asList(author));

        book.setPublisher(bookModel.getPublisher());
        book.setTotalnoPages(bookModel.getTotalnoPages());
        return book;
    }


    private Reader getReaderObjectbyModel(ReaderModel readerModel) {
        Reader reader = new Reader();
        try {
            reader.setReaderId(readerModel.getReaderId());
            reader.setReaderName(readerModel.getReaderName());
        } catch (NullPointerException e) {
            reader.setReaderId(9999);
            reader.setReaderName("NoReader");
        }
        return reader;
    }


    private Author getAuthorObjbyModel(AuthorModel authorModel) {
        Author author = new Author();
        author.setAuthorId(authorModel.getAuthorId());
        author.setAuthorName(authorModel.getAuthorName());
        return author;
    }


    private Actor getActorObjectbyModel(ActorModel actorModel) {
        Actor actor = new Actor();
        actor.setActorId(actorModel.getActorId());
        actor.setActorName(actorModel.getActorName());
        return actor;
    }


    private Report getReportObjectbyModel(ReportModel reportModel) {
        Report report = new Report();
        report.setIsbn(reportModel.getIsbn());
        report.setItemName(reportModel.getItemName());
        report.setReaderName(reportModel.getReaderName());
        report.setBorrowDate(reportModel.getBorrowDate());
        report.setReturnDate(reportModel.getReturnDate());
        report.setDays(reportModel.getDays());
        report.setFee(reportModel.getFee());
        return report;
    }


    //BorrowItems
    @Override
    public String borrowItem(int isbn, String reader_name) {


        //Check Reader
        List<ReaderModel> chkReader = Ebean.find(ReaderModel.class).findList();
        for (ReaderModel chkRList : chkReader) {
            if (reader_name.equals(chkRList.getReaderName())) {
                readerAvailable = true;
                readerCheck = chkRList;
                break;
            }
        }

        //Check ISBN
        List<BookModel> bookIsbn = Ebean.find(BookModel.class).findList();
        for (BookModel chkList : bookIsbn) {
            if (isbn == chkList.getIsbn()) {
                BookIsbnAvailable = true;
                if (chkList.getReader() == null) {
                    bookAvailable = true;
                }
                bookCheck = chkList;
                break;
            }
        }

        List<DVDModel> dvdIsbn = Ebean.find(DVDModel.class).findList();
        for (DVDModel chkList : dvdIsbn) {
            if (isbn == chkList.getIsbn()) {
                DvdIsbnAvailable = true;
                if (chkList.getReader() == null) {
                    dvdAvailable = true;
                }
                dvdCheck = chkList;
                break;
            }
        }

        //Error Messages
        int isbn_marks, item_marks, reader_marks, total;
        if (!(BookIsbnAvailable && DvdIsbnAvailable)) {
            isbn_marks = 1;
        } else {
            isbn_marks = 0;
        }
        if (!(bookAvailable && dvdAvailable)) {
            item_marks = 2;
        } else {
            item_marks = 0;
        }
        if (!readerAvailable) {
            reader_marks = 5;
        } else {
            reader_marks = 0;
        }
        total = isbn_marks + item_marks + reader_marks;
        switch (total) {
            case 8:
                displaymessage = "IsbnReaderNotAvailable";
                break;
            case 5:
                displaymessage = "ReaderNotAvailable";
                break;
            case 7:
                displaymessage = "ItemReaderNotAvailable";
                break;
            case 3:
                displaymessage = "IsbnNotAvailable";
                break;
        }

        if (BookIsbnAvailable) {
            if (bookAvailable) {
                if (readerAvailable) {
                    bookCheck.setBorrowedDate(todayDate);
                    bookCheck.setReader(readerCheck);
                    bookCheck.setBorrowedTime(hours);
                    Ebean.update(bookCheck);
                    displaymessage = "BorrowedItem";
                }
            }
        }
        if (DvdIsbnAvailable) {
            if (dvdAvailable) {
                if (readerAvailable) {
                    dvdCheck.setBorrowedDate(todayDate);
                    dvdCheck.setReader(readerCheck);
                    dvdCheck.setBorrowedTime(hours);
                    Ebean.update(dvdCheck);
                    displaymessage = "BorrowedItem";
                }
            }
        }
        //All False
        BookIsbnAvailable = false;
        DvdIsbnAvailable = false;
        readerAvailable = false;
        bookAvailable = false;
        dvdAvailable = false;
        total = 0;
        //---
        return displaymessage;
    }

    //ReturnItem
    @Override
    public String returnItem(int isbn) throws ParseException {
        DecimalFormat df2 = new DecimalFormat(".##");
        //Check ISBN
        List<BookModel> bookIsbn = Ebean.find(BookModel.class).findList();
        for (BookModel chkList : bookIsbn) {
            if (isbn == chkList.getIsbn()) {
                BookIsbnAvailable = true;
                break;
            }
        }

        List<DVDModel> dvdIsbn = Ebean.find(DVDModel.class).findList();
        for (DVDModel chkList : dvdIsbn) {
            if (isbn == chkList.getIsbn()) {
                DvdIsbnAvailable = true;
                break;
            }
        }

        if (!(BookIsbnAvailable && DvdIsbnAvailable)) {
            displaymessage = "IsbnNotAvailable";
        }

        //Book Return
        List<BookModel> bookIsbnc = Ebean.find(BookModel.class).findList();
        for (BookModel chkList : bookIsbnc) {
            if (isbn == chkList.getIsbn() && !(chkList.getReader() == null)) {

                //Report
                ReportModel report = new ReportModel();
                report.setIsbn(chkList.getIsbn());
                report.setItemName(chkList.getTitle());
                report.setReaderName(chkList.getReader().getReaderName());
                report.setBorrowDate(chkList.getBorrowedDate());
                report.setReturnDate(todayDate);

                //Fee
                String b_date = chkList.getBorrowedDate();
                int b_time = chkList.getBorrowedTime();

                int f_date,f_time;

                DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date1 = dFormat.parse(todayDate);
                Date date2 = dFormat.parse(b_date);
                long timeDifInMillis = date1.getTime() - date2.getTime();

                Date dateDiff = new Date(timeDifInMillis);
                Calendar diffCal = Calendar.getInstance();
                diffCal.setTime(dateDiff);
                int days = diffCal.get(Calendar.DAY_OF_YEAR);

                if(days >= 7){
                    f_time = hours - b_time;
                    if(days == 7){
                        if(f_time <= 0){
                            fee = 0;
                        }else{
                            fee = f_time * 0.2;
                        }
                    }
                    if(days > 7 && days < 10){
                        f_date = days - 7;
                        if(f_time <= 0){
                            fee = (f_date*24)*0.2;
                        }else{
                            fee = ((f_date*24)*0.2) + (f_time * 0.2);
                        }
                    }
                    if(days == 10){
                        if(f_time <= 0){
                            fee = (3*24)*0.2;
                        }else{
                            fee = ((3*24)*0.2) + (f_time * 0.5);
                        }
                    }
                    if(days > 10){
                        f_date = days - 10;
                        if(f_time <= 0){
                            fee = (3*24)*0.2;
                        }else{
                            fee = ((3*24)*0.2) + (f_time * 0.5) + ((f_date*24)*0.5);
                        }
                    }
                }else{
                    fee = 0;
                }
                report.setDays(days);
                report.setFee(Double.parseDouble(df2.format(fee)));
                Ebean.save(report);
                //Update ---
                chkList.setReader(null);
                chkList.setBorrowedDate("Not Borrowed");
                chkList.setBorrowedTime(0);
                displaymessage = Double.toString(Double.parseDouble(df2.format(fee)));
                Ebean.update(chkList);
                break;
            }
        }
        //DVD Return
        List<DVDModel> dvdIsbnc = Ebean.find(DVDModel.class).findList();
        //CheckISBN
        for (DVDModel chkList : dvdIsbnc) {
            if (isbn == chkList.getIsbn() && !(chkList.getReader() == null)) {
                //Report
                ReportModel report = new ReportModel();
                report.setIsbn(chkList.getIsbn());
                report.setItemName(chkList.getTitle());
                report.setReaderName(chkList.getReader().getReaderName());
                report.setBorrowDate(chkList.getBorrowedDate());
                report.setReturnDate(todayDate);

                //Fee
                String b_date = chkList.getBorrowedDate();
                int b_time = chkList.getBorrowedTime();

                int f_date,f_time;

                DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date1 = dFormat.parse(todayDate);
                Date date2 = dFormat.parse(b_date);
                long timeDifInMillis = date1.getTime() - date2.getTime();

                Date dateDiff = new Date(timeDifInMillis);
                Calendar diffCal = Calendar.getInstance();
                diffCal.setTime(dateDiff);
                int days = diffCal.get(Calendar.DAY_OF_YEAR);

                if(days >= 3){
                    f_time = hours - b_time;
                    if(days == 3){
                        if(f_time <= 0){
                            fee = 0;
                        }else{
                            fee = f_time * 0.2;
                        }
                    }
                    if(days > 3 && days < 6){
                        f_date = days - 3;
                        if(f_time <= 0){
                            fee = (f_date*24)*0.2;
                        }else{
                            fee = ((f_date*24)*0.2) + (f_time * 0.2);
                        }
                    }
                    if(days == 6){
                        if(f_time <= 0){
                            fee = (3*24)*0.2;
                        }else{
                            fee = ((3*24)*0.2) + (f_time * 0.5);
                        }
                    }
                    if(days > 6){
                        f_date = days - 6;
                        if(f_time <= 0){
                            fee = (3*24)*0.2;
                        }else{
                            fee = ((3*24)*0.2) + (f_time * 0.5) + ((f_date*24)*0.5);
                        }
                    }
                }else{
                    fee = 0;
                }
                report.setDays(days);
                report.setFee(Double.parseDouble(df2.format(fee)));
                Ebean.save(report);

                //Update ---
                chkList.setReader(null);
                chkList.setBorrowedDate("Not Borrowed");
                chkList.setBorrowedTime(0);
                displaymessage = Double.toString(Double.parseDouble(df2.format(fee)));
                Ebean.update(chkList);
                break;
            }
        }
        return displaymessage;
    }


    //DeleteItems
    @Override
    public String deleteItem(int isbn) {
        if (String.valueOf(isbn).length() == 4) {
            //DeleteBook Model
            List<BookModel> bookIsbn = Ebean.find(BookModel.class).findList();
            //CheckISBN
            for (BookModel chkList : bookIsbn) {
                if (isbn == chkList.getIsbn()) {
                    BookIsbnAvailable = true;
                    bookCheck = chkList;
                    break;
                }
            }
            //DeleteDVD Model
            List<DVDModel> dvdIsbn = Ebean.find(DVDModel.class).findList();
            //CheckISBN
            for (DVDModel chkList : dvdIsbn) {
                if (isbn == chkList.getIsbn()) {
                    DvdIsbnAvailable = true;
                    dvdCheck = chkList;
                    break;
                }
            }
            if (BookIsbnAvailable) {
                Ebean.delete(bookCheck);
                BookIsbnAvailable = false;
                displaymessage = "ItemDeleted";
            } else if (DvdIsbnAvailable) {
                Ebean.delete(dvdCheck);
                DvdIsbnAvailable = false;
                displaymessage = "ItemDeleted";
            } else {
                displaymessage = "IsbnNotAvailable";
            }
        } else {
            displaymessage = "IsbnIncorrect";
        }

        return displaymessage;
    }
}

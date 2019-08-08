package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Book;
import dto.DVD;
import dto.Reader;
import dto.Report;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.LibraryManager;
import services.WestminsterLibraryManager;
import java.text.ParseException;


import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {


    LibraryManager libraryObj = new WestminsterLibraryManager();

    public Result index() {
        List<DVD> dvds = libraryObj.getAllDVDs();
        return ok(Json.toJson(dvds));
    }

    //(/getbooks)
    public Result getBookList() {
        List<Book> books = libraryObj.getAllBooks();
        return ok(Json.toJson(books));
    }

    //(/getdvds)
    public Result getDVDList() {
        List<DVD> dvds = libraryObj.getAllDVDs();
        return ok(Json.toJson(dvds));
    }

    //(/getreaders)
    public Result getReaderList() {
        List<Reader> reader = libraryObj.getAllReaders();
        return ok(Json.toJson(reader));
    }

    //(/getreport)
    public Result getReport() {
        List<Report> report = libraryObj.getReport();
        return ok(Json.toJson(report));
    }

    public Result addBook() {
        JsonNode body = request().body().asJson();
        //Json Body
        int isbn = body.get("isbn").asInt();
        String title = body.get("title").asText();
        String sector = body.get("sector").asText();
        String publicationDate = body.get("publicationDate").asText();
        String borrowedDate = body.get("borrowedDate").asText();
        String reader = body.get("reader").asText();
        String author = body.get("author").asText();
        String publisher = body.get("publisher").asText();
        int totalnoPages = body.get("totalnoPages").asInt();


        String message = libraryObj.addBook(isbn, title, sector, publicationDate, borrowedDate, reader,
                author, publisher, totalnoPages);
        ObjectNode result = Json.newObject();
        result.put("message", message);
        return ok(result);
    }

    public Result addDvds() {
        JsonNode body = request().body().asJson();
        //Json Body
        int isbn = body.get("isbn").asInt();
        String title = body.get("title").asText();
        String sector = body.get("sector").asText();
        String publicationDate = body.get("publicationDate").asText();
        String borrowedDate = body.get("borrowedDate").asText();
        String reader = body.get("reader").asText();
        String avail_languages = body.get("avail_languages").asText();
        String avail_subtitiles = body.get("avail_subtitiles").asText();
        String producer = body.get("producer").asText();
        String actor = body.get("actor").asText();



        String message = libraryObj.addDvd(isbn, title, sector, publicationDate, borrowedDate,
                reader, avail_languages, avail_subtitiles, producer, actor);
        ObjectNode result = Json.newObject();
        result.put("message", message);
        return ok(result);
    }

    public Result addreader() {
        JsonNode body = request().body().asJson();
        //Json Body
        String readerName = body.get("readerName").asText();


        String message = libraryObj.addReader(readerName);
        ObjectNode result = Json.newObject();
        result.put("message", message);
        return ok(result);
    }

    public Result borrowItem() {
        JsonNode body = request().body().asJson();

        int isbn = body.get("isbn").asInt();
        String readerName = body.get("readerName").asText();


        String message = libraryObj.borrowItem(isbn, readerName);
        ObjectNode result = Json.newObject();
        result.put("message", message);
        return ok(result);
    }

    public Result returnItem() throws ParseException {
        JsonNode body = request().body().asJson();
        int isbn = body.get("isbn").asInt();


        String message = libraryObj.returnItem(isbn);
        ObjectNode result = Json.newObject();
        result.put("message", message);
        return ok(result);
    }

    public Result deleteItem() {
        JsonNode body = request().body().asJson();
        int isbn = body.get("isbn").asInt();

        String message = libraryObj.deleteItem(isbn);
        ObjectNode result = Json.newObject();
        result.put("message", message);
        return ok(result);
    }


}

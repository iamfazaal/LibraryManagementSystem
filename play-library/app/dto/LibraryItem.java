package dto;

public abstract class LibraryItem {

    private int isbn;
    private String title;
    private String sector;
    private String publicationDate;
    private String borrowed_Date;
    private int borrowed_Time;
    private Reader readerName;

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

    public String getBorrowed_Date() {
        return borrowed_Date;
    }

    public void setBorrowed_Date(String borrowed_Date) {
        this.borrowed_Date = borrowed_Date;
    }


    public int getBorrowed_Time() {
        return borrowed_Time;
    }

    public void setBorrowed_Time(int borrowed_Time) {
        this.borrowed_Time = borrowed_Time;
    }

    public Reader getReaderName() {
        return readerName;
    }

    public void setReaderName(Reader readerName) {
        this.readerName = readerName;
    }
}

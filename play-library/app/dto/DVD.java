package dto;

public class DVD extends LibraryItem {

    private String avail_languages;
    private String avail_subtitiles;
    private String producer;
    private Actor actors;

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

    public Actor getActors() {
        return actors;
    }

    public void setActors(Actor actors) {
        this.actors = actors;
    }
}

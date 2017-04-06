package entities;


public class Track {
    private Cover cover;
    private Composer composer;
    private String title;
    private String format;
    private String bytes;


    public Track(String title, String format, String bytes) {
        this.title = title;
        this.format = format;
        this.bytes = bytes;
        this.cover = new Cover("standart image");
        this.composer = new Composer("-", "-");
    }

    public String getBytes() {
        return bytes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }
}

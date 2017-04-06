package MusicPackage;

public class Track implements Comparable<Track>{
    private Composer composer;
    private String title;
    private int duration;


    private Cover cover;

    public Track(String title, int duration, Composer composer, Cover cover ) {
        this.title = title;
        this.duration = duration;
        this.composer = composer;
        this.cover = cover;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    @Override
    public int compareTo(Track track){
        return title.compareTo(track.getTitle());
    }


    @Override
    public String toString(){
        return "\nTitle: " + title + " Duration: " + duration + " Composer: " + composer.getName() + " Cover: " + cover.getImage() + "\n";
    }
}

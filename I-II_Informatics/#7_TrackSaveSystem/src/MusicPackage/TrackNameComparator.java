package MusicPackage;

import java.util.Comparator;

public class TrackNameComparator implements Comparator<Track> {

    @Override
    public int compare(Track track1, Track track2){
        return track1.getTitle().compareTo(track2.getTitle());
    }

}

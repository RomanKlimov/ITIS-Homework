package MusicPackage;

import java.util.Comparator;

public class TrackCoverComparator implements Comparator<Track> {

    @Override
    public int compare(Track track1, Track track2){
        return track1.getCover().getImage().compareTo(track2.getCover().getImage());
    }

}

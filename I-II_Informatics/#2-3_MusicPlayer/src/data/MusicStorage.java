package data;
import entities.Track;

public class MusicStorage {
    private DataStorage dataStorage;
    private Track[] trackList;

    public MusicStorage(){
        dataStorage = new InternalDataStorage();
        trackList = new Track[0];
    }

    public void scan(String path) throws DbException{
        try {
            dataStorage.setPath(path);
            dataStorage.scanFiles();
            Object[] objList = dataStorage.getFiles();
            trackList = new Track[objList.length];
            for (int i = 0; i < objList.length; i++) {
                String s = (String)objList[i];
                int q = s.indexOf(" ", s.indexOf(" ") + 1 );
                String format = s.substring(s.indexOf(" "), q );
                String name = s.substring(q, s.indexOf(" ", q +1 ));
                q = s.indexOf(" ", q + 1 );
                String bytes = s.substring(q, s.length());
                if(!(format.equals("mp3") || format.equals("flaac") || format.equals("wav"))) throw new DbException();
                Track track = new Track(name, format, bytes);
                trackList[i] = track;
            }
        } catch (Exception ex) {
            throw new DbException("Ошибка в формате композиций");
        }
    }

    public void scan() throws DbException {
        try {
            dataStorage.scanFiles();
            Object[] objList = dataStorage.getFiles();
            trackList = new Track[objList.length];
            for (int i = 0; i < objList.length; i++) {
                String s = (String) objList[i];
                int q = s.indexOf(" ", s.indexOf(" ") + 1 );
                String format = s.substring(s.indexOf(" "), q );
                String name = s.substring(q, s.indexOf(" ", q +1 ));
                q = s.indexOf(" ", q + 1 );
                String bytes = s.substring(q, s.length());
                if(!(format.equals("mp3") || format.equals("flaac") || format.equals("wav"))) throw new DbException();
                Track track = new Track(name, format, bytes);
                trackList[i] = track;
            }
        } catch (Exception ex) {
            throw new DbException("Ошибка в формате композиций");
        }
    }

    public void setPath(String path) throws DbException{
        dataStorage.setPath(path);
        scan();
    }

    public void deleteTrack(int i) throws DbException {
        dataStorage.deleteFile(i);
        scan();
    }

    public Track getSong(int i){
        Track track = trackList[i];
        return track;
    }

    public int getNumberOfSongs(){
        return trackList.length;
    }
}

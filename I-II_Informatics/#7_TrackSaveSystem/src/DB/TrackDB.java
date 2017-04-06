package DB;

import MusicPackage.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class TrackDB implements DB {

    private ArrayList<Track> arrayList;

    public TrackDB(){
        arrayList = new ArrayList<Track>();
    }


    public void add(Object track){
        if(track instanceof  Track) {
            arrayList.add((Track)track);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void remove(int i){
        if(i < arrayList.size()) {
            arrayList.remove(i);
        } else {
            throw new NoSuchElementException();
        }
    }


    @Override
    public void readDBFromFile() throws DbException {
        try {
            File file = new File("D://code//ITIS-Homework//I-II_Informatics//#7_TrackSaveSystem//src//DB//TracksFile");
            Scanner sc = new Scanner(file);
            String s, title, composerName, image;
            int k, duration;

            while (sc.hasNext()) {
                s = sc.nextLine();
                k = s.indexOf(" ");
                title = s.substring(k + 1, s.indexOf(" ", k + 1));
                k = s.indexOf(" ", k + 1);
                duration = Integer.parseInt(s.substring(k + 1, s.indexOf(" ", k + 1)));
                k = s.indexOf(" ", k + 1);
                composerName = s.substring(k + 1, s.indexOf(" ", k + 1));
                k = s.indexOf(" ", k + 1);
                image = s.substring(k + 1, s.length());

                if(title != null && duration > 0 && composerName != null && image != null) {
                    Composer composer = new Composer(composerName);
                    Cover cover = new Cover(image);
                    Track track = new Track(title, duration, composer, cover);
                    add(track);
                } else throw new DbException();
            }
        } catch (IOException ex) {
           throw new DbException("problem with file");
        } catch (DbException ex) {
            throw new DbException("problem with tracks bytes");
        }
    }

    public void writeDBInFile() throws DbException{
        try {
            File file = new File("D://code//ITIS-Homework//I-II_Informatics//#7_TrackSaveSystem//src//DB//TracksFile");
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            int i = 0;
            Iterator<Track> iterator = arrayList.iterator();
            while (iterator.hasNext()){
                Track track = iterator.next();
                bufferedWriter.append(i + ". " + track.getTitle() + " ");
                bufferedWriter.append(Integer.toString(track.getDuration()) + " ");
                bufferedWriter.append(track.getComposer().getName() + " ");
                bufferedWriter.append(track.getCover().getImage() + "\n");
                i++;
            }
            bufferedWriter.close();
        } catch (IOException ex) {
           throw new DbException("Problem with file");
        }
    }

    public Track partOfNameSearchFirst(String string){
        Iterator<Track> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Track track = iterator.next();
            if(track.getTitle().contains(string)){
                return track;
            }
        }
        return null;
    }

    public ArrayList<Track> partOfNameSearch(String string){
        ArrayList<Track> newArrayList = new ArrayList<>();
        Iterator<Track> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Track track = iterator.next();
            if(track.getTitle().contains(string)){
                newArrayList.add(track);
            }
        }
        return newArrayList;
    }

    public Track trackDurationSearchFirstBigger(int t){
        Iterator<Track> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Track track = iterator.next();
            if(track.getDuration() > t){
                return track;
            }
        }
        return null;
    }

    public Track trackDurationSearchFirstLesser(int t){
        Iterator<Track> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Track track = iterator.next();
            if(track.getDuration() < t){
                return track;
            }
        }
        return null;
    }

    public List<Track> trackDurationSearchLessers(int t){
        ArrayList<Track> newArrayList = new ArrayList<>();
        Iterator<Track> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Track track = iterator.next();
            if(track.getDuration() < t){
                newArrayList.add(track);
            }
        }
        return newArrayList;
    }

    public ArrayList<Track> trackDurationSearchBiggers(int t){
        ArrayList<Track> newArrayList = new ArrayList<>();
        Iterator<Track> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Track track = iterator.next();
            if(track.getDuration() > t){
                newArrayList.add(track);
            }
        }
        return newArrayList;
    }

    public ArrayList<Track> searchByComposer(Composer composer){
        ArrayList<Track> newArrayList = new ArrayList<>();
        Iterator<Track> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Track track = iterator.next();
            if(track.getComposer().getName().equals(composer.getName())){
                newArrayList.add(track);
            }
        }
        return newArrayList;
    }

    public ArrayList<Track> sortByNames(){
        arrayList.sort(new TrackNameComparator());
        return arrayList;
    }

    public ArrayList<Track> sortByDuration(){
        arrayList.sort(new TrackDurationComparator());
        return arrayList;
    }

    public ArrayList<Track> sortByComposer(){
        arrayList.sort(new TrackComposerNameComparator());
        return arrayList;
    }

    public ArrayList<Track> sortByCovers(){
        arrayList.sort(new TrackCoverComparator());
        return arrayList;
    }

    public ArrayList<Track> getArray(){
        return arrayList;
    }


    @Override
    public String toString(){
        int i = 1;
        String s = "";
        Iterator<Track> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Track track = iterator.next();
            s += (i + ". Title: " + track.getTitle() + " Duration: ");
            s += (Integer.toString(track.getDuration()) + " Composer: ");
            s += (track.getComposer().getName() + " Cover ");
            s += (track.getCover().getImage()) + "\n";
            i++;
        }
        return s;
    }



}

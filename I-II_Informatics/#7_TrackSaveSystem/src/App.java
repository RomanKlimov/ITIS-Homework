import DB.DbException;
import DB.TrackDB;
import MusicPackage.Composer;
import MusicPackage.Cover;
import MusicPackage.Track;
import UI.*;

import java.util.Arrays;



public class App extends Application{

    protected UserInteractor terminal;
    protected TrackDB trackDB;

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        App app = new App(args);
    }

    public App(String[] args) {
        super(args);
    }

    @Override
    public void init() {
        try {
            this.terminal = new ConsoleUserInteractor();
            this.trackDB = new TrackDB();
            this.trackDB.readDBFromFile();
        } catch (UserInteractorException ex) {
            System.out.println("Couldn't start application due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (DbException ex){
            System.out.println("Couldn't start application due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void start() {
        try {
            String command;
            while((command = this.terminal.readCommand()) != null){
                switch(command){
                    case "exit":
                        trackDB.writeDBInFile();
                        this.terminal.print("Bye");
                        System.exit(0);
                        break;

                    case "add":
                        this.terminal.print("Enter title, duration, composer name, cover");
                        String s, title, composerName, image;
                        int k, duration;
                            s = terminal.readCommand();
                            k = 0;
                            title = s.substring(k, s.indexOf(" ", k + 1));
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
                            trackDB .add(track);
                        } else throw new DbException();
                        break;

                    case "remove":
                        terminal.print("Enter index");
                        int i = Integer.parseInt(terminal.readCommand());
                        trackDB.remove(i);
                        break;

                    case "search by title":
                        terminal.print("Enter part of Title");
                        String s1 = terminal.readCommand();
                        terminal.print(Arrays.toString(trackDB.partOfNameSearch(s1).toArray()));
                        break;

                    case "search by composer":
                        terminal.print("Enter name of Composer:");
                        String s2 = terminal.readCommand();
                        Composer composer = new Composer(s2);
                        terminal.print(Arrays.toString(trackDB.searchByComposer(composer).toArray()));
                        break;

                    case "search by duration":
                        terminal.print("Enter duration");
                        int dur = Integer.parseInt(terminal.readCommand());
                        terminal.print("Duration of song should be 1. >  2. <  then your duration");
                        String s3 = terminal.readCommand();
                        if(s3.equals(">")) {
                            terminal.print(Arrays.toString(trackDB.trackDurationSearchBiggers(dur).toArray()));
                        } else {
                            terminal.print(Arrays.toString(trackDB.trackDurationSearchLessers(dur).toArray()));
                        }
                        break;

                    case "print":
                        terminal.print(trackDB.toString());
                        break;

                    case "sort by Names":
                        trackDB.sortByNames();
                        break;

                    case "sort by Covers":
                        trackDB.sortByCovers();
                        break;

                    case "sort by Composers":
                        trackDB.sortByComposer();
                        break;

                    case "sort by duration":
                        trackDB.sortByDuration();
                        break;

                    default:
                        this.terminal.print("Unkown command");
                        break;
                }



            }
        } catch (UserInteractorReadException ex) {
            System.out.println("Can't read user input due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (UserInteractorWriteException ex) {
            System.out.println("Can't print data to user due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (DbException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

}


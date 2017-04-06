import UI.*;
import data.*;
import entities.Track;
import etc.PlayerManager;

import java.util.Arrays;


public class App extends Application{

    protected UserInteractor terminal;
    protected MusicStorage musicStorage;
    protected PlayerManager playerManager;

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
            this.musicStorage = new MusicStorage();
            playerManager = PlayerManager.getInstance();
        } catch (UserInteractorException ex) {
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
                        this.terminal.print("Bye");
                        System.exit(0);
                        break;

                    case "play":
                        this.terminal.print("введите номер песни");
                        command = this.terminal.readCommand();
                        Track track = musicStorage.getSong(Integer.parseInt(command)-1);
                        playerManager.play(track);
                        break;


                    case "stop":
                        playerManager.stop();
                        break;

                    case "delete track":
                        this.terminal.print("Enter Number: ");
                        command = terminal.readCommand();
                        musicStorage.deleteTrack(Integer.parseInt(command));
                        break;

                    case "Set path":
                        this.terminal.print("Enter Path: ");
                        command = this.terminal.readCommand();
                        musicStorage.setPath(command);
                        break;

                    case "scan files":
                        musicStorage.scan();
                        break;

                    case "scan files on path":
                        this.terminal.print("Enter Path: ");
                        command = this.terminal.readCommand();
                        musicStorage.scan(command);
                        break;

                    default:
                        this.terminal.print("Unkown command");
                        break;
                }
//        this.terminal.print(command);
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


package etc;

import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;
import data.DbException;
import entities.Track;


public class PlayerManager implements Player{
    private static PlayerManager instance;
    private static int i;
    private static boolean state;
    private Track track;

    private PlayerManager () {
        state = false;
        i = -1;
    }


    //singleton
    public static PlayerManager getInstance()  {
        if (instance == null) {
            instance = new PlayerManager();
        }
        return instance;
    }


    @Override
    public void play(Track track) throws DbException {
        String bytes = track.getBytes();

        Formatter f = FormatFactory.formate(track);
        bytes = f.decode(bytes);
        state = true;
        System.out.print("playing");
    }



    @Override
    public void stop() {
        state = false;
        System.out.print("not playing");
    }
}

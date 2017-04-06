package etc;

import data.DbException;
import entities.Track;

interface Player {
    public void play(Track track) throws DbException;
    public void stop();

}

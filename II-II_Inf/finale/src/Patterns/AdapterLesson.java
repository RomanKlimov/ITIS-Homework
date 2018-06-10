package Patterns;
//позволяет объектам с несовместимыми интерфейсами работать вместе
public class AdapterLesson {
    public static void main(String[] args) {
        PlaneWash planeWash = new PlaneWash();
        planeWash.washPlane(new TrackWrap(new MyTrack()));
    }
}

class TrackWrap implements Plane {
    Track track;
    public TrackWrap(Track track) {
        this.track = track;
    }
    @Override
    public void wash() {
        track.clean();
    }
}

interface Track {
    void clean();
}

class MyTrack implements Track{

    @Override
    public void clean() {
        System.out.println("Track is cleaning");
    }
}

interface Plane {
    void wash();
}

class Tu52 implements Plane {

    @Override
    public void wash() {
        System.out.println("Plane is washing");
    }
}

class PlaneWash {
    public void washPlane(Plane plane) {
        plane.wash();
    }
}
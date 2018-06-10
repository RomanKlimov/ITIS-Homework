package lambdas.Simple;

public class Radio implements ElectricityConcumer {
    public void playMusic() {
        System.out.println("Radio plays");
    }

    @Override
    public void electricityOn(Object sender) {
        playMusic();

    }
}

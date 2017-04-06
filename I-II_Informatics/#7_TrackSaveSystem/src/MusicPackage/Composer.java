package MusicPackage;

public class Composer implements Comparable<Composer> {
    private String name;

    public Composer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Composer composer){
        return name.compareTo(composer.getName());
    }

}

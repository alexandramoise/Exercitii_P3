package problema1;

import java.util.List;

public class Departament {
    String nume, director;
    List <Membru> membri;

    public Departament() {
    }

    public Departament(String nume, String director, List<Membru> membri) {
        this.nume = nume;
        this.director = director;
        this.membri = membri;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "nume='" + nume + '\'' +
                ", director='" + director + '\'' +
                ", membri=" + membri +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Membru> getMembri() {
        return membri;
    }

    public void setMembri(List<Membru> membri) {
        this.membri = membri;
    }

}

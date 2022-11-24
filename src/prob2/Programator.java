package prob2;

public class Programator extends Angajat {
    String limbaj,studii;

    public Programator() {
    }

    public Programator(String nume, int salariu, String limbaj, String studii) {
        super(nume, salariu);
        this.limbaj = limbaj;
        this.studii = studii;
    }

    @Override
    public String toString() {
        return "Programator {" +
                "nume='" + nume + '\'' +
                ", salariu=" + salariu +
                ", limbaj='" + limbaj + '\'' +
                ", studii='" + studii + '\'' +
                '}';
    }
}

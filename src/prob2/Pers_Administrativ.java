package prob2;

public class Pers_Administrativ extends Angajat {
    String departament;

    public Pers_Administrativ() {
    }

    public Pers_Administrativ(String nume, int salariu, String departament) {
        super(nume, salariu);
        this.departament = departament;
    }

    public Pers_Administrativ(String nume, int salariu) {
        super(nume, salariu);
    }

    @Override
    public String toString() {
        return "Pers_Administrativ {" +
                "departament='" + departament + '\'' +
                ", nume='" + nume + '\'' +
                ", salariu=" + salariu +
                '}';
    }

    public String getDepartament() {
        return departament;
    }
}

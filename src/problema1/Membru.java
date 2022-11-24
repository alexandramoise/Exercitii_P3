package problema1;

import java.util.List;

public class Membru {
    String nume;
    int varsta;
    List <String> domenii;

    public Membru() {
    }

    public Membru(String nume, int varsta, List<String> domenii) {
        this.nume = nume;
        this.varsta = varsta;
        this.domenii = domenii;
    }

    @Override
    public String toString() {
        return "Membru{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", domenii=" + domenii +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public List<String> getDomenii() {
        return domenii;
    }

    public void setDomenii(List<String> domenii) {
        this.domenii = domenii;
    }
}

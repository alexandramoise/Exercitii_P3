package problema1; // PRPOBLEMA DEPARTAMENTE

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        // b) - creare si afisare lista de departamente
        List <Departament> departamente = new ArrayList<>();
        creare(departamente);
        System.out.println("---------- LISTA DEPARTAMENTE: ---------------");
        for (Departament de : departamente)
            System.out.println(de);

        // c)
        System.out.println("\n --------- LISTA SORTATA DUPA NR MEDIU DE DOMENII ------------");
        sortare_nr_mediu_de_domenii(departamente);

        //d)
        System.out.println("\n ----------- CEL MAI TANAR / IN VARSTA DIN FIECARE DEP ----------");
        cel_mai_tanar_batran_membru(departamente);

        //e)
        System.out.println("\n ---------- CEL MAI FRECVENT / PUTIN FRECVENT ALES DOMENIU DIN LISTA DE DEP -------");
        cel_mai_frecvent_putin_frecvent_domeniu(departamente);
    }

    public static void creare(List <Departament> dept) {
        // a) - creare obiecte de tipul claselor
        List<String> dom = new ArrayList<>();
        dom.add("info");
        dom.add("mate");

        List<String> dom2 = new ArrayList<>();
        dom2.add("info");
        dom2.add("cercetare");
        dom2.add("domeniu interesant");
        dom2.add("domeniu interesant");

        List<String> dom3 = new ArrayList<>();
        dom3.add("inteligenta artificiala");
        dom3.add("mate");
        dom3.add("fizica");

        List<String> dom4 = new ArrayList<>();
        dom4.add("fizica");
        dom4.add("info");

        Membru m = new Membru("Popescu Ion", 21, dom);
        Membru m2 = new Membru("Ionescu Andrei", 20, dom2);
        Membru m3 = new Membru("Lala Ioana", 25, dom3);
        List<Membru> mem = new ArrayList<>();
        mem.add(m);
        mem.add(m2);
        mem.add(m3);

        Departament d = new Departament("Computer Science", "Flavia Micota", mem);

        List<Membru> mem2 = new ArrayList<>();
        mem2.add(m);
        mem2.add(new Membru("eu", 21, dom4));

        Departament d2 = new Departament("Math", "Profa faina", mem2);

        // b) - crearea listei de departamente
        dept.add(d);
        dept.add(d2);
    }

    public static void sortare_nr_mediu_de_domenii(List <Departament> departamente) {
        Map <String,Integer> compar = new HashMap<>(); // sortez dictionar in care pun numele depart. si nr mediu de domenii
        for (Departament de : departamente) {
            int suma = 0, medie;
            for (Membru m : de.getMembri()) {
                suma += m.getDomenii().size(); // calculez nr de domenii total pt fiecare departament
            }
            medie = (int)suma/de.getMembri().size(); // calculez nr mediu de dom per departament
            compar.put(de.getNume(),medie);
        }

        compar.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println); // afisare in ordine cresc.
    }

    public static void cel_mai_tanar_batran_membru(List <Departament> dep) {
        for(Departament de : dep) {
            int minim = 100, max = 1;
            for(Membru m : de.getMembri()) {
                if (m.getVarsta() < minim)
                    minim = m.getVarsta();
                if (m.getVarsta() > max)
                    max = m.getVarsta();
            }

            for(Membru m : de.getMembri()) {
                if(m.getVarsta() == minim || m.getVarsta() == max)
                    if(minim == max)
                        System.out.println(de.getNume() + " - Singura varsta din departament: " + minim + " la: " + m.getNume());
                    else
                        if(m.getVarsta() == minim)
                            System.out.println(de.getNume() + " - Cel mai tanar: " + m.getNume() + " are " + m.getVarsta() );
                        else
                            System.out.println(de.getNume() + " - Cel mai batran: " + m.getNume() + "are " + m.getVarsta());
            }
        }
    }

    public static void cel_mai_frecvent_putin_frecvent_domeniu(List <Departament> dep) {
        Map <String,Integer> frecventa = new HashMap<>();
        for(Departament d : dep) {
            for(Membru m : d.getMembri()) {
                for(String dom : m.getDomenii())
                    if(frecventa.containsKey(dom))
                        frecventa.put(dom,frecventa.get(dom)+1);
                    else
                        frecventa.put(dom,1);
            }
        }
        int minimum=100,maximum=1;
        for(Map.Entry<String,Integer> pereche : frecventa.entrySet()) {
            if(pereche.getValue() < minimum)
                minimum = pereche.getValue();
            if(pereche.getValue() > maximum)
                maximum = pereche.getValue();
        }

        for(Map.Entry<String,Integer> pereche : frecventa.entrySet()) {
            if(pereche.getValue() == minimum)
                System.out.println("Cel mai putin frecvent: " + pereche.getKey() + ", ales de " + minimum);
            if(pereche.getValue() == maximum)
                System.out.println("Cel mai frecvent: " + pereche.getKey() + ", ales de " + maximum);
        }
    }
}
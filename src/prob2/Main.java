package prob2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // b) creare si afisare lista angajati
        System.out.println("---------- LISTA ANGAJATI ------------");
        List <Angajat> angajati = new ArrayList<>();
        creare(angajati);
        for(Angajat ob : angajati)
            System.out.println(ob);

        // c) sortare dupa salariu, daca au acelasi salariu dupa nume
        System.out.println("----------LISTA SORTATA -----------");
        sortare(angajati);
        for(Angajat an : angajati)
            System.out.println(an);

        // d) dep cu cei mai multi angajati, resp cei mai putini
        System.out.println("-------- CEI MAI MULTI / PUTINI ANGAJATI ----------");
        frecventa(angajati);
    }

    public static void creare(List <Angajat> ang) {
        // a) creare obiecte de tipul claselor
        Programator p = new Programator("super programator",8000,"c++","licenta");
        Pers_Administrativ a = new Pers_Administrativ("ionescu ana",5500,"cercetare");
        Pers_Administrativ b = new Pers_Administrativ("popescu ion",3000,"curatenie");
        Pers_Administrativ c = new Pers_Administrativ("angajat random",2000,"curatenie");
        Programator pr = new Programator("alt programator",8000,"java","master");

        ang.add(p);
        ang.add(a);
        ang.add(b);
        ang.add(pr);
    }

    public static void sortare(List <Angajat> ang) {
        Collections.sort(ang,new Comparator<Angajat>() {
            @Override
            public int compare(Angajat o1,Angajat o2) {
                if(o1.getSalariu() == o2.getSalariu())
                    return o1.getNume().compareTo(o2.getNume()); // pt STRING merge compareTo
                else
                    return o1.getSalariu() - o2.getSalariu(); // pt INT fac scadere
            }
        });
    }

    public static void frecventa(List <Angajat> ang) {
        Map <String,Integer> dic = new HashMap<>();
        List <Pers_Administrativ> l = new ArrayList<>();

        for(Angajat a : ang)
            if(a instanceof Pers_Administrativ)
                l.add((Pers_Administrativ) a);

        for(Pers_Administrativ p : l ){
            if(dic.containsKey(p.getDepartament()))
                dic.put(p.getDepartament(),dic.get(p.getDepartament())+1);
            else
                dic.put(p.getDepartament(),1);
        }

        int minim=100,maxim=1;
        for(Map.Entry<String,Integer> per : dic.entrySet()) {
            if(per.getValue() < minim)
                minim = per.getValue();
            if(per.getValue() > maxim)
                maxim = per.getValue();
        }
        for(Map.Entry<String,Integer> per : dic.entrySet())
        {
            if(per.getValue() == minim)
                System.out.println("Cei mai putini angajati: " + minim + " in depart: " + per.getKey());
            if(per.getValue() == maxim)
                System.out.println("Cei mai multi angajati: " + maxim + " in depart: " + per.getKey());
        }
    }
}

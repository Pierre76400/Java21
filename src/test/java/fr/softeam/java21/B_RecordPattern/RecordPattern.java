package fr.softeam.java21.B_RecordPattern;

import org.junit.jupiter.api.Test;

public class RecordPattern {

    @Test
    public void patternMatching(){
        Object o = "Hello world !";

        if(o instanceof String){
            String s = (String)o;
            System.out.println(s);
        }
    }

    record Rectangle(int largeur, int hauteur) {}
    record Carre(int largeur) {}


    @Test
    public void calculAires(){
        Rectangle rectangle=new Rectangle(2,3);
        Carre carre=new Carre(4);

        System.out.println("Aire rectangle="+ calculerAire(rectangle));
        System.out.println("Aire carre="+ calculerAire(carre));
    }

    static int calculerAire(Object o) {
        if (o instanceof Rectangle rect) {
            int largeur = rect.largeur();
            int hauteur = rect.hauteur();
            return largeur*hauteur;
        }
        if (o instanceof Carre carre) {
            int largeur = carre.largeur();
            return largeur*largeur;
        }
        throw new IllegalStateException("Unexpected value: " + o);
    }






    static int calculerAireJ21Switch(Object o) {
        return switch (o){
            case Rectangle(int largeur, int hauteur) -> largeur*hauteur;
            case Carre(int largeur) -> largeur*largeur;
            default -> throw new IllegalStateException("Unexpected value: " + o);
        };
    }

}

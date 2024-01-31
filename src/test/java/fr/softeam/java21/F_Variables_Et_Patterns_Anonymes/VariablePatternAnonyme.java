package fr.softeam.java21.F_Variables_Et_Patterns_Anonymes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// JEP 443
public class VariablePatternAnonyme {
    @Test
    void test(){
        List<String> numbers= Arrays.asList("One","Two","Three");

        int cpt=0;

        for(String n:numbers){
            System.out.println(cpt++);
        }

        var num=numbers.remove(1);

        try{
            int i = Integer.parseInt("1");
        }catch(NumberFormatException e){
            System.out.println("Valeur non numérique !");
        }
    }

    record Rectangle(int largeur, int hauteur,int couleur) {}

    @Test
    public void patternMatching(){
        Rectangle rectangle=new Rectangle(2,3,12);

        System.out.println("Aire rectangle="+calculerAireJ21(rectangle));
    }

    static int calculerAireJ21(Object o) {
        if (o instanceof Rectangle(int largeur, int hauteur,int couleur)) {
            return largeur*hauteur;
        }
        throw new IllegalStateException("Unexpected value: " + o);
    }
}

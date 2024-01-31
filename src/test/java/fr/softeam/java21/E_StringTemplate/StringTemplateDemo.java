package fr.softeam.java21.E_StringTemplate;

import org.junit.jupiter.api.Test;

import static java.util.FormatProcessor.FMT;

public class StringTemplateDemo {

    //Preview de la JEP 430
    @Test
    void stringTemplate(){
        String nom="Pierre";

        String messageStr=STR."Hello \{nom} in Java";
        System.out.println(messageStr);

        String messageFmt=FMT."Hello %-12s\{nom} in Java";
        System.out.println(messageFmt);
    }

    @Test
    void stringTemplatePlusComplexe(){
        //Supporte les expressions
        int x = 10, y = 20;
        String s = STR."\{x} + \{y} = \{x + y}";
        System.out.println(s);

        //Supporte les méthodes
        String s2 = STR."Hello \{getName()}";
        System.out.println(s2);
    }

    private String getName() {
        return "Pierre";
    }
}

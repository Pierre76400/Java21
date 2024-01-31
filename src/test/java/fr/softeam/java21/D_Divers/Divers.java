package fr.softeam.java21.D_Divers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Divers {
    @Test
    void isEmoji(){
        String penguin = "En ☕ on peut afficher des 🐧";

        System.out.println(penguin);
        for(int cp:penguin.codePoints().toArray()) {
            if (Character.isEmoji(cp)) {
                System.out.println("Emoji " + new String(new int[] { cp }, 0, 1));
            }
        }
    }

    @Test
    void stringBuilderRepeat(){
        StringBuilder sb=new StringBuilder();

        sb.repeat("Hip ",3);

        System.out.println(sb);
    }


    @Test
    void collectionShuffle(){
        List<String> numbers= Arrays.asList("One","Two","Three","For");

        System.out.println("Liste avant :");
        numbers.forEach(s->System.out.println(s));


        System.out.println("Liste mélangée :");
        Collections.shuffle(numbers);
        numbers.forEach(s->System.out.println(s));
    }

    @Test
    void splitWithDelimeters(){
        String numbers="One,Two,Three";

        for(String s:numbers.splitWithDelimiters(",",0)){
            System.out.println(s);
        }
    }
}

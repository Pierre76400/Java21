package fr.softeam.java21.C_SequencedCollection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.SequencedCollection;

public class SequencedCollections {

    @Test
    public void testSequenced(){
        SequencedCollection<String> sequencedCollection=new ArrayList();

        sequencedCollection.add("Two");
        sequencedCollection.addFirst("One");
        sequencedCollection.addLast("Three");

        System.out.println("Ordre normal");
        for(String s:sequencedCollection){
            System.out.println(s);
        }

        System.out.println("\nOrdre inversé");
        for(String s2:sequencedCollection.reversed()){
            System.out.println(s2);
        }
    }
}

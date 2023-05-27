package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Actor doc = new Actor("Docent", "Moscow, Red Square, 02", LocalDate.parse("1952-02-29"),true,15);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try{
            mapper.writeValue(new File("doc.json"),doc);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        try {
            ActorAndFriends[] actor= mapper.readValue(new File("actors.json"), ActorAndFriends[].class);
            System.out.println(Arrays.toString(actor));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
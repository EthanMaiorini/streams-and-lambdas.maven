package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.anthropoid.PersonWarehouse;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;
import io.vavr.collection.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
        PersonFactory people = new PersonFactory();
        Character randomChar = (char)((int)'A'+Math.random()*((int)'Z'-(int)'A'+1));
        Stream<Person> everyone = people.createPersonStream(2000)
                .filter((Person p)->p.getName().charAt(0) == randomChar).limit(100);
        this.personStream = everyone;
        this.startingCharacter = randomChar.toString();
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this.personStream = Stream.of(people).filter((Person p)->p.getName().charAt(0) == startingCharacter);
        this.startingCharacter = startingCharacter.toString();
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this(people.toArray(new Person[people.size()]),startingCharacter);
    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this((Person[]) people.toArray(),startingCharacter);
        //this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
        List<Person> people = new ArrayList<>();
        personStream.forEach((Person p) -> people.add(p));
        return people;
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        return personStream.collect(Collectors.toList());
    }

    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        return personStream.toArray(Person[]::new);
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        Person [] people = personStream.toArray(Person[]::new);
        //Array.fill(people,personStream.forEach(p -> people.add(p)));
        //people = personStream.toArray(Person[]::new);
        return people;
    }

}

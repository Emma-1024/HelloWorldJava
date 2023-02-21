package org.practice2;

class Person implements Comparable<Person> {
    String name;
    int score;

    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(Person other) {
        return other.score-this.score;
    }

    public String toString() {
        return "{" + this.name + "," + this.score + "}";
    }
}
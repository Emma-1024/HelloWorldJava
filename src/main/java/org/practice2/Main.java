package org.practice2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll().toString()); // Boss/V1
        System.out.println(q.poll().toString()); // Bob/A1
        System.out.println(q.poll().toString()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}

class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2) {

        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            int i1 = Integer.parseInt(u1.number.substring(1));
            int i2 = Integer.parseInt(u2.number.substring(1));
            return (i1 - i2);
        }
        if (u1.number.charAt(0) == 'V') {
            return -1;
        } else {
            return 1;
        }
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return "{" + name + ',' + number + "}";
    }
}









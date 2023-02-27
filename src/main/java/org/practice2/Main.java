package org.practice2;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );

        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    // remove duplicates and keep unique messages"
    static List<Message> process(List<Message> received) {
        // TODO
        Set<Message> set = new TreeSet<>(new Comparator<Message>() {
            public int compare(Message m1, Message m2) {
                return Integer.compare(m1.sequence, m2.sequence);
            }
        });
//        for(Message m: received ){
//            set.add(m);
//        }
        set.addAll(received);
        return new ArrayList<Message>(set);
    }

}

class Message {
    public int sequence;
    public String text;

    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}








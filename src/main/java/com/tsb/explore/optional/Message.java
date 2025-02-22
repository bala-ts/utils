package com.tsb.explore.optional;
public class Message {
    private String recipient;
    private String text;
    private String sender;

    private Message(Builder builder) {
        this.recipient = builder.recipient;
        this.text = builder.text;
        this.sender = builder.sender != null ? builder.sender : "Unknown";
    }

    public static class Builder {
        private String recipient;
        private String text;
        private String sender;

        public Builder(String recipient, String text) {
            this.recipient = recipient;
            this.text = text;
        }

        public Builder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }

    public void display() {
        System.out.println("To: " + recipient);
        System.out.println("Message: " + text);
        System.out.println("From: " + sender);
    }

    public static void main(String[] args) {
        Message message1 = new Message.Builder("Alice", "Hi there!").build();
        Message message2 = new Message.Builder("Bob", "Good evening").sender("Charlie").build();

        message1.display();
        message2.display();
    }
}

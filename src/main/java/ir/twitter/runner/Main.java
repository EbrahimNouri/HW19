package ir.twitter.runner;

import ir.twitter.utility.SessionFactoryProvider;

public class Main {
    public static void main(String[] args) {

        System.out.println("helllo");

        System.out.println("Hello world!");

        SessionFactoryProvider.sessionFactory.openSession();
    }
}
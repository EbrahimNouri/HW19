package ir.twitter.utility;

import ir.twitter.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryProvider {

    public static SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Tweet.class)
                .addAnnotatedClass(Like.class)
                .addAnnotatedClass(Replay.class)
                .addAnnotatedClass(Follower.class)
                .addAnnotatedClass(Following.class)
                .buildMetadata()
                .buildSessionFactory();
    }
}

package ir.twitter.repository;

import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<E, I> {
    void save(Session session, E e);

    Optional<E> find(Session session, I i);

    Optional<List<E>> findAll(Session session, I i);

    void update(Session session,E e);

    void delete(Session session, I i);

}

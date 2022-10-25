package ir.twitter.repository.commentRepositori;

import ir.twitter.entity.Comment;
import ir.twitter.entity.CommentId;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class CommentRepositoryImpl implements CommentRepository {

    public void save( Session session,Comment comment) {
        session.save(comment);
    }

    public Optional<Comment> find(Session session, Long id) {
        return Optional.ofNullable(session.find(Comment.class, id));
    }

    @Override
    public void update(Session session, Comment comment) {
        session.update(comment);
    }

    @Override
    public void delete(Session session, CommentId comment) {
        session.delete(comment);
    }

    public Optional<Comment> find( Session session,CommentId id) {
        return Optional.ofNullable(session.find(Comment.class, id));
    }

    @Override
    public Optional<List<Comment>> findAll(Session session, CommentId commentId) {
        return Optional.ofNullable(session.createQuery("from Comment c where c.tweet.id = :accId", Comment.class)
                .setParameter("accId", commentId.getTweet().getId()).getResultList());
    }
}

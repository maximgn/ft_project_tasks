package com.maximgn.api.task3.repos;

import com.maximgn.api.task3.domain.Messages;
import com.maximgn.api.task3.domain.RepoResponse;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MessageRepoImpl implements MessageRepo {

    private final EntityManager em;

    @Autowired
    public MessageRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public RepoResponse<?> create(String msg) {
        Session session = em.unwrap(Session.class);
        Messages message = new Messages();
        message.setMsg(msg);
        session.saveOrUpdate(message);
        return new RepoResponse<>(HttpStatus.OK, "Record was successfully added in table");
    }

    @Override
    public RepoResponse<?> delete() {
        Session session = em.unwrap(Session.class);
        Query<Messages> querySelect = session.createQuery("from Messages", Messages.class).setMaxResults(1);
        List<Messages> lm = querySelect.getResultList();
        if (lm.isEmpty()) {
            return new RepoResponse<>(HttpStatus.OK, "The queue is empty");
        }
        int id = querySelect.getSingleResult().getId();
        Query<?> queryDelete = session.createQuery("delete from Messages where id = :myid").setParameter("myid", id);
        queryDelete.executeUpdate();
        return new RepoResponse<>(HttpStatus.OK, lm.get(0));
    }

    @Override
    public RepoResponse<?> readFirst() {
        Session session = em.unwrap(Session.class);
        Query<Messages> query = session.createQuery("from Messages", Messages.class).setMaxResults(1);
        List<Messages> lm = query.getResultList();
        if (lm.isEmpty()) {
            return new RepoResponse<>(HttpStatus.OK, "The queue is empty");
        }
        return new RepoResponse<>(HttpStatus.OK, lm);
    }

    @Override
    public RepoResponse<?> readMax() {
        Session session = em.unwrap(Session.class);
        Query<Messages> query = session.createQuery("from Messages order by id desc", Messages.class).setMaxResults(1);
        List<Messages> lm = query.getResultList();
        if (lm.isEmpty()) {
            return new RepoResponse<>(HttpStatus.OK, "The queue is empty");
        }
        return new RepoResponse<>(HttpStatus.OK, lm);
    }

    @Override
    public RepoResponse<?> read() {
        Session session = em.unwrap(Session.class);
        Query<Messages> query = session.createQuery("from Messages", Messages.class);
        List<Messages> lm = query.getResultList();
        if (lm.isEmpty()) {
            return new RepoResponse<>(HttpStatus.OK, "The queue is empty");
        }
        return new RepoResponse<>(HttpStatus.OK, lm);
    }
}

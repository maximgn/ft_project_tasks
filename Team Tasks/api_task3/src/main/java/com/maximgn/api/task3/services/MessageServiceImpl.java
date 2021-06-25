package com.maximgn.api.task3.services;
import com.maximgn.api.task3.domain.RepoResponse;
import com.maximgn.api.task3.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageServiceImpl(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @Override
    @Transactional
    public RepoResponse<?> offer(String msg) {
        return messageRepo.create(msg);
    }

    @Override
    @Transactional
    public RepoResponse<?> poll() {
        return messageRepo.delete();
    }

    @Override
    public RepoResponse<?> peek() {
        return messageRepo.readFirst();
    }

    @Override
    public RepoResponse<?> peekMax() {
        return messageRepo.readMax();
    }

    @Override
    public RepoResponse<?> all() {
        return messageRepo.read();
    }
}

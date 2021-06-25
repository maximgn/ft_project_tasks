package com.maximgn.api.task3.services;

import com.maximgn.api.task3.domain.Messages;
import com.maximgn.api.task3.domain.RepoResponse;
import org.springframework.http.ResponseEntity;

public interface MessageService {
    RepoResponse<?> offer(String msg);
    RepoResponse<?> poll();
    RepoResponse<?> peek();
    RepoResponse<?> peekMax();
    RepoResponse<?> all();
}

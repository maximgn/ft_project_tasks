package com.maximgn.api.task3.services;
import com.maximgn.api.task3.domain.RepoResponse;

public interface MessageService {
    RepoResponse<?> offer(String msg);
    RepoResponse<?> poll();
    RepoResponse<?> peek();
    RepoResponse<?> peekMax();
    RepoResponse<?> all();
}

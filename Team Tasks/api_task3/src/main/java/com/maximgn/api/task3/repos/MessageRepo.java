package com.maximgn.api.task3.repos;
import com.maximgn.api.task3.domain.RepoResponse;

public interface MessageRepo {
    RepoResponse<?> create(String msg);
    RepoResponse<?> delete();
    RepoResponse<?> readFirst();
    RepoResponse<?> readMax();
    RepoResponse<?> read();
}

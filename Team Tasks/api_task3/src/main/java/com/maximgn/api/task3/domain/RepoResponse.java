package com.maximgn.api.task3.domain;

import org.springframework.http.HttpStatus;

public class RepoResponse<T> {
    private HttpStatus status;
    private T response;

    public RepoResponse(HttpStatus status, T response) {
        this.status = status;
        this.response = response;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}

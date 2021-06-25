package com.maximgn.api.task3.controllers;

import com.maximgn.api.task3.domain.RepoResponse;
import com.maximgn.api.task3.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class Controller {
    private final MessageService messageService;

    @Autowired
    Controller(MessageService messageService) {this.messageService = messageService;}

    @PostMapping("/offer")
    public ResponseEntity<?> offer(@Valid @RequestBody String msg) {
        RepoResponse<?> rr = messageService.offer(msg);
        return new ResponseEntity<>(rr.getResponse(), rr.getStatus());
    }

    @GetMapping("/poll")
    public ResponseEntity<?> poll() {
        RepoResponse<?> rr = messageService.poll();
        return new ResponseEntity<>(rr.getResponse(), rr.getStatus());
    }

    @GetMapping("/peek")
    public ResponseEntity<?> peek() {
        RepoResponse<?> rr = messageService.peek();
        return new ResponseEntity<>(rr.getResponse(), rr.getStatus());
    }

    @GetMapping("/peek/max")
    public ResponseEntity<?> peekMax() {
        RepoResponse<?> rr = messageService.peekMax();
        return new ResponseEntity<>(rr.getResponse(), rr.getStatus());
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        RepoResponse<?> rr = messageService.all();
        return new ResponseEntity<>(rr.getResponse(), rr.getStatus());
    }
}

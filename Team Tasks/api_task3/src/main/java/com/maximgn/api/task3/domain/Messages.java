package com.maximgn.api.task3.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Messages {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NotNull
    private Integer id;

    @Size(min = 1, max = 4000)
    @NotNull
    private String msg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

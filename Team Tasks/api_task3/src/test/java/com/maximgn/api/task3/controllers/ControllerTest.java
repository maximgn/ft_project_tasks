package com.maximgn.api.task3.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@Sql("/schema.sql")
@Transactional
@PropertySource("classpath:/application-test.properties")
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Controller controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void offer() throws Exception {
        this.mockMvc.perform(post("/offer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Four message of queue"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Record was successfully added in table")));
    }

    @Test
    void poll() throws Exception {
        this.mockMvc.perform(get("/poll"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":13,\"msg\":\"First message of queue\"}")));
    }

    @Test
    void peek() throws Exception {
        this.mockMvc.perform(get("/peek"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":13,\"msg\":\"First message of queue\"}]")));
    }

    @Test
    void peekMax() throws Exception {
        this.mockMvc.perform(get("/peek/max"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":15,\"msg\":\"Third message of queue\"}]")));
    }

    @Test
    void all() throws Exception {
        this.mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":13,\"msg\":\"First message of queue\"},{\"id\":14,\"msg\":\"Second message of queue\"},{\"id\":15,\"msg\":\"Third message of queue\"}]")));
    }
}
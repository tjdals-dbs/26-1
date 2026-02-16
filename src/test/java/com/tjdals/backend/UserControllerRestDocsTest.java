package com.tjdals.backend;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
class UserControllerRestDocsTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    @Test
    void users_create() throws Exception{
        var body = Map.of("name", "Seongmin", "email", "seongmin@test.com");

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                  .content(objectMapper.writeValueAsString(body)))
                .andExpect(status().isOk())
                .andDo(document("users-create"));
    }
}

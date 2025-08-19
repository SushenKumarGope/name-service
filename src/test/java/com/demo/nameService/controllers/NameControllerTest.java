package com.demo.nameService.controllers;

import com.demo.nameService.requests.Name;
import com.demo.nameService.services.NameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class NameControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    NameService nameService;

    @Test
    void testConcatenateName() throws Exception {
        when(nameService.concatenate(any(Name.class))).thenReturn("Raghu Rokhda");


        mockMvc.perform(post("/v1/name")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"Name\":\"Raghu\",\"Surname\":\"Rokhda\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Raghu Rokhda"));

    }

    @Test
    void testConcatenateNameWithBlankName() throws Exception {

        mockMvc.perform(post("/v1/name")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"\",\"surname\":\"Cena\"}"))
                .andExpect(status().isBadRequest());

    }

    @Test
    void testConcatenateNameWithMissingField() throws Exception {

        mockMvc.perform(post("/v1/name")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Rock\"}"))
                .andExpect(status().isBadRequest());

    }


}

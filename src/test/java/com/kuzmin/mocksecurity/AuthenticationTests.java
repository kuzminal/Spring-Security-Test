package com.kuzmin.mocksecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationTests {
    @Autowired
    private MockMvc mvc;
    @Test
    public void helloAuthenticatingWithValidUser() throws Exception {
        mvc.perform(
                get("/hello")
                        .with(httpBasic("john","12345")))
                .andExpect(status().isOk());
    }
    @Test
    public void helloAuthenticatingWithInvalidUser() throws Exception {
        mvc.perform(
                get("/hello")
                        .with(httpBasic("mary","12345")))
                .andExpect(status().isUnauthorized());
    }
}

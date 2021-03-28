package br.com.validador.senha.validador.validador;

import br.com.validador.senha.validador.business.impl.ValidatorPasswordRegexImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class Run {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ValidatorPasswordRegexImpl test;

    @Test
    public void callEndpointValidaPasswordValid() throws Exception {
        mockMvc.perform(post("/valida")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"senha\": \"!AbTp9^fok\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.retorno",is(true)));

    }

    @Test
    public void callEndpointValidaPasswordNotValid() throws Exception {
        mockMvc.perform(post("/valida")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"senha\": \"!AbTp9 ^fok\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.retorno",is(false)));

    }


}

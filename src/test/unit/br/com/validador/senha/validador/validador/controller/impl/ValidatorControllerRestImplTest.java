package br.com.validador.senha.validador.validador.controller.impl;

import br.com.validador.senha.validador.business.interfaces.ValidatorPassword;
import br.com.validador.senha.validador.controller.impl.ValidatorControllerRestImpl;
import br.com.validador.senha.validador.domain.Return;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class ValidatorControllerRestImplTest {

    @InjectMocks
    ValidatorControllerRestImpl test;

    @Mock
    ValidatorPassword validator;

    @Test
    public void validatePasswordWithReturnFalseTest(){
        Mockito.when(validator.validatePassword(null)).thenReturn(false);
        ResponseEntity<Return> result = test.validatePassword(null);
        assertFalse(result.getBody().isRetorno());
    }

    @Test
    public void validatePasswordWithReturnTrueTest(){
        Mockito.when(validator.validatePassword(null)).thenReturn(true);
        ResponseEntity<Return> result = test.validatePassword(null);
        assertTrue(result.getBody().isRetorno());
    }

}

package br.com.validador.senha.validador.controller.interfaces;

import br.com.validador.senha.validador.domain.Password;
import br.com.validador.senha.validador.domain.Return;
import org.springframework.http.ResponseEntity;

public interface ValidatorController {

    public ResponseEntity<Return> validatePassword(Password password);
}

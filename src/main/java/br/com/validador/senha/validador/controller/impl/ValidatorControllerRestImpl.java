package br.com.validador.senha.validador.controller.impl;


import br.com.validador.senha.validador.business.interfaces.ValidatorPassword;
import br.com.validador.senha.validador.controller.interfaces.ValidatorController;
import br.com.validador.senha.validador.domain.Password;
import br.com.validador.senha.validador.domain.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ValidatorControllerRestImpl implements ValidatorController {

    @Autowired
    ValidatorPassword validator;

    @Override
    @PostMapping("/valida")
    public ResponseEntity<Return> validatePassword(@RequestBody Password password) {
        Return retorno = new Return();
        retorno.setRetorno(validator.validatePassword(password));
        return new ResponseEntity<Return>(retorno, HttpStatus.OK);
    }
}

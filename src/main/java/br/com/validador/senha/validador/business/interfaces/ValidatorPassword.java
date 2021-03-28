package br.com.validador.senha.validador.business.interfaces;

import br.com.validador.senha.validador.domain.Password;

public interface ValidatorPassword {
    public boolean validatePassword(Password value);
}

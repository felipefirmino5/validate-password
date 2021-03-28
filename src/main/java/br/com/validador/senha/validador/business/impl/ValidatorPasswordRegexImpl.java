package br.com.validador.senha.validador.business.impl;

import br.com.validador.senha.validador.business.interfaces.ValidatorPassword;
import br.com.validador.senha.validador.domain.Password;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**************************************************************************************
  Classe: ValidatorPasswordRegexImpl.
Contexto: Essa classe tem como objetivo implementar a validação de senhas do usuário utilizando
Expressões regulares.
  Regras: 1 - Nove ou mais caracteres
          2 - Ao menos 1 dígito
          3 - Ao menos 1 letra minúscula e Ao menos 1 letra maiúscula
          4 - Ao menos 1 caractere especial (!@#$%^&*()-+)
          5 - Não possuir caracteres repetidos dentro do conjunto
 Obs: Considerei (por ex:A e a) como sendo o mesmo caractere
 **************************************************************************************/


@Service
public class ValidatorPasswordRegexImpl implements ValidatorPassword {
    final String regexRepeet = "(.)(?=.*\\1)";
    final String regexValidate = "^(((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()\\-+])))(?=.{9,})";
    final Pattern patternRepeet = Pattern.compile(regexRepeet, Pattern.MULTILINE);
    final Pattern patternValidate = Pattern.compile(regexValidate, Pattern.MULTILINE);



    @Override
    public Boolean validatePassword(Password value) {
        if(value!=null && value.getSenha()!=null && !value.getSenha().contains(" ")){
            Matcher matcherRepeticao = patternRepeet.matcher(value.getSenha().toLowerCase());
            Matcher matcherValidacao = patternValidate.matcher(value.getSenha());
            if(!matcherRepeticao.find() && matcherValidacao.find()){
                return true;
            }
        }
        return false;

    }
}

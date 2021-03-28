package br.com.validador.senha.validador.validador.business.impl;

import br.com.validador.senha.validador.business.impl.ValidatorPasswordRegexImpl;
import br.com.validador.senha.validador.domain.Password;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ValidatorPasswordRegexImplTest {

    @Autowired
    ValidatorPasswordRegexImpl validator;


    @Test
    public void validatePasswordPassTest(){
        /*E esperado neste caso de teste o retorno "true",
          ou seja que a senha atenda os requisitos necessarios*/
        Password pass = new Password();
        pass.setSenha("AbTp9!fok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }


    @Test
    public void validatePasswordWhenNullObjectTest(){
        /*E esperado neste caso de teste o retorno false" */
        boolean result = validator.validatePassword(null);
        assertFalse(result);
    }

    @Test
    public void validatePasswordWhenNullAtributteTest(){
        /*E esperado neste caso de teste o retorno false" */
        Password pass = new Password();
        boolean result = validator.validatePassword(pass);
        assertFalse(result);
    }

    @Test
    public void validatePasswordRepeatedWorldTest(){
        /*E esperado neste caso de teste o retorno false" */
        Password pass = new Password();
        pass.setSenha("AbTp9!foA");
        boolean result1 = validator.validatePassword(pass);
        assertFalse(result1);

        pass.setSenha("abTp9!foa");
        boolean result2 = validator.validatePassword(pass);
        assertFalse(result2);

        pass.setSenha("AbTp9!foa");
        boolean result3 = validator.validatePassword(pass);
        assertFalse(result3);
    }


    @Test
    public void validatePasswordMinLengthTest(){
        /*E esperado neste caso de teste o retorno false" */
        Password pass = new Password();
        pass.setSenha("aaa");
        boolean result = validator.validatePassword(pass);
        assertFalse(result);
    }

    @Test
    public void validatePasswordWithBlackSpaceAtributteTest(){
        /*E esperado neste caso de teste o retorno false" */
        Password pass = new Password();
        pass.setSenha("AbTp9 fok");
        boolean result = validator.validatePassword(pass);
        assertFalse(result);
    }

    @Test
    public void validatePasswordWithMultiplesBlankSpacesTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("     ");
        boolean result = validator.validatePassword(pass);
        assertFalse(result);
    }


    @Test
    public void validatePasswordWithoutSpecialCharacterTest(){
        /*E esperado neste caso de teste o retorno false" */
        Password pass = new Password();
        pass.setSenha("AbTp9wsfok");
        boolean result = validator.validatePassword(pass);
        assertFalse(result);
    }

    @Test
    public void validatePasswordWithExclmationCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("AbTp9wsfok!");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordWithCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("AbTp9wsfok@");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordWithSharpCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("AbTp9#wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordWithCaretCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("AbTp9^wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordWithParLeftCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("AbTp9)wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordRigthParLeftCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("AbTp9(wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordRigthMinusCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("AbT-p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordRigthMaxCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("AbT+p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordPercentCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("AbT%p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordDolarCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("AbT$p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    /*TESTES de UNIDADE dos Caracteres Especiais no inicio da expressão (Para validar se a expressão regular cumpre o papel)*/
    @Test
    public void validatePasswordMinusInitCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("-AbT$p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordDolarInitCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("$AbTp9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordParInitCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("(AbT$p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }
    @Test
    public void validatePasswordIntegotionInitCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("!AbT$p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordAtSignInitCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("@AbT$p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordSustenidoInitCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("#AbT$p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordPercentInitCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("%AbT$p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordAcentInitCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("%AbT$p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordAmpersandInitCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("&AbT$p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordAsteriskInitCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("*AbT$p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }

    @Test
    public void validatePasswordPlusInitCharacterTest(){
        /*E esperado neste caso de teste o retorno true" */
        Password pass = new Password();
        pass.setSenha("+AbT$p9wsfok");
        boolean result = validator.validatePassword(pass);
        assertTrue(result);
    }






}

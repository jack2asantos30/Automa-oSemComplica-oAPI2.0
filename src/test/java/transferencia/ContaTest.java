package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvioSantos;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa","12345678900","1111111");
        silvioSantos = new Cliente("Sivio santos", "22222222222","2222222");

        contaXuxa = new Conta("0035","12365",2500.00,xuxa);
        contaSilvioSantos = new Conta ("0026","22151",3500.00, silvioSantos);

    }

    @Test
    public void realizarTransacao(){

        contaXuxa.realizarTransferencia(1000.00,contaSilvioSantos);
        assertEquals(1500.00,contaXuxa.getSaldo());
        assertEquals(4500.00,contaSilvioSantos.getSaldo());


    }

    @Test
    public void validarTransferenciaInvalida(){

       boolean reultado = contaXuxa.realizarTransferencia(3500.00,contaSilvioSantos);
       assertFalse(reultado);

    }
}
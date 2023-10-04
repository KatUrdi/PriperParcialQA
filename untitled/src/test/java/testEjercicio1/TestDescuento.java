package testEjercicio1;

import ejercicio1.CalcularDescuento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestDescuento {
    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,1",
            "2,2",

            "999,999",
            "1000,1000",
            "1001,1001",

            "1999,1999",
            "2000,2000",
            "2001,1901",

            "2999,2850",
            "3000,2850",
            "3001,2851",

            "3999,3800",
            "4000,3800",
            "4001,3401"
    })

    public void calDescuento(int sueldo, int expected) throws Exception{
        CalcularDescuento calcularDescuento = new CalcularDescuento();
        if(sueldo<1){
            Assertions.assertThrows(Exception.class, ()->{calcularDescuento.devDescuento(sueldo);});
        }else {
            int actualResult = calcularDescuento.devDescuento(sueldo);
            Assertions.assertEquals(expected, actualResult, "ERROR en el descuento");
        }
    }
}
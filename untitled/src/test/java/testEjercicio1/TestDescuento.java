package testEjercicio1;

import org.junit.jupiter.api.Test;
import ejercicio1.CalcularDescuento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestDescuento {
    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1.1",
            "2,2",

            "999,999",
            "1000,1000",
            "1001,1001",


    })
}
package testEjercicio2;

import ejercicio2.Datos;
import ejercicio2.Reserva;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class TestReserva {
    Datos datosMock = Mockito.mock(Datos.class);
    @ParameterizedTest
    @CsvSource(
            {
                    "La Paz, 3, 23, 3,2023,Lunes,true, el dia Lunes 23 Marzo 2023 existen 3 pasajes para La Paz",
                    "Santa Cruz, 20, 28, 13,2023,Viernes,true, FECHA NO VALIDA",
                    "Santa Cruz, 20, 29, 2,2023,Viernes,true, FECHA NO VALIDA",
                    "Cochabamba, 80, 27, 2, 2023,Viernes,false, no existen suficientes pasajes para Cochabamba",

            }
    )
    public void verifyMaxPrestamo(String destino, int cantidad, int dia, int mes, int gestion, String day, boolean hayPasajes, String expected){
        MockedStatic<Datos> datosStatic = Mockito.mockStatic(Datos.class);
        datosStatic.when(() -> Datos.getDay(dia, mes, gestion)).thenReturn(day);

        Mockito.when(datosMock.existenPasajes(destino,cantidad)).thenReturn(hayPasajes);

        Reserva reserva = new Reserva();
        reserva.setDatos(datosMock);
        String actual = reserva.reservaVuelo(destino, cantidad, dia, mes, gestion);
        Assertions.assertEquals(expected, actual, "ERROR: no devuelve el texto correcto o no alerta que se ingresaron datos erroneos");
        datosStatic.close();
    }
}

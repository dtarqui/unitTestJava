import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CalculadoraTest {

    // En java hay dos excepciones controladas y no controladas
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void enCadenaVaciaRetornarCero() throws Exception {
        // 1.- Preparacion de la prueba
        Calculadora c = new Calculadora();

        // 2.- Logica de la prueba
        String resultado = c.suma("");

        // 3.- Verificacion o Assert
        assertEquals("0", resultado);
    }

    @Test
    public void para2numerosComasRetornarSuma() throws Exception {
        Calculadora c = new Calculadora();
        String res = c.suma("2,3");
        assertEquals("5", res);
    }

    @Test
    public void para3numerosComasRetornarSuma() throws Exception {
        Calculadora c = new Calculadora();
        String res = c.suma("2,3");
        assertEquals("5", res);
        assertEquals("10", c.suma("2,3,5"));
    }

    @Test
    public void numerosMayores1000sonIgnorados() throws Exception {
        Calculadora c = new Calculadora();
        assertEquals("5", c.suma("2,3,1001"));
    }

    @Test
    public void exceptionEnNumeros() throws Exception {
        Calculadora c = new Calculadora();
        // Siempre antes del assert que se espera una exception
        exception.expect(Exception.class);
        assertEquals("5", c.suma("2,3,-1"));
    }
}
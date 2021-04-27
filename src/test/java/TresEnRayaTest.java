import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TresEnRayaTest {
    private TresEnRaya tresEnRaya;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        tresEnRaya = new TresEnRaya();
    }

    @Test
    public void cuandoFueraXLanzarException() throws Exception {
        //PARTES DE UNA PRUEBA Preparacion // Logica // Verificacion
        // exception.expect(Exception.class);
        exception.expect(RuntimeException.class);
        tresEnRaya.jugar(5, 2);
        tresEnRaya.jugar(-1, 2);
    }

    @Test
    public void cuandoFueraYLanzarException() throws Exception {
        exception.expect(RuntimeException.class);
        tresEnRaya.jugar(2, 5);
        tresEnRaya.jugar(2, -5);
    }

    @Test
    public void cuandoCasillaOcupadaLanzarException() throws Exception {
        tresEnRaya.jugar(2, 1); // X
        exception.expect(Exception.class);
        tresEnRaya.jugar(2, 1); // +
    }

    @Test
    public void siPrimerTurnoEntoncesJuegaX() throws Exception {
        assertEquals('X', tresEnRaya.siguienteTurno());
    }

    @Test
    public void siPrimerTurnoXSiguiente() throws Exception {
        tresEnRaya.jugar(2, 1);
        assertEquals('+', tresEnRaya.siguienteTurno());
        tresEnRaya.jugar(1, 2);
        assertEquals('X', tresEnRaya.siguienteTurno());
        tresEnRaya.jugar(3, 3);
        assertEquals('+', tresEnRaya.siguienteTurno());
        System.out.println(tresEnRaya.getIteracion());
    }

    @Test
    public void cuandoJuegaNoHayGanador() throws Exception {
        String resultado = tresEnRaya.jugar(2, 1);
        assertEquals("No hay ganador", resultado);
    }

    @Test
    public void siLlenaUnEjeVerticalEntoncesGana() throws Exception {
        tresEnRaya.jugar(1, 1);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(2, 1);
        tresEnRaya.jugar(2, 2);
        String resultado = tresEnRaya.jugar(3, 1);
        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void siLlenaUnEjeHorizontalEntoncesGana() throws Exception {
        tresEnRaya.jugar(2, 1);
        tresEnRaya.jugar(1, 1);
        tresEnRaya.jugar(3, 1);
        tresEnRaya.jugar(1, 2);
        tresEnRaya.jugar(2, 2);
        String resultado = tresEnRaya.jugar(1, 3);
        assertEquals("X es el ganador", resultado);
    }
}
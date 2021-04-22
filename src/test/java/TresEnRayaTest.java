import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TresEnRayaTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void cuandoFueraXLanzarException() throws Exception {
        //PARTES DE UNA PRUEBA Preparacion // Logica // Verificacion
        TresEnRaya tresEnRaya = new TresEnRaya();
//        exception.expect(Exception.class);
        exception.expect(RuntimeException.class);
        tresEnRaya.jugar(5, 2);
        tresEnRaya.jugar(-1, 2);
    }

    @Test
    public void cuandoFueraYLanzarException() throws Exception {
        TresEnRaya tresEnRaya = new TresEnRaya();
        exception.expect(RuntimeException.class);
        tresEnRaya.jugar(2, 5);
        tresEnRaya.jugar(2, -5);
    }
    @Test
    public void cuandoCasillaOcupadaLanzarException() throws Exception {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(2, 1);
        exception.expect(Exception.class);
        tresEnRaya.jugar(2, 1);
    }
}
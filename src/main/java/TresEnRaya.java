public class TresEnRaya {
    private final int MAX = 3;
    private final int MIN = 3;
    private int[][] tablero = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    public void jugar(int x, int y) throws Exception {
        if (x > MAX || x < 0 || y > MAX || y < 0)
            throw new RuntimeException("X salio de rango");
        if (tablero[x - 1][y - 1] != 0)
            throw new Exception("Casilla ocupada");
        tablero[x - 1][y - 1] = 1;

    }
}

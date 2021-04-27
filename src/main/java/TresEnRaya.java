public class TresEnRaya {
    private final int MAX = 3;
    private final int MIN = 1;
    private int iteracion = 0;
    private Character[][] tablero = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
    };
    private char ultimoJugador = '+';

    public String jugar(int x, int y) throws Exception {
        verificarLimites(x, y);
        if (tablero[x - 1][y - 1] != '0')
            throw new Exception("Casilla ocupada");
        if (ultimoJugador == '+')
            tablero[x - 1][y - 1] = 'X';
        else
            tablero[x - 1][y - 1] = '+';

        ultimoJugador = siguienteTurno();
        print2D(getTablero());
        iteracion++;
        return "No hay ganador";
    }

    private void verificarLimites(int x, int y) {
        if (x > getMAX() || x < getMIN() || y > getMAX() || y < getMIN())
            throw new RuntimeException("X o Y salio de rango");
    }

    public int getIteracion() {
        return iteracion;
    }

    public void setIteracion(int iteracion) {
        this.iteracion = iteracion;
    }

    public char getUltimoJugador() {
        return ultimoJugador;
    }

    public void setUltimoJugador(char ultimoJugador) {
        this.ultimoJugador = ultimoJugador;
    }

    public int getMAX() {
        return MAX;
    }

    public int getMIN() {
        return MIN;
    }


    public Character[][] getTablero() {
        return tablero;
    }

    public void setTablero(Character[][] tablero) {
        this.tablero = tablero;
    }

    private static void print2D(Character[][] mat) {
        for (Character[] characters : mat) {
            for (Character character : characters)
                System.out.print(character + " ");
            System.out.println();
        }
        System.out.println();

    }

    public char siguienteTurno() {
        if (ultimoJugador == 'X')
            return '+';
        return 'X';
    }
}

public class Calculadora {
    private final int MAX = 1000;

    public String suma(String s) throws Exception {
        if (s.isEmpty() && s != null) {
            return "0";
        }
        int total = 0;
        String[] sums = s.split(",");
        for (String value : sums) {
            int sum = Integer.parseInt(value);
            if (sum < MAX)
                total += sum;
            if (sum < 0)
                throw new Exception("El numero es negativo");
        }
        return (new Integer(total)).toString();
    }

}

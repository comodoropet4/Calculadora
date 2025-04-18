public class Calculadora {
    public static int sumar(int sumando1, int sumando2) {
        return sumando1 + sumando2;
    }

    public static int restar(int minuendo, int sustraendo) {
        return minuendo - sustraendo;
    }

    public static int multiplicar(int multiplicando, int multiplicador) {
        return multiplicando * multiplicador;
    }

    public static int dividir(int dividendo, int divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir entre 0.");
        } else {
            return dividendo / divisor;
        }
    }
}

public class Rectangulo {
    public static double area(double base, double altura) {
        if (base < 0 || altura < 0) {
            throw new IllegalArgumentException("Base y altura deben ser no negativas");
        }
        return base * altura;
    }
}

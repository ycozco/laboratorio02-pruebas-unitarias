import java.util.List;
import java.util.ArrayList;

public class ParImpar {
    public static List<String> identificar(List<Integer> numeros) {
        List<String> resultado = new ArrayList<>();
        for (int n : numeros) {
            if (n % 2 == 0) {
                resultado.add("Par");
            } else {
                resultado.add("Impar");
            }
        }
        return resultado;
    }
}

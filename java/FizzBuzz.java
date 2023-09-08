import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * @author b4yerl
 */
public class FizzBuzz {
  public static List<String> classicSolution(int n) {
    List<String> output = new ArrayList<>();
    for(int i = 1; i <= n; i++) {
      // Aqui basta checarmos em qual caso nossa iteração atual se encaixa
      // Atenção apenas para a ordem das condicionais e o uso de else if, evitando que um caso se enquadre em mais de uma condição.
      if(i % 3 == 0 && i % 5 == 0) output.add("FizzBuzz");
      else if(i % 3 == 0) output.add("Fizz");
      else if(i % 5 == 0) output.add("Buzz");
      else output.add(String.valueOf(i));
    }
    return output;
  }
}

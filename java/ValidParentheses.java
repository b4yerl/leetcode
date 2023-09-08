import java.util.Stack;

/**
 * 20. Valid Parentheses
 * @author b4yerl
 */
public class ValidParentheses {
  /**
   * Para esse problema optei por usar uma pilha, dessa maneira eu consigo garantir qual deve ser o próximo par a ser fechado. 
   * Lembre-se que o princípio básico de uma pilha é o LIFO, assim, o último valor a entrar sempre deverá ser o primeiro a sair.
   * 
   * @param s Input do problema consiste em uma string formada apenas por ([{}]).
   * @return Retorna um valor booleano para validação do input baseado nas regras apresentadas.
   */
  public static boolean isValid(String s) {
    Stack<Character> validationStack = new Stack<>();
    for(char c : s.toCharArray()) {
      // Aqui basicamente adicionamos à pilha o par que fecha o que foi aberto
      if(c == '(') validationStack.push(')');
      else if(c == '[') validationStack.push(']');
      else if(c == '{') validationStack.push('}');
      // Caso tente-se fechar um par fora da ordem correta retornamos falso aqui, para isso usamos a comparação com o que foi removido no pop()
      else if(validationStack.isEmpty() || c != validationStack.pop()) return false;
    }
    // Após o for loop não pode haver mais nada na pilha, no caso seria possível que houvessem ), ] ou } na espera.
    return validationStack.isEmpty();
  }
}

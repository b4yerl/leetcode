/**
 * 7. Reverse Integer
 *
 * @author b4yerl
 */
public class ReverseInteger {
    /**
     * Pra esse problema não tem muito segredo, apenas tomar cuidado com a conversão para Long, dessa forma garantimos
     * que não haverá um Integer Overflow já de cara.
     *
     * @param x Input
     * @return Número invertido
     */
    public static int reverse(int x) {
        // Como o Math.abs() não faz nada em caso de Integer.MIN_VALUE, já fazemos a verificação na linha 1
        if(x == Integer.MIN_VALUE) return 0;
        // Usei o StringBuilder aqui apenas pela comodidade do reverse()
        StringBuilder sb = new StringBuilder().append(Math.abs(x));
        sb = sb.reverse();

        // Com essa variável temporária podemos verificar se o nosso valor está no range de 32 bits, isso sem correr
        // o risco de um Overflow
        Long tmp = Long.parseLong(sb.toString());
        if(tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) return 0;

        int result = Integer.parseInt(sb.toString());
        return (x > 0) ? result : -result;
    }
}

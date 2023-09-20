/**
 * 476. Number Complement
 *
 * @author b4yerl
 */
public class NumberComplement {
    /**
     * Como o problema já trata de manipulação de bits, então resolvi o problema com bitwise operators.
     *
     * @param num Input
     * @return Complemento dos bits do input
     */
    public static int findComplement(int num) {
        // Essa expressão permite que encontremos a quantidade de bits necessária para representar o input
        // Ex: num == 12; bitLength == 4, já que 12 == 1100
        int bitLength = Integer.SIZE - Integer.numberOfLeadingZeros(num);
        // A ideia aqui é criar uma máscara que usaremos para preservar o sinal do complemento após o NOT
        // Ex: bitLength == 4; 1 << bitLength vai cuspir 10000, que subtraindo 1 termina na nossa mask 1111
        int mask = (1 << bitLength) - 1;
        // Aqui é a operação óbiva de negação do num com o AND mask para preservar o sinal positivo
        return (~num) & mask;
    }
}

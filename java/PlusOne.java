/**
 * 66. Plus One
 *
 * @author b4yerl
 */
public class PlusOne {
    /**
     * Esse aqui eu me enrolei um pouco até perceber que não havia porque converter o input e tirar ele do array.
     *
     * Basicamente vamos verificar cada dígito do fim para o início, caso encontremos um menor do que 9, já o incrementamos e
     * retornamos a resposta ali mesmo, se trombarmos em um 9 então basta alterá-lo para 0 e deixar o loop seguir.
     *
     * Em último caso, [9,9,9] por exemplo, retornamos um novo array com o 1 seguido dos n zeros.
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            // O return aqui nesse if cobre todos os casos possíveis em que haverá incremento e não um novo array
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            else digits[i] = 0;
        }
        // Ex: input=[9,9,9]; output=[1,0,0,0]
        // Note que isso é possível no Java, pois o valor padrão dos elementos de um array de int é 0.
        int[] output = new int[digits.length + 1];
        output[0] = 1;
        return output;
    }
}

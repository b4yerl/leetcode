/**
 * 70. Climbing Stairs
 */
public class ClimbingStairs {
    /**
     * 2 em 1, usei uma função de auxílio aqui. Fiz um algoritmo recursivo, inicialmente em um único método, o problema é
     * que isso tava assassinando o desempenho a medida que o n subia. Optei então por utilizar uma segunda função em que
     * eu pudesse armazenar o progresso computado e consequentemente aliviasse a barra.
     *
     * @param n Degraus da escada
     * @return Possibilidades de subí-la com passos de 1 ou 2 degraus
     */
    public static int climbStairs(int n) {
        // O n+1 aqui é pra não tomar um Index Out of Bounds
        int[] aux = new int[n + 1];
        return climbIt(n, aux);
    }

    /**
     * É aqui que acontece tudo, uma função recursiva que armazena o seu progresso.
     *
     * @param n Número de degraus restantes
     * @param aux Array com os valores que já tenham sido computados
     * @return Possibilidades de subí-la com passos de 1 ou 2 degraus
     */
    public static int climbIt(int n, int[] aux) {
        // Caso tenhamos passado o máximo de degraus, o caminho atual não é contabilizado
        if(n < 0) return 0;
        // Mas contabiliza todas as vezes em que zeramos os degraus
        if(n == 0) return 1;

        // Esse aqui é o diferencial dessa abordagem, ele impede que o mesmo valor seja calculado a cada vez que aparecer
        // Por exemplo, quando descobrimos uma vez que para n = 4 temos 5 possibilidades, não precisamos calcular novamente
        // basta computar esse valor e quando chegarmos aqui retorná-lo, lembrando que só funciona, pois 0 é o valor padrão dos elementos de um Array Java
        if(aux[n] != 0) return aux[n];

        // Computamos aqui os valores no array auxiliar, inicialmente o código era só duas linhas semelhantes a esta, mais as condições acima
        aux[n] = climbIt(n - 1, aux) + climbIt(n - 2, aux);
        return aux[n];
    }
}

/**
 * 495. Teemo Attacking
 *
 * @author b4yerl
 */
public class TeemoAttacking {
    /**
     * Maldito Teemo... Nessa primeira abordagem optei por usar um único loop e nenhuma nova estrutura.
     * Basicamente o que é feito aqui é uma checagem a cada iteração para saber o tempo de poison que será computado.
     *
     * @param timeSeries Momentos em que os ataques são realizados
     * @param duration Duração do efeito de poison
     * @return Tempo total de duração do poison
     */
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0) return 0;
        if(timeSeries.length == 1) return duration;
        int output = duration;
        for(int i = 1; i < timeSeries.length; i++) {
            // Quando a duração entre dois ataques reseta o poison, tiramos o tempo extra remanescente.
            if(timeSeries[i] - timeSeries[i - 1] < duration) output -= duration - (timeSeries[i] - timeSeries[i - 1]);
            output += duration;
        }
        return output;
    }

    /**
     * Absolutamente a mesma ideia, mas fazendo uma graça com try...catch
     *
     * @param timeSeries Momentos em que os ataques são realizados
     * @param duration Duração do efeito de poison
     * @return Tempo total de duração do poison
     */
    public static int findPoisonedDurationTryCatch(int[] timeSeries, int duration) {
        if(timeSeries.length == 0) return 0;
        int output = 0;
        for(int i = 0; i < timeSeries.length; i++) {
            try {
                if(timeSeries[i + 1] - timeSeries[i] < duration) output += timeSeries[i + 1] - timeSeries[i];
                else output += duration;
            } catch (IndexOutOfBoundsException e) {
                // Quando caímos aqui é porque não tem mais nada pra frente, logo basta somar a duração e retornar
                output += duration;
                return output;
            }
        }
        return output;
    }
}

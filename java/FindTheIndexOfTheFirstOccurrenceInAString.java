/**
 * 28. Find the Index of the First Occurrence in a String
 *
 * @author b4yerl
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    /**
     * Aqui é só ler a documentação da java.lang.String mesmo kkkkkkkk
     *
     * @param haystack String que receberá a busca
     * @param needle Termo que procuramos
     * @return Index da primeira ocorrência
     */
    public static int finder(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * Agora implementando na mão, aqui iteramos pelo haystack, quando acontece do char atual bater com o primeiro da substring
     * que procuramos, aí o código começa a comparação entre os 2, por isso acho que isso aí é O(NM) :)
     *
     * @param haystack String que receberá a busca
     * @param needle Termo que procuramos
     * @return Index da primeira ocorrência
     */
    public static int trueFinder(String haystack, String needle) {
        // Essa flag nos ajuda a manter um controle sobre o código
        boolean wasFound = false;
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                // Aqui mesmo antes de checar já altero a flag pra true, caso não seja eu mudo lá na frente
                wasFound = true;
                String fraction = haystack.substring(i);
                for(int j = 0; j < needle.length(); j++) {
                    // A primeira parte da condição garante que não vamos ultrapassar o limite do haystack
                    // Voltamos a flag pra false e retomamos o loop externo
                    if(j > fraction.length() - 1 || fraction.charAt(j) != needle.charAt(j)) {
                        wasFound = false;
                        break;
                    }
                }
            }
            // Se tudo ocorrer bem o wasFound chega aqui como true
            if(wasFound) return i;
        }
        return  -1;
    }

    /**
     * Outra possibilidade, dessa vez usando o equals() ao invés da comparação char a char, no fim é a mesma coisa
     *
     * @param haystack String que receberá a busca
     * @param needle Termo que procuramos
     * @return Index da primeira ocorrência
     */
    public static int substringFinder(String haystack, String needle) {
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                // Isso aqui é pra não tomar um Index Out of Bounds
                if(haystack.length() - i < needle.length()) continue;
                if(haystack.substring(i, needle.length() + i).equals(needle)) return i;
            }
        }
        return -1;
    }
}

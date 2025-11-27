// Criamos uma classe genérica para permitir qualquer tipo de chave (K) e valor (V)
public class TabelaHashSondagemLinear<K,V> {

    // Vetor de chaves
    private K[] chaves;
    
    // Vetor de valores (paralelo ao vetor de chaves)
    private V[] valores;

    // Conta quantos elementos foram inseridos
    private int tamanho;

    // Construtor recebe o tamanho máximo da tabela
    @SuppressWarnings("unchecked")
    public TabelaHashSondagemLinear(int capacidade) {
        // Criamos dois vetores "vazios", mas do mesmo tamanho
        chaves = (K[]) new Object[capacidade];
        valores = (V[]) new Object[capacidade];
        tamanho = 0; // Começa vazia
    }

    // Função hash para obter a posição inicial da chave na tabela
    private int hash(K chave) {
        // hashCode() gera número baseado na chave, % deixa dentro dos limites do vetor
        return Math.abs(chave.hashCode() % chaves.length);
    }

    // Método para inserir chave e valor
    public void inserir(K chave, V valor) {
        int indice = hash(chave); // Calcula o índice baseado na chave

        // Enquanto a posição está ocupada e NÃO é a mesma chave,
        // vamos andando para o próximo índice (sondagem linear)
        while (chaves[indice] != null && !chaves[indice].equals(chave)) {
            indice = (indice + 1) % chaves.length;  // Avança para próxima posição
                                                   // % impedindo overflow do vetor
        }

        // Quando encontrar posição vazia ou a chave for igual, salva no vetor
        chaves[indice] = chave;
        valores[indice] = valor;
        tamanho++; // Aumenta contador
    }

    // Método para buscar valor usando a chave
    public V buscar(K chave) {
        int indice = hash(chave); // Começa da posição calculada

        // Enquanto houver algo na posição, procura pela chave
        while (chaves[indice] != null) {
            // Se encontramos, retornamos o valor
            if (chaves[indice].equals(chave)) 
                return valores[indice];

            // Caso não seja, continuamos procurando linearmente
            indice = (indice + 1) % chaves.length;
        }

        // Se encontrou posição vazia sem achar a chave, então a chave não existe
        return null;
    }

    // Método para remover uma chave da tabela
    public void remover(K chave) {
        int indice = hash(chave);

        // Procura pela chave avançando linearmente
        while (chaves[indice] != null) {
            if (chaves[indice].equals(chave)) {
                // Para remover, apenas apagamos a chave e o valor
                chaves[indice] = null;
                valores[indice] = null;
                tamanho--;
                return; // Finaliza remoção
            }
            indice = (indice + 1) % chaves.length;
        }
    }

    // Método para obter quantos elementos existem na tabela
    public int tamanho() { 
        return tamanho; 
    }

    // Imprime a tabela de sondagem linear mostrando índice e par chave/valor
    public void imprimir() {
        System.out.println("Tabela Hash (Sondagem Linear):");
        for (int i = 0; i < chaves.length; i++) {
            System.out.print(i + ": ");
            if (chaves[i] != null) {
                System.out.println("(" + chaves[i] + " -> " + valores[i] + ")");
            } else {
                System.out.println("null");
            }
        }
    }
}

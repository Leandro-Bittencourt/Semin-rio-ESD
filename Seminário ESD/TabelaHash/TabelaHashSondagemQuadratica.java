// Classe genérica: permite escolher o tipo de chave (K) e valor (V)
public class TabelaHashSondagemQuadratica<K,V> {

    // Vetor onde guardamos as chaves
    private K[] chaves;

    // Vetor paralelo que guarda os valores
    private V[] valores;

    // Contador de quantos elementos a tabela possui
    private int tamanho;

    // Construtor: define o tamanho inicial da tabela
    @SuppressWarnings("unchecked")
    public TabelaHashSondagemQuadratica(int capacidade) {
        // Criamos dois vetores do mesmo tamanho (para chaves e valores)
        chaves = (K[]) new Object[capacidade];
        valores = (V[]) new Object[capacidade];
        tamanho = 0; // Inicialmente vazia
    }

    // Função hash: transforma a chave em um índice dentro do vetor
    private int hash(K chave) {
        // hashCode() gera um número; % garante que fique no tamanho do vetor
        return Math.abs(chave.hashCode() % chaves.length);
    }

    // Método para inserir uma chave e valor
    public void inserir(K chave, V valor) {
        int indice = hash(chave); // Primeiro índice sugerido pela função hash
        int i = 1;                // Contador usado para o salto quadrático (1, 2, 3...)

        // Enquanto a posição estiver ocupada e a chave for diferente, precisamos sondar
        while (chaves[indice] != null && !chaves[indice].equals(chave)) {
            // Atualiza índice com salto quadrático
            indice = (indice + i * i) % chaves.length;
            i++; // Aumenta o salto progressivamente
        }

        // Quando encontramos índice vazio OU a mesma chave, inserimos/atualizamos
        chaves[indice] = chave;
        valores[indice] = valor;
        tamanho++; // Incrementa o número de elementos
    }

    // Método para buscar o valor associado a uma chave
    public V buscar(K chave) {
        int indice = hash(chave); // Ponto de partida
        int i = 1;                // Início da sondagem quadrática

        // Enquanto houver algo na posição atual, procuramos a chave correta
        while (chaves[indice] != null) {
            if (chaves[indice].equals(chave)) // Encontrou?
                return valores[indice];       // Retorna o valor associado

            // Caso não seja essa chave, pula usando sondagem quadrática
            indice = (indice + i * i) % chaves.length;
            i++;
        }

        // Se encontrar uma posição vazia sem achar a chave, então ela não existe
        return null;
    }

    // Método para remover uma chave e seu valor da tabela
    public void remover(K chave) {
        int indice = hash(chave);
        int i = 1;

        // Procura a chave usando saltos quadráticos
        while (chaves[indice] != null) {
            if (chaves[indice].equals(chave)) {
                // Removemos a chave e o valor colocando como null
                chaves[indice] = null;
                valores[indice] = null;
                tamanho--;
                return; // Sai após remover
            }
            indice = (indice + i * i) % chaves.length;
            i++;
        }
    }

    // Retorna o número de elementos armazenados
    public int tamanho() { 
        return tamanho; 
    }
}

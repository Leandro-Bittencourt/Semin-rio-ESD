// Classe genérica, permite usar qualquer tipo de chave K e valor V.
public class TabelaHashDuploHash<K,V> {

    // Vetor onde guardamos as chaves
    private K[] chaves;

    // Vetor paralelo que guarda os valores
    private V[] valores;

    // Contador de quantos elementos estão armazenados
    private int tamanho;

    // Construtor que define o tamanho da tabela
    @SuppressWarnings("unchecked")
    public TabelaHashDuploHash(int capacidade) {
        // Criamos vetores paralelos do mesmo tamanho
        chaves = (K[]) new Object[capacidade];
        valores = (V[]) new Object[capacidade];
        tamanho = 0; // Inicialmente, está vazia
    }

    // Primeira função hash: calcula o primeiro índice candidato
    private int hash1(K chave) { 
        return Math.abs(chave.hashCode() % chaves.length); 
    }

    // Segunda função hash: define o passo (salto) usado nas colisões
    private int hash2(K chave) { 
        // Aqui usamos: 7 - (hash mod 7)
        // O número 7 deve ser menor que o tamanho da tabela e de preferência primo.
        return 7 - (Math.abs(chave.hashCode()) % 7); 
    }

    // Método para inserir chave e valor na tabela
    public void inserir(K chave, V valor) {
        int indice = hash1(chave);  // Índice inicial
        int passo = hash2(chave);   // Salto obtido pela segunda função hash

        // Enquanto a posição estiver ocupada por outra chave, pulamos
        while (chaves[indice] != null && !chaves[indice].equals(chave)) {
            indice = (indice + passo) % chaves.length; 
            // Aplicamos o salto, usando módulo para não ultrapassar o vetor
        }

        // Quando encontramos posição vazia OU a mesma chave, armazenamos/atualizamos
        chaves[indice] = chave;
        valores[indice] = valor;
        tamanho++; // Incrementa contagem dos elementos
    }

    // Método para buscar valor associado à chave
    public V buscar(K chave) {
        int indice = hash1(chave);
        int passo = hash2(chave);

        // Enquanto uma posição estiver ocupada, procuramos a chave
        while (chaves[indice] != null) {
            if (chaves[indice].equals(chave)) 
                return valores[indice]; // Se achou, retorna o valor
            indice = (indice + passo) % chaves.length; // Usa salto para procurar
        }

        // Se chegar em posição vazia, a chave não existe
        return null;
    }

    // Método para remover chave da tabela
    public void remover(K chave) {
        int indice = hash1(chave);
        int passo = hash2(chave);

        // Procuramos utilizando o mesmo esquema dual
        while (chaves[indice] != null) {
            if (chaves[indice].equals(chave)) {
                chaves[indice] = null;   // Removemos chave
                valores[indice] = null;  // Removemos valor associado
                tamanho--;
                return; // Saímos após a remoção
            }
            indice = (indice + passo) % chaves.length;
        }
    }

    // Método que retorna quantos elementos existem na tabela
    public int tamanho() { 
        return tamanho; 
    }
}

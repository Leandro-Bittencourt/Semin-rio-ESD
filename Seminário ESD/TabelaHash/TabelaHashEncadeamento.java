// Importamos LinkedList porque cada posição do vetor vai guardar
// uma lista encadeada de pares (chave, valor).
import java.util.LinkedList;

// Criamos uma classe genérica que aceita chave (K) e valor (V).
// Generics permitem usar qualquer tipo: String, Integer, etc.
public class TabelaHashEncadeamento<K, V> {

    // Classe interna para representar um par (chave, valor).
    // Assim, cada objeto Par contém uma chave e um valor juntos.
    private static class Par<K, V> {
        K chave;  // Armazena a chave
        V valor;  // Armazena o valor

        // Construtor da classe Par, recebe chave e valor e guarda internamente.
        Par(K c, V v) { 
            chave = c; 
            valor = v; 
        }
    }

    // Vetor representando a tabela hash.
    // Cada posição guarda uma lista encadeada de pares.
    private LinkedList<Par<K, V>>[] tabela;

    // Variável para contar quantos elementos foram inseridos.
    private int tamanho;

    // Construtor que recebe a capacidade inicial da tabela.
    // @SuppressWarnings serve apenas para esconder avisos do Java.
    @SuppressWarnings("unchecked")
    public TabelaHashEncadeamento(int capacidade) {
        tabela = new LinkedList[capacidade]; // Cria o vetor de listas (inicialmente todas null)
        tamanho = 0;                         // A tabela começa vazia
    }

    // Função hash que calcula o índice no vetor com base na chave.
    private int hash(K chave) {
        // hashCode() transforma a chave em um número.
        // % tabela.length garante que o índice não ultrapasse o tamanho do array.
        // Math.abs() evita índices negativos.
        return Math.abs(chave.hashCode() % tabela.length);
    }

    // Método para inserir chave e valor na tabela.
    public void inserir(K chave, V valor) {
        int indice = hash(chave); // Calcula onde deve ser armazenado

        // Se no índice não tiver lista ainda, criamos uma nova.
        if (tabela[indice] == null) 
            tabela[indice] = new LinkedList<>();

        // Percorremos a lista daquele índice para ver se a chave já existe.
        // Se existir, apenas atualizamos o valor.
        for (Par<K, V> par : tabela[indice]) {
            if (par.chave.equals(chave)) { 
                par.valor = valor; 
                return;            // Atualizado, então saímos do método
            }
        }

        // Se a chave NÃO existe, adicionamos um novo Par (chave, valor).
        tabela[indice].add(new Par<>(chave, valor));
        tamanho++; // Aumentamos o contador de elementos
    }

    // Método para buscar um valor pela chave.
    public V buscar(K chave) {
        int indice = hash(chave);     // Calcula o índice da chave
        if (tabela[indice] == null)   // Se não houver lista, não existe esse dado
            return null;

        // Procuramos na lista o par com a mesma chave.
        for (Par<K, V> par : tabela[indice]) {
            if (par.chave.equals(chave)) 
                return par.valor;    // Encontramos e retornamos o valor
        }

        return null; // Se percorrer toda a lista e não achar, é porque não existe.
    }

    // Método para remover uma chave da tabela.
    public void remover(K chave) {
        int indice = hash(chave); // Calcula onde estaria armazenado
        if (tabela[indice] == null) return; // Não existe nada para remover

        // removeIf remove um elemento se a condição for verdadeira.
        tabela[indice].removeIf(par -> par.chave.equals(chave));
        tamanho--; // Decrementa contagem
    }

    // Método que retorna quantos elementos a tabela tem.
    public int tamanho() { 
        return tamanho; 
    }
}

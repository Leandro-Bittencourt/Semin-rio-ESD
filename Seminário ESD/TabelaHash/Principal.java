public class Principal {
    public static void main(String[] args) {

        System.out.println("=== Teste: Encadeamento ===");
        TabelaHashEncadeamento<String, Integer> enc = new TabelaHashEncadeamento<>(5);

        enc.inserir("Arthur", 15);
        enc.inserir("Leandro", 22);
        enc.inserir("Cauã", 18);
        enc.inserir("Lucas", 30);
        enc.inserir("Mateo", 10);

        System.out.println("Valor de 'Leandro': " + enc.buscar("Leandro"));
        enc.remover("Cauã");
        System.out.println("Após remover Cauã: " + enc.buscar("Cauã"));



        System.out.println("\n=== Teste: Sondagem Linear ===");
        TabelaHashSondagemLinear<String, Integer> lin = new TabelaHashSondagemLinear<>(7);

        lin.inserir("Arthur", 15);
        lin.inserir("Leandro", 22);
        lin.inserir("Cauã", 18);
        lin.inserir("Lucas", 30);
        lin.inserir("Mateo", 10);

        System.out.println("Valor de 'Lucas': " + lin.buscar("Lucas"));
        lin.remover("Lucas");
        System.out.println("Após remover Lucas: " + lin.buscar("Lucas"));



        System.out.println("\n=== Teste: Sondagem Quadrática ===");
        TabelaHashSondagemQuadratica<String, Integer> quad = new TabelaHashSondagemQuadratica<>(7);

        quad.inserir("Arthur", 15);
        quad.inserir("Leandro", 22);
        quad.inserir("Cauã", 18);
        quad.inserir("Lucas", 30);
        quad.inserir("Mateo", 10);

        System.out.println("Valor de 'Mateo': " + quad.buscar("Mateo"));
        quad.remover("Mateo");
        System.out.println("Após remover Mateo: " + quad.buscar("Mateo"));



        System.out.println("\n=== Teste: Duplo Hash ===");
        TabelaHashDuploHash<String, Integer> dup = new TabelaHashDuploHash<>(7);

        dup.inserir("Arthur", 15);
        dup.inserir("Leandro", 22);
        dup.inserir("Cauã", 18);
        dup.inserir("Lucas", 30);
        dup.inserir("Mateo", 10);

        System.out.println("Valor de 'Arthur': " + dup.buscar("Arthur"));
        dup.remover("Arthur");
        System.out.println("Após remover Arthur: " + dup.buscar("Arthur"));
    }
}

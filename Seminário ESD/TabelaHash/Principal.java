import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        System.out.println("=== Teste: Encadeamento ===");
        TabelaHashEncadeamento<String, Integer> enc = new TabelaHashEncadeamento<>(5);

        enc.inserir("Arthur", 1);
        enc.inserir("Leandro", 2);
        enc.inserir("Cauã", 3);
        enc.inserir("Lucas", 4);
        enc.inserir("Mateo", 5);

        System.out.println("Valor de 'Leandro': " + enc.buscar("Leandro"));
        enc.remover("Cauã");
        System.out.println("Após remover Cauã: " + enc.buscar("Cauã"));



        System.out.println("\n=== Teste: Sondagem Linear ===");
        TabelaHashSondagemLinear<String, Integer> lin = new TabelaHashSondagemLinear<>(7);

        lin.inserir("Arthur", 1);
        lin.inserir("Leandro", 2);
        lin.inserir("Cauã", 3);
        lin.inserir("Lucas", 4);
        lin.inserir("Mateo", 5);

        System.out.println("Valor de 'Lucas': " + lin.buscar("Lucas"));
        lin.remover("Lucas");
        System.out.println("Após remover Lucas: " + lin.buscar("Lucas"));



        System.out.println("\n=== Teste: Sondagem Quadrática ===");
        TabelaHashSondagemQuadratica<String, Integer> quad = new TabelaHashSondagemQuadratica<>(7);

        quad.inserir("Arthur", 1);
        quad.inserir("Leandro", 2);
        quad.inserir("Cauã", 3);
        quad.inserir("Lucas", 4);
        quad.inserir("Mateo", 5);

        System.out.println("Valor de 'Mateo': " + quad.buscar("Mateo"));
        quad.remover("Mateo");
        System.out.println("Após remover Mateo: " + quad.buscar("Mateo"));



        System.out.println("\n=== Teste: Duplo Hash ===");
        TabelaHashDuploHash<String, Integer> dup = new TabelaHashDuploHash<>(7);

        dup.inserir("Arthur", 1);
        dup.inserir("Leandro", 2);
        dup.inserir("Cauã", 3);
        dup.inserir("Lucas", 4);
        dup.inserir("Mateo", 5);

        System.out.println("Valor de 'Arthur': " + dup.buscar("Arthur"));
        dup.remover("Arthur");
        System.out.println("Após remover Arthur: " + dup.buscar("Arthur"));

        // Menu interativo para testar inserção/busca/remocao e imprimir
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Menu Interativo: [0] Sair | [1] Encadeamento | [2] Sondagem Linear | [3] Sondagem Quadrática | [4] Duplo Hash");
            System.out.print("Escolha a tabela: ");
            int opc;
            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (Exception e) { System.out.println("Entrada inválida"); continue; }
            if (opc == 0) break;

            switch (opc) {
                case 1:
                    menuInterativoEncadeamento(sc, enc);
                    break;
                case 2:
                    menuInterativoLinear(sc, lin);
                    break;
                case 3:
                    menuInterativoQuadratica(sc, quad);
                    break;
                case 4:
                    menuInterativoDuplo(sc, dup);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }

    private static void menuInterativoEncadeamento(Scanner sc, TabelaHashEncadeamento<String,Integer> t) {
        while (true) {
            System.out.println("\nEncadeamento: [0] Voltar | [1] Inserir | [2] Buscar | [3] Remover | [4] Imprimir");
            System.out.print("Opção: ");
            int op;
            try { op = Integer.parseInt(sc.nextLine()); } catch (Exception e) { System.out.println("Entrada inválida"); continue; }
            if (op == 0) break;
            switch (op) {
                case 1:
                    System.out.print("Chave (String): ");
                    String k1 = sc.nextLine();
                    System.out.print("Valor (int): ");
                    int v1 = Integer.parseInt(sc.nextLine());
                    t.inserir(k1, v1);
                    break;
                case 2:
                    System.out.print("Chave (String) a buscar: ");
                    String bk = sc.nextLine();
                    System.out.println("Resultado: " + t.buscar(bk));
                    break;
                case 3:
                    System.out.print("Chave (String) a remover: ");
                    String rk = sc.nextLine();
                    t.remover(rk);
                    break;
                case 4:
                    t.imprimir();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void menuInterativoLinear(Scanner sc, TabelaHashSondagemLinear<String,Integer> t) {
        while (true) {
            System.out.println("\nSondagem Linear: [0] Voltar | [1] Inserir | [2] Buscar | [3] Remover | [4] Imprimir");
            System.out.print("Opção: ");
            int op;
            try { op = Integer.parseInt(sc.nextLine()); } catch (Exception e) { System.out.println("Entrada inválida"); continue; }
            if (op == 0) break;
            switch (op) {
                case 1:
                    System.out.print("Chave (String): ");
                    String k1 = sc.nextLine();
                    System.out.print("Valor (int): ");
                    int v1 = Integer.parseInt(sc.nextLine());
                    t.inserir(k1, v1);
                    break;
                case 2:
                    System.out.print("Chave (String) a buscar: ");
                    String bk = sc.nextLine();
                    System.out.println("Resultado: " + t.buscar(bk));
                    break;
                case 3:
                    System.out.print("Chave (String) a remover: ");
                    String rk = sc.nextLine();
                    t.remover(rk);
                    break;
                case 4:
                    t.imprimir();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void menuInterativoQuadratica(Scanner sc, TabelaHashSondagemQuadratica<String,Integer> t) {
        while (true) {
            System.out.println("\nSondagem Quadrática: [0] Voltar | [1] Inserir | [2] Buscar | [3] Remover | [4] Imprimir");
            System.out.print("Opção: ");
            int op;
            try { op = Integer.parseInt(sc.nextLine()); } catch (Exception e) { System.out.println("Entrada inválida"); continue; }
            if (op == 0) break;
            switch (op) {
                case 1:
                    System.out.print("Chave (String): ");
                    String k1 = sc.nextLine();
                    System.out.print("Valor (int): ");
                    int v1 = Integer.parseInt(sc.nextLine());
                    t.inserir(k1, v1);
                    break;
                case 2:
                    System.out.print("Chave (String) a buscar: ");
                    String bk = sc.nextLine();
                    System.out.println("Resultado: " + t.buscar(bk));
                    break;
                case 3:
                    System.out.print("Chave (String) a remover: ");
                    String rk = sc.nextLine();
                    t.remover(rk);
                    break;
                case 4:
                    t.imprimir();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void menuInterativoDuplo(Scanner sc, TabelaHashDuploHash<String,Integer> t) {
        while (true) {
            System.out.println("\nDuplo Hash: [0] Voltar | [1] Inserir | [2] Buscar | [3] Remover | [4] Imprimir");
            System.out.print("Opção: ");
            int op;
            try { op = Integer.parseInt(sc.nextLine()); } catch (Exception e) { System.out.println("Entrada inválida"); continue; }
            if (op == 0) break;
            switch (op) {
                case 1:
                    System.out.print("Chave (String): ");
                    String k1 = sc.nextLine();
                    System.out.print("Valor (int): ");
                    int v1 = Integer.parseInt(sc.nextLine());
                    t.inserir(k1, v1);
                    break;
                case 2:
                    System.out.print("Chave (String) a buscar: ");
                    String bk = sc.nextLine();
                    System.out.println("Resultado: " + t.buscar(bk));
                    break;
                case 3:
                    System.out.print("Chave (String) a remover: ");
                    String rk = sc.nextLine();
                    t.remover(rk);
                    break;
                case 4:
                    t.imprimir();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

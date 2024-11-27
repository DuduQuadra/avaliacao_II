package avaliação_II;

public class Main {
    public static void main(String[] args) {
        // Criando países
        Pais brasil = new Pais("BRA", "Brasil", 8515767.049);
        brasil.setPopulacao(213317639);

        Pais argentina = new Pais("ARG", "Argentina", 2780400);
        argentina.setPopulacao(45376763);

        Pais uruguai = new Pais("URU", "Uruguai", 176215);
        uruguai.setPopulacao(3473727);

        Pais chile = new Pais("CHL", "Chile", 756102);
        chile.setPopulacao(19087000);

        // Adicionando fronteiras
        brasil.adicionarFronteira(argentina);
        brasil.adicionarFronteira(uruguai);
        argentina.adicionarFronteira(uruguai);
        argentina.adicionarFronteira(chile);

        // Criando continente
        Continente americaDoSul = new Continente("América do Sul");
        americaDoSul.adicionarPais(brasil);
        americaDoSul.adicionarPais(argentina);
        americaDoSul.adicionarPais(uruguai);
        americaDoSul.adicionarPais(chile);

        // Testando o método de vizinhos comuns
        System.out.println("Vizinhos comuns entre Brasil e Argentina:");
        for (Pais vizinho : brasil.getVizinhosComuns(argentina)) {
            System.out.println(vizinho.getNome());
        }

        System.out.println("Vizinhos comuns entre Brasil e Chile:");
        for (Pais vizinho : brasil.getVizinhosComuns(chile)) {
            System.out.println(vizinho.getNome());
        }

        // Testando os métodos do continente
        System.out.println("Dimensão total do continente: " + americaDoSul.getDimensaoTotal());
        System.out.println("População total do continente: " + americaDoSul.getPopulacaoTotal());
        System.out.println("Densidade populacional do continente: " + americaDoSul.getDensidadePopulacional());

        // Testando os países com maior e menor dimensão
        Pais maiorDimensao = americaDoSul.getPaisMaiorDimensao();
        Pais menorDimensao = americaDoSul.getPaisMenorDimensao();

        System.out.println("País de maior dimensão territorial: " + maiorDimensao.getNome());
        System.out.println("País de menor dimensão territorial: " + menorDimensao.getNome());

        // Testando a razão territorial
        double razaoTerritorial = americaDoSul.getRazaoTerritorial();
        System.out.println("Razão territorial do maior país em relação ao menor país: " + razaoTerritorial);
    }
}

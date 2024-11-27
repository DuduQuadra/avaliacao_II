package avaliação_II;

import java.util.ArrayList;
import java.util.List;

public class Continente {
    private List<Pais> paises;

    // Construtor para inicializar o nome do continente e a lista de países
    public Continente(String nome) {
        this.paises = new ArrayList<>();
    }

    // Método para adicionar um país ao continente
    public void adicionarPais(Pais pais) {
        if (!paises.contains(pais)) {
            paises.add(pais);
        }
    }

    // Método que retorna a dimensão total do continente (somando as dimensões dos países)
    public double getDimensaoTotal() {
        return paises.stream().mapToDouble(Pais::getDimensao).sum();
    }

    // Método que retorna a população total do continente (somando a população dos países)
    public long getPopulacaoTotal() {
        return paises.stream().mapToLong(Pais::getPopulacao).sum();
    }

    // Método que retorna a densidade populacional do continente
    public double getDensidadePopulacional() {
        return getPopulacaoTotal() / getDimensaoTotal();
    }

    // Método que retorna o país com maior população no continente
    public Pais getPaisMaiorPopulacao() {
        return paises.stream().max((p1, p2) -> Long.compare(p1.getPopulacao(), p2.getPopulacao())).orElse(null);
    }

    // Método que retorna o país com menor população no continente
    public Pais getPaisMenorPopulacao() {
        return paises.stream().min((p1, p2) -> Long.compare(p1.getPopulacao(), p2.getPopulacao())).orElse(null);
    }

    // Método que retorna o país de maior dimensão territorial no continente
    public Pais getPaisMaiorDimensao() {
        return paises.stream().max((p1, p2) -> Double.compare(p1.getDimensao(), p2.getDimensao())).orElse(null);
    }

    // Método que retorna o país de menor dimensão territorial no continente
    public Pais getPaisMenorDimensao() {
        return paises.stream().min((p1, p2) -> Double.compare(p1.getDimensao(), p2.getDimensao())).orElse(null);
    }

    // Método que retorna a razão territorial do maior país em relação ao menor país
    public double getRazaoTerritorial() {
        Pais maior = getPaisMaiorDimensao();
        Pais menor = getPaisMenorDimensao();
        if (maior != null && menor != null) {
            return maior.getDimensao() / menor.getDimensao();
        }
        return 0; // Caso não haja país de maior e menor dimensão
    }
}

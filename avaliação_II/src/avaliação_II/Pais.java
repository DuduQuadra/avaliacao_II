package avaliação_II;


import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String codigoISO;
    private String nome;
    private long populacao;
    private double dimensao;
    private List<Pais> paisesFronteira;

    // Construtor
    public Pais(String codigoISO, String nome, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.dimensao = dimensao;
        this.paisesFronteira = new ArrayList<>();
    }

    // Getters e Setters
    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public List<Pais> getPaisesFronteira() {
        return paisesFronteira;
    }

    // Adicionar país fronteiriço (máximo de 40)
    public void adicionarFronteira(Pais pais) {
        if (paisesFronteira.size() < 40 && !paisesFronteira.contains(pais)) {
            paisesFronteira.add(pais);
            pais.getPaisesFronteira().add(this); // Garantir reciprocidade
        }
    }

    // Comparação semântica
    public boolean equals(Pais outroPais) {
        return this.codigoISO.equals(outroPais.getCodigoISO());
    }

    // Verificar se outro país é fronteiriço
    public boolean isLimitrofe(Pais pais) {
        return paisesFronteira.contains(pais);
    }

    // Calcular densidade populacional
    public double getDensidadePopulacional() {
        return (double) populacao / dimensao;
    }

    // Encontrar vizinhos comuns
    public List<Pais> getVizinhosComuns(Pais outroPais) {
        List<Pais> vizinhosComuns = new ArrayList<>();
        // Verificando se ambos têm vizinhos em comum
        for (Pais vizinho : paisesFronteira) {
            if (outroPais.getPaisesFronteira().contains(vizinho)) {
                vizinhosComuns.add(vizinho);
            }
        }
        return vizinhosComuns;
    }
}

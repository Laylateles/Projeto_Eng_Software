package br.inatel.engsoftware;

import java.util.ArrayList;
import java.util.List;

public class Prestador extends Usuario {

    private String profissao;
    private String descricao;
    private String cidade;
    private double valorHora;
    private List<String> servicos;
    private List<Avaliacao> avaliacoesRecebidas;

    public Prestador(int id, String nome, String email, String senha, String telefone,
                     CriptografiaService criptografiaService,
                     String profissao, String descricao, String cidade, double valorHora) {
        super(id, nome, email, senha, telefone, criptografiaService);
        this.profissao = profissao;
        this.descricao = descricao;
        this.cidade = cidade;
        this.valorHora = valorHora;
        this.servicos = new ArrayList<>();
        this.avaliacoesRecebidas = new ArrayList<>();
    }


    public String getProfissao() { return profissao; }
    public void setProfissao(String profissao) { this.profissao = profissao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public double getValorHora() { return valorHora; }
    public void setValorHora(double valorHora) { this.valorHora = valorHora; }

    public List<String> getServicos() { return servicos; }

    public void cadastrarServico(String servico) {
        if (servico != null && !servico.isBlank() && !servicos.contains(servico)) {
            servicos.add(servico);
        }
    }

    public void removerServico(String servico) {
        servicos.remove(servico);
    }

    public List<Avaliacao> listarAvaliacoesRecebidas() {
        return avaliacoesRecebidas;
    }

    public void receberAvaliacao(Avaliacao avaliacao) {
        avaliacoesRecebidas.add(avaliacao);
    }

    @Override
    public void exibirPerfil() {
        super.exibirPerfil();
        System.out.println("Profissão: " + profissao);
        System.out.println("Descrição: " + descricao);
        System.out.println("Cidade: " + cidade);
        System.out.println("Valor/hora: R$ " + valorHora);
        System.out.println("Serviços: " + servicos);
    }
}
package br.ufpb.dcx.Loja;

import java.util.Collection;

public interface Loja {

    public boolean cadastraContato(String nome, int cpf, int celular);
    public Collection<Contato> pesquisarClientes(int cpf, int celular);
    public boolean removeContato(String nome);
    public boolean adicionarCarro(String modelo, int ano, double quilometragem, double placa);
    public boolean removerCarro(double placa);
    Collection<LojaCarro> pesquisarCarros(double placa, int ano);
}

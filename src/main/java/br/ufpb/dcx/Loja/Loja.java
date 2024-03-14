package br.ufpb.dcx.Loja;

import java.util.Collection;

public interface Loja {

    public boolean cadastraContato(String nome, int cpf, int celular);
    public Collection<Cliente> pesquisarClientes(int cpf, int celular);
    public boolean removeContato(String nome);
    public boolean adicionarCarro(String modelo, int ano, double quilometragem, String placa);
    public boolean removerCarro(String placa);
    Collection<Carro> pesquisarCarros(String placa, int ano);
}

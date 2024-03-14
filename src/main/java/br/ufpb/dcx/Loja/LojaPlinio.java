package br.ufpb.dcx.Loja;

import java.io.IOException;
import java.util.*;

public class LojaPlinio implements Loja {
    private Map<String, Cliente> contatos;
    private Map<String, Carro> lojaCarro;
    private GravadorDeDados gravador = new GravadorDeDados();

    public LojaPlinio(){
        this.contatos = new HashMap<>();
        this.lojaCarro = new HashMap<>();
        recuperaDados();
        recuperaCarros();
    }


    public void salvarDados(){
        try {
            this.gravador.salvarContatos(this.contatos);
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void salvarCarros(){
        try {
            this.gravador.salvarCarros(this.lojaCarro);
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void recuperaDados(){
        try {
            this.contatos = this.gravador.recuperarContatos();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public void recuperaCarros(){
        try {
            this.lojaCarro = this.gravador.recuperarCarros();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean cadastraContato(String nome, int cpf, int celular) {
        if (!contatos.containsKey(nome)){
            this.contatos.put(nome, new Cliente(nome,cpf, celular));
            salvarDados();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<Cliente> pesquisarClientes(int cpf, int celular) {
        Collection<Cliente> contatosAchados = new ArrayList<>();
        for (Cliente c: this.contatos.values()){
            if (c.getCpf()==cpf && c.getCelular()==celular){
                contatosAchados.add(c);
            }
        }
        return contatosAchados;
    }

    @Override
    public boolean removeContato(String nome) {
        if (this.contatos.containsKey(nome)){
            this.contatos.remove(nome);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean adicionarCarro(String modelo, int ano, double quilometragem, String placa) {
        if (!lojaCarro.containsKey(placa)) {
            this.lojaCarro.put(placa, new Carro(modelo, ano, quilometragem, placa));
            salvarCarros();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removerCarro(String placa) {

        if(this.lojaCarro.containsKey(placa)) {
            this.lojaCarro.remove(placa);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Collection<Carro> pesquisarCarros(String placa, int ano) {
        Collection<Carro> carrosAchados = new ArrayList<>();
        for ( Carro c: this.lojaCarro.values()){
            if (c.getPlaca()==placa && c.getAno()==ano){
                carrosAchados.add(c);
            }
    }
        return carrosAchados;
    }
}

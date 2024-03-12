package br.ufpb.dcx.Loja;

import java.io.IOException;
import java.util.*;

public class LojaPlinio implements Loja {
    private Map<String, Contato> contatos;
    private Map<String, LojaCarro> lojaCarro;
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
            this.contatos.put(nome, new Contato(nome,cpf, celular));
            salvarDados();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<Contato> pesquisarClientes(int cpf, int celular) {
        Collection<Contato> contatosAchados = new ArrayList<>();
        for (Contato c: this.contatos.values()){
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
    public boolean adicionarCarro(String modelo, int ano, double quilometragem, double placa) {
        String chavePlaca = Double.toString(placa);

        if (!lojaCarro.containsKey(chavePlaca)) {
            this.lojaCarro.put(chavePlaca, new LojaCarro(modelo, ano, quilometragem, placa));
            salvarCarros();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removerCarro(double placa) {
        String chavePlaca = Double.toString(placa);
        if(this.lojaCarro.containsKey(chavePlaca)) {
            this.lojaCarro.remove(chavePlaca);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Collection<LojaCarro> pesquisarCarros(double placa, int ano) {
        Collection<LojaCarro> carrosAchados = new ArrayList<>();
        for ( LojaCarro c: this.lojaCarro.values()){
            if (c.getPlaca()==placa && c.getAno()==ano){
                carrosAchados.add(c);
            }
    }
        return carrosAchados;
    }
}

package br.ufpb.dcx.Loja;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable {

    private String nome;
    private int cpf;
    private int celular;

    public Contato(String nome, int cpf, int celular){
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Double.compare(cpf, contato.cpf) == 0 && celular == contato.celular && Objects.equals(nome, contato.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, celular);
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular){this.celular = celular;}

    public String toString(){
        return this.nome+":"+this.cpf+"/"+this.celular;
    }
}

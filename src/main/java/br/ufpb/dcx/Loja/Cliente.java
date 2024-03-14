package br.ufpb.dcx.Loja;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {

    private String nome;
    private long cpf;
    private long celular;

    public Cliente(String nome, long cpf, long celular){
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente contato = (Cliente) o;
        return Double.compare(cpf, contato.cpf) == 0 && celular == contato.celular && Objects.equals(nome, contato.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, celular);
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular){this.celular = celular;}

    public String toString(){
        return this.nome+":"+this.cpf+"/"+this.celular;
    }
}

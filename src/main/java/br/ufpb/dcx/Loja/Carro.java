package br.ufpb.dcx.Loja;

import java.io.Serializable;
import java.util.Objects;

public class Carro implements Serializable {

    private String modelo;
    private int ano;
    private double quilometragem;
    private String placa;



    public Carro(String modelo, int ano, double quilometragem, String placa) {
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.placa = placa;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(placa, carro.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    @Override
    public String toString() {
        return "Caro: " + this.modelo + "\nAno: "  + this.ano + " \nQuilometragem: " + this.quilometragem + " \nPlaca = " + this.placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}



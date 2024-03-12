package br.ufpb.dcx.Loja;

import java.io.Serializable;
import java.util.Objects;

public class LojaCarro implements Serializable {

    private String modelo;
    private int ano;
    private double quilometragem;
    private double placa;



    public LojaCarro(String modelo, int ano, double quilometragem, double placa) {
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.placa = placa;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LojaCarro lojaCarro = (LojaCarro) o;
        return Double.compare(placa, lojaCarro.placa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    @Override
    public String toString() {
        return "Carro: " +
                "modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", quilometragem=" + quilometragem +
                ", placa=" + placa +
                '}';
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

    public double getPlaca() {
        return placa;
    }

    public void setPlaca(double placa) {
        this.placa = placa;
    }
}


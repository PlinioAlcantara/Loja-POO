package br.ufpb.dcx.Loja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class CarroSearchController implements ActionListener {
    private Loja loja;
    private JFrame janelaPrincipal;

    public CarroSearchController(Loja loja, JFrame janela) {
        this.loja = loja;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String placa = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual a placa  do Carro? ");
        int ano = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o ano do Carro? " ));
        Collection<Carro> carros = loja.pesquisarCarros(placa, ano);
        if (carros.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Carro encontrado com sucesso:");
            for (Carro c: carros) {
                JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Não foi encontrado nenhum Carro com esses dados");
        }
    }
}


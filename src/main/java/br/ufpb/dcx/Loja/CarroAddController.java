package br.ufpb.dcx.Loja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CarroAddController implements ActionListener {
    private Loja loja;
    private JFrame janelaPrincipal;

    public CarroAddController(Loja loja, JFrame janela) {
        this.loja = loja;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String modelo = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o modelo do carro?");
        int ano = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o ano do carro? "));
        double quilometragem = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual a quilometragem do carro?" ));
        double placa = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,
                "informe a placa do carro?" ));

        boolean cadastrou = loja.adicionarCarro( modelo, ano, quilometragem, placa);
        if (cadastrou){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Carro Cadastrado");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Carro não foi cadastrado " +
                            "Verifique se já não existia");
        }
    }

}

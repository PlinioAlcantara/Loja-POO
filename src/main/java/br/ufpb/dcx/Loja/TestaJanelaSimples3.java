package br.ufpb.dcx.Loja;

import javax.swing.*;
import java.awt.*;

public class TestaJanelaSimples3 {
    public static void main(String [] args){
        JFrame janela = new JFrame();
        janela.setTitle("Janela de teste 3");
        janela.setLocation(0,0);
        janela.setSize(400,400);
        JButton botao = new JButton("Meu Botão");
        botao.setToolTipText("Dica: Meu botão de teste");
        botao.addActionListener((ae) -> JOptionPane.showMessageDialog(janela,
                "Testando botão"));
        janela.setLayout(new GridLayout(3,1));
        janela.add(new JLabel());
        janela.add(botao);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}

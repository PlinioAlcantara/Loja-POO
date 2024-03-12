package br.ufpb.dcx.Loja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LojaAddController implements ActionListener {
    private Loja loja;
    private JFrame janelaPrincipal;

    public LojaAddController(Loja loja, JFrame janela) {
        this.loja = loja;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o nome do Cliente?");
        int cpf = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o CPF do Cliente? "));
        int celular = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o Celular do Cliente?" ));

        boolean cadastrou = loja.cadastraContato(nome, cpf, celular);
        if (cadastrou){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Cliente Cadastrado");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Cliente não foi cadastrado " +
                            "Verifique se já não existia");
        }
    }

}

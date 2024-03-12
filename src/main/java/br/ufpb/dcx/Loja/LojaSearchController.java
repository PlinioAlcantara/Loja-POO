package br.ufpb.dcx.Loja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class LojaSearchController implements ActionListener {
    private Loja loja;
    private JFrame janelaPrincipal;

    public LojaSearchController(Loja agenda, JFrame janela) {
        this.loja = agenda;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int cpf = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o CPF do Cliente?"));
        int celular = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o celular do Cliente?" ));
        Collection<Contato> clientes = loja.pesquisarClientes(cpf, celular);
        if (clientes.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Cliente encontrado com sucesso:");
            for (Contato c: clientes) {
                JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Não foi encontrado nenhum Cliente com esses dados");
        }
    }
}

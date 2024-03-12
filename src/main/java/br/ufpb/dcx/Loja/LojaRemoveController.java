package br.ufpb.dcx.Loja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LojaRemoveController implements ActionListener {
    private Loja agenda;
    private JFrame janelaPrincipal;
    public LojaRemoveController(Loja agenda, JFrame janela) {
        this.agenda = agenda;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o nome do Cliente?");
        boolean removeu = agenda.removeContato(nome);
        if (removeu){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Cliente removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Cliente não foi encontrado. "+
                            "Operação não realizada");
        }
    }
}

package br.ufpb.dcx.Loja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverCarroController implements ActionListener {
    private Loja loja;
    private JFrame janelaPrincipal;
    public RemoverCarroController(Loja loja, JFrame janela) {
        this.loja = loja;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String placa = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual a placa do carro?");
        boolean removeu = loja.removerCarro(Double.parseDouble(placa));
        if (removeu){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Carro removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Carro não foi encontrado. "+
                            "Operação não realizada");
        }
    }
}

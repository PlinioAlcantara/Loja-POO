package br.ufpb.dcx.Loja;

import javax.swing.*;
import java.awt.*;

public class LojaGUIV3ComMenu extends JFrame {
    JLabel linha1, linha2;
    ImageIcon boloImg = new ImageIcon("./imgs/carros.jpg");
    Loja loja = new LojaPlinio();
    JMenuBar barraDeMenu = new JMenuBar();

    public LojaGUIV3ComMenu() {
        setTitle("Agenda de Aniversários");
        setSize(800, 600); //tamanho da janela
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.white);
        linha1 = new JLabel("Carros usados", JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("serif", Font.BOLD, 24));
        linha2 = new JLabel(boloImg, JLabel.CENTER);
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarAniversariante = new JMenuItem(
                "Cadastrar Cliente");
        menuCadastrar.add(menuCadastrarAniversariante);
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarAniversariante = new JMenuItem(
                "Pesquisar Cliente");
        menuPesquisar.add(menuPesquisarAniversariante);
        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverAniversariante = new JMenuItem(
                "Remover Cliente");
        menuRemover.add(menuRemoverAniversariante);
        menuPesquisarAniversariante.addActionListener(
                new LojaSearchController(loja,this));
        menuRemoverAniversariante.addActionListener(
                new LojaRemoveController(loja, this));
        menuCadastrarAniversariante.addActionListener(
                (ae) -> {
                    String nome = JOptionPane.showInputDialog(this,
                            "Qual o nome do Cliente?");
                    int dia = Integer.parseInt(JOptionPane.showInputDialog(this,
                            "Qual o CPF do Cliente? "));
                    int mes = Integer.parseInt(JOptionPane.showInputDialog(this,
                            "Qual o número do celular do cliente?"));
                    boolean cadastrou = loja.cadastraContato(nome, dia, mes);
                    if (cadastrou) {
                        JOptionPane.showMessageDialog(this,
                                "Cliente cadastrado");
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Cliente não foi cadastrado. " +
                                        "Verifique se já não existia");
                    }
                });
        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        setJMenuBar(barraDeMenu);
    }

    //...
    public static void main(String[] args) {
        JFrame janela = new LojaGUIV3ComMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

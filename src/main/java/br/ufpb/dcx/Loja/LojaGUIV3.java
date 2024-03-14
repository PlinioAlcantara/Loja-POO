package br.ufpb.dcx.Loja;

import javax.swing.*;
import java.awt.*;

public class LojaGUIV3 extends JFrame {
    JLabel linha1, linha2, linha3;
    ImageIcon carrosImg = new ImageIcon("./imgs/carros.png");
    ImageIcon addImg = new ImageIcon("./imgs/icons/add_person.png");
    ImageIcon pesqImg = new ImageIcon("./imgs/icons/search_person.png");
    ImageIcon removeImg = new ImageIcon("./imgs/icons/remove_person.png");
    ImageIcon pesqCarroImg = new ImageIcon("./imgs/icons/buscarCarro.png");
    ImageIcon addCarroImg = new ImageIcon("./imgs/icons/adicionarcarro.png");
    ImageIcon removerCarroImg = new ImageIcon("./imgs/icons/removercarro.png");
    JButton botaoAdicionar, botaoPesquisar, botaoRemover, botaoPesquisarCarro, botaoAddCarro, botaoRemoverCarro;
    Loja loja = new LojaPlinio();

    public LojaGUIV3() {
        setTitle("Carros usados");
        setSize(900, 800);
        setLocation(10, 10);
        setResizable(true);
        getContentPane().setBackground(Color.white);
        linha1 = new JLabel("Loja de carros usados", JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("Robot", Font.BOLD, 40));
        linha2 = new JLabel(carrosImg, JLabel.CENTER);


        botaoAdicionar = new JButton("Adicionar Clientes", addImg);
        botaoAdicionar.addActionListener(new LojaAddController(loja, this));

        Image imagemPesqRedimensionada = pesqCarroImg.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon pesqCarroImgRedimensionada = new ImageIcon(imagemPesqRedimensionada);
        botaoPesquisarCarro = new JButton("pesquisar Carro", pesqCarroImgRedimensionada);
        botaoPesquisarCarro.addActionListener(new CarroSearchController(loja, this));

        botaoPesquisar = new JButton("Pesquisar Clientes", pesqImg);
        botaoPesquisar.addActionListener(new LojaSearchController(loja, this));
        botaoRemover = new JButton("Remover Cliente", removeImg);
        botaoRemover.addActionListener(new LojaRemoveController(loja, this));

        Image imagemAddRedimensionada = addCarroImg.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon addCarroImgRedimensionada = new ImageIcon(imagemAddRedimensionada);
        botaoAddCarro = new JButton("Adicionar carro", addCarroImgRedimensionada);
        botaoAddCarro.addActionListener(new CarroAddController(loja, this));

        Image imagemRedimensionada = removerCarroImg.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon removerCarroImgRedimensionada = new ImageIcon(imagemRedimensionada);
        botaoRemoverCarro = new JButton("Remover carro", removerCarroImgRedimensionada);
        botaoRemoverCarro.addActionListener(new RemoverCarroController(loja, this));

        getContentPane().setLayout(new GridLayout(4, 2));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
        getContentPane().add(botaoAdicionar);
        getContentPane().add(botaoAddCarro);
        getContentPane().add(botaoPesquisar);
        getContentPane().add(botaoPesquisarCarro);
        getContentPane().add(botaoRemover);
        getContentPane().add(botaoRemoverCarro);


    }

    //...
    public static void main(String[] args) {
        JFrame janela = new LojaGUIV3();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

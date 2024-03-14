package br.ufpb.dcx.Loja;

import javax.swing.*;
import java.awt.*;

public class LojaGUIV2 extends JFrame {

    JLabel linha1, linha2, linha3;
    ImageIcon carroImg = new ImageIcon("./imgs/carros.png");
    ImageIcon pesqCarroImg = new ImageIcon("./imgs/pesquisa_carro.png");

    public LojaGUIV2(){
        setTitle("Loja de carros usados");
        setSize(400,400); //tamanho da janela
        setLocation(0, 0);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        linha1 = new JLabel("Carros usados", JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("Robot", Font.BOLD, 30));
        linha2 = new JLabel(carroImg, JLabel.CENTER);
        linha3 = new JLabel(pesqCarroImg, JLabel.CENTER);
        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
        getContentPane().add(linha3);
    }
    //...
    public static void main(String [] args){
        JFrame janela = new LojaGUIV2();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

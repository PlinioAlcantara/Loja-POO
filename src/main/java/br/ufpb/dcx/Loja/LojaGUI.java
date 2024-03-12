package br.ufpb.dcx.Loja;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LojaGUI extends JFrame {
    public LojaGUI(){
        setTitle("Loja de carros usados");
        setSize(400,200);
        setLocation(150, 150);
        //localização da janela na tela
        setResizable(true);
        //janela não redimensionável
        getContentPane().setBackground(Color.lightGray);
    }
    //...
    public static void main(String [] args){
        LojaGUI janela = new LojaGUI();
        janela.setVisible(true);
        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e){

                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanelaPrincipal);

    }
}

package br.ufpb.dcx.Loja;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;

class LojaPlinioTest {
    @Test
    public void testaCadastro(){
        LojaPlinio agenda = new LojaPlinio();
        assertTrue(agenda.pesquisarClientes(3,3).size()==0);
        agenda.cadastraContato("Juliana",3,3);
        assertEquals(1, agenda.pesquisarClientes(3,3).size());
        assertTrue(agenda.pesquisarClientes(3,3).contains(new Cliente("Juliana",3,3)));
    }

    @Test
    public void testaGravacao(){
        File f = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        if (f.exists()){
            f.delete();
        }
        LojaPlinio agenda = new LojaPlinio();
        agenda.cadastraContato("Ana",1,1);
        agenda.salvarDados();
        assertEquals(1, agenda.pesquisarClientes(1,1).size());
        assertTrue(f.exists());
        f.delete();
    }
}
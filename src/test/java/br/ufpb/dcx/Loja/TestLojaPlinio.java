package br.ufpb.dcx.Loja;

import br.ufpb.dcx.Loja.LojaPlinio;
import br.ufpb.dcx.Loja.Cliente;
import br.ufpb.dcx.Loja.Carro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

public class TestLojaPlinio {

    @Test
    public void testCadastraContato() {
        LojaPlinio loja = new LojaPlinio();
        assertTrue(loja.cadastraContato("Fulano", 12345678901L, 9988776655L));
        assertFalse(loja.cadastraContato("Fulano", 12345678901L, 9988776655L));
    }

    @Test
    public void testPesquisarClientes() {
        LojaPlinio loja = new LojaPlinio();
        loja.cadastraContato("Fulano", 12345678901L, 9988776655L);
        Collection<Cliente> clientes = loja.pesquisarClientes(12345678901L, 9988776655L);
        assertEquals(1, clientes.size());
        assertEquals("Fulano", clientes.iterator().next().getNome());
    }

    @Test
    public void testRemoveContato() {
        LojaPlinio loja = new LojaPlinio();
        loja.cadastraContato("Fulano", 12345678901L, 9988776655L);
        assertTrue(loja.removeContato("Fulano"));
        assertFalse(loja.removeContato("Fulano"));
    }

    @Test
    public void testAdicionarCarro() {
        LojaPlinio loja = new LojaPlinio();
        assertTrue(loja.adicionarCarro("Modelo1", 2023, 10000.0, "ABC1234"));
        assertFalse(loja.adicionarCarro("Modelo1", 2023, 10000.0, "ABC1234"));
    }

    @Test
    public void testRemoverCarro() {
        LojaPlinio loja = new LojaPlinio();
        loja.adicionarCarro("Modelo1", 2023, 10000.0, "ABC1234");
        assertTrue(loja.removerCarro("ABC1234"));
        assertFalse(loja.removerCarro("ABC1234"));
    }

    @Test
    public void testPesquisarCarros() {
        LojaPlinio loja = new LojaPlinio();
        loja.adicionarCarro("Modelo1", 2023, 10000.0, "ABC1234");
        Collection<Carro> carros = loja.pesquisarCarros("ABC1234", 2023);
        assertEquals(1, carros.size());
        assertEquals("Modelo1", carros.iterator().next().getModelo());
    }
}

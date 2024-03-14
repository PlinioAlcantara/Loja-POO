package br.ufpb.dcx.Loja;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    public static final String ARQUIVO_CONTATOS = "contatos.dat";
    public static final String ARQUIVO_CARROS = "carros.dat";

    public HashMap<String, Cliente> recuperarContatos() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTATOS));
            return (HashMap<String, Cliente>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar os contatos");
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVO_CONTATOS);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }

    public void salvarContatos(Map<String, Cliente> cliente) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS));
            out.writeObject(cliente);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os contatos no arquivo "+ARQUIVO_CONTATOS);
        }
    }

    public HashMap<String, Carro> recuperarCarros() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_CARROS));
            return (HashMap<String, Carro>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar os carros");
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVO_CARROS);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }

    public void salvarCarros(Map<String, Carro> carros) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CARROS));
            out.writeObject(carros);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os carros no arquivo "+ARQUIVO_CARROS);
        }
    }



}

package br.com.frota.util;

import br.com.frota.DAO.MarcaDAO;
import br.com.frota.model.Marca;

import java.sql.SQLException;
import java.util.List;

public class Teste {
    static MarcaDAO marcaDAO = new MarcaDAO();

    public static void main(String[] args) throws SQLException {

        //salvar
        Marca marca = new Marca("Toyota");
        marcaDAO.insertMarca(marca);

        //buscar por ID
        marca = marcaDAO.selectMarca(1);
        System.out.println(marca);

        //Update
        marca.setDescricao("Volt");
        marcaDAO.updateMarca(marca);
        marca = marcaDAO.selectMarca(1);
        System.out.println(marca);

        //Select all
        List<Marca> marcas = marcaDAO.selectAllMarcas();
        marcas.forEach(System.out::println);

        //Delete
        marcaDAO.deleteMarca(1);
        marcaDAO.selectAllMarcas().forEach(System.out::println);
    }
}

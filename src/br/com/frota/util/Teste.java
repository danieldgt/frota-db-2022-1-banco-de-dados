package br.com.frota.util;

import br.com.frota.DAO.MarcaDAO;
import br.com.frota.model.Marca;

import java.sql.SQLException;
import java.util.List;

public class Teste {
    static MarcaDAO marcaDAO = new MarcaDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(marcaDAO.count());

        //salvar
        Marca marca = new Marca("Citroen");
        marcaDAO.insertMarca(marca);

        //buscar por ID
        marca = marcaDAO.selectMarca(2);
        System.out.println(marca);

        //Update
        marca.setDescricao("Volt");
        marcaDAO.updateMarca(marca);
        marca = marcaDAO.selectMarca(2);
        System.out.println(marca);

        //Select all
        List<Marca> marcas = marcaDAO.selectAllMarcas();
        marcas.forEach(System.out::println);

        //Delete
        marcaDAO.deleteMarca(2);
        marcaDAO.selectAllMarcas().forEach(System.out::println);
    }
}

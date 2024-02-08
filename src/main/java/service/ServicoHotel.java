package service;

import model.EntradaCliente;
import model.Hotel;
import repository.RepositorioHotel;

public class ServicoHotel {
    private static RepositorioHotel repositorioHotel = new RepositorioHotel();

    public static Hotel encontrarHotelMaisBarato(EntradaCliente entradaCliente) {

		return repositorioHotel.buscarHotelMaisBarato(entradaCliente);
		
    }
}

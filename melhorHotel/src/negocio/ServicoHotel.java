package negocio;

import modelo.Hotel;
import repositorio.RepositorioHotel;

public class ServicoHotel {
    private RepositorioHotel repositorioHotel;

    public ServicoHotel(RepositorioHotel repositorioHotel) {
        this.repositorioHotel = repositorioHotel;
    }

    public Hotel encontrarHotelMaisBarato(String datas, String tipoCliente) {
        return repositorioHotel.buscarHotelMaisBarato(datas.split(","), tipoCliente);
    }
}

package main;
import modelo.Hotel;
import negocio.ServicoHotel;
import repositorio.RepositorioHotel;

public class main {
    public static void main(String[] args) {
    	Hotel hotel3 = new Hotel("Azure Horizon Retreat", 5, 220, 100, 150, 40);
        Hotel hotel1 = new Hotel("Palm Plaza Resor", 3, 110, 80, 90, 80);
        Hotel hotel2 = new Hotel("Elegance Haven Hotel", 4, 160, 110, 60, 50);
       


        Hotel[] hoteis = {hotel1, hotel2, hotel3};


        RepositorioHotel repositorioHotel = new RepositorioHotel(hoteis);
        ServicoHotel servicoHotel = new ServicoHotel(repositorioHotel);

        // Entrada
        //String entrada = "Regular: 13Mar2020(fri), 14Mar2020(sat), 15Mar2020(sun)";
        String entrada = "VIP: 13Mar2020(fri), 14Mar2020(sat), 15Mar2020(sun)";
        String[] partesEntrada = entrada.split(":");
        String tipoCliente = partesEntrada[0].trim();
        String datas = partesEntrada[1].trim();

        Hotel hotelMaisBarato = servicoHotel.encontrarHotelMaisBarato(datas, tipoCliente);

        if (hotelMaisBarato != null) {
            System.out.println("Hotel mais barato: " + hotelMaisBarato.getNome());
        } else {
            System.out.println("Nenhum hotel encontrado.");
        }
    }
}

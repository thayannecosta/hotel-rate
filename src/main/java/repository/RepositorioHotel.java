package repository;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import model.EntradaCliente;
import model.EntradaClienteData;
import model.Hotel;

public class RepositorioHotel {
    private List<Hotel> hoteis;


    public RepositorioHotel() {
        Hotel palmPlaza = HotelFactory.createPalmPlazaResor();
        Hotel eleganceHaven = HotelFactory.createEleganceHavenHotel();
        Hotel azureHorizon = HotelFactory.createAzureHorizonRetreat();

        hoteis = Arrays.asList(palmPlaza, eleganceHaven, azureHorizon);
    }

    public Hotel buscarHotelMaisBarato(EntradaCliente entradaCliente) {

        Hotel cheapestHotel = encontrarHotelMaisBarato(hoteis, entradaCliente);

        return cheapestHotel;

    }

    private static Hotel encontrarHotelMaisBarato(List<Hotel> hoteis, EntradaCliente entradaCliente) {
        if (hoteis == null || hoteis.isEmpty()) {
            throw new NoSuchElementException("Lista de hoteis está vazia ou nula.");
        }
        
        Hotel hotelMaisBarato = hoteis.get(0);
        double precoMaisBarato = calcularPrecoTotal(hotelMaisBarato, entradaCliente);
        int qtdEstrelas = hotelMaisBarato.getQtdEstrelas();
    
        for (Hotel hotel : hoteis.subList(1, hoteis.size())) {
            double precoAtual = calcularPrecoTotal(hotel, entradaCliente);
            if (precoAtual < precoMaisBarato) {
                hotelMaisBarato = hotel;
                precoMaisBarato = precoAtual;
                qtdEstrelas = hotel.getQtdEstrelas();
            } else if (precoAtual == precoMaisBarato) {
                if (hotel.getQtdEstrelas() > qtdEstrelas) {
                    hotelMaisBarato = hotel;
                    qtdEstrelas = hotel.getQtdEstrelas();
                }
            }
        }
    
        return hotelMaisBarato;
    }

    private static double calcularPrecoTotal(Hotel hotel, EntradaCliente entradaCliente) {
        double totalPrice = 0;
        for (EntradaClienteData data : entradaCliente.getEntradaClienteData()) {
            if (data.getIsFimDeSemana()) {
                totalPrice += (entradaCliente.getTipoCliente().equals("VIP") || entradaCliente.getTipoCliente().equals("Fidelidade")) ?
                        hotel.getPrecoFdsVip() : hotel.getPrecoFdsRegular();
            } else {
                totalPrice += (entradaCliente.getTipoCliente().equals("VIP") || entradaCliente.getTipoCliente().equals("Fidelidade")) ?
                        hotel.getPrecoSemanaVip() : hotel.getPrecoSemanaRegular();
            }
        }
        return totalPrice;
    }



}

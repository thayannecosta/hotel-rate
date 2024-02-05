package repositorio;

import modelo.Hotel;

public class RepositorioHotel {
    private Hotel[] hoteis;


    public RepositorioHotel(Hotel[] hoteis) {
        this.hoteis = hoteis;
    }

    public Hotel buscarHotelMaisBarato(String[] datas, String tipoCliente) {
        double precoMaisBarato = Double.MAX_VALUE;
        Hotel hotelMaisBarato = null;

        for (Hotel hotel : hoteis) {
            double precoTotal = calcularPrecoTotal(hotel, datas, tipoCliente);

            if (precoTotal < precoMaisBarato || (precoTotal == precoMaisBarato && hotel.getQtdEstrelas() > hotelMaisBarato.getQtdEstrelas())) {
                precoMaisBarato = precoTotal;
                hotelMaisBarato = hotel;
            }
        }

        return hotelMaisBarato;
    }

    private double calcularPrecoTotal(Hotel hotel, String[] datas, String tipoCliente) {
        double precoTotal = 0;

        for (String data : datas) {
            char tipoDia = data.charAt(data.length() - 3); 
            boolean fimDeSemana = tipoDia == 's' || tipoDia == 'u';

            if (fimDeSemana) {
                if (tipoCliente.equals("VIP")) {
                    precoTotal += hotel.getPrecoFdsVip();
                } else {
                    precoTotal += hotel.getPrecoFdsRegular();
                }
            } else {
                if (tipoCliente.equals("VIP")) {
                    precoTotal += hotel.getPrecoSemanaVip();
                } else {
                    precoTotal += hotel.getPrecoSemanaRegular();
                }
            }
        }

        return precoTotal;
    }

}

package repository;

import model.Hotel;

public class HotelFactory {
    public static Hotel createPalmPlazaResor() {
        return new Hotel("Palm Plaza Resor", 3, 110, 80, 90, 80);
    }

    public static Hotel createEleganceHavenHotel() {
        return new Hotel("Elegance Haven Hotel", 4, 160, 110, 60, 50);
    }

    public static Hotel createAzureHorizonRetreat() {
        return new Hotel("Azure Horizon Retreat", 5, 220, 100, 150, 40);
    }
}

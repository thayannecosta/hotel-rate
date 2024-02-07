package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

public class EntradaClienteData {

    private String dataCliente;
    private String diaCliente;
    private boolean isFimDeSemana;

    public EntradaClienteData(String dataCliente, String diaCliente) {
        this.dataCliente = dataCliente;
        this.diaCliente = diaCliente;
        this.isFimDeSemana = this.getIsFimDeSemana();
    }

    public String getDataCliente() {
        return this.dataCliente;
    }

    public String getDiaCliente() {
        return this.diaCliente;
    }

    public boolean getIsFimDeSemana() {
        boolean fimDeSemana = this.diaCliente.equals("sat") || this.diaCliente.equals("sun");

        if(fimDeSemana) { // sábado ou domingo = fim de semana
            return fimDeSemana;
        } else if (this.diaCliente.equals("mon")  || this.diaCliente.equals("tues") ||  // qualquer uma das outras datas = dia de semana
                   this.diaCliente.equals("thur") || this.diaCliente.equals("fri")  ||
                   this.diaCliente.equals("wed")) {
            return false;
        } else {
            return isFimDaSemanaFallback(this.dataCliente); // nenhuma das outras datas = tenta formatar e descobrir qual o dia
        }
    }

    private boolean isFimDaSemanaFallback(String dataCliente) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");

        try {
            LocalDate date = LocalDate.parse(dataCliente, formatter);
            
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            
            return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        } catch (Exception e) {
            throw new NoSuchElementException("::: DATA NO FORMATO INCORRETO.");
        }

    }
    
}

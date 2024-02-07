package model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EntradaCliente {
    private String tipoCliente;
    private List<EntradaClienteData> entradaClienteData;

    public EntradaCliente(String tipoCliente, List<EntradaClienteData> entradaClienteData) {
        this.tipoCliente = tipoCliente;
        this.entradaClienteData = entradaClienteData;
    }

    public String getTipoCliente() {
        return this.tipoCliente;
    }

    public List<EntradaClienteData> getEntradaClienteData() {
        return this.entradaClienteData;
    }

    public static EntradaCliente fromInput(String input) {
        String tipoCliente;
        List<EntradaClienteData> entradaClienteDataList = new ArrayList<>();
        try {
			String[] parts = input.split(":");
			tipoCliente = parts[0].trim();
			String[] datasEntradas = parts[1].trim().split(",");

			for (String data : datasEntradas) {
				String[] partesData = data.split("\\(");
				String dataPura = partesData[0].trim();
				String diaDaSemana = partesData[1].substring(0, partesData[1].length() - 1);
				EntradaClienteData entradaClienteData = new EntradaClienteData(dataPura, diaDaSemana);
				entradaClienteDataList.add(entradaClienteData);
			}
		} catch (Exception e) {
			throw new NoSuchElementException("::: ENTRADA NO FORMATO INCORRETO.");
		}
        
        return new EntradaCliente(tipoCliente, entradaClienteDataList);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tipoCliente: ").append(tipoCliente).append("\n");
        sb.append("entradaClienteData:\n");
        for (EntradaClienteData data : entradaClienteData) {
            sb.append("\n Data: ").append(data.getDataCliente()).append(", Dia: ").append(data.getDiaCliente()).append("\n");
        }
        return sb.toString();
    }

}

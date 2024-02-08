import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.EntradaCliente;
import model.EntradaClienteData;
import model.Hotel;
import repository.HotelFactory;
import service.ServicoHotel;

public class Principal {

	public static void main(String[] args) {
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("::: DESAFIO TÉCNICO -- Hotel [Ruhan Monte, Thayanne Tenório] :::");
		System.out.println("::: Escreva 'sair' para finalizar o programa.                :::");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

		Scanner scanner = new Scanner(System.in);

		// Entrando em loop pra manter o programa rodando
		while (true) {
			System.out.println("\n\n::: BUSQUE PELO HOTEL MAIS BARATO: (<tipo_do_cliente>: <data_1>, <data_2>, <data_3>, ...)");

			String value = scanner.nextLine();

			// Pular execução se input for vazio
			if (value.isEmpty() || value == null) continue;

			// Saída do loop
			if (value.equals("sair")) break;

			// Processando entrada 
			EntradaCliente entradaCliente = EntradaCliente.fromInput(value);

			// Buscando hotel mais barato
			Hotel hotelMaisBarato = ServicoHotel.encontrarHotelMaisBarato(entradaCliente);

			// Retornando resultado
			if (hotelMaisBarato != null) {
				System.out.println("::: => HOTEL MAIS BARATO: " + hotelMaisBarato.getNome());
			} else {
				System.out.println("::: Nenhum hotel encontrado.");
			}

		}

        scanner.close();
	}

}

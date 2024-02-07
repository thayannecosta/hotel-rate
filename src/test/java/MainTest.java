import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.EntradaCliente;
import model.EntradaClienteData;
import model.Hotel;
import service.ServicoHotel;

public class MainTest {

	@Test
	public void testBuild() {
		String value = "Regular: 16Mar2020(mon), 17Mar2020(tues), 18Mar2020(wed)";
		EntradaCliente actualOutput = EntradaCliente.fromInput(value);

		assertEquals(actualOutput.getTipoCliente(), "Regular");

		assertEquals(actualOutput.getEntradaClienteData().get(0).getDataCliente(), "16Mar2020");
		assertEquals(actualOutput.getEntradaClienteData().get(0).getDiaCliente(), "mon");
		assertEquals(actualOutput.getEntradaClienteData().get(0).getIsFimDeSemana(), false);

		assertEquals(actualOutput.getEntradaClienteData().get(1).getDataCliente(), "17Mar2020");
		assertEquals(actualOutput.getEntradaClienteData().get(1).getDiaCliente(), "tues");
		assertEquals(actualOutput.getEntradaClienteData().get(1).getIsFimDeSemana(), false);

		assertEquals(actualOutput.getEntradaClienteData().get(2).getDataCliente(), "18Mar2020");
		assertEquals(actualOutput.getEntradaClienteData().get(2).getDiaCliente(), "wed");
		assertEquals(actualOutput.getEntradaClienteData().get(2).getIsFimDeSemana(), false);

	}

	@Test
	public void testService() {
		List<EntradaClienteData> data = new ArrayList<>();
		data.add(new EntradaClienteData("16Mar2020", "mon"));
		data.add(new EntradaClienteData("17Mar2020", "tues"));
		data.add(new EntradaClienteData("18Mar2020", "wed"));

		EntradaCliente entradaCliente = new EntradaCliente("Regular", data);

		Hotel hotel = ServicoHotel.encontrarHotelMaisBarato(entradaCliente);

		assertEquals(hotel.getNome(), "Palm Plaza Resor");

	}

}
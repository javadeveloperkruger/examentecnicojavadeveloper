package ec.com.kruger.examen;

import java.util.ArrayList;
import java.util.List;

public class MoneyParts {

	private static List<Double> denominaciones;
	
	public static void main(String[] args) {
		inicializarDenominaciones();
		System.out.println(build("10.5"));
	}

	private static List<Double> inicializarDenominaciones() {
		denominaciones = new ArrayList<Double>();
		denominaciones.add(0.05d);
		denominaciones.add(0.1d);
		denominaciones.add(0.2d);
		denominaciones.add(0.5d);
		denominaciones.add(1d);
		denominaciones.add(2d);
		denominaciones.add(5d);
		denominaciones.add(10d);
		denominaciones.add(20d);
		denominaciones.add(50d);
		denominaciones.add(100d);
		denominaciones.add(200d);
		return denominaciones;
	}

	private static List<List<Double>> build(String entrada) {
		List<List<Double>> salida = new ArrayList<List<Double>>();
		Double entradaDouble = Double.valueOf(entrada);
		List<Double> listaReducida = new ArrayList<Double>();
		// Se obtiene solo la lista que será utilizada para combinar
		denominaciones.forEach(denominacion -> {
			if (denominacion <= entradaDouble) {
				listaReducida.add(denominacion);
			}
		});
		for (int i = 0; i < listaReducida.size(); i++) {
			List<Double> iteracionesList = new ArrayList<Double>();
			Double repeticiones = entradaDouble / listaReducida.get(i);
			int numeroRepeticiones = repeticiones.intValue();
			Double restante = repeticiones - numeroRepeticiones;
			for (int n = 0; n < numeroRepeticiones; n++) {
				iteracionesList.add(listaReducida.get(i));
			}
			if (restante > 0) {
				Double suma = iteracionesList.size()*iteracionesList.get(0);
				Double sobrante = entradaDouble - suma;
				Double adicional = Math.round(sobrante * 100) / 100d;
				if (denominaciones.contains(adicional)) {
					iteracionesList.add(adicional);
				} else {
					// Cuando se ingresan decimales diferentes a las denominaciones, se recorre nuevamente 
					// y se toma solo el ultimo valor para completar
					List<List<Double>> bucleList = build(adicional.toString());
					List<Double> minimoList = bucleList.get(bucleList.size() - 1);
					minimoList.forEach(minimo -> {
						iteracionesList.add(minimo);
					});
				}
			}
			salida.add(iteracionesList);
		}
		return salida;
	}

}
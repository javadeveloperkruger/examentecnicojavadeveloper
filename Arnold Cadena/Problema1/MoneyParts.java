package com.kruger.prueba;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author diego
 *
 */
public class MoneyParts {

	private List<Double> denominaciones;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MoneyParts moneyParts = new MoneyParts();
		ArrayList<List<Double>> respuesta = moneyParts.build(10.5d);
		System.out.print(respuesta.size());
		System.out.println(respuesta);
	}

	public MoneyParts() {

		// Inicializa las denominaciones
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
	}

	/**
	 * @param entrada
	 * @return Itera las denominaciones para obtner las convinaciones contenidas en
	 *         la entrada
	 */
	public ArrayList<List<Double>> build(Double entrada) {
		ArrayList<List<Double>> respuesta = new ArrayList<List<Double>>();

		denominaciones.forEach(denominacion -> {
			Double rest = getMod(entrada, denominacion);
			Integer iteraciones = getDivInt(entrada, denominacion);

			if (iteraciones != 0) {
				List<Double> listaCombinaciones = new ArrayList<Double>();
				for (int i = 0; i < iteraciones; i++) {
					listaCombinaciones.add(denominacion);
				}
				if (rest.equals(new Double(0))) {
					respuesta.add(listaCombinaciones);
				}
				// agrego el residuo a la lista
				else {
					// agrego solo si el residuo es una denominaci�n valida
					if (denominaciones.contains(rest)) {
						listaCombinaciones.add(rest);
						respuesta.add(listaCombinaciones);
					} else {
						// Si no es un residuo v�lido se llama nuevamente al metodo build para
						// descomponer el residuo.
						ArrayList<List<Double>> respuestaResiduo = build(rest);
						if (respuestaResiduo.isEmpty()) {
							respuesta.add(listaCombinaciones);
						} else {
							respuestaResiduo.forEach(listaResiduo -> {
								// Creo una copia de la lista procesada anteriormente
								ArrayList<Double> listaLocal = new ArrayList<Double>();
								listaLocal.addAll(listaCombinaciones);
								// Agrego cada elemento obtenido de la recursividad.
								listaLocal.addAll(listaResiduo);
								respuesta.add(listaLocal);
							});
						}
					}
				}
			}
		});

		return respuesta;
	}

	/**
	 * @param numerator
	 * @param denominator
	 * @return El residudo de dos n�meros Doubles
	 */
	public Double getMod(Double numerator, Double denominator) {
		Integer intPart = getDivInt(numerator, denominator);
		Double rest = numerator - denominator * intPart;

		return roundDouble(rest);
	}

	/**
	 * @param rest
	 * @return Un Double redondeado a dos cifras
	 */
	private double roundDouble(Double rest) {
		return new BigDecimal(rest).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	/**
	 * @param numerator
	 * @param denominator
	 * @return El resultado entero de una division
	 */
	public Integer getDivInt(Double numerator, Double denominator) {
		Integer intPart = ((Double) (numerator / denominator)).intValue();

		return intPart;
	}

	/**
	 * @return the denominaciones
	 */
	public List<Double> getDenominaciones() {
		return denominaciones;
	}

	/**
	 * @param denominaciones
	 *            the denominaciones to set
	 */
	public void setDenominaciones(List<Double> denominaciones) {
		this.denominaciones = denominaciones;
	}

}

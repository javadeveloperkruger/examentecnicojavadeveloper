package ec.com.kruger.examen;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OrdenesPago database table.
 * 
 */
@Entity
@Table(name="OrdenesPago")
@NamedQuery(name="OrdenesPago.findAll", query="SELECT o FROM OrdenesPago o")
public class OrdenesPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idOrden;

	private String estado;

	private String fechapago;

	private String moneda;

	private String monto;

	public OrdenesPago() {
	}

	public int getIdOrden() {
		return this.idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechapago() {
		return this.fechapago;
	}

	public void setFechapago(String fechapago) {
		this.fechapago = fechapago;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getMonto() {
		return this.monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

}
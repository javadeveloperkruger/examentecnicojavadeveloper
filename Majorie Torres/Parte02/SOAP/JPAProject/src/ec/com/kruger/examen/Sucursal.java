package ec.com.kruger.examen;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Sucursal database table.
 * 
 */
@Entity
@Table(name="Sucursal")
@NamedQuery(name="Sucursal.findAll", query="SELECT s FROM Sucursal s")
@NamedQuery(name = "find Sucursal by idBanco", query = "Select e from Sucursal e where e.id = :id")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSucursal;

	private String direccion;

	private String fecharegistro;

	private int idbanco;

	private String nombre;

	public Sucursal() {
	}

	public int getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public int getIdbanco() {
		return this.idbanco;
	}

	public void setIdbanco(int idbanco) {
		this.idbanco = idbanco;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
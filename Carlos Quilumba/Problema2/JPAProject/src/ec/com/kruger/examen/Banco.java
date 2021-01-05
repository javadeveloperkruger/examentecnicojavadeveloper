package ec.com.kruger.examen;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Banco database table.
 * 
 */
@Entity
@Table(name="Banco")
@NamedQuery(name="Banco.findAll", query="SELECT b FROM Banco b")
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idbanco;

	private String direccion;

	private String fecharegistro;

	private String nombre;

	public Banco() {
	}

	public int getIdbanco() {
		return this.idbanco;
	}

	public void setIdbanco(int idbanco) {
		this.idbanco = idbanco;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
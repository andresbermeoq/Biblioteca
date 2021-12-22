package ec.edu.ups.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Autor
 *
 */
@Entity
public class Autor implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String Nombre;
	private String Nacionalidad;
	private static final long serialVersionUID = 1L;

	public Autor() {
		super();
	}   
	
	public Autor(String nombre, String nacionalidad) {
		super();
		Nombre = nombre;
		Nacionalidad = nacionalidad;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getNacionalidad() {
		return this.Nacionalidad;
	}

	public void setNacionalidad(String Nacionalidad) {
		this.Nacionalidad = Nacionalidad;
	}
	@Override
	public String toString() {
		return "Autor [codigo=" + codigo + ", Nombre=" + Nombre + ", Nacionalidad=" + Nacionalidad + "]";
	}
	
	
   
}

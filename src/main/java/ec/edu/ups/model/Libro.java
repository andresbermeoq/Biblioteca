package ec.edu.ups.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Libro
 *
 */
@Entity

public class Libro implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer codigo;
	private String nombre;
	private String ISBN;
	private Integer numero_paginas;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Capitulo> capitulos;
	
	public Libro() {
		super();
	}   

	public Libro(String nombre, String iSBN, Integer numero_paginas, List<Capitulo> capitulos) {
		super();
		this.nombre = nombre;
		ISBN = iSBN;
		this.numero_paginas = numero_paginas;
		this.capitulos = capitulos;
	}


	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getISBN() {
		return this.ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}   
	public Integer getNumero_paginas() {
		return this.numero_paginas;
	}

	public void setNumero_paginas(Integer numero_paginas) {
		this.numero_paginas = numero_paginas;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", nombre=" + nombre + ", ISBN=" + ISBN + ", numero_paginas="
				+ numero_paginas + ", capitulos=" + capitulos + "]";
	}
   
}

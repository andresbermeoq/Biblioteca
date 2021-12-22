package ec.edu.ups.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Capitulo
 *
 */
@Entity
public class Capitulo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer codigo;
	private String numero;
	private String titulo;
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "autor_id")
	@OneToOne(fetch = FetchType.LAZY)
	private Autor autor;

	public Capitulo() {
		super();
	}   
	
	
	public Capitulo(String numero, String titulo, Autor autor) {
		super();
		this.numero = numero;
		this.titulo = titulo;
		this.autor = autor;
	}


	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}   
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}   
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	@Override
	public String toString() {
		return "Capitulo [codigo=" + codigo + ", numero=" + numero + ", titulo=" + titulo + ", autor=" + autor + "]";
	}
	
   
}

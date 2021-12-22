package ec.edu.ups.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import org.primefaces.expression.impl.ThisExpressionResolver;

import ec.edu.ups.ejb.AutorFacade;
import ec.edu.ups.ejb.CapituloFacade;
import ec.edu.ups.ejb.LibroFacade;
import ec.edu.ups.model.Autor;
import ec.edu.ups.model.Capitulo;
import ec.edu.ups.model.Libro;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class LibroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private AutorFacade autorFacade;
	
	@EJB
	private CapituloFacade capituloFacade;
	private String number;
	private String title;
	private Integer autor;
	
	private Capitulo capitulo;
	
	@EJB
	private LibroFacade libroFacade;
	private String nombre;
	private String isbn;
	private Integer number_pages;
	
	private Libro libro;
	
	private List<Capitulo> capitulos;
	
	@PostConstruct
	public void init() {
		capitulos = new ArrayList<>();
		libro = new Libro();
		capitulo = new Capitulo();
	}

	public LibroBean() {
		
	}

	public AutorFacade getAutorFacade() {
		return autorFacade;
	}

	public void setAutorFacade(AutorFacade autorFacade) {
		this.autorFacade = autorFacade;
	}

	public CapituloFacade getCapituloFacade() {
		return capituloFacade;
	}

	public void setCapituloFacade(CapituloFacade capituloFacade) {
		this.capituloFacade = capituloFacade;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAutor() {
		return autor;
	}

	public void setAutor(Integer autor) {
		this.autor = autor;
	}

	public LibroFacade getLibroFacade() {
		return libroFacade;
	}

	public void setLibroFacade(LibroFacade libroFacade) {
		this.libroFacade = libroFacade;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNumber_pages() {
		return number_pages;
	}

	public void setNumber_pages(Integer number_pages) {
		this.number_pages = number_pages;
	}
	
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	
	public Capitulo getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	
	public void addCapitulo() {
		capitulo.setNumero(this.number);
		capitulo.setTitulo(this.title);
		capitulo.setAutor(autorFacade.find(this.autor));
		
		capitulos.add(capitulo);
		
		capitulo = new Capitulo();
	}
	
	public void addLibro() {
		libro.setISBN(this.isbn);
		libro.setNombre(this.nombre);
		libro.setNumero_paginas(this.number_pages);
		libro.setCapitulos(capitulos);
		
		libroFacade.create(libro);
		
		capitulos = new ArrayList<Capitulo>();
		libro = new Libro();
		
	}

	

	

	
	

}

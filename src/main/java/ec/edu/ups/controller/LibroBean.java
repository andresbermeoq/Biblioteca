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
	
	private Integer id;
	
	private Capitulo capitulo;
	
	private String nombre_busqueda;
	private String nacionalidad_busqueda;
	
	@EJB
	private LibroFacade libroFacade;
	private String nombre;
	private String isbn;
	private Integer number_pages;
	
	private Libro libro;
	
	private List<Capitulo> capitulos;
	private List<Libro> libros;
	
	private String nameSearch;
	private String titleSearch;
	
	@PostConstruct
	public void init() {
		capitulos = new ArrayList<>();
		libro = new Libro();
		capitulo = new Capitulo();
		setLibros(libroFacade.findAll());
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
		setLibros(libroFacade.findAll());
		
	}
	
	public void searchID() {
		Autor autor_busqueda = autorFacade.find(this.id);
		this.nombre_busqueda = autor_busqueda.getNombre();
		this.nacionalidad_busqueda = autor_busqueda.getNacionalidad();
	}
	
	public void searchbyName() {
		libros = new ArrayList<Libro>();
		libros = libroFacade.findbyName(this.nameSearch);
		this.nameSearch = new String();
	}
	
	public void searchbyTitle() {
		libros = new ArrayList<Libro>();
		libros = libroFacade.findbyTitle(this.titleSearch);
		System.out.println("libros titulo " + libros);
		this.titleSearch = new String();	
	}
	
	public void reupdateTheList() {
		libros = libroFacade.findAll();
		this.titleSearch = new String();
		this.isbn = new String();
		this.nombre = new String();
		this.capitulos = new ArrayList<Capitulo>();
		this.number = new String();
		this.title = new String();
		
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public String getNameSearch() {
		return nameSearch;
	}

	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}

	public String getTitleSearch() {
		return titleSearch;
	}

	public void setTitleSearch(String titleSearch) {
		this.titleSearch = titleSearch;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre_busqueda() {
		return nombre_busqueda;
	}

	public void setNombre_busqueda(String nombre_busqueda) {
		this.nombre_busqueda = nombre_busqueda;
	}

	public String getNacionalidad_busqueda() {
		return nacionalidad_busqueda;
	}

	public void setNacionalidad_busqueda(String nacionalidad_busqueda) {
		this.nacionalidad_busqueda = nacionalidad_busqueda;
	}

	
	
	

	

	

	
	

}

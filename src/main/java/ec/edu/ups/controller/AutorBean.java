package ec.edu.ups.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.AutorFacade;
import ec.edu.ups.model.Autor;



@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class AutorBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AutorFacade autorFacade;
	
	private String nameAuthor;
	private String nationalizationAuthor;

	public AutorBean() {
		
	}
	
	@PostConstruct
	public void init() {
		
	}
	
	public AutorFacade getAutorFacade() {
		return autorFacade;
	}
	public void setAutorFacade(AutorFacade autorFacade) {
		this.autorFacade = autorFacade;
	}
	public String getNameAuthor() {
		return nameAuthor;
	}
	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}
	public String getNationalizationAuthor() {
		return nationalizationAuthor;
	}
	public void setNationalizationAuthor(String nationalizationAuthor) {
		this.nationalizationAuthor = nationalizationAuthor;
	}
	
	public String addAuthor() {
		autorFacade.create(new Autor(this.nameAuthor, this.nationalizationAuthor));
		return null;
	}

}

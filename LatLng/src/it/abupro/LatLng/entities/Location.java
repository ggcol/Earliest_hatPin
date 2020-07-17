package it.abupro.LatLng.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.Session;

import it.abupro.LatLng.connection.HibCon;


@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLocation")
	private int idLocation;
	@Column(name="latlng")
	private String latlng;
	@Column(name="titolo")
	private String titolo;
	@Column(name="corpo")
	private String corpo;
	@Column(name="ref_img")
	private String ref_img;
	
	
	public Location(int idLocation, String latlng, String titolo, String corpo, String ref_img) {
		setIdLocation(idLocation);
		setLatlng(latlng);
		setTitolo(titolo);
		setCorpo(corpo);
		setRef_img(ref_img);
		
	}
	
	public Location() {}

	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public String getLatlng() {
		return latlng;
	}

	public void setLatlng(String latlng) {
		this.latlng = latlng;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getRef_img() {
		return ref_img;
	}

	public void setRef_img(String ref_img) {
		this.ref_img = ref_img;
	}
	
	public void newEntry(Location l) {
	HibCon h = new HibCon();
	try (Session s = h.getSessionFactory().openSession()) {
		s.beginTransaction();
		s.save(l);
		s.getTransaction().commit();
	}
	}
	
	
	
	

}

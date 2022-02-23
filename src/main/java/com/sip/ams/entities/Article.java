package com.sip.ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Généré par Hibernate Sequence 
	private long id;
	
	@NotBlank(message=" Label is mandatory")
	@Column(name="label")
	private String label;
	
	 //@NotBlank(message=" Price is mandatory")  cette instruction cause une erreur " No validator could be found for constraint 'javax.validation.constraints.NotBlank' validating type 'java.lang.Float'. Check configuration for 'price'"
	@Column(name="price")
	private float price;
	
	@Column(name = "picture")
	 private String picture;

	
	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public Article() {
		
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", label=" + label + ", price=" + price + ", provider=" + provider + "]";
	}


	public Article(String label, float price) {
		super();
		this.label = label;
		this.price = price;
	}
	


	public Article(@NotBlank(message = " Label is mandatory") String label, float price, String picture) {
		super();
		this.label = label;
		this.price = price;
		this.picture = picture;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}
	
	//*****Many to one Provider ****//'e"'

	@ManyToOne(fetch=FetchType.LAZY , optional = false)
	@JoinColumn(name="provider_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)

	private Provider provider;


	public Provider getProvider() {
		return provider;
	}


	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	

}

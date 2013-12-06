package com.otogami.server.model;

import org.hibernate.annotations.Index;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class VideogameEntity {

	//PK 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	//Original game id in the store
	private String storeGameId;

	//Game Title 
	private String title;

	//Game Platform	as String
    @Index(name = "platformIdx")
	private String platform;

	//Complete game Url	
	private String url;

	//Game Availability	as String
	private String availability;

	//Game Price. Null if it doesn't have
	private BigDecimal price;

	//Id or Name of the store
	private String storeId;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStoreGameId() {
		return storeGameId;
	}
	public void setStoreGameId(String storeGameId) {
		this.storeGameId = storeGameId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	@Override
	public String toString(){
		return id+";"+platform+";"+price+":"+url;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideogameEntity other = (VideogameEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

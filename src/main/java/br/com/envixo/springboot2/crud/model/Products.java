package br.com.envixo.springboot2.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {

	private long id;
	private String title;
	private String description;

	@ManyToOne
	@JoinColumn(name = "categories_id")
	private Categories category;
	private Boolean isEnabled;

	private Double price;

	private Double promotionPrice;

	public Products() {
		
	}
	
	public Products(String title, String description, Categories category, Boolean isEnabled, Double price, Double promotionPrice) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.isEnabled = isEnabled;
		this.price = price;
		this.promotionPrice = promotionPrice;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "enabled", nullable = false)
	public Boolean getEnabled() {
		return isEnabled;
	}
	public void setEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Column(name = "price", nullable = false)
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "promotion_price", nullable = false)
	public Double getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(Double promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	@Override
	public String toString() {
		return "Products{" +
				"id=" + id +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", categories=" + category +
				", isEnabled=" + isEnabled +
				", price=" + price +
				", promotionPrice=" + promotionPrice +
				'}';
	}
}

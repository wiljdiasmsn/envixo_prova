package br.com.envixo.springboot2.crud.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {

	private long id;
	private String title;

	@Lob
	@Type( type = "org.hibernate.type.TextType")
	private String description;

	@ManyToOne
	@JoinColumn(name = "categories_id")
	private Categories category;
	private Boolean isEnabled;

	private Double price;

	private Double promotionPrice;



	private String tags;

	public Products() {
		
	}
	
	public Products(String title, String description, Categories category, Boolean isEnabled, Double price, Double promotionPrice, String tags) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.isEnabled = isEnabled;
		this.price = price;
		this.promotionPrice = promotionPrice;
		this.tags = tags;
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

	@Column(name = "promotion_price", nullable = true)
	public Double getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(Double promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public String getTags() {
		return tags;
	}
	@Column(name = "tags", nullable = true)
	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Products{" +
				"id=" + id +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", category=" + category +
				", isEnabled=" + isEnabled +
				", price=" + price +
				", promotionPrice=" + promotionPrice +
				", tags='" + tags + '\'' +
				'}';
	}
}

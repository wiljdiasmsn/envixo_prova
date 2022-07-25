package br.com.envixo.springboot2.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "medias")
public class Medias {

	private long id;

	@ManyToMany
	@JoinColumn(name = "product_id")
	private Products product;
	private String title;
	private String description;
	private String url;

	public Medias() {

	}

	public Medias(String title, String description, String url, Products product) {
		this.title = title;
		this.product = product;
		this.description = description;
		this.url = url;
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
	
	@Column(name = "url", nullable = false)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Medias{" +
				"id=" + id +
				", products=" + product +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}

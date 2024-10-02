package webhan.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {
	private int id;
	private String name;
	private String icon;
	private boolean deleted;
	private String image;
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", icon=" + icon + "]";
	}
	
	public Category(int id, String name, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
	}

	public Category(int id, String name, String icon, boolean deleted, String image) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.deleted = deleted;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}

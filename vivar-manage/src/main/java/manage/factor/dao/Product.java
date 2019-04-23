package manage.factor.dao;

import java.sql.Date;

public class Product {

	private String id;
	private String name;
	private String description;
	private double price;
	private Date manufactureDate;
	private Date expirationDate;
	private int maintainDate;
	private int idCompany;

	public Product() {

	}

	public int getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	public Product(String id, String name, String description, double d, int idCompany) {
		super();
		this.idCompany = idCompany;
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = d;
	}

	public Product(String id, String name, String description, double price, int idCompany, Date manufactureDate,
			Date expirationDate, int maintainDate) {
		super();
		this.idCompany = idCompany;
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.expirationDate = expirationDate;
		this.maintainDate = maintainDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getMaintainDate() {
		return maintainDate;
	}

	public void setMaintainDate(int maintainDate) {
		this.maintainDate = maintainDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toStringSimple() {
		return "product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}

	@Override
	public String toString() {
		return "product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", manufactureDate=" + manufactureDate + ", expirationDate=" + expirationDate + ", maintainDate="
				+ maintainDate + "]";
	}

}

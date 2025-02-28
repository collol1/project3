package springmvc.com.beans;

import java.sql.Timestamp;

public class Product {
	private int ProductId;
	private String ProductName;
	private String Description;
	private double Price;
	private String ImageURL;
	private Timestamp CreateAt;
	private Timestamp UpdateAt;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Product(String productName, String description, double price, String imageURL, Timestamp createAt,
			Timestamp updateAt) {
		super();
		ProductName = productName;
		Description = description;
		Price = price;
		ImageURL = imageURL;
		CreateAt = createAt;
		UpdateAt = updateAt;
	}



	/**
	 * @return the productId
	 */
	public int getProductId() {
		return ProductId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		ProductId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return ProductName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		ProductName = productName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return Price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		Price = price;
	}

	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return ImageURL;
	}

	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}

	/**
	 * @return the createAt
	 */
	public Timestamp getCreateAt() {
		return CreateAt;
	}

	/**
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(Timestamp createAt) {
		CreateAt = createAt;
	}

	/**
	 * @return the updateAt
	 */
	public Timestamp getUpdateAt() {
		return UpdateAt;
	}

	/**
	 * @param updateAt the updateAt to set
	 */
	public void setUpdateAt(Timestamp updateAt) {
		UpdateAt = updateAt;
	}

}

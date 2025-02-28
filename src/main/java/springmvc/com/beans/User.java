package springmvc.com.beans;

public class User {
	private int UserId;
	private String UserName;
	private String FullName;
	private String Password;
	private String Email;
	private String phone;
	private double role;
	private String CreateAT;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String fullName, String password, String email, String phone, double role,
			String createAT) {
		super();
		UserName = userName;
		FullName = fullName;
		Password = password;
		Email = email;
		this.phone = phone;
		this.role = role;
		CreateAT = createAT;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return UserId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		UserId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return FullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		FullName = fullName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the role
	 */
	public double getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(double role) {
		this.role = role;
	}

	/**
	 * @return the createAT
	 */
	public String getCreateAT() {
		return CreateAT;
	}

	/**
	 * @param createAT the createAT to set
	 */
	public void setCreateAT(String createAT) {
		CreateAT = createAT;
	}

}



public class account{

	private String acc_id;
	private String cust_id;
	private float balance;
	private String trangthai;

	public String getAcc_id() {
		return this.acc_id;
	}

	/**
	 * 
	 * @param acc_id
	 */
	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public String getCust_id() {
		return this.cust_id;
	}

	/**
	 * 
	 * @param cust_id
	 */
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public float getBalance() {
		return this.balance;
	}

	/**
	 * 
	 * @param balance
	 */
	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getTrangthai() {
		return this.trangthai;
	}

	/**
	 * 
	 * @param trangthai
	 */
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

}
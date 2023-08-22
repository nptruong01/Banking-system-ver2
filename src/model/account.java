package model;





public class account{

	private String acc_id;
	private String cust_id;
	private int balance;
	private String trangthai;

    public account() {
    }

    public account(String acc_id, String cust_id, int balance, String trangthai) {
        this.acc_id = acc_id;
        this.cust_id = cust_id;
        this.balance = balance;
        this.trangthai = trangthai;
    }

        
        
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

	public int getBalance() {
		return this.balance;
	}

	/**
	 * 
	 * @param balance
	 */
	public void setBalance(int balance) {
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
         @Override
    public String toString() {
        return acc_id;
    }
}
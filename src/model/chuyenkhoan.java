package model;



public class chuyenkhoan {

	private String gd_id;
	private String acc_id;
	private String toacc_id;
	private String date;
	private int amount;
	private String branch_id;

    public chuyenkhoan() {
    }

    
    
    public chuyenkhoan(String gd_id, String acc_id, String toacc_id,  String date, int amount, String branch_id) {
        this.gd_id = gd_id;
        this.acc_id = acc_id;
        this.toacc_id = toacc_id;
        this.date = date;
        this.amount = amount;
        this.branch_id = branch_id;
    }

        
        
	public String getGd_id() {
		return this.gd_id;
	}

	/**
	 * 
	 * @param gd_id
	 */
	public void setGd_id(String gd_id) {
		this.gd_id = gd_id;
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

	public String getToacc_id() {
		return this.toacc_id;
	}

	/**
	 * 
	 * @param toacc_id
	 */
	public void setToacc_id(String toacc_id) {
		this.toacc_id = toacc_id;
	}

	public String getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return this.amount;
	}

	/**
	 * 
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getBranch_id() {
		return this.branch_id;
	}

	/**
	 * 
	 * @param branch_id
	 */
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
        @Override
    public String toString() {
        return gd_id;
    }
    
}
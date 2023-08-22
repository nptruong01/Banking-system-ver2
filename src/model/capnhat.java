package model;





public class capnhat{

	private String acc_id;
	
	private int balance;
	

    public capnhat() {
    }

    public capnhat(String acc_id, int balance) {
        this.acc_id = acc_id;
        
        this.balance = balance;
       
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

	
         @Override
    public String toString() {
        return acc_id;
    }
}
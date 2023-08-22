public class chinhanh {

	private String branch_id;
	private String location;
	private String branch_name;

        public chinhanh() {
        }

        public chinhanh(String branch_id, String location, String branch_name) {
            this.branch_id = branch_id;
            this.location = location;
            this.branch_name = branch_name;
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

	public String getLocation() {
		return this.location;
	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	public String getBranch_name() {
		return this.branch_name;
	}

	/**
	 * 
	 * @param branch_name
	 */
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

        @Override
        public String toString() {
            return branch_name;
        }
        
}
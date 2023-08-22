/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Branch {
//    private String LoaiPhong;
//    private String MoTaPhong;
//    private float GiaPhong;
    
        private String branch_id;
	private String location;
	private String branch_name;

    public Branch() {
    }

//    public LoaiPhong(String LoaiPhong, String MoTaPhong, float GiaPhong) {
//        this.LoaiPhong = LoaiPhong;
//        this.MoTaPhong = MoTaPhong;
//        this.GiaPhong = GiaPhong;
//    }

    public Branch(String branch_id, String location, String branch_name) {
        this.branch_id = branch_id;
        this.location = location;
        this.branch_name = branch_name;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }
    
    

    @Override
    public String toString() {
        return branch_id;
    }
    
    
    
}

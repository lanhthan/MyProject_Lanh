/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author windy
 */
public class Customers {
    String cid, uid, fname, gender, dob, address, phone;

    public Customers() {
    }

    public Customers(String cid, String uid, String fname, String gender, String dob, String address, String phone) {
        this.cid = cid;
        this.uid = uid;
        this.fname = fname;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customers{" + "cid=" + cid + ", uid=" + uid + ", fname=" + fname + ", gender=" + gender + ", dob=" + dob + ", address=" + address + ", phone=" + phone + '}';
    }
    
    
}

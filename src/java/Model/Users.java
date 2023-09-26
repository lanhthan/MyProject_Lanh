/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dal.DBContext;

/**
 *
 * @author windy
 */
public class Users {
    String id, account, password, role;

    public Users() {
        
    }

    public Users(String account, String password) {
        this.account = account;
        this.password = password;
        
    }

    public Users(String id, String account, String password, String role) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.role = role;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", account=" + account + ", password=" + password + ", role=" + role + '}';
    }
    
    
    
}

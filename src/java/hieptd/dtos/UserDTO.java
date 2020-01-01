/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.dtos;

import java.io.Serializable;

/**
 *
 * @author Hiep
 */
public class UserDTO implements Serializable {
    
    private String username, password, fullname, email, photo, phone, roleid;
    private int promotionrank;
    private boolean isDelete;

    public UserDTO() {
    }

    public UserDTO(String username, String fullname, String photo, String phone) {
        this.username = username;
        this.fullname = fullname;
        this.photo = photo;
        this.phone = phone;
    }

    public UserDTO(String username, String fullname, String photo) {
        this.username = username;
        this.fullname = fullname;
        this.photo = photo;
    }
    
    public UserDTO(String username, String fullname, String email, String photo, String phone, String roleid) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.photo = photo;
        this.phone = phone;
        this.roleid = roleid;
    }

    public UserDTO(String username, String password, String fullname, String email, String photo, String phone, String roleid) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.photo = photo;
        this.phone = phone;
        this.roleid = roleid;
        this.password = password;
    }
    
    public UserDTO(String username, String password, String fullname, String email, String photo, String phone, String roleid, boolean isDelete) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.photo = photo;
        this.phone = phone;
        this.roleid = roleid;
        this.isDelete = isDelete;
    }
    
    public UserDTO(String username, String password, String fullname, String email, String photo, String phone, String roleid, int promotionrank) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.photo = photo;
        this.phone = phone;
        this.roleid = roleid;
        this.promotionrank = promotionrank;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRoleid() {
        return roleid;
    }

    public int getPromotionrank() {
        return promotionrank;
    }

    public void setPromotionrank(int promotionrank) {
        this.promotionrank = promotionrank;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}

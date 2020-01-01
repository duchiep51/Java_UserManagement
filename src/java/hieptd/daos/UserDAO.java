/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.daos;

import hieptd.conn.MyConnection;
import hieptd.dtos.UserDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hiep
 */
public class UserDAO implements Serializable {
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement preStm;
    
    private void closeConnection() throws Exception {
        if(rs != null) {
            rs.close();
        }
        if(preStm != null) {
            preStm.close();
        }
        if(conn != null) {
            conn.close();
        }
    }
    
    public boolean create(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into tbl_User(UserName, Password, FullName, "
                    + "Email, Phone, Photo, RoleID, isDelete)"
                    + " values (?,?,?,?,?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getEmail());
            preStm.setString(5, dto.getPhone());
            preStm.setString(6, dto.getPhoto());
            preStm.setString(7, dto.getRoleid());
            preStm.setBoolean(8, false);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public String checkLogin(String username, String password) throws Exception {
        String check = "failed";
        try {
            conn = MyConnection.getConnection();
            if(conn != null){
                String sql = "select RoleID from tbl_User where UserName = ? and Password = ? and isDelete = 0";
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, username);
                preStm.setString(2, password);
                rs = preStm.executeQuery();
                if(rs.next()){
                    check = rs.getString("RoleID");
                }
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<UserDTO> findByLikeName(String search) throws Exception {
        List<UserDTO> result = null;
        String username = null;
        String fullname = null;
        String photo = null;
        String phone = null;
        UserDTO dto = null;
        try {
            String sql = "select UserName, FullName, Phone, Photo from tbl_User where FullName Like ? and isDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()) {
                username = rs.getString("UserName");
                fullname = rs.getString("FullName");
                photo = rs.getString("Photo");
                phone = rs.getString("Phone");
                dto = new UserDTO(username, fullname, photo, phone);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public UserDTO findByUserName(String username) throws Exception {
        UserDTO dto = null;
        String fullname = null;
        String photo = null;
        String phone = null;
        String email = null;
        try {
            String sql = "select FullName, Email, Phone, Photo from tbl_User where UserName = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            dto = new UserDTO();
            if(rs.next()){
                fullname = rs.getString("FullName");
                photo = rs.getString("Photo");
                phone = rs.getString("Phone");
                email = rs.getString("Email");
                dto.setEmail(email);
                dto = new UserDTO(username, fullname, photo, phone);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public UserDTO getUserInfo(String username) throws Exception {
        UserDTO dto = null;
        String fullname = null;
        String email = null;
        String photo = null;
        String phone = null;
        String roleid = null;
        String password = null;
        try {
            String sql = "select FullName, Email, Phone, Photo, RoleID from tbl_User where UserName = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            dto = new UserDTO();
            if(rs.next()){
                fullname = rs.getString("FullName");
                email = rs.getString("Email");
                photo = rs.getString("Photo");
                phone = rs.getString("Phone");
                roleid = rs.getString(("RoleID"));
                dto = new UserDTO(username, fullname, email, photo, phone, roleid);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean delete(String username) throws Exception {
        boolean check = false;
        try {
            String sql = "update tbl_User set isDelete = ? where UserName = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, true);
            preStm.setString(2, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean update(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "update tbl_User set Password = ?, FullName = ?, Email = ?, Phone = ?, Photo = ?, RoleID = ? where UserName = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getFullname());
            preStm.setString(3, dto.getEmail());
            preStm.setString(4, dto.getPhone());
            preStm.setString(5, dto.getPhoto());
            preStm.setString(6, dto.getRoleid());
            preStm.setString(7, dto.getUsername());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean insert(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into tbl_User (UserName, Password, FullName, Email, Phone, Photo, RoleID, isDelete) values (?,?,?,?,?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getFullname());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getEmail());
            preStm.setString(5, dto.getPhone());
            preStm.setString(6, dto.getPhoto());
            preStm.setString(7, dto.getRoleid());
            preStm.setBoolean(8, false);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}

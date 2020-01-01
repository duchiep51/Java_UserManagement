/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.daos;

import hieptd.conn.MyConnection;
import hieptd.dtos.RoleDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Hiep
 */
public class RoleDAO implements Serializable {
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
    
    public List<RoleDTO> getAllRole() throws SQLException, NamingException, Exception {
        List<RoleDTO> result = null;
        RoleDTO dto = null;
        String roleid = null;
        String rolename = null;
        try {
            String sql = "select RoleID, RoleName from tbl_Role";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                roleid = rs.getString("RoleID");
                rolename = rs.getString("RoleName");
                dto = new RoleDTO(roleid, rolename);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public int countByRoleId(String roleid) throws NamingException, SQLException, Exception {
        int count = 0;
        try {
            String sql = "select count(RoleID) as rolecount from tbl_User where RoleID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, roleid);
            rs = preStm.executeQuery();
            if(rs.next()){
                count = rs.getInt("rolecount");
            }
        } finally {
            closeConnection();
        }
        return count;
    }
}

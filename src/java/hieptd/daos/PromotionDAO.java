/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.daos;

import hieptd.conn.MyConnection;
import hieptd.dtos.PromotionDTO;
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
public class PromotionDAO implements Serializable {
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
    
    public boolean insert(PromotionDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into tbl_PromotionRank(UserName, PromotionRank, isDelete)"
                    + " values(?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setInt(2, dto.getPromotionrank());
            preStm.setBoolean(3, false);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    } 
    
    public List<PromotionDTO> viewHistory() throws Exception {
        List<PromotionDTO> result = null;
        try {
            String sql = "select UserName, PromotionRank, Date from tbl_PromotionRank"
                            + " where isDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()) {
                String username = rs.getString("UserName");
                int rank = rs.getInt("PromotionRank");
                String date = rs.getDate("Date").toString();
                PromotionDTO dto = new PromotionDTO(username, rank);
                dto.setDate(date);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    } 
}

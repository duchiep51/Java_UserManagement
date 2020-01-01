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
public class PromotionDTO implements Serializable {
    String username;
    int promotionrank;
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PromotionDTO(String username, int promotionrank) {
        this.username = username;
        this.promotionrank = promotionrank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPromotionrank() {
        return promotionrank;
    }

    public void setPromotionrank(int promotionrank) {
        this.promotionrank = promotionrank;
    }
    
    
}

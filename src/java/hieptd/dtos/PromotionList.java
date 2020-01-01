/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.dtos;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Hiep
 */
public class PromotionList implements Serializable {
    private HashMap<String, Integer> list;

    public PromotionList() {
        this.list = new HashMap<>();
    }

    public PromotionList(HashMap<String, Integer> list) {
        this.list = list;
    }

    public HashMap<String, Integer> getList() {
        return list;
    }

    public void setList(HashMap<String, Integer> cart) {
        this.list = cart;
    }
    
    public void addList(String username, int rank) {
        if(!this.list.containsKey(username)){
            this.list.put(username, rank);
        }
    }
    
    public void removeList(String username) throws Exception {
        if(this.list.containsKey("username"))
            this.list.remove(username);
    }
}

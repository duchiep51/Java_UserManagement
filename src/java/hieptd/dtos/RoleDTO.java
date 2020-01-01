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
public class RoleDTO implements Serializable {
    String roleid, rolename;

    public RoleDTO(String roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    
    
}

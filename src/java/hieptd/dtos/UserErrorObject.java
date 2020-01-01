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
public class UserErrorObject implements Serializable {
    private String usernameError, passwordError;
    private String confirmError, fullnamError;
}

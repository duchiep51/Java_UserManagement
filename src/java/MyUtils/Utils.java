/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyUtils;

import java.security.MessageDigest;

/**
 *
 * @author Hiep
 */
public class Utils {
    public static String getEncrypted(String password) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            return new sun.misc.BASE64Encoder().encode(md.digest());
        } finally {
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.encrypt;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author villa
 */
public class Encrypt {

    public static String sha256(String pass) {
        String sha256hex = Hashing.sha256()
                .hashString(pass, StandardCharsets.UTF_8)
                .toString();
        return sha256hex;
    }
}

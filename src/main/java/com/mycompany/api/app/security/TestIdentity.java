/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.security;

import com.mycompany.api.app.encrypt.AES;
import static java.util.Arrays.asList;
import java.util.HashSet;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author villa
 */
@ApplicationScoped
public class TestIdentity implements IdentityStore {

    @Inject
    @ConfigProperty(name = "my.user")
    private String username;

    @Inject
    @ConfigProperty(name = "my.password")
    private String password;

    @Inject
    @ConfigProperty(name = "secretKey")
    private String secretKey;

    public CredentialValidationResult validate(UsernamePasswordCredential user) throws Exception {

        String userdes;
        String passdes;
        userdes = AES.decrypt(username, secretKey);
        passdes = AES.decrypt(password, secretKey);

        if (user.compareTo(userdes, passdes)) {
            return new CredentialValidationResult("user", new HashSet<>(asList("admin", "todos")));
        }
        return INVALID_RESULT;
    }
}

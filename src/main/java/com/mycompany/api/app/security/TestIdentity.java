/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.app.security;

import static java.util.Arrays.asList;
import java.util.HashSet;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;

/**
 *
 * @author villa
 */
@ApplicationScoped
public class TestIdentity implements IdentityStore {

    public CredentialValidationResult validate(UsernamePasswordCredential user) {
        if (user.compareTo("jose", "admin")) {
            return new CredentialValidationResult("jose", new HashSet<>(asList("admin", "todos")));
        }
        return INVALID_RESULT;
    }
}

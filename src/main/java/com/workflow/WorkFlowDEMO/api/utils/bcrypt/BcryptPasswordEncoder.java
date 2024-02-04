package com.workflow.WorkFlowDEMO.api.utils.bcrypt;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BcryptPasswordEncoder {


    // Method for encoding password using BCrypt
    public static String encodePassword(String password){

        // Generate a salt
        String salt = BCrypt.gensalt();

        // Encoding the password using the generated salt
        return BCrypt.hashpw(password,salt);

    }


}

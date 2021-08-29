package net.movingjin.api.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityTest {
    @Test
    @DisplayName("Password 암호화")
    void main(){
        int i = 0;
        while(i<5){
            String password = "123456";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPwd = passwordEncoder.encode(password);
            System.out.println(hashedPwd);
            i++;
        }
    }
}

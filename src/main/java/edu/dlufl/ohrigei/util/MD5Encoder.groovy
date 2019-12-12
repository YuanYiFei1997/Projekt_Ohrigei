package edu.dlufl.ohrigei.util

import org.springframework.security.crypto.password.PasswordEncoder

class MD5Encoder implements PasswordEncoder{
    @Override
    String encode(CharSequence charSequence) {
        return null
    }

    @Override
    boolean matches(CharSequence charSequence, String s) {
        return false
    }
}

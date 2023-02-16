package com.works.services;

import com.works.Utils.RestEnum;
import com.works.entities.Admin;

import com.works.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminDetailService implements UserDetailsService {
    final PasswordEncoder encoder;
    final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public ResponseEntity register(Admin admin) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        // şifreyi encoder yapma yöntemi
        admin.setPassword(encoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        hm.put(RestEnum.status,true);
        hm.put(RestEnum.result,admin);
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}

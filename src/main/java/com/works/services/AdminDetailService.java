package com.works.services;

import com.works.Utils.RestEnum;
import com.works.entities.Admin;

import com.works.entities.Role;
import com.works.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AdminDetailService implements UserDetailsService {
    // User detail önemli !!
    final PasswordEncoder encoder;
    final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> optionalAdmin = adminRepository.findByUsernameEqualsIgnoreCase(username);
        // varsa eğer demek is present
        if(optionalAdmin.isPresent()){
            Admin admin = optionalAdmin.get();
            // kullanıcı kayıtlıysa - USer nesnesi Springin dikkate aldığı bir nesnedir.
            return new User(
                    admin.getUsername(),
                    admin.getPassword(),
                    admin.getEnable(),
                    true,
                    true,
                    true,
                    parseRoles(admin.getRoles())
            );
        }else {
            // kayıtlı olmayan kullanıcı hata fırlattı
            throw new UsernameNotFoundException("Not found " + username);
        }
    }

    private Collection<? extends GrantedAuthority> parseRoles(List<Role> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        for( Role role : roles){
            list.add(new SimpleGrantedAuthority(role.getName()));
        }
        return list;
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

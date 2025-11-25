package com.ecommerce.ecommerce.security.details;

import com.ecommerce.ecommerce.entity.User;
import com.ecommerce.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // username = userId as String (coming from JWT subject)
    @Override
    public UserDetails loadUserByUsername(String userIdStr) throws UsernameNotFoundException {

        Long userId;
        try {
            userId = Long.parseLong(userIdStr);
        } catch (NumberFormatException ex) {
            throw new UsernameNotFoundException("Invalid user id in token: " + userIdStr);
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + userId));

        List<GrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));

        return new org.springframework.security.core.userdetails.User(
                String.valueOf(user.getId()), // principal name = userId string
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }
}

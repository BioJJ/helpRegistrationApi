package com.biojj.helpregistration.service;

import com.biojj.helpregistration.domain.User;
import com.biojj.helpregistration.repositories.UserRepository;
import com.biojj.helpregistration.security.UserSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final
    UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return new UserSS(user.get().getId(), user.get().getEmail(), user.get().getPassword(), user.get().getProfiles(), user.get().getName(), user.get().getCpf());
        }
        throw new UsernameNotFoundException(email);
    }
}

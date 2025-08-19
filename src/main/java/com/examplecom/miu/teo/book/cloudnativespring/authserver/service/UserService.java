package com.examplecom.miu.teo.book.cloudnativespring.authserver.service;


import com.examplecom.miu.teo.book.cloudnativespring.authserver.repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@RequiredArgsConstructor
@Service
@Log
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(()->{
//                    log.debug("Query returned no results for user '" + username + "'");
                    return new UsernameNotFoundException(format("Username %s not found",username));
                });
    }
}

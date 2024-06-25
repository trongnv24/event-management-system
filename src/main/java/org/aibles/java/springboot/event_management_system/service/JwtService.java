package org.aibles.java.springboot.event_management_system.service;

import org.apache.coyote.BadRequestException;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String parseToken(String token) throws BadRequestException;

    UserDetails loadUserByUsername(String username);

    boolean validateToken(String token, UserDetails userDetails);
}

package ch.noser.uek223.core.security.authentication;

import ch.noser.uek223.domain.user.dto.UserDTOAdmin;

import java.util.UUID;

public interface AuthenticationService {

    UserDTOAdmin getAuthenticationResponse(UUID userId);

    void authenticate(String authenticationHeader);

}

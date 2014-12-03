package eu.solidcraft.starter.infrastructure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import eu.solidcraft.starter.infrastructure.security.LoggedUserRepository
import org.springframework.stereotype.Component

@Component
class BackendAuthenticator {
    private AuthenticationManager authenticationManager

    @Autowired
    BackendAuthenticator(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager
    }

    boolean login(String login, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password))
        boolean isAuthenticated = LoggedUserRepository.isAuthenticated(authentication)
        if (isAuthenticated) {
            SecurityContextHolder.getContext().setAuthentication(authentication)
        }
        return isAuthenticated
    }

    boolean logout() {
        SecurityContextHolder.getContext().setAuthentication(null)
    }

}

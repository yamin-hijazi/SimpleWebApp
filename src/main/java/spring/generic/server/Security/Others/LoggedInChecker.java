package spring.generic.server.Security.Others;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import spring.generic.server.MongoDB.User.User;

@Component
public class LoggedInChecker {
    public User getLoggedInUser() {
        User user = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();

            // principal can be "anonymousUser" (String)
            if (principal instanceof NuvolaUserDetails) {
                NuvolaUserDetails userDetails = (NuvolaUserDetails) principal;
                user = userDetails.getUser();
            }
        }

        return user;
    }
}

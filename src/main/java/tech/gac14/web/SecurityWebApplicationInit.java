package tech.gac14.web;
import org.springframework.security.web.context.*;

public class SecurityWebApplicationInit extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInit() {
        super(SecurityConfig.class);
    }

}

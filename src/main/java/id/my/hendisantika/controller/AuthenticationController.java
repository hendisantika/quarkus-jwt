package id.my.hendisantika.controller;

import id.my.hendisantika.util.PBKDF2Encoder;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 */
@Path("/auth")
public class AuthenticationController {

    @ConfigProperty(name = "id.my.hendisantika.jwt.duration")
    public Long duration;
    @ConfigProperty(name = "mp.jwt.verify.issuer")
    public String issuer;
    @Inject
    private PBKDF2Encoder passwordEncoder;
}

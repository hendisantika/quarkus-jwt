package id.my.hendisantika.controller;

import id.my.hendisantika.model.AuthRequest;
import id.my.hendisantika.model.AuthResponse;
import id.my.hendisantika.model.User;
import id.my.hendisantika.util.PBKDF2Encoder;
import id.my.hendisantika.util.TokenUtils;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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

    @PermitAll
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(AuthRequest authRequest) {
        User u = User.findByUsername(authRequest.username);
        if (u != null && u.password.equals(passwordEncoder.encode(authRequest.password))) {
            try {
                return Response.ok(new AuthResponse(TokenUtils.generateToken(u.username, u.roles, duration, issuer))).build();
            } catch (Exception e) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}

package id.my.hendisantika.util;

import id.my.hendisantika.model.Role;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;

import java.security.PrivateKey;
import java.util.HashSet;
import java.util.Set;

import static io.smallrye.jwt.util.KeyUtils.readPrivateKey;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 10:12
 * To change this template use File | Settings | File Templates.
 */
public class TokenUtils {
    public static String generateToken(String username, Set<Role> roles, Long duration, String issuer) throws Exception {
        String privateKeyLocation = "/privateKey.pem";
        PrivateKey privateKey = readPrivateKey(privateKeyLocation);

        JwtClaimsBuilder claimsBuilder = Jwt.claims();
        long currentTimeInSecs = currentTimeInSecs();

        Set<String> groups = new HashSet<>();
        for (Role role : roles) groups.add(role.toString());

        claimsBuilder.issuer(issuer);
        claimsBuilder.subject(username);
        claimsBuilder.issuedAt(currentTimeInSecs);
        claimsBuilder.expiresAt(currentTimeInSecs + duration);
        claimsBuilder.groups(groups);

        return claimsBuilder.jws().signatureKeyId(privateKeyLocation).sign(privateKey);
    }
}

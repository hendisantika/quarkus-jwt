package id.my.hendisantika.util;

import jakarta.enterprise.context.RequestScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 10:11
 * To change this template use File | Settings | File Templates.
 */
@RequestScoped
public class PBKDF2Encoder {

    @ConfigProperty(name = "id.my.hendisantika.password.secret")
    private String secret;
    @ConfigProperty(name = "id.my.hendisantika.password.iteration")
    private Integer iteration;
    @ConfigProperty(name = "id.my.hendisantika.password.keyLength")
    private Integer keyLength;

    /**
     * More info (https://www.owasp.org/index.php/Hashing_Java) 404 :(
     *
     * @param cs password
     * @return encoded password
     */
    public String encode(CharSequence cs) {
        try {
            byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                    .generateSecret(new PBEKeySpec(cs.toString().toCharArray(), secret.getBytes(), iteration, keyLength))
                    .getEncoded();
            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException(ex);
        }
    }
}

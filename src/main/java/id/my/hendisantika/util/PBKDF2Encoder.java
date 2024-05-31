package id.my.hendisantika.util;

import jakarta.enterprise.context.RequestScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

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
}

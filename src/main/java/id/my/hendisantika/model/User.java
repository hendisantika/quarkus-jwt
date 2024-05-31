package id.my.hendisantika.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 10:10
 * To change this template use File | Settings | File Templates.
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class User {

    public String username;
    public String password;
    public Set<Role> roles;

    // this is just an example, you can load the user from the database (via PanacheEntityBase)
    public static User findByUsername(String username) {

        //if using Panache pattern (extends or PanacheEntity PanacheEntityBase)
        //return find("username", username).firstResult();

        Map<String, User> data = new HashMap<>();

        //username:password -> user:user
        data.put("user", new User("user", "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=", Collections.singleton(Role.USER)));

        //username:password -> admin:admin
        data.put("admin", new User("admin", "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=", Collections.singleton(Role.ADMIN)));

        return data.getOrDefault(username, null);
    }
}

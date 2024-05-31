package id.my.hendisantika.controller;

import id.my.hendisantika.model.Message;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 10:16
 * To change this template use File | Settings | File Templates.
 */
@Path("/resource")
public class ResourceController {

    @RolesAllowed("USER")
    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response user() {
        return Response.ok(new Message("Content for user")).build();
    }

    @RolesAllowed("ADMIN")
    @GET
    @Path("/admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response admin() {
        return Response.ok(new Message("Content for admin")).build();
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GET
    @Path("/user-or-admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response userOrAdmin() {
        return Response.ok(new Message("Content for user or admin")).build();
    }
}

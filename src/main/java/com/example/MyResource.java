package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @Path("/test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTest(){
        TestEntity entity=new TestEntity();
        entity.setId(1);
        entity.setName("1");
        return Response.ok(entity).build();
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTest(){
        List<TestEntity> list=new ArrayList<TestEntity>();
        TestEntity entity1=new TestEntity();
        entity1.setId(1);
        entity1.setName("1");

        TestEntity entity2=new TestEntity();
        entity2.setId(1);
        entity2.setName("1");

        list.add(entity1);
        list.add(entity2);

        GenericEntity<List<TestEntity>> entity = new GenericEntity<List<TestEntity>>(list) {};

        return Response.ok(entity).build();
    }
}

package com.thenetvalue;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestItem {

    private List<Item> items = new CopyOnWriteArrayList<>();

    @GET
    @Path("/all")
    public List<Item> getAll() {
        return items;
    }

    @GET
    @Path("/{id}")
    public Response getByID(@PathParam("id") String id) {
        Optional<Item> any = items.stream().filter(p -> p.getId().equals(id)).findAny();
        if (any.isPresent()) {
            return Response.ok(any.get()).build();
        } else {
            return Response.status(404).build();
        }
    }

    @POST
    public Response create(@Valid Item item) {
        items.add(item);
        return Response.created(UriBuilder.fromUri("/" + item.getId()).build()).build();
    }

    @PATCH
    @Path("/{id}")
    public Response update(@Valid Item product, @PathParam("id") String id) {
        Optional<Item> any = items.stream().filter(i -> i.getId().equals(id)).findAny();

        if (any.isPresent()) {
            any.get().setNome(product.getNome());
            return Response.ok(any.get()).build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        Optional<Item> any = items.stream().filter(p -> p.getId().equals(id)).findAny();

        if (any.isPresent()) {
            items.remove(any.get());
            return Response.noContent().build();
        } else {
            return Response.status(404).build();
        }
    }

}

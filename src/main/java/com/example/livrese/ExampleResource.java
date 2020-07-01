package com.example.livrese;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.livrese.cep.client.CepService;
import com.example.livrese.cep.client.Endereco;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class ExampleResource {

    @Inject
    @RestClient
    CepService cepService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco hello() {
        System.out.println(this.cepService.getEnderecoByCep("03156150"));
        return this.cepService.getEnderecoByCep("66650600");
    }
}
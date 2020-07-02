package com.example.livrese;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.livrese.cep.client.CepService;
import com.example.livrese.cep.client.Endereco;
import com.example.livrese.cep.client.EnderecoRequest;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class ExampleResource {

    @Inject
    @RestClient
    CepService cepService;

    @POST
    @Path("endereco")
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco endereco(EnderecoRequest req) {
        req.persist();
        return this.cepService.getEnderecoByCep(req.cep);
    }

    @GET
    @Path("endereco")
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco endereco() {
        Endereco endereco = new Endereco();
        endereco.logradouro = "FAKE";
        return endereco;
    }
}
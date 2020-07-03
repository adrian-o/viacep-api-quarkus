package com.example.livrese.cep.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.livrese.cep.client.data.Endereco;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("")
@RegisterRestClient(configKey = "viacep-client")
public interface ViaCepService {
    
    @GET
    @Path("{cep}/json")
    @Produces("application/json")
    Endereco getEnderecoByCep(@PathParam String cep);
}
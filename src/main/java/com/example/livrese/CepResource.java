package com.example.livrese;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.livrese.cep.client.ViaCepService;
import com.example.livrese.cep.client.data.Endereco;
import com.example.livrese.cep.client.data.EnderecoRequest;
import com.example.livrese.cep.services.CepService;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/livrese/cep")
public class CepResource {

    @Inject
    @RestClient
    ViaCepService viaCepService;

    @Inject
    CepService cepService;

    @POST
    @Path("endereco")
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco endereco(EnderecoRequest req) {
        Endereco response = this.viaCepService.getEnderecoByCep(req.cep);
        req.result = response.cep!=null?1:0;
        this.cepService.saveEndereco(req);
        return response;
    }

}
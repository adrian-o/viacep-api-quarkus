package com.example.livrese;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.livrese.cep.client.ViaCepService;
import com.example.livrese.cep.client.data.Endereco;
import com.example.livrese.cep.client.data.EnderecoRequest;
import com.example.livrese.cep.client.data.EnderecoResponse;
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
    public Response endereco(EnderecoRequest req) {
        EnderecoResponse response = new EnderecoResponse();
        try {
            Endereco endereco = this.viaCepService.getEnderecoByCep(req.cep);
            response.request = req;
            if (endereco != null && endereco.cep != null) {
                response.endereco = endereco;
                this.cepService.saveEndereco(response);
                return Response.ok(response).build();
            } else {
                response.mensagem = "Cep não encontrado na API do ViaCep";
                this.cepService.saveEndereco(response);
                return Response.status(Status.NOT_FOUND).entity(response).build();
            }
        } catch(Exception e) {
            response.mensagem = "Erro ao consultar o serviço do ViaCep";
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                        .entity(response)
                        .build();
        }  
    }
}
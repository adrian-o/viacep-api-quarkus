package com.example.livrese.cep.services;

import java.util.Date;

import javax.inject.Singleton;

import com.example.livrese.cep.client.data.Endereco;
import com.example.livrese.cep.client.data.EnderecoRequest;

@Singleton
public class CepService {
    
    public void saveEndereco(EnderecoRequest req) {
        req.data = new Date();
        req.persist();
    }
}
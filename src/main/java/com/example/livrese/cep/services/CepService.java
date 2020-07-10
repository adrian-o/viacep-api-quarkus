package com.example.livrese.cep.services;

import java.util.Date;

import javax.inject.Singleton;

import com.example.livrese.cep.client.data.EnderecoResponse;

@Singleton
public class CepService {
    
    public void saveEndereco(EnderecoResponse resp) {
        resp.data = new Date();
        resp.result = (resp.endereco!=null && resp.endereco.cep!=null) ? 1 : 0;
        resp.persist();
    }
}
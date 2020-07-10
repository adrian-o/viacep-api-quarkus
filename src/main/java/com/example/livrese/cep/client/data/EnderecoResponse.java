package com.example.livrese.cep.client.data;

import java.util.Date;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection="EnderecoResponse")
public class EnderecoResponse extends PanacheMongoEntity {
    public EnderecoRequest request;
    public Date data;
    public Integer result;
    public Endereco endereco;
    public String mensagem;
}
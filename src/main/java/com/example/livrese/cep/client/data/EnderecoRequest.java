package com.example.livrese.cep.client.data;

import java.util.Date;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection="EnderecoRequest")
public class EnderecoRequest extends PanacheMongoEntity {
    public String nome;
    public String cep;
}
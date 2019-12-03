package com.thenetvalue;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Item {

    private String id = UUID.randomUUID().toString();

    @NotBlank
    private String nome;

    public String getId() {
        return id;
    }

    public Item setId(String id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Item setNome(String nome) {
        this.nome = nome;
        return this;
    }
}

package com.example.sensores;

public class Eventos {
    Integer id;
    Float values[] = new Float[3];


    public Eventos(Integer id,Float[] values) {
        this.values = values;
        this.id = id;
    }
}

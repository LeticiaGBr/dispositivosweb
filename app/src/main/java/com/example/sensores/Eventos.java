package com.example.sensores;

public class Eventos {
    Integer id;
    Float[] values = new Float[3];

    public Eventos(Integer id, Float[] values) {
        this.id = id;
        this.values = values;
    }

    public Integer getId() {
        return id;
    }

    public Float[] getValues() {
        return values;
    }
}

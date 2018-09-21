package com.example.manasatpc.recyclingfact.model;

import java.io.Serializable;

/**
 * Created by ManasatPC on 21/09/18.
 */

public class Commercy implements Serializable {
    private String name ;
    private String description;
    public Commercy(String name , String description, int image_id){
        this.name = name;
        this.description = description;
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    private int image_id;

}

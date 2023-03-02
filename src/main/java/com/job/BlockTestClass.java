package com.job;

public class BlockTestClass implements Block {
    private String color;
    private String material;

    public String getColor(){
        return color;
    }

    public String getMaterial(){
        return material;
    }

    public BlockTestClass(String color, String material) {
        this.color = color;
        this.material = material;
    }
}
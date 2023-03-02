package com.job;

import java.util.List;

public class CompositeBlockTestClass implements CompositeBlock{
    List<Block> blocks;
    private String color;
    private String material;

    public String getColor(){
        return color;
    }

    public String getMaterial(){
        return material;
    }

    public List<Block> getBlocks(){
        return blocks;
    }

    public CompositeBlockTestClass(String color, String material) {
        this.color = color;
        this.material = material;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
package com.job;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wall implements Structure {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color){
        return getListOfOnlyBlocks(blocks)
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material){
        return getListOfOnlyBlocks(blocks)
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count(){
        Long sum = getListOfOnlyBlocks(blocks)
                .count();

        return sum.intValue();
    }

    public boolean isCompositeBlock(Block block){
        return block instanceof CompositeBlock;
    }

    public List<Block> getBlocksList(Block block){
        CompositeBlock compositeBlock = (CompositeBlock) block;
        List<Block> blocksList = compositeBlock.getBlocks();
        return blocksList;
    }

    public Stream<Block> getListOfOnlyBlocks(List<Block> blocks){
        return blocks.stream()
                .flatMap(block -> isCompositeBlock(block) ? getBlocksList(block).stream() : Stream.of(block) );
    }

    //method only used for tests
    public void setList(List<Block> list){this.blocks = list;}
}
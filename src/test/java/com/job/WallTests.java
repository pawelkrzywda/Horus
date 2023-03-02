package com.job;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class WallTests {

    @Test
    public void testFindBlockByColorMethod(){
        //Given
        Wall wall1 = new Wall();
        Wall wall2 = new Wall();
        List<Block> blocks1 = new ArrayList<>();
        List<Block> blocks2 = new ArrayList<>();

        BlockTestClass block1 = new BlockTestClass("grey", "concrete");
        BlockTestClass block2 = new BlockTestClass("grey2", "concrete2");
        BlockTestClass block3 = new BlockTestClass("grey3", "concrete3");
        blocks1.add(block1);
        blocks1.add(block2);
        blocks1.add(block3);

        CompositeBlockTestClass compositeBlock1 = new CompositeBlockTestClass("red", "brick");
        compositeBlock1.setBlocks(blocks1);
        blocks2.add(compositeBlock1);
        blocks2.add(block1);

        wall1.setList(blocks1);
        wall2.setList(blocks2);

        //When
        Optional<Block> blockOpt1 = wall1.findBlockByColor("grey");
        Optional<Block> blockOpt2 = wall2.findBlockByColor("grey2");

        //Then
        assertTrue(blockOpt1.isPresent());
        assertTrue(blockOpt2.isPresent());
        assertEquals("grey", blockOpt1.get().getColor());
        assertEquals("grey2", blockOpt2.get().getColor());
    }

    @Test
    public void testFindBlocksByMaterialMethod(){
        //Given
        Wall wall1 = new Wall();
        Wall wall2 = new Wall();
        List<Block> blocks1 = new ArrayList<>();
        List<Block> blocks2 = new ArrayList<>();

        BlockTestClass block1 = new BlockTestClass("grey", "concrete");
        BlockTestClass block2 = new BlockTestClass("grey2", "concrete2");
        BlockTestClass block3 = new BlockTestClass("grey3", "concrete3");
        blocks1.add(block1);
        blocks1.add(block2);
        blocks1.add(block3);

        CompositeBlockTestClass compositeBlock1 = new CompositeBlockTestClass("red", "brick");
        compositeBlock1.setBlocks(blocks1);
        blocks2.add(compositeBlock1);
        blocks2.add(block1);

        wall1.setList(blocks1);
        wall2.setList(blocks2);

        //When
        List<Block> blockList1 = wall1.findBlocksByMaterial("concrete");
        List<Block> blockList2 = wall2.findBlocksByMaterial("concrete");

        //Then
        assertEquals(1, blockList1.size());
        assertEquals(2, blockList2.size());
    }

    @Test
    public void testCountMethod(){
        //Given
        Wall wall1 = new Wall();
        Wall wall2 = new Wall();
        List<Block> blocks1 = new ArrayList<>();
        List<Block> blocks2 = new ArrayList<>();

        BlockTestClass block1 = new BlockTestClass("grey", "concrete");
        BlockTestClass block2 = new BlockTestClass("grey2", "concrete2");
        BlockTestClass block3 = new BlockTestClass("grey3", "concrete3");
        blocks1.add(block1);
        blocks1.add(block2);
        blocks1.add(block3);

        CompositeBlockTestClass compositeBlock1 = new CompositeBlockTestClass("red", "brick");
        compositeBlock1.setBlocks(blocks1);
        blocks2.add(compositeBlock1);
        blocks2.add(block1);

        wall1.setList(blocks1);
        wall2.setList(blocks2);

        //When
        int result1 = wall1.count();
        int result2 = wall2.count();

        //Then
        assertEquals(3, result1);
        assertEquals(4, result2);
    }
}
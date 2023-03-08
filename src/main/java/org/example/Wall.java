package org.example;

import org.example.repository.Block;
import org.example.repository.Structure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {

    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        verifyArg(color);
        return blocks.stream()
                .filter(block -> color.equals(block.getColor()))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        verifyArg(material);
        return blocks.stream()
                .filter(block -> material.equals(block.getMaterial()))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }

    private void verifyArg(String arg) {
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }


}
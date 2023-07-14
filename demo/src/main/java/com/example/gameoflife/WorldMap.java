package com.example.gameoflife;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WorldMap {

  private final World world;

  private WorldMap(World world) {
    this.world = world;
  }

  public static WorldMap of(World world) {
    return new WorldMap(world);
  }

  @Override
  public String toString() {
    return IntStream.range(0, world.getGridSize())
        .mapToObj(y -> IntStream.range(0, 10)
            .mapToObj(x -> world.isAlive(x, y) ? "*" : ".")
            .collect(Collectors.joining()))
        .collect(Collectors.joining("\n"));
  }

}

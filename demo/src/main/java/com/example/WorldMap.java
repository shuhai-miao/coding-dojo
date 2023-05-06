package com.example;

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
    StringBuilder sb = new StringBuilder();
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 10; x++) {
        sb.append(world.isAlive(x, y) ? "*" : ".");
      }
      sb.append("\n");
    }
    return sb.toString();
  } 
}

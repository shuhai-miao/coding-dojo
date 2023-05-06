package com.example;

public class GameOfLife {
  
  public static void main(String[] args) {
  
    World world = new World(10);
    world.add(Cell.aliveCell(2, 2));
    world.add(Cell.aliveCell(2, 3));
    world.add(Cell.aliveCell(2, 4));

    WorldMap worldMap = WorldMap.of(world);
    System.out.println(worldMap);

    World nextWorld = world.tick();
    WorldMap nextWorldMap = WorldMap.of(nextWorld);
    System.out.println(nextWorldMap);

    World nextNextWorld = nextWorld.tick();
    WorldMap nextNextWorldMap = WorldMap.of(nextNextWorld);
    System.out.println(nextNextWorldMap);
  }
}

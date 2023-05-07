package com.example;

public class GameOfLife {
  
  public static void main(String[] args) {
  
    World world = World.of(5);
    world.add(Cell.aliveCell(2, 2));
    world.add(Cell.aliveCell(2, 3));
    world.add(Cell.aliveCell(2, 4));

    System.out.println("New World");
    System.out.println(WorldMap.of(world));
    
    World nextWorld = world.tick();
    System.out.println("Next World");
    System.out.println(WorldMap.of(nextWorld));

    System.out.println("Next Next World");
    World nextNextWorld = nextWorld.tick();
    System.out.println(WorldMap.of(nextNextWorld));
  }
}

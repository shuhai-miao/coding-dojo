package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class World {

  private static final int GRID_SIZE = 10;

  private List<Cell> cells;
  private int gridSize;

  private static final List<Rule> rules = List.of(new UnderPopulationRule(),
      new OverPopulationRule(), new ReproductionRule());

  public static World of() {
    return of(GRID_SIZE);
  }

  public static World of(int gridSize) {
    return new World(initializeWorld(gridSize), gridSize);
  }

  public World(List<Cell> cells, int gridSize) {
    this.cells = cells;
    this.gridSize = gridSize;
  }

  public boolean isEmpty() {
    return countLivingCells() == 0;
  }

  public void add(Cell cell) {
    cells.stream()
        .filter(existingCell -> existingCell.hasSameCoordinates(cell))
        .findFirst()
        .ifPresent(existingCell -> {
          if (existingCell.isAlive() != cell.isAlive()) {
            existingCell.revive();
          }
        });
  }

  public World tick() {
    List<Cell> newCells = cells.stream().map(cell -> {
      Cell newCell = Cell.of(cell);
      rules.forEach(rule -> rule.apply(newCell, countLivingNeighbors(cell)));
      return newCell;
    }).collect(Collectors.toList());
    return new World(newCells, gridSize);
  }

  public long countLivingCells() {
    return cells.stream().filter(cell -> cell.isAlive()).count();
  }

  public long countLivingNeighbors(Cell cell) {
    return cells.stream().filter(c -> c.isNeighborOf(cell) && c.isAlive()).count();
  }

  public boolean isAlive(int x, int y) {
    return cells.stream()
        .filter(cell -> cell.getCoordinate().equals(Coordinate.of(x, y)))
        .findFirst()
        .orElse(Cell.of(x, y))
        .isAlive();
  }

  public int getGridSize() {
    return gridSize;
  }

  private static List<Cell> initializeWorld(int gridSize) {
    List<Cell> cells = new ArrayList<>();
    for (int x = 0; x < gridSize; x++) {
      for (int y = 0; y < gridSize; y++) {
        cells.add(Cell.of(x, y));
      }
    }
    return cells;
  }

  interface Rule {
    void apply(Cell cell, long livingNeighborsCount);
  }

  static class UnderPopulationRule implements Rule {
    @Override
    public void apply(Cell cell, long livingNeighborsCount) {
      if (cell.isAlive() && livingNeighborsCount < 2) {
        cell.die();
      }
    }
  }

  static class OverPopulationRule implements Rule {
    @Override
    public void apply(Cell cell, long livingNeighborsCount) {
      if (cell.isAlive() && livingNeighborsCount > 3) {
        cell.die();
      }
    }
  }

  static class ReproductionRule implements Rule {
    @Override
    public void apply(Cell cell, long livingNeighborsCount) {
      if (!cell.isAlive() && livingNeighborsCount == 3) {
        cell.revive();
      }
    }
  }

}

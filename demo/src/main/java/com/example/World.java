package com.example;

import java.util.ArrayList;
import java.util.List;

public class World {

  private static final int MAX_ROWS = 10;
  private static final int MAX_COLS = 10;

  private List<Cell> cells;
  private static final List<Rule> rules = List.of(
      new UnderPopulationRule(),
      new OverPopulationRule(),
      new ReproductionRule());

  public World() {
    this(initializeWorld());
  }

  public World(List<Cell> cells) {
    this.cells = cells;
  }

  private static List<Cell> initializeWorld() {
    List<Cell> cells = new ArrayList<>();
    for (int x = 0; x < MAX_ROWS; x++) {
      for (int y = 0; y < MAX_COLS; y++) {
        cells.add(Cell.of(x, y, false));
      }
    }
    return cells;
  }

  public boolean isEmpty() {
    return countLivingCells() == 0;
  }

  public World tick() {
    List<Cell> newCells = new ArrayList<>();

    for (Cell cell : cells) {
      Cell newCell = Cell.of(cell);
      rules.forEach(rule -> rule.apply(newCell, countLivingNeighbors(cell)));
      newCells.add(newCell);
    }
    return new World(newCells);
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

  public long countLivingCells() {
    return cells.stream().filter(cell -> cell.isAlive()).count();
  }

  public long countLivingNeighbors(Cell cell) {
    return cells.stream().filter(c -> c.isNeighborOf(cell) && c.isAlive()).count();
  }

  public boolean isAlive(int x, int y) {
    return cells.stream().filter(cell -> cell.hasSameCoordinates(Cell.of(x, y, false))).findFirst().get().isAlive();
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

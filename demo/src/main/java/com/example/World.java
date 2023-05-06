package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World {

  private static final int MAX_ROWS = 10;
  private static final int MAX_COLS = 10;

  private List<Cell> cells;
  private List<Rule> rules;

  public World() {
    initializeWorld();
    initializeRules();
  }

  private void initializeWorld() {
    cells = new ArrayList<>();
    for (int x = 0; x < MAX_ROWS; x++) {
      for (int y = 0; y < MAX_COLS; y++) {
        cells.add(new Cell(x, y, false));
      }
    }
  }

  private void initializeRules() {
    rules = List.of(new UnderPopulationRule(), new OverPopulationRule(), new ReproductionRule());
  }

  public boolean isEmpty() {
    return countLivingCells() == 0;
  }

  public void tick() {
    Iterator<Cell> iterator = cells.iterator();
    while (iterator.hasNext()) {
      Cell cell = iterator.next();
      rules.forEach(rule -> rule.apply(cell, countLivingNeighbors(cell)));
    }
  }

  public void add(Cell cell) {
    Iterator<Cell> iterator = cells.iterator();
    while (iterator.hasNext()) {
      Cell existingCell = iterator.next();
      if (existingCell.getX() == cell.getX() && existingCell.getY() == cell.getY()) {
        iterator.remove();
      }
    }
    this.cells.add(cell);
  }

  public long countLivingCells() {
    return cells.stream().filter(cell -> cell.isAlive()).count();
  }

  public long countLivingNeighbors(Cell cell) {
    return cells.stream().filter(c -> c.isNeighborOf(cell) && c.isAlive()).count();
  }

  public boolean isAlive(int x, int y) {
    return cells.stream().filter(cell -> cell.getX() == x && cell.getY() == y).findFirst().get().isAlive();
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

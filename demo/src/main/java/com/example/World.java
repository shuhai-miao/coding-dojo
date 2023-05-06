package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World {

  private static final int MAX_ROWS = 10;
  private static final int MAX_COLS = 10;

  private List<Cell> cells = new ArrayList<>();

  public World() {
    
    initializeWorld();
  }

  private void initializeWorld() {
    for (int x = 0; x < MAX_ROWS; x++) {
      for (int y = 0; y < MAX_COLS; y++) {
        cells.add(new Cell(x, y, false));
      }
    }
  }

  public boolean isEmpty() {
    return countLivingCells() == 0;
  }

  public void tick() {
    Iterator<Cell> iterator = cells.iterator();
    while (iterator.hasNext()) {
      Cell cell = iterator.next();
        if (isUnderPopulation(cell)) {
          cell.die();
        }
        if (isOverPopulation(cell)) {
          cell.die();
        }
        if (isReproduction(cell)) {
          cell.revive();
        }
    }
  }

  private boolean isReproduction(Cell cell) {
    return !cell.isAlive() && countLivingNeighbors(cell) == 3;
  }

  private boolean isOverPopulation(Cell cell) {
    return cell.isAlive() && countLivingNeighbors(cell) >= 3;
  }

  private boolean isUnderPopulation(Cell cell) {
    return cell.isAlive() && countLivingNeighbors(cell) <= 2;
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

}

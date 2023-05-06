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
      if (cell.isAlive()) {
        if (countLivingNeighbors(cell) <= 2) {
          cell.die();
        }
        if (countLivingNeighbors(cell) >= 3) {
          cell.die();
        }
      } else {
        if (countLivingNeighbors(cell) == 3) {
          cell.revive();
        }
      }
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

}

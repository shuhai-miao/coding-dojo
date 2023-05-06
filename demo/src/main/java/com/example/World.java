package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World {

  private List<Cell> cells = new ArrayList<>();

  public boolean isEmpty() {
    return countLivingCells() == 0;
  }

  public void tick() {
    cells.stream().forEach(cell -> cell.die());
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
   return cells.stream().filter(cell -> !cell.isDead()).count();
  }

}

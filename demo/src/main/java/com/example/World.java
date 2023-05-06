package com.example;

public class World {

  private Cell cell;

  public boolean isEmpty() {
    return cell == null || cell.isDead();
  }

  public void tick() {
    if (cell != null) {
      cell.die();
    }
  }

  public void add(Cell cell) {
    this.cell = cell;
  }

}

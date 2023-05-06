package com.example;

import java.util.Objects;

public class Cell {

  private boolean alive;
  private int x;
  private int y;

  public static Cell aliveCell(int x, int y) {
    return new Cell(x, y, true);
  }

  public Cell(int x, int y, boolean alive) {
    this.alive = alive;
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isAlive() {
    return alive;
  }

  public void revive() {
    alive = true;
  }

  public void die() {
    alive = false;
  }

  public boolean isNeighborOf(Cell cell) {
    if (Objects.isNull(cell) || this.equals(cell)) {
      return false;
    }

    int deltaX = Math.abs(this.x - cell.getX());
    int deltaY = Math.abs(this.y - cell.getY());

    return (deltaX <= 1) && (deltaY <= 1);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Cell cell = (Cell) obj;
    return x == cell.x && y == cell.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}

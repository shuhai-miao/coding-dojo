package com.example;

import java.util.Objects;

public class Cell {

  private boolean alive;
  private int x;
  private int y;

  public static Cell of(int x, int y) {
    return of(x, y, false);
  }
  
  public static Cell of(int x, int y, boolean alive) {
    return new Cell(x, y, alive);
  }
  public static Cell aliveCell(int x, int y) {
    return of (x, y, true);
  }

  private Cell(int x, int y, boolean alive) {
    this.alive = alive;
    this.x = x;
    this.y = y;
  }

  public Cell(Cell other) {
    this(other.x, other.y, other.alive);
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

  public boolean hasSameCoordinates(Cell other) {
    if (other == null) return false;
    return this.x == other.x && this.y == other.y;
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

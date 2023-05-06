package com.example;

import java.util.Objects;

public class Cell {

  private boolean alive;
  private final Coordinate coordinate;

  public static Cell of(int x, int y) {
    return of(x, y, false);
  }

  public static Cell of(int x, int y, boolean alive) {
    return new Cell(Coordinate.of(x, y), alive);
  }

  public static Cell of(Cell other) {
    return new Cell(other.getCoordinate(), other.alive);
  }

  public static Cell aliveCell(int x, int y) {
    return of(x, y, true);
  }

  private Cell(Coordinate coordinate, boolean alive) {
    this.coordinate = coordinate;
    this.alive = alive;
  }

  public Coordinate getCoordinate() {
    return coordinate;
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
    return Objects.equals(this.coordinate, other.coordinate);
  }

  public boolean isNeighborOf(Cell cell) {
    return Objects.isNull(cell) || coordinate.isNeighborOf(cell.coordinate);
  }

}

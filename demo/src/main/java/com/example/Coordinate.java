package com.example;

import java.util.Objects;

public class Coordinate {
  private final int x;
  private final int y;

  private Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public static Coordinate of(int x, int y) {
    return new Coordinate(x, y);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isNeighborOf(Coordinate other) {
    if (Objects.isNull(other) || this.equals(other)) {
      return false;
    }

    int deltaX = Math.abs(this.x - other.getX());
    int deltaY = Math.abs(this.y - other.getY());

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
    Coordinate that = (Coordinate) obj;
    return x == that.x && y == that.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}

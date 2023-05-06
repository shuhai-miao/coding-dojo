package com.example;

public class World {

  private Cell cell;

  public boolean isEmpty() {
    return cell == null;
  }

  public void tick() {
  }

  public void add(Cell cell) {
    this.cell = cell;
  }

}

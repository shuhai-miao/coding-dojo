package com.example;

public class Cell {

  private boolean alive;
  private int x;
  private int y;

  public Cell() {
    this(0, 0);
  }

  public Cell(int x, int y) {
    alive = true;
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
  
  public boolean isDead() {
    return !alive;
  }

  public void die() {
    alive = false;
  }
}

package com.example;

public class Cell {

  private boolean alive;

  public Cell() {
    alive = true;
  }

  public boolean isDead() {
    return !alive;
  }

  public void die() {
    alive = false;
  }
}

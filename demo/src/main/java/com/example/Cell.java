package com.example;

public class Cell {

  private boolean alive;
  private int x;
  private int y;

  public static Cell aliveCell() {
    return new Cell(0, 0, true);
  }

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

  public boolean isDead() {
    return !alive;
  }

  public boolean isAlive() {
    return alive;
  }

  public void die() {
    alive = false;
  }

	public boolean isNeighborOf(Cell cell) {
    if (cell == null) return false;
    if (cell.getX() == x && cell.getY() == y) return false;
    if (cell.getX() == x && cell.getY() == y - 1) return true;
    if (cell.getX() == x && cell.getY() == y + 1) return true;
    if (cell.getX() == x - 1 && cell.getY() == y) return true;
    if (cell.getX() == x + 1 && cell.getY() == y) return true;
    if (cell.getX() == x - 1 && cell.getY() == y - 1) return true;
    if (cell.getX() == x + 1 && cell.getY() == y + 1) return true;
    if (cell.getX() == x - 1 && cell.getY() == y + 1) return true;
    if (cell.getX() == x + 1 && cell.getY() == y - 1) return true;
		return false;
	}

  public void revive() {
    alive = true;
  }
}

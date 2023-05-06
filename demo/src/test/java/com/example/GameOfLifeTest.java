package com.example;

import org.junit.jupiter.api.Test;

public class GameOfLifeTest {


  @Test
  public void a_world_with_three_living_cells_in_a_row_does_not_die_after_a_tick() {

    // Given a world with three living cells in a row
    World world = new World();
    world.add(Cell.aliveCell(0, 1));
    world.add(Cell.aliveCell(1, 1));
    world.add(Cell.aliveCell(2, 1));

    // When I tick the world
    World newWorld = world.tick();

    // Then the world is not empty
    assert !newWorld.isEmpty();

  }

  @Test
  public void a_dead_cell_with_three_living_neighbors_comes_to_life() {

    // Given a world with a dead cell with three living neighbors
    World world = new World();
    Cell cell1 = Cell.aliveCell(3, 3);
    Cell cell2 = Cell.aliveCell(3, 4);
    Cell cell3 = Cell.aliveCell(3, 5);
    world.add(cell1);
    world.add(cell2);
    world.add(cell3);

    // When I tick the world
    World newWorld = world.tick();

    // Then the cell comes to life
    assert newWorld.isAlive(2, 4);
    assert newWorld.isAlive(4, 4);

  }

  @Test
  public void a_living_cell_with_less_than_two_living_neighbors_dies() {

    // Given a world with a living cell with two living neighbors
    World world = new World();
    Cell cell1 = Cell.aliveCell(3, 3);
    Cell cell2 = Cell.aliveCell(3, 4);
    Cell cell3 = Cell.aliveCell(3, 5);
    world.add(cell1);
    world.add(cell2);
    world.add(cell3);

    assert world.countLivingNeighbors(cell1) == 1;
    assert world.countLivingNeighbors(cell2) == 2;
    assert world.countLivingNeighbors(cell3) == 1;

    // When I tick the world
    World newWorld = world.tick();

    // Then the cell dies
    assert !newWorld.isAlive(3, 3);
    assert newWorld.isAlive(3, 4);
    assert !newWorld.isAlive(3, 5);

  }

  @Test
  public void a_living_cell_with_one_living_neighbor_dies() {

    // Given a world with a living cell with one living neighbor
    World world = new World();
    Cell cell1 = Cell.aliveCell(0, 0);
    Cell cell2 = Cell.aliveCell(0, 1);
    world.add(cell1);
    world.add(cell2);

    // When I tick the world
    World newWorld = world.tick();

    // Then the cell dies
    assert !newWorld.isAlive(0, 0);
    assert !newWorld.isAlive(0, 1);
  }

  @Test
  public void count_living_neighbors_of_a_cell() {

    // Given a world with three living cells in a row
    World world = new World();
    Cell cell1 = Cell.aliveCell(0, 1);
    Cell cell2 = Cell.aliveCell(1, 1);
    Cell cell3 = Cell.aliveCell(2, 1);
    world.add(cell1);
    world.add(cell2);
    world.add(cell3);

    // When I count the living neighbors of a cell
    // Then the count is correct
    assert world.countLivingNeighbors(cell1) == 1;
    assert world.countLivingNeighbors(cell2) == 2;
    assert world.countLivingNeighbors(cell3) == 1;
  }

  @Test
  public void a_world_with_two_living_cells_dies_after_one_tick() {
      
      // Given a world with two living cells
      World world = new World();
      world.add(Cell.aliveCell(0, 1));
      world.add(Cell.aliveCell(1, 1));
  
      // When I tick the world
      World newWorld = world.tick();
  
      // Then the world is empty
      assert newWorld.isEmpty();
  }

  @Test
  public void one_location_can_only_house_one_cell() {

    // Given a world
    World world = new World();

    // When I add a cell to the world
    world.add(Cell.aliveCell(0, 0));

    // And I add another cell to the same location
    world.add(Cell.aliveCell(0, 0));

    // Then the world is not empty
    assert !world.isEmpty();
    assert world.countLivingCells() == 1;
  }

  @Test
  public void more_than_one_living_cells_can_be_added_to_the_world() {

    // Given a world
    World world = new World();

    // When I add a cell to the world
    world.add(Cell.aliveCell(0, 1));

    // And I add another cell to the world
    world.add(Cell.aliveCell(1, 1));

    // Then the world is not empty
    assert !world.isEmpty();
    assert world.countLivingCells() == 2;
  }

  @Test
  public void a_world_with_a_single_living_cell_dies_after_one_tick() {
      
      // Given a world with a single living cell
      World world = new World();
      world.add(Cell.aliveCell(0, 0));
  
      // When I tick the world
      World newWorld = world.tick();
  
      // Then the world is empty
      assert newWorld.isEmpty();
  }

  @Test
  public void a_living_cell_can_be_added_to_the_world() {

    // Given a world
    World world = new World();

    // When I add a cell to the world
    world.add(Cell.aliveCell(0,0));

    // Then the world is not empty
    assert !world.isEmpty();
  }

  @Test
  public void An_empty_world_stays_empty() {

    // Given an empty world
    World world = new World();

    // When I tick the world
    World newWorld = world.tick();

    // Then it should still be empty
    assert newWorld.isEmpty();
  }

  @Test
  public void a_new_world_with_no_cells_is_empty() {

    // Given a new world with no cells
    World world = new World();

    // When I ask if it is empty
    // Then it should be empty
    assert world.isEmpty();
  }

}

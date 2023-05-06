package com.example;

import org.junit.jupiter.api.Test;

public class GameOfLifeTest {


  @Test
  public void a_living_cell_can_be_added_to_the_world() {

    // Given a world
    World world = new World();

    // When I add a living cell to the world
    world.add(new Cell());

    // Then the world is not empty
    assert !world.isEmpty();
  }

  @Test
  public void An_empty_world_stays_empty() {

    // Given an empty world
    World world = new World();

    // When I tick the world
    world.tick();

    // Then it should still be empty
    assert world.isEmpty();
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

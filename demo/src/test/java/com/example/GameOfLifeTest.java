package com.example;

import org.junit.jupiter.api.Test;

public class GameOfLifeTest {

  @Test
  public void a_new_world_with_no_cells_is_empty() {

    // Given a new world with no cells
    World world = new World();

    // When I ask if it is empty
    // Then it should be empty
    assert world.isEmpty();
  }

}

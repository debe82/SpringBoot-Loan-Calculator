package se.kontek.backend.model.general;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import se.kontek.backend.model.house.HouseInterest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HouseInterestTest {
  double fixed = 3.5;
  double variable = 0.0;

  @Test
  public void testFixedTypeAndInterestRate() {
    String type = "fixed";

    double result = new HouseInterest(type).getInterests();

    assertTrue(fixed == result);
    assertFalse(variable == result);
  }

  @Test
  public void testVariableTypeAndInterestRate() {
    String type = "variable";

    double result = new HouseInterest(type).getInterests();

    assertTrue(variable == result);
    assertFalse(fixed == result);
  }



}
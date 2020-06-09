package edu.iis.mto.testreactor.dishwasher;

import static org.junit.Assert.assertThat;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import edu.iis.mto.testreactor.dishwasher.engine.Engine;
import edu.iis.mto.testreactor.dishwasher.pump.WaterPump;

public class DishWasherTest {
	@Mock
	private WaterPump waterPump;
	@Mock
	private Engine engine;
	@Mock
	private DirtFilter dirtFilter;
	@Mock
	private Door door;
	
	private DishWasher dishWasher;
	
	@Before
	public void setup() {
		dishWasher = new DishWasher(waterPump, engine, dirtFilter, door);
	}
	
    @Test
    public void itCompiles() {
        assertThat(true, Matchers.equalTo(true));
    }
}

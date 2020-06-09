package edu.iis.mto.testreactor.dishwasher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import edu.iis.mto.testreactor.dishwasher.engine.Engine;
import edu.iis.mto.testreactor.dishwasher.pump.WaterPump;

public class DishWasherTest {
	private WaterPump waterPump = mock(WaterPump.class);
	private Engine engine = mock(Engine.class);
	private DirtFilter dirtFilter = mock(DirtFilter.class);
	private Door door = mock(Door.class);
	
	private DishWasher dishWasher;
	
	@Before
	public void setup() {
		dishWasher = new DishWasher(waterPump, engine, dirtFilter, door);
	}
	
    @Test
    public void itCompiles() {
        assertThat(true, Matchers.equalTo(true));
    }
    
    @Test
    public void test() {
    	when(door.closed()).thenReturn(true);
    	when(dirtFilter.capacity()).thenReturn(0.0);
    	
        RunResult result = dishWasher.start(ProgramConfiguration.builder().withFillLevel(FillLevel.HALF).withProgram(WashingProgram.ECO).withTabletsUsed(false).build());
        
        RunResult expected = RunResult.builder().withRunMinutes(WashingProgram.ECO.getTimeInMinutes()).withStatus(Status.SUCCESS).build();
        
        assertEquals(expected.getRunMinutes(), result.getRunMinutes());
        assertEquals(expected.getStatus(), result.getStatus());
    }
}

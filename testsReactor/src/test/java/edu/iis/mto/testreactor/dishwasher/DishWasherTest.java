package edu.iis.mto.testreactor.dishwasher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

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
    public void shouldMakeSuccessWashing() {
    	when(door.closed()).thenReturn(true);
    	when(dirtFilter.capacity()).thenReturn(55.0);
    	
        RunResult result = dishWasher.start(ProgramConfiguration.builder().withFillLevel(FillLevel.HALF).withProgram(WashingProgram.ECO).withTabletsUsed(true).build());
        
        RunResult expected = RunResult.builder().withRunMinutes(WashingProgram.ECO.getTimeInMinutes()).withStatus(Status.SUCCESS).build();
        
        assertEquals(expected.getRunMinutes(), result.getRunMinutes());
        assertEquals(expected.getStatus(), result.getStatus());
    }
    
    @Test
    public void shouldCallMethodsInOrder() {
    	when(door.closed()).thenReturn(true);
    	when(dirtFilter.capacity()).thenReturn(55.0);
    	
        dishWasher.start(ProgramConfiguration.builder().withFillLevel(FillLevel.HALF).withProgram(WashingProgram.ECO).withTabletsUsed(true).build());
        
        InOrder inOrder = inOrder(door, dirtFilter);
        inOrder.verify(door).closed();
        inOrder.verify(dirtFilter).capacity();
    }
    
    @Test
    public void shouldNotStartWithOpenDoor() {
    	when(door.closed()).thenReturn(false);
    	when(dirtFilter.capacity()).thenReturn(55.0);
    	
        RunResult result = dishWasher.start(ProgramConfiguration.builder().withFillLevel(FillLevel.HALF).withProgram(WashingProgram.ECO).withTabletsUsed(true).build());
        
        RunResult expected = RunResult.builder().withRunMinutes(0).withStatus(Status.DOOR_OPEN).build();
        
        assertEquals(expected.getRunMinutes(), result.getRunMinutes());
        assertEquals(expected.getStatus(), result.getStatus());
    }
    
    @Test
    public void shouldNotStartWithDirtyFilter() {
    	when(door.closed()).thenReturn(true);
    	when(dirtFilter.capacity()).thenReturn(0.0);
    	
        RunResult result = dishWasher.start(ProgramConfiguration.builder().withFillLevel(FillLevel.HALF).withProgram(WashingProgram.ECO).withTabletsUsed(true).build());
        
        RunResult expected = RunResult.builder().withRunMinutes(0).withStatus(Status.ERROR_FILTER).build();
        
        assertEquals(expected.getRunMinutes(), result.getRunMinutes());
        assertEquals(expected.getStatus(), result.getStatus());
    }
}

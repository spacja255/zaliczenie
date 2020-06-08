package edu.iis.mto.testreactor.dishwasher.pump;

import edu.iis.mto.testreactor.dishwasher.FillLevel;

public interface WaterPump {

    void pour(FillLevel fillLevel) throws PumpException;

    void drain() throws PumpException;
}

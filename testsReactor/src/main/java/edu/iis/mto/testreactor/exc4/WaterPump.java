package edu.iis.mto.testreactor.exc4;

public interface WaterPump {

    void pour(WashingProgram program) throws PumpException;

    void drain() throws PumpException;
}

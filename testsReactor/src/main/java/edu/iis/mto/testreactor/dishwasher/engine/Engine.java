package edu.iis.mto.testreactor.dishwasher.engine;

import edu.iis.mto.testreactor.dishwasher.WashingProgram;

public interface Engine {

    void runProgram(WashingProgram program) throws EngineException;

}

package edu.iis.mto.testreactor.dishwasher;

public enum WashingProgram {
    INTENSIVE(120),
    ECO(90),
    RINSE(14),
    NIGHT(300);

    private int timeMinutes;

    private WashingProgram(int timeMinutes) {
        this.timeMinutes = timeMinutes;

    }

    public int getTimeInMinutes() {
        return timeMinutes;
    }
}

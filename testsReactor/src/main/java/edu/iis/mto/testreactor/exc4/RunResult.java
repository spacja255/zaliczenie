package edu.iis.mto.testreactor.exc4;

public class RunResult {

    private final int runMinutes;
    private final Status status;

    private RunResult(Builder builder) {
        this.runMinutes = builder.runMinutes;
        this.status = builder.status;
    }

    public Status getStatus() {
        return status;
    }

    public int getRunMinutes() {
        return runMinutes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private int runMinutes;
        private Status status;

        private Builder() {}

        public Builder withRunMinutes(int runMinutes) {
            this.runMinutes = runMinutes;
            return this;
        }

        public Builder withStatus(Status status) {
            this.status = status;
            return this;
        }

        public RunResult build() {
            return new RunResult(this);
        }
    }
}

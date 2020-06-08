package edu.iis.mto.testreactor.exc4;

public class ProgramConfiguration {

    private final WashingProgram program;
    private final boolean tabletsUsed;

    private ProgramConfiguration(Builder builder) {
        this.program = builder.program;
        this.tabletsUsed = builder.tabletsUsed;
    }

    public WashingProgram getProgram() {
        return program;
    }

    public boolean isWashingTabletsUsed() {
        return tabletsUsed;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private WashingProgram program;
        private boolean tabletsUsed;

        private Builder() {}

        public Builder withProgram(WashingProgram program) {
            this.program = program;
            return this;
        }

        public Builder withTabletsUsed(boolean tabletsUsed) {
            this.tabletsUsed = tabletsUsed;
            return this;
        }

        public ProgramConfiguration build() {
            return new ProgramConfiguration(this);
        }
    }
}

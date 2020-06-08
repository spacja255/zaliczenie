package edu.iis.mto.testreactor.dishwasher;

import static java.util.Objects.requireNonNull;

public class ProgramConfiguration {

    private final WashingProgram program;
    private final boolean tabletsUsed;
    private final FillLevel fillLevel;

    private ProgramConfiguration(Builder builder) {
        this.program = requireNonNull(builder.program, "program");
        this.tabletsUsed = builder.tabletsUsed;
        this.fillLevel = requireNonNull(builder.fillLevel, "fillLevel");
    }

    public WashingProgram getProgram() {
        return program;
    }

    public boolean isWashingTabletsUsed() {
        return tabletsUsed;
    }

    public FillLevel getFillLevel() {
        return fillLevel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private WashingProgram program;
        private boolean tabletsUsed = false;
        private FillLevel fillLevel;

        private Builder() {}

        public Builder withProgram(WashingProgram program) {
            this.program = program;
            return this;
        }

        public Builder withTabletsUsed(boolean tabletsUsed) {
            this.tabletsUsed = tabletsUsed;
            return this;
        }

        public Builder withFillLevel(FillLevel fillLevel) {
            this.fillLevel = fillLevel;
            return this;
        }

        public ProgramConfiguration build() {
            return new ProgramConfiguration(this);
        }
    }
}

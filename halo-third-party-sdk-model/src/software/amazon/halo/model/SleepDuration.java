/*
* Copyright 2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
* except in compliance with the License. A copy of the License is located at
*
* http://aws.amazon.com/apache2.0/
*
* or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
* the specific language governing permissions and limitations under the License.
*/


package software.amazon.halo.model;

import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object containing sleep duration data.
 */

@JsonDeserialize(builder = SleepDuration.Builder.class)
public final class SleepDuration {

    @JsonProperty("total")
    private BigDecimal total = null;

    @JsonProperty("inBed")
    private BigDecimal inBed = null;

    @JsonProperty("awakeAfterSleep")
    private BigDecimal awakeAfterSleep = null;

    @JsonProperty("lightSleep")
    private BigDecimal lightSleep = null;

    @JsonProperty("deepSleep")
    private BigDecimal deepSleep = null;

    @JsonProperty("remSleep")
    private BigDecimal remSleep = null;

    public static Builder builder() {
        return new Builder();
    }

    private SleepDuration(Builder builder) {
        if (builder.total != null) {
            this.total = builder.total;
        }
        if (builder.inBed != null) {
            this.inBed = builder.inBed;
        }
        if (builder.awakeAfterSleep != null) {
            this.awakeAfterSleep = builder.awakeAfterSleep;
        }
        if (builder.lightSleep != null) {
            this.lightSleep = builder.lightSleep;
        }
        if (builder.deepSleep != null) {
            this.deepSleep = builder.deepSleep;
        }
        if (builder.remSleep != null) {
            this.remSleep = builder.remSleep;
        }
    }

    /**
     * Total time spent in various sleep stages over the course of the night in second.
     * @return total
    **/
    @JsonProperty("total")
    public BigDecimal getTotal() {
        return total;
    }


    /**
     * Total time spent in bed over the course of the night in seconds.
     * @return inBed
    **/
    @JsonProperty("inBed")
    public BigDecimal getInBed() {
        return inBed;
    }


    /**
     * Total time spent awake after falling asleep in seconds.
     * @return awakeAfterSleep
    **/
    @JsonProperty("awakeAfterSleep")
    public BigDecimal getAwakeAfterSleep() {
        return awakeAfterSleep;
    }


    /**
     * The total duration of time spent in light sleep in seconds.
     * @return lightSleep
    **/
    @JsonProperty("lightSleep")
    public BigDecimal getLightSleep() {
        return lightSleep;
    }


    /**
     * The total duration of time spent in deep sleep in seconds.
     * @return deepSleep
    **/
    @JsonProperty("deepSleep")
    public BigDecimal getDeepSleep() {
        return deepSleep;
    }


    /**
     * The total duration of time spent in REM sleep in seconds.
     * @return remSleep
    **/
    @JsonProperty("remSleep")
    public BigDecimal getRemSleep() {
        return remSleep;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SleepDuration sleepDuration = (SleepDuration) o;
        return Objects.equals(this.total, sleepDuration.total) &&
            Objects.equals(this.inBed, sleepDuration.inBed) &&
            Objects.equals(this.awakeAfterSleep, sleepDuration.awakeAfterSleep) &&
            Objects.equals(this.lightSleep, sleepDuration.lightSleep) &&
            Objects.equals(this.deepSleep, sleepDuration.deepSleep) &&
            Objects.equals(this.remSleep, sleepDuration.remSleep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, inBed, awakeAfterSleep, lightSleep, deepSleep, remSleep);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SleepDuration {\n");
        
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("    inBed: ").append(toIndentedString(inBed)).append("\n");
        sb.append("    awakeAfterSleep: ").append(toIndentedString(awakeAfterSleep)).append("\n");
        sb.append("    lightSleep: ").append(toIndentedString(lightSleep)).append("\n");
        sb.append("    deepSleep: ").append(toIndentedString(deepSleep)).append("\n");
        sb.append("    remSleep: ").append(toIndentedString(remSleep)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
  
    public static class Builder {
        private BigDecimal total;
        private BigDecimal inBed;
        private BigDecimal awakeAfterSleep;
        private BigDecimal lightSleep;
        private BigDecimal deepSleep;
        private BigDecimal remSleep;

        private Builder() {}

        @JsonProperty("total")

        public Builder withTotal(BigDecimal total) {
            this.total = total;
            return this;
        }


        @JsonProperty("inBed")

        public Builder withInBed(BigDecimal inBed) {
            this.inBed = inBed;
            return this;
        }


        @JsonProperty("awakeAfterSleep")

        public Builder withAwakeAfterSleep(BigDecimal awakeAfterSleep) {
            this.awakeAfterSleep = awakeAfterSleep;
            return this;
        }


        @JsonProperty("lightSleep")

        public Builder withLightSleep(BigDecimal lightSleep) {
            this.lightSleep = lightSleep;
            return this;
        }


        @JsonProperty("deepSleep")

        public Builder withDeepSleep(BigDecimal deepSleep) {
            this.deepSleep = deepSleep;
            return this;
        }


        @JsonProperty("remSleep")

        public Builder withRemSleep(BigDecimal remSleep) {
            this.remSleep = remSleep;
            return this;
        }


        public SleepDuration build() {
            return new SleepDuration(this);
        }
    }
}


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
 * An object containing the average, maximum and resting heart rate during the given day.
 */

@JsonDeserialize(builder = HeartRate.Builder.class)
public final class HeartRate {

    @JsonProperty("average")
    private BigDecimal average = null;

    @JsonProperty("maximum")
    private BigDecimal maximum = null;

    @JsonProperty("resting")
    private BigDecimal resting = null;

    public static Builder builder() {
        return new Builder();
    }

    private HeartRate(Builder builder) {
        if (builder.average != null) {
            this.average = builder.average;
        }
        if (builder.maximum != null) {
            this.maximum = builder.maximum;
        }
        if (builder.resting != null) {
            this.resting = builder.resting;
        }
    }

    /**
     * Average heart rate across the activity, in beats per minute (contained within a \"heartRate\" object).
     * @return average
    **/
    @JsonProperty("average")
    public BigDecimal getAverage() {
        return average;
    }


    /**
     * The maximum heart rate during the activity, in beats per minute (contained within a \"heartRate\" object).
     * @return maximum
    **/
    @JsonProperty("maximum")
    public BigDecimal getMaximum() {
        return maximum;
    }


    /**
     * Daily resting heart rate, in beats per minute (only contained within a \"heartRate\" object in the \"summary\").
     * @return resting
    **/
    @JsonProperty("resting")
    public BigDecimal getResting() {
        return resting;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HeartRate heartRate = (HeartRate) o;
        return Objects.equals(this.average, heartRate.average) &&
            Objects.equals(this.maximum, heartRate.maximum) &&
            Objects.equals(this.resting, heartRate.resting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(average, maximum, resting);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HeartRate {\n");
        
        sb.append("    average: ").append(toIndentedString(average)).append("\n");
        sb.append("    maximum: ").append(toIndentedString(maximum)).append("\n");
        sb.append("    resting: ").append(toIndentedString(resting)).append("\n");
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
        private BigDecimal average;
        private BigDecimal maximum;
        private BigDecimal resting;

        private Builder() {}

        @JsonProperty("average")

        public Builder withAverage(BigDecimal average) {
            this.average = average;
            return this;
        }


        @JsonProperty("maximum")

        public Builder withMaximum(BigDecimal maximum) {
            this.maximum = maximum;
            return this;
        }


        @JsonProperty("resting")

        public Builder withResting(BigDecimal resting) {
            this.resting = resting;
            return this;
        }


        public HeartRate build() {
            return new HeartRate(this);
        }
    }
}


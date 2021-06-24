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
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * An object containing the body fat percentage measurements.
 */

@JsonDeserialize(builder = FatPercentage.Builder.class)
public final class FatPercentage {

    @JsonProperty("measurements")
    private List<software.amazon.halo.model.Measurement> measurements = new ArrayList<software.amazon.halo.model.Measurement>();

    public static Builder builder() {
        return new Builder();
    }

    private FatPercentage(Builder builder) {
        if (builder.measurements != null) {
            this.measurements = builder.measurements;
        }
    }

    /**
     * Get measurements
     * @return measurements
    **/
    @JsonProperty("measurements")
    public List<software.amazon.halo.model.Measurement> getMeasurements() {
        return measurements;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FatPercentage fatPercentage = (FatPercentage) o;
        return Objects.equals(this.measurements, fatPercentage.measurements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(measurements);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FatPercentage {\n");
        
        sb.append("    measurements: ").append(toIndentedString(measurements)).append("\n");
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
        private List<software.amazon.halo.model.Measurement> measurements;

        private Builder() {}

        @JsonProperty("measurements")

        public Builder withMeasurements(List<software.amazon.halo.model.Measurement> measurements) {
            this.measurements = measurements;
            return this;
        }

        public Builder addMeasurementsItem(software.amazon.halo.model.Measurement measurementsItem) {
            if (this.measurements == null) {
                this.measurements = new ArrayList<software.amazon.halo.model.Measurement>();
            }
            this.measurements.add(measurementsItem);
            return this;
        }

        public FatPercentage build() {
            return new FatPercentage(this);
        }
    }
}


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
 * Body fat percentage measurements taken on the specified day, or the most recent measurement, if none were taken the specified day.
 */

@JsonDeserialize(builder = Measurement.Builder.class)
public final class Measurement {

    @JsonProperty("value")
    private BigDecimal value = null;

    @JsonProperty("timestamp")
    private String timestamp = null;

    public static Builder builder() {
        return new Builder();
    }

    private Measurement(Builder builder) {
        if (builder.value != null) {
            this.value = builder.value;
        }
        if (builder.timestamp != null) {
            this.timestamp = builder.timestamp;
        }
    }

    /**
     * The user daily, or most recent (if none take for given day), body fat percentage measurements.
     * @return value
    **/
    @JsonProperty("value")
    public BigDecimal getValue() {
        return value;
    }


    /**
     * The timestamp for when the data was recorded in extended ISO 8601 date/time format (yyyy-mm-ddThh:mm:ss.mmmZ).
     * @return timestamp
    **/
    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Measurement measurement = (Measurement) o;
        return Objects.equals(this.value, measurement.value) &&
            Objects.equals(this.timestamp, measurement.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, timestamp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Measurement {\n");
        
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
        private BigDecimal value;
        private String timestamp;

        private Builder() {}

        @JsonProperty("value")

        public Builder withValue(BigDecimal value) {
            this.value = value;
            return this;
        }


        @JsonProperty("timestamp")

        public Builder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }


        public Measurement build() {
            return new Measurement(this);
        }
    }
}


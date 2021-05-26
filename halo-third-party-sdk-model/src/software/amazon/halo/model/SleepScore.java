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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object containing daily sleep score.
 */

@JsonDeserialize(builder = SleepScore.Builder.class)
public final class SleepScore {

    @JsonProperty("value")
    private Integer value = null;

    @JsonProperty("timestamp")
    private String timestamp = null;

    @JsonProperty("isFinal")
    private Boolean isFinal = null;

    public static Builder builder() {
        return new Builder();
    }

    private SleepScore(Builder builder) {
        if (builder.value != null) {
            this.value = builder.value;
        }
        if (builder.timestamp != null) {
            this.timestamp = builder.timestamp;
        }
        if (builder.isFinal != null) {
            this.isFinal = builder.isFinal;
        }
    }

    /**
     * The daily sleep score.
     * @return value
    **/
    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }


    /**
     * The timestamp for when the data was synced in extended ISO 8601 date/time format (yyyy-mm-ddThh:mm:ss.mmmZ).
     * @return timestamp
    **/
    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }


    /**
     * A boolean flag denoting if the score is final (true) from the automatic detection algorithms perspective. Scores can still change if they are modified by the customer.
     * @return isFinal
    **/
    @JsonProperty("isFinal")
    public Boolean getIsFinal() {
        return isFinal;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SleepScore sleepScore = (SleepScore) o;
        return Objects.equals(this.value, sleepScore.value) &&
            Objects.equals(this.timestamp, sleepScore.timestamp) &&
            Objects.equals(this.isFinal, sleepScore.isFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, timestamp, isFinal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SleepScore {\n");
        
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    isFinal: ").append(toIndentedString(isFinal)).append("\n");
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
        private Integer value;
        private String timestamp;
        private Boolean isFinal;

        private Builder() {}

        @JsonProperty("value")

        public Builder withValue(Integer value) {
            this.value = value;
            return this;
        }


        @JsonProperty("timestamp")

        public Builder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }


        @JsonProperty("isFinal")

        public Builder withIsFinal(Boolean isFinal) {
            this.isFinal = isFinal;
            return this;
        }


        public SleepScore build() {
            return new SleepScore(this);
        }
    }
}


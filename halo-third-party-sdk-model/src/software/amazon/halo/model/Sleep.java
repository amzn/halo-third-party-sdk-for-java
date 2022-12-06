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
 * An object including the sleep data for the user on the given day.
 */

@JsonDeserialize(builder = Sleep.Builder.class)
public final class Sleep {

    @JsonProperty("timestamp")
    private String timestamp = null;

    @JsonProperty("score")
    private software.amazon.halo.model.SleepScore score = null;

    @JsonProperty("duration")
    private software.amazon.halo.model.SleepDuration duration = null;

    @JsonProperty("efficiency")
    private BigDecimal efficiency = null;

    @JsonProperty("onsetLatency")
    private BigDecimal onsetLatency = null;

    @JsonProperty("numberOfAwakenings")
    private Integer numberOfAwakenings = null;

    @JsonProperty("modified")
    private Boolean modified = null;

    @JsonProperty("sessionStartTime")
    private String sessionStartTime = null;

    @JsonProperty("sessionEndTime")
    private String sessionEndTime = null;

    public static Builder builder() {
        return new Builder();
    }

    private Sleep(Builder builder) {
        if (builder.timestamp != null) {
            this.timestamp = builder.timestamp;
        }
        if (builder.score != null) {
            this.score = builder.score;
        }
        if (builder.duration != null) {
            this.duration = builder.duration;
        }
        if (builder.efficiency != null) {
            this.efficiency = builder.efficiency;
        }
        if (builder.onsetLatency != null) {
            this.onsetLatency = builder.onsetLatency;
        }
        if (builder.numberOfAwakenings != null) {
            this.numberOfAwakenings = builder.numberOfAwakenings;
        }
        if (builder.modified != null) {
            this.modified = builder.modified;
        }
        if (builder.sessionStartTime != null) {
            this.sessionStartTime = builder.sessionStartTime;
        }
        if (builder.sessionEndTime != null) {
            this.sessionEndTime = builder.sessionEndTime;
        }
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
     * Get score
     * @return score
    **/
    @JsonProperty("score")
    public software.amazon.halo.model.SleepScore getScore() {
        return score;
    }


    /**
     * Get duration
     * @return duration
    **/
    @JsonProperty("duration")
    public software.amazon.halo.model.SleepDuration getDuration() {
        return duration;
    }


    /**
     * Percentage of time in bed that a user is asleep.
     * @return efficiency
    **/
    @JsonProperty("efficiency")
    public BigDecimal getEfficiency() {
        return efficiency;
    }


    /**
     * Time to fall asleep in seconds.
     * @return onsetLatency
    **/
    @JsonProperty("onsetLatency")
    public BigDecimal getOnsetLatency() {
        return onsetLatency;
    }


    /**
     * The number of times awoken during sleep for 5 or more minutes.
     * @return numberOfAwakenings
    **/
    @JsonProperty("numberOfAwakenings")
    public Integer getNumberOfAwakenings() {
        return numberOfAwakenings;
    }


    /**
     * A boolean flag denoting if this sleep session information was modified by the user.
     * @return modified
    **/
    @JsonProperty("modified")
    public Boolean getModified() {
        return modified;
    }


    /**
     * The date and time the session started, encoded in ISO8601 date/time format (yyyy-mm-ddThh:mm:ss.mmmZ).
     * @return sessionStartTime
    **/
    @JsonProperty("sessionStartTime")
    public String getSessionStartTime() {
        return sessionStartTime;
    }


    /**
     * The date and time the session ended, encoded in ISO8601 date/time format (yyyy-mm-ddThh:mm:ss.mmmZ).
     * @return sessionEndTime
    **/
    @JsonProperty("sessionEndTime")
    public String getSessionEndTime() {
        return sessionEndTime;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sleep sleep = (Sleep) o;
        return Objects.equals(this.timestamp, sleep.timestamp) &&
            Objects.equals(this.score, sleep.score) &&
            Objects.equals(this.duration, sleep.duration) &&
            Objects.equals(this.efficiency, sleep.efficiency) &&
            Objects.equals(this.onsetLatency, sleep.onsetLatency) &&
            Objects.equals(this.numberOfAwakenings, sleep.numberOfAwakenings) &&
            Objects.equals(this.modified, sleep.modified) &&
            Objects.equals(this.sessionStartTime, sleep.sessionStartTime) &&
            Objects.equals(this.sessionEndTime, sleep.sessionEndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, score, duration, efficiency, onsetLatency, numberOfAwakenings, modified, sessionStartTime, sessionEndTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Sleep {\n");
        
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    score: ").append(toIndentedString(score)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    efficiency: ").append(toIndentedString(efficiency)).append("\n");
        sb.append("    onsetLatency: ").append(toIndentedString(onsetLatency)).append("\n");
        sb.append("    numberOfAwakenings: ").append(toIndentedString(numberOfAwakenings)).append("\n");
        sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
        sb.append("    sessionStartTime: ").append(toIndentedString(sessionStartTime)).append("\n");
        sb.append("    sessionEndTime: ").append(toIndentedString(sessionEndTime)).append("\n");
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
        private String timestamp;
        private software.amazon.halo.model.SleepScore score;
        private software.amazon.halo.model.SleepDuration duration;
        private BigDecimal efficiency;
        private BigDecimal onsetLatency;
        private Integer numberOfAwakenings;
        private Boolean modified;
        private String sessionStartTime;
        private String sessionEndTime;

        private Builder() {}

        @JsonProperty("timestamp")

        public Builder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }


        @JsonProperty("score")

        public Builder withScore(software.amazon.halo.model.SleepScore score) {
            this.score = score;
            return this;
        }


        @JsonProperty("duration")

        public Builder withDuration(software.amazon.halo.model.SleepDuration duration) {
            this.duration = duration;
            return this;
        }


        @JsonProperty("efficiency")

        public Builder withEfficiency(BigDecimal efficiency) {
            this.efficiency = efficiency;
            return this;
        }


        @JsonProperty("onsetLatency")

        public Builder withOnsetLatency(BigDecimal onsetLatency) {
            this.onsetLatency = onsetLatency;
            return this;
        }


        @JsonProperty("numberOfAwakenings")

        public Builder withNumberOfAwakenings(Integer numberOfAwakenings) {
            this.numberOfAwakenings = numberOfAwakenings;
            return this;
        }


        @JsonProperty("modified")

        public Builder withModified(Boolean modified) {
            this.modified = modified;
            return this;
        }


        @JsonProperty("sessionStartTime")

        public Builder withSessionStartTime(String sessionStartTime) {
            this.sessionStartTime = sessionStartTime;
            return this;
        }


        @JsonProperty("sessionEndTime")

        public Builder withSessionEndTime(String sessionEndTime) {
            this.sessionEndTime = sessionEndTime;
            return this;
        }


        public Sleep build() {
            return new Sleep(this);
        }
    }
}


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
 * An object containing daily activity summary information.
 */

@JsonDeserialize(builder = ActivitySummary.Builder.class)
public final class ActivitySummary {

    @JsonProperty("timestamp")
    private String timestamp = null;

    @JsonProperty("duration")
    private software.amazon.halo.model.ActivitySummaryDuration duration = null;

    public static Builder builder() {
        return new Builder();
    }

    private ActivitySummary(Builder builder) {
        if (builder.timestamp != null) {
            this.timestamp = builder.timestamp;
        }
        if (builder.duration != null) {
            this.duration = builder.duration;
        }
    }

    /**
     * The timestamp for when the activity summary was last computed in extended ISO 8601 date/time format (yyyy-mm-ddThh:mm:ss.mmmZ).
     * @return timestamp
    **/
    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }


    /**
     * Get duration
     * @return duration
    **/
    @JsonProperty("duration")
    public software.amazon.halo.model.ActivitySummaryDuration getDuration() {
        return duration;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivitySummary activitySummary = (ActivitySummary) o;
        return Objects.equals(this.timestamp, activitySummary.timestamp) &&
            Objects.equals(this.duration, activitySummary.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, duration);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActivitySummary {\n");
        
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
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
        private software.amazon.halo.model.ActivitySummaryDuration duration;

        private Builder() {}

        @JsonProperty("timestamp")

        public Builder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }


        @JsonProperty("duration")

        public Builder withDuration(software.amazon.halo.model.ActivitySummaryDuration duration) {
            this.duration = duration;
            return this;
        }


        public ActivitySummary build() {
            return new ActivitySummary(this);
        }
    }
}


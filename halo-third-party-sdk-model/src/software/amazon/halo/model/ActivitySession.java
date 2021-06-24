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
 * An activity sessions completed by the user on the given day.
 */

@JsonDeserialize(builder = ActivitySession.Builder.class)
public final class ActivitySession {

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("startDateTime")
    private String startDateTime = null;

    @JsonProperty("endDateTime")
    private String endDateTime = null;

    @JsonProperty("modified")
    private Boolean modified = null;

    @JsonProperty("automatic")
    private Boolean automatic = null;

    @JsonProperty("stepInfo")
    private software.amazon.halo.model.StepInfo stepInfo = null;

    @JsonProperty("heartRate")
    private software.amazon.halo.model.HeartRate heartRate = null;

    @JsonProperty("timestamp")
    private String timestamp = null;

    @JsonProperty("calorieInfo")
    private software.amazon.halo.model.CalorieInfo calorieInfo = null;

    public static Builder builder() {
        return new Builder();
    }

    private ActivitySession(Builder builder) {
        if (builder.id != null) {
            this.id = builder.id;
        }
        if (builder.type != null) {
            this.type = builder.type;
        }
        if (builder.startDateTime != null) {
            this.startDateTime = builder.startDateTime;
        }
        if (builder.endDateTime != null) {
            this.endDateTime = builder.endDateTime;
        }
        if (builder.modified != null) {
            this.modified = builder.modified;
        }
        if (builder.automatic != null) {
            this.automatic = builder.automatic;
        }
        if (builder.stepInfo != null) {
            this.stepInfo = builder.stepInfo;
        }
        if (builder.heartRate != null) {
            this.heartRate = builder.heartRate;
        }
        if (builder.timestamp != null) {
            this.timestamp = builder.timestamp;
        }
        if (builder.calorieInfo != null) {
            this.calorieInfo = builder.calorieInfo;
        }
    }

    /**
     * A UUID identifying the activity session.
     * @return id
    **/
    @JsonProperty("id")
    public String getId() {
        return id;
    }


    /**
     * The type of activity that was completed.
     * @return type
    **/
    @JsonProperty("type")
    public String getType() {
        return type;
    }


    /**
     * The date and time the activity started, encoded in ISO8601 date/time format (yyyy-mm-ddThh:mm:ss.mmmZ).
     * @return startDateTime
    **/
    @JsonProperty("startDateTime")
    public String getStartDateTime() {
        return startDateTime;
    }


    /**
     * The date and time the activity ended, encoded in ISO8601 date/time format (yyyy-mm-ddThh:mm:ss.mmmZ).
     * @return endDateTime
    **/
    @JsonProperty("endDateTime")
    public String getEndDateTime() {
        return endDateTime;
    }


    /**
     * A boolean flag denoting if this session information was modified by the user.
     * @return modified
    **/
    @JsonProperty("modified")
    public Boolean getModified() {
        return modified;
    }


    /**
     * A boolean flag denoting if the session was automatically tracked (true) or manually entered.
     * @return automatic
    **/
    @JsonProperty("automatic")
    public Boolean getAutomatic() {
        return automatic;
    }


    /**
     * Get stepInfo
     * @return stepInfo
    **/
    @JsonProperty("stepInfo")
    public software.amazon.halo.model.StepInfo getStepInfo() {
        return stepInfo;
    }


    /**
     * Get heartRate
     * @return heartRate
    **/
    @JsonProperty("heartRate")
    public software.amazon.halo.model.HeartRate getHeartRate() {
        return heartRate;
    }


    /**
     * The timestamp for when the session and associated data (e.g. heart rate) was synced in extended ISO 8601 date/time format (yyyy-mm-ddThh:mm:ss.mmmZ).
     * @return timestamp
    **/
    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }


    /**
     * Get calorieInfo
     * @return calorieInfo
    **/
    @JsonProperty("calorieInfo")
    public software.amazon.halo.model.CalorieInfo getCalorieInfo() {
        return calorieInfo;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivitySession activitySession = (ActivitySession) o;
        return Objects.equals(this.id, activitySession.id) &&
            Objects.equals(this.type, activitySession.type) &&
            Objects.equals(this.startDateTime, activitySession.startDateTime) &&
            Objects.equals(this.endDateTime, activitySession.endDateTime) &&
            Objects.equals(this.modified, activitySession.modified) &&
            Objects.equals(this.automatic, activitySession.automatic) &&
            Objects.equals(this.stepInfo, activitySession.stepInfo) &&
            Objects.equals(this.heartRate, activitySession.heartRate) &&
            Objects.equals(this.timestamp, activitySession.timestamp) &&
            Objects.equals(this.calorieInfo, activitySession.calorieInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, startDateTime, endDateTime, modified, automatic, stepInfo, heartRate, timestamp, calorieInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActivitySession {\n");
        
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
        sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
        sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
        sb.append("    automatic: ").append(toIndentedString(automatic)).append("\n");
        sb.append("    stepInfo: ").append(toIndentedString(stepInfo)).append("\n");
        sb.append("    heartRate: ").append(toIndentedString(heartRate)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    calorieInfo: ").append(toIndentedString(calorieInfo)).append("\n");
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
        private String id;
        private String type;
        private String startDateTime;
        private String endDateTime;
        private Boolean modified;
        private Boolean automatic;
        private software.amazon.halo.model.StepInfo stepInfo;
        private software.amazon.halo.model.HeartRate heartRate;
        private String timestamp;
        private software.amazon.halo.model.CalorieInfo calorieInfo;

        private Builder() {}

        @JsonProperty("id")

        public Builder withId(String id) {
            this.id = id;
            return this;
        }


        @JsonProperty("type")

        public Builder withType(String type) {
            this.type = type;
            return this;
        }


        @JsonProperty("startDateTime")

        public Builder withStartDateTime(String startDateTime) {
            this.startDateTime = startDateTime;
            return this;
        }


        @JsonProperty("endDateTime")

        public Builder withEndDateTime(String endDateTime) {
            this.endDateTime = endDateTime;
            return this;
        }


        @JsonProperty("modified")

        public Builder withModified(Boolean modified) {
            this.modified = modified;
            return this;
        }


        @JsonProperty("automatic")

        public Builder withAutomatic(Boolean automatic) {
            this.automatic = automatic;
            return this;
        }


        @JsonProperty("stepInfo")

        public Builder withStepInfo(software.amazon.halo.model.StepInfo stepInfo) {
            this.stepInfo = stepInfo;
            return this;
        }


        @JsonProperty("heartRate")

        public Builder withHeartRate(software.amazon.halo.model.HeartRate heartRate) {
            this.heartRate = heartRate;
            return this;
        }


        @JsonProperty("timestamp")

        public Builder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }


        @JsonProperty("calorieInfo")

        public Builder withCalorieInfo(software.amazon.halo.model.CalorieInfo calorieInfo) {
            this.calorieInfo = calorieInfo;
            return this;
        }


        public ActivitySession build() {
            return new ActivitySession(this);
        }
    }
}


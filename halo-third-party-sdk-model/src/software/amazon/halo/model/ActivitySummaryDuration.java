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
 * An object containing the user&#39;s various activity durations per day.
 */

@JsonDeserialize(builder = ActivitySummaryDuration.Builder.class)
public final class ActivitySummaryDuration {

    @JsonProperty("intenseActivity")
    private BigDecimal intenseActivity = null;

    @JsonProperty("moderateActivity")
    private BigDecimal moderateActivity = null;

    @JsonProperty("lightActivity")
    private BigDecimal lightActivity = null;

    @JsonProperty("sedentary")
    private BigDecimal sedentary = null;

    public static Builder builder() {
        return new Builder();
    }

    private ActivitySummaryDuration(Builder builder) {
        if (builder.intenseActivity != null) {
            this.intenseActivity = builder.intenseActivity;
        }
        if (builder.moderateActivity != null) {
            this.moderateActivity = builder.moderateActivity;
        }
        if (builder.lightActivity != null) {
            this.lightActivity = builder.lightActivity;
        }
        if (builder.sedentary != null) {
            this.sedentary = builder.sedentary;
        }
    }

    /**
     * Daily total intense activity duration in seconds.
     * @return intenseActivity
    **/
    @JsonProperty("intenseActivity")
    public BigDecimal getIntenseActivity() {
        return intenseActivity;
    }


    /**
     * Daily total moderate activity duration in seconds.
     * @return moderateActivity
    **/
    @JsonProperty("moderateActivity")
    public BigDecimal getModerateActivity() {
        return moderateActivity;
    }


    /**
     * Daily total light activity duration in seconds.
     * @return lightActivity
    **/
    @JsonProperty("lightActivity")
    public BigDecimal getLightActivity() {
        return lightActivity;
    }


    /**
     * Daily total sedentary duration in seconds.
     * @return sedentary
    **/
    @JsonProperty("sedentary")
    public BigDecimal getSedentary() {
        return sedentary;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivitySummaryDuration activitySummaryDuration = (ActivitySummaryDuration) o;
        return Objects.equals(this.intenseActivity, activitySummaryDuration.intenseActivity) &&
            Objects.equals(this.moderateActivity, activitySummaryDuration.moderateActivity) &&
            Objects.equals(this.lightActivity, activitySummaryDuration.lightActivity) &&
            Objects.equals(this.sedentary, activitySummaryDuration.sedentary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intenseActivity, moderateActivity, lightActivity, sedentary);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActivitySummaryDuration {\n");
        
        sb.append("    intenseActivity: ").append(toIndentedString(intenseActivity)).append("\n");
        sb.append("    moderateActivity: ").append(toIndentedString(moderateActivity)).append("\n");
        sb.append("    lightActivity: ").append(toIndentedString(lightActivity)).append("\n");
        sb.append("    sedentary: ").append(toIndentedString(sedentary)).append("\n");
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
        private BigDecimal intenseActivity;
        private BigDecimal moderateActivity;
        private BigDecimal lightActivity;
        private BigDecimal sedentary;

        private Builder() {}

        @JsonProperty("intenseActivity")

        public Builder withIntenseActivity(BigDecimal intenseActivity) {
            this.intenseActivity = intenseActivity;
            return this;
        }


        @JsonProperty("moderateActivity")

        public Builder withModerateActivity(BigDecimal moderateActivity) {
            this.moderateActivity = moderateActivity;
            return this;
        }


        @JsonProperty("lightActivity")

        public Builder withLightActivity(BigDecimal lightActivity) {
            this.lightActivity = lightActivity;
            return this;
        }


        @JsonProperty("sedentary")

        public Builder withSedentary(BigDecimal sedentary) {
            this.sedentary = sedentary;
            return this;
        }


        public ActivitySummaryDuration build() {
            return new ActivitySummaryDuration(this);
        }
    }
}


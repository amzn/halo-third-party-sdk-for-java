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
 * An object containing the user&#39;s light/moderate/intense activity durations during the workout session.
 */

@JsonDeserialize(builder = ActivitySessionDuration.Builder.class)
public final class ActivitySessionDuration {

    @JsonProperty("intenseActivity")
    private BigDecimal intenseActivity = null;

    @JsonProperty("moderateActivity")
    private BigDecimal moderateActivity = null;

    @JsonProperty("lightActivity")
    private BigDecimal lightActivity = null;

    public static Builder builder() {
        return new Builder();
    }

    private ActivitySessionDuration(Builder builder) {
        if (builder.intenseActivity != null) {
            this.intenseActivity = builder.intenseActivity;
        }
        if (builder.moderateActivity != null) {
            this.moderateActivity = builder.moderateActivity;
        }
        if (builder.lightActivity != null) {
            this.lightActivity = builder.lightActivity;
        }
    }

    /**
     * Amount (in seconds) of intense activity completed during the session.
     * @return intenseActivity
    **/
    @JsonProperty("intenseActivity")
    public BigDecimal getIntenseActivity() {
        return intenseActivity;
    }


    /**
     * Amount (in seconds) of moderate activity completed during the session.
     * @return moderateActivity
    **/
    @JsonProperty("moderateActivity")
    public BigDecimal getModerateActivity() {
        return moderateActivity;
    }


    /**
     * Amount (in seconds) of light activity completed during the session.
     * @return lightActivity
    **/
    @JsonProperty("lightActivity")
    public BigDecimal getLightActivity() {
        return lightActivity;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivitySessionDuration activitySessionDuration = (ActivitySessionDuration) o;
        return Objects.equals(this.intenseActivity, activitySessionDuration.intenseActivity) &&
            Objects.equals(this.moderateActivity, activitySessionDuration.moderateActivity) &&
            Objects.equals(this.lightActivity, activitySessionDuration.lightActivity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intenseActivity, moderateActivity, lightActivity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActivitySessionDuration {\n");
        
        sb.append("    intenseActivity: ").append(toIndentedString(intenseActivity)).append("\n");
        sb.append("    moderateActivity: ").append(toIndentedString(moderateActivity)).append("\n");
        sb.append("    lightActivity: ").append(toIndentedString(lightActivity)).append("\n");
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


        public ActivitySessionDuration build() {
            return new ActivitySessionDuration(this);
        }
    }
}


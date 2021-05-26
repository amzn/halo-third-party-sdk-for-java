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
 * Daily summary.
 */

@JsonDeserialize(builder = Record.Builder.class)
public final class Record {

    @JsonProperty("date")
    private String date = null;

    @JsonProperty("sub")
    private String sub = null;

    @JsonProperty("stepInfo")
    private software.amazon.halo.model.StepInfo stepInfo = null;

    @JsonProperty("sleep")
    private software.amazon.halo.model.Sleep sleep = null;

    @JsonProperty("activity")
    private software.amazon.halo.model.Activity activity = null;

    @JsonProperty("challenges")
    private List<software.amazon.halo.model.Challenge> challenges = new ArrayList<software.amazon.halo.model.Challenge>();

    @JsonProperty("body")
    private software.amazon.halo.model.Body body = null;

    public static Builder builder() {
        return new Builder();
    }

    private Record(Builder builder) {
        if (builder.date != null) {
            this.date = builder.date;
        }
        if (builder.sub != null) {
            this.sub = builder.sub;
        }
        if (builder.stepInfo != null) {
            this.stepInfo = builder.stepInfo;
        }
        if (builder.sleep != null) {
            this.sleep = builder.sleep;
        }
        if (builder.activity != null) {
            this.activity = builder.activity;
        }
        if (builder.challenges != null) {
            this.challenges = builder.challenges;
        }
        if (builder.body != null) {
            this.body = builder.body;
        }
    }

    /**
     * The customer-perceived day of the record as YYYY-MM-DD.
     * @return date
    **/
    @JsonProperty("date")
    public String getDate() {
        return date;
    }


    /**
     * The identity of the customer that the record pertains to.
     * @return sub
    **/
    @JsonProperty("sub")
    public String getSub() {
        return sub;
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
     * Get sleep
     * @return sleep
    **/
    @JsonProperty("sleep")
    public software.amazon.halo.model.Sleep getSleep() {
        return sleep;
    }


    /**
     * Get activity
     * @return activity
    **/
    @JsonProperty("activity")
    public software.amazon.halo.model.Activity getActivity() {
        return activity;
    }


    /**
     * An array of Challenges completed by the user on the given day.
     * @return challenges
    **/
    @JsonProperty("challenges")
    public List<software.amazon.halo.model.Challenge> getChallenges() {
        return challenges;
    }


    /**
     * Get body
     * @return body
    **/
    @JsonProperty("body")
    public software.amazon.halo.model.Body getBody() {
        return body;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Record record = (Record) o;
        return Objects.equals(this.date, record.date) &&
            Objects.equals(this.sub, record.sub) &&
            Objects.equals(this.stepInfo, record.stepInfo) &&
            Objects.equals(this.sleep, record.sleep) &&
            Objects.equals(this.activity, record.activity) &&
            Objects.equals(this.challenges, record.challenges) &&
            Objects.equals(this.body, record.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, sub, stepInfo, sleep, activity, challenges, body);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Record {\n");
        
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    sub: ").append(toIndentedString(sub)).append("\n");
        sb.append("    stepInfo: ").append(toIndentedString(stepInfo)).append("\n");
        sb.append("    sleep: ").append(toIndentedString(sleep)).append("\n");
        sb.append("    activity: ").append(toIndentedString(activity)).append("\n");
        sb.append("    challenges: ").append(toIndentedString(challenges)).append("\n");
        sb.append("    body: ").append(toIndentedString(body)).append("\n");
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
        private String date;
        private String sub;
        private software.amazon.halo.model.StepInfo stepInfo;
        private software.amazon.halo.model.Sleep sleep;
        private software.amazon.halo.model.Activity activity;
        private List<software.amazon.halo.model.Challenge> challenges;
        private software.amazon.halo.model.Body body;

        private Builder() {}

        @JsonProperty("date")

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }


        @JsonProperty("sub")

        public Builder withSub(String sub) {
            this.sub = sub;
            return this;
        }


        @JsonProperty("stepInfo")

        public Builder withStepInfo(software.amazon.halo.model.StepInfo stepInfo) {
            this.stepInfo = stepInfo;
            return this;
        }


        @JsonProperty("sleep")

        public Builder withSleep(software.amazon.halo.model.Sleep sleep) {
            this.sleep = sleep;
            return this;
        }


        @JsonProperty("activity")

        public Builder withActivity(software.amazon.halo.model.Activity activity) {
            this.activity = activity;
            return this;
        }


        @JsonProperty("challenges")

        public Builder withChallenges(List<software.amazon.halo.model.Challenge> challenges) {
            this.challenges = challenges;
            return this;
        }

        public Builder addChallengesItem(software.amazon.halo.model.Challenge challengesItem) {
            if (this.challenges == null) {
                this.challenges = new ArrayList<software.amazon.halo.model.Challenge>();
            }
            this.challenges.add(challengesItem);
            return this;
        }

        @JsonProperty("body")

        public Builder withBody(software.amazon.halo.model.Body body) {
            this.body = body;
            return this;
        }


        public Record build() {
            return new Record(this);
        }
    }
}


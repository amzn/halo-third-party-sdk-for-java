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
 * An Challenge completed by the user on the given day.
 */

@JsonDeserialize(builder = Challenge.Builder.class)
public final class Challenge {

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("startDate")
    private String startDate = null;

    @JsonProperty("completionDate")
    private String completionDate = null;

    @JsonProperty("timestamp")
    private String timestamp = null;

    public static Builder builder() {
        return new Builder();
    }

    private Challenge(Builder builder) {
        if (builder.id != null) {
            this.id = builder.id;
        }
        if (builder.name != null) {
            this.name = builder.name;
        }
        if (builder.type != null) {
            this.type = builder.type;
        }
        if (builder.startDate != null) {
            this.startDate = builder.startDate;
        }
        if (builder.completionDate != null) {
            this.completionDate = builder.completionDate;
        }
        if (builder.timestamp != null) {
            this.timestamp = builder.timestamp;
        }
    }

    /**
     * A UUID identifying the Challenge.
     * @return id
    **/
    @JsonProperty("id")
    public String getId() {
        return id;
    }


    /**
     * A human-readable string describing the challenge the user completed.
     * @return name
    **/
    @JsonProperty("name")
    public String getName() {
        return name;
    }


    /**
     * An enumerated string describing what domain the challenge falls into. Values include 'ACTIVITY', 'SLEEP', 'MINDFULNESS', and 'NUTRITION'.
     * @return type
    **/
    @JsonProperty("type")
    public String getType() {
        return type;
    }


    /**
     * The date the user started the Challenge, encoded as YYYY-MM-DD.
     * @return startDate
    **/
    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }


    /**
     * The date the Challenge ended, encoded in YYYY-MM-DD.
     * @return completionDate
    **/
    @JsonProperty("completionDate")
    public String getCompletionDate() {
        return completionDate;
    }


    /**
     * The timestamp for when the Challenge was synced in extended ISO 8601 date/time format (yyyy-mm-ddThh:mm:ss.mmmZ).
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
        Challenge challenge = (Challenge) o;
        return Objects.equals(this.id, challenge.id) &&
            Objects.equals(this.name, challenge.name) &&
            Objects.equals(this.type, challenge.type) &&
            Objects.equals(this.startDate, challenge.startDate) &&
            Objects.equals(this.completionDate, challenge.completionDate) &&
            Objects.equals(this.timestamp, challenge.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, startDate, completionDate, timestamp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Challenge {\n");
        
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    completionDate: ").append(toIndentedString(completionDate)).append("\n");
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
        private String id;
        private String name;
        private String type;
        private String startDate;
        private String completionDate;
        private String timestamp;

        private Builder() {}

        @JsonProperty("id")

        public Builder withId(String id) {
            this.id = id;
            return this;
        }


        @JsonProperty("name")

        public Builder withName(String name) {
            this.name = name;
            return this;
        }


        @JsonProperty("type")

        public Builder withType(String type) {
            this.type = type;
            return this;
        }


        @JsonProperty("startDate")

        public Builder withStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }


        @JsonProperty("completionDate")

        public Builder withCompletionDate(String completionDate) {
            this.completionDate = completionDate;
            return this;
        }


        @JsonProperty("timestamp")

        public Builder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }


        public Challenge build() {
            return new Challenge(this);
        }
    }
}


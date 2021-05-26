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
 * Request wrapper for all events.
 */

@JsonDeserialize(builder = RequestEnvelope.Builder.class)
public final class RequestEnvelope {

    @JsonProperty("version")
    private String version = null;

    @JsonProperty("timestamp")
    private String timestamp = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("data")
    private software.amazon.halo.model.Data data = null;

    public static Builder builder() {
        return new Builder();
    }

    private RequestEnvelope(Builder builder) {
        if (builder.version != null) {
            this.version = builder.version;
        }
        if (builder.timestamp != null) {
            this.timestamp = builder.timestamp;
        }
        if (builder.type != null) {
            this.type = builder.type;
        }
        if (builder.data != null) {
            this.data = builder.data;
        }
    }

    /**
     * The version specifier for the request.
     * @return version
    **/
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }


    /**
     * The data and time the notification was sent, encoded in extended ISO 8601 date/time format (yyyy-mm-ddThh:mm:ss.mmmZ).
     * @return timestamp
    **/
    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }


    /**
     * The notification type, which can have values 'HEALTH_METRIC', 'HEALTH_METRIC_TEST', or 'DEAUTHORIZATION'.
     * @return type
    **/
    @JsonProperty("type")
    public String getType() {
        return type;
    }


    /**
     * Get data
     * @return data
    **/
    @JsonProperty("data")
    public software.amazon.halo.model.Data getData() {
        return data;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestEnvelope requestEnvelope = (RequestEnvelope) o;
        return Objects.equals(this.version, requestEnvelope.version) &&
            Objects.equals(this.timestamp, requestEnvelope.timestamp) &&
            Objects.equals(this.type, requestEnvelope.type) &&
            Objects.equals(this.data, requestEnvelope.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, timestamp, type, data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestEnvelope {\n");
        
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
        private String version;
        private String timestamp;
        private String type;
        private software.amazon.halo.model.Data data;

        private Builder() {}

        @JsonProperty("version")

        public Builder withVersion(String version) {
            this.version = version;
            return this;
        }


        @JsonProperty("timestamp")

        public Builder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }


        @JsonProperty("type")

        public Builder withType(String type) {
            this.type = type;
            return this;
        }


        @JsonProperty("data")

        public Builder withData(software.amazon.halo.model.Data data) {
            this.data = data;
            return this;
        }


        public RequestEnvelope build() {
            return new RequestEnvelope(this);
        }
    }
}


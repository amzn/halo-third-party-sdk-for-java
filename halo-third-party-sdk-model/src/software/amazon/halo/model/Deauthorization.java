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
 * Deauthorization notification event.
 */

@JsonDeserialize(builder = Deauthorization.Builder.class)
public final class Deauthorization {

    @JsonProperty("sub")
    private String sub = null;

    @JsonProperty("timestamp")
    private String timestamp = null;

    public static Builder builder() {
        return new Builder();
    }

    private Deauthorization(Builder builder) {
        if (builder.sub != null) {
            this.sub = builder.sub;
        }
        if (builder.timestamp != null) {
            this.timestamp = builder.timestamp;
        }
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
     * The data and time the notification was sent, encoded in extended ISO 8601 date/time format (yyyy-mm-ddThh:mm:ss.mmmZ).
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
        Deauthorization deauthorization = (Deauthorization) o;
        return Objects.equals(this.sub, deauthorization.sub) &&
            Objects.equals(this.timestamp, deauthorization.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sub, timestamp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Deauthorization {\n");
        
        sb.append("    sub: ").append(toIndentedString(sub)).append("\n");
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
        private String sub;
        private String timestamp;

        private Builder() {}

        @JsonProperty("sub")

        public Builder withSub(String sub) {
            this.sub = sub;
            return this;
        }


        @JsonProperty("timestamp")

        public Builder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }


        public Deauthorization build() {
            return new Deauthorization(this);
        }
    }
}


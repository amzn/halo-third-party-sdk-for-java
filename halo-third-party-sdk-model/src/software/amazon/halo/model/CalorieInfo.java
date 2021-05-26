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
 * An object including the calories burned by the user on the given day.
 */

@JsonDeserialize(builder = CalorieInfo.Builder.class)
public final class CalorieInfo {

    @JsonProperty("count")
    private software.amazon.halo.model.Count count = null;

    public static Builder builder() {
        return new Builder();
    }

    private CalorieInfo(Builder builder) {
        if (builder.count != null) {
            this.count = builder.count;
        }
    }

    /**
     * Get count
     * @return count
    **/
    @JsonProperty("count")
    public software.amazon.halo.model.Count getCount() {
        return count;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CalorieInfo calorieInfo = (CalorieInfo) o;
        return Objects.equals(this.count, calorieInfo.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CalorieInfo {\n");
        
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
        private software.amazon.halo.model.Count count;

        private Builder() {}

        @JsonProperty("count")

        public Builder withCount(software.amazon.halo.model.Count count) {
            this.count = count;
            return this;
        }


        public CalorieInfo build() {
            return new CalorieInfo(this);
        }
    }
}


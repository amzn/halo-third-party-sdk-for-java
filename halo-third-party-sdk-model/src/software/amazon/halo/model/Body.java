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
 * An object including a list of body fat percentage measurements taking on the given day.
 */

@JsonDeserialize(builder = Body.Builder.class)
public final class Body {

    @JsonProperty("fatPercentage")
    private software.amazon.halo.model.FatPercentage fatPercentage = null;

    public static Builder builder() {
        return new Builder();
    }

    private Body(Builder builder) {
        if (builder.fatPercentage != null) {
            this.fatPercentage = builder.fatPercentage;
        }
    }

    /**
     * Get fatPercentage
     * @return fatPercentage
    **/
    @JsonProperty("fatPercentage")
    public software.amazon.halo.model.FatPercentage getFatPercentage() {
        return fatPercentage;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Body body = (Body) o;
        return Objects.equals(this.fatPercentage, body.fatPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fatPercentage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Body {\n");
        
        sb.append("    fatPercentage: ").append(toIndentedString(fatPercentage)).append("\n");
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
        private software.amazon.halo.model.FatPercentage fatPercentage;

        private Builder() {}

        @JsonProperty("fatPercentage")

        public Builder withFatPercentage(software.amazon.halo.model.FatPercentage fatPercentage) {
            this.fatPercentage = fatPercentage;
            return this;
        }


        public Body build() {
            return new Body(this);
        }
    }
}


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
 * An object containing the data payload of the message.
 */

@JsonDeserialize(builder = Data.Builder.class)
public final class Data {

    @JsonProperty("records")
    private List<software.amazon.halo.model.Record> records = new ArrayList<software.amazon.halo.model.Record>();

    @JsonProperty("deauthorization")
    private software.amazon.halo.model.Deauthorization deauthorization = null;

    public static Builder builder() {
        return new Builder();
    }

    private Data(Builder builder) {
        if (builder.records != null) {
            this.records = builder.records;
        }
        if (builder.deauthorization != null) {
            this.deauthorization = builder.deauthorization;
        }
    }

    /**
     * An array of daily summaries (records).
     * @return records
    **/
    @JsonProperty("records")
    public List<software.amazon.halo.model.Record> getRecords() {
        return records;
    }


    /**
     * Get deauthorization
     * @return deauthorization
    **/
    @JsonProperty("deauthorization")
    public software.amazon.halo.model.Deauthorization getDeauthorization() {
        return deauthorization;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data data = (Data) o;
        return Objects.equals(this.records, data.records) &&
            Objects.equals(this.deauthorization, data.deauthorization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(records, deauthorization);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Data {\n");
        
        sb.append("    records: ").append(toIndentedString(records)).append("\n");
        sb.append("    deauthorization: ").append(toIndentedString(deauthorization)).append("\n");
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
        private List<software.amazon.halo.model.Record> records;
        private software.amazon.halo.model.Deauthorization deauthorization;

        private Builder() {}

        @JsonProperty("records")

        public Builder withRecords(List<software.amazon.halo.model.Record> records) {
            this.records = records;
            return this;
        }

        public Builder addRecordsItem(software.amazon.halo.model.Record recordsItem) {
            if (this.records == null) {
                this.records = new ArrayList<software.amazon.halo.model.Record>();
            }
            this.records.add(recordsItem);
            return this;
        }

        @JsonProperty("deauthorization")

        public Builder withDeauthorization(software.amazon.halo.model.Deauthorization deauthorization) {
            this.deauthorization = deauthorization;
            return this;
        }


        public Data build() {
            return new Data(this);
        }
    }
}


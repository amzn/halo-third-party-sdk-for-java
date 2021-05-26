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
 * An object including a summary and a list of activities completed by the user on the given day.
 */

@JsonDeserialize(builder = Activity.Builder.class)
public final class Activity {

    @JsonProperty("sessions")
    private List<software.amazon.halo.model.ActivitySession> sessions = new ArrayList<software.amazon.halo.model.ActivitySession>();

    public static Builder builder() {
        return new Builder();
    }

    private Activity(Builder builder) {
        if (builder.sessions != null) {
            this.sessions = builder.sessions;
        }
    }

    /**
     * An array of activity sessions completed by the user on the given day.
     * @return sessions
    **/
    @JsonProperty("sessions")
    public List<software.amazon.halo.model.ActivitySession> getSessions() {
        return sessions;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Activity activity = (Activity) o;
        return Objects.equals(this.sessions, activity.sessions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Activity {\n");
        
        sb.append("    sessions: ").append(toIndentedString(sessions)).append("\n");
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
        private List<software.amazon.halo.model.ActivitySession> sessions;

        private Builder() {}

        @JsonProperty("sessions")

        public Builder withSessions(List<software.amazon.halo.model.ActivitySession> sessions) {
            this.sessions = sessions;
            return this;
        }

        public Builder addSessionsItem(software.amazon.halo.model.ActivitySession sessionsItem) {
            if (this.sessions == null) {
                this.sessions = new ArrayList<software.amazon.halo.model.ActivitySession>();
            }
            this.sessions.add(sessionsItem);
            return this;
        }

        public Activity build() {
            return new Activity(this);
        }
    }
}


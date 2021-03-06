/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.kogito.taskassigning.index.service.client.graphql;

import java.time.ZonedDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class UserTaskInstance {

    public enum Field {
        ID("id"),
        DESCRIPTION("description"),
        NAME("name"),
        PRIORITY("priority"),
        PROCESS_INSTANCE_ID("processInstanceId"),
        PROCESS_ID("processId"),
        ROOT_PROCESS_INSTANCE_ID("rootProcessInstanceId"),
        ROOT_PROCESS_ID("rootProcessId"),
        STATE("state"),
        ACTUAL_OWNER("actualOwner"),
        ADMIN_GROUPS("adminGroups"),
        ADMIN_USERS("adminUsers"),
        COMPLETED("completed"),
        STARTED("started"),
        EXCLUDED_USERS("excludedUsers"),
        POTENTIAL_GROUPS("potentialGroups"),
        POTENTIAL_USERS("potentialUsers"),
        INPUTS("inputs"),
        REFERENCE_NAME("referenceName"),
        LAST_UPDATE("lastUpdate"),
        ENDPOINT("endpoint");

        private final String name;

        Field(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private String id;
    private String description;
    private String name;
    private String priority;
    private String processInstanceId;
    private String processId;
    private String rootProcessInstanceId;
    private String rootProcessId;
    private String state;
    private String actualOwner;
    private List<String> adminGroups;
    private List<String> adminUsers;
    private ZonedDateTime completed;
    private ZonedDateTime started;
    private List<String> excludedUsers;
    private List<String> potentialGroups;
    private List<String> potentialUsers;
    @JsonDeserialize(using = PlainJsonDeserializer.class)
    private JsonNode inputs;
    /*
    outputs: String
    */
    private String referenceName;
    private ZonedDateTime lastUpdate;
    private String endpoint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getRootProcessInstanceId() {
        return rootProcessInstanceId;
    }

    public void setRootProcessInstanceId(String rootProcessInstanceId) {
        this.rootProcessInstanceId = rootProcessInstanceId;
    }

    public String getRootProcessId() {
        return rootProcessId;
    }

    public void setRootProcessId(String rootProcessId) {
        this.rootProcessId = rootProcessId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getActualOwner() {
        return actualOwner;
    }

    public void setActualOwner(String actualOwner) {
        this.actualOwner = actualOwner;
    }

    public List<String> getAdminGroups() {
        return adminGroups;
    }

    public void setAdminGroups(List<String> adminGroups) {
        this.adminGroups = adminGroups;
    }

    public List<String> getAdminUsers() {
        return adminUsers;
    }

    public void setAdminUsers(List<String> adminUsers) {
        this.adminUsers = adminUsers;
    }

    public ZonedDateTime getCompleted() {
        return completed;
    }

    public void setCompleted(ZonedDateTime completed) {
        this.completed = completed;
    }

    public ZonedDateTime getStarted() {
        return started;
    }

    public void setStarted(ZonedDateTime started) {
        this.started = started;
    }

    public List<String> getExcludedUsers() {
        return excludedUsers;
    }

    public void setExcludedUsers(List<String> excludedUsers) {
        this.excludedUsers = excludedUsers;
    }

    public List<String> getPotentialGroups() {
        return potentialGroups;
    }

    public void setPotentialGroups(List<String> potentialGroups) {
        this.potentialGroups = potentialGroups;
    }

    public List<String> getPotentialUsers() {
        return potentialUsers;
    }

    public void setPotentialUsers(List<String> potentialUsers) {
        this.potentialUsers = potentialUsers;
    }

    public JsonNode getInputs() {
        return inputs;
    }

    public void setInputs(JsonNode inputs) {
        this.inputs = inputs;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public ZonedDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(ZonedDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return "UserTaskInstance{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", processInstanceId='" + processInstanceId + '\'' +
                ", processId='" + processId + '\'' +
                ", rootProcessInstanceId='" + rootProcessInstanceId + '\'' +
                ", rootProcessId='" + rootProcessId + '\'' +
                ", state='" + state + '\'' +
                ", actualOwner='" + actualOwner + '\'' +
                ", adminGroups=" + adminGroups +
                ", adminUsers=" + adminUsers +
                ", completed=" + completed +
                ", started=" + started +
                ", excludedUsers=" + excludedUsers +
                ", potentialGroups=" + potentialGroups +
                ", potentialUsers=" + potentialUsers +
                ", inputs=" + inputs +
                ", referenceName='" + referenceName + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", endpoint='" + endpoint + '\'' +
                '}';
    }
}

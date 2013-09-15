/*
 * Copyright 2013 Matthias Schorsch.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.joclinfo;

/**
 *
 * @author Matthias Schorsch
 */
class CapabilitiesRow {
    
    private final String group;
    private final String subGroup;
    private final String paramName;
    private final String description;
    private final Object value;

    public CapabilitiesRow(String group, String paramName, Object value) {
        this(group, paramName, "", value);
    }
    
    public CapabilitiesRow(String group, String paramName, String description, Object value) {
        this(group, "", paramName, description, value);
    }
    
    public CapabilitiesRow(String group, String subGroup, String paramName, String description, Object value) {
        this.group = group;
        this.subGroup = subGroup;
        this.paramName = paramName;
        this.description = description;
        this.value = value;
    }

    public String getGroup() {
        return group;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public String getParamName() {
        return paramName;
    }

    public String getDescription() {
        return description;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.paramName != null ? this.paramName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CapabilitiesRow other = (CapabilitiesRow) obj;
        if ((this.paramName == null) ? (other.paramName != null) : !this.paramName.equals(other.paramName)) {
            return false;
        }
        return true;
    }
}

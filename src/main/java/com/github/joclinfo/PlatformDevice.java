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

import com.github.joclinfo.util.ClDeviceInfo;
import com.github.joclinfo.util.ClPlatformInfo;

/**
 *
 * @author Matthias Schorsch
 */
public class PlatformDevice {
    
    private final ClPlatformInfo clPlatformInfo;
    private final ClDeviceInfo clDeviceInfo;
    private final String deviceName;

    public PlatformDevice(ClPlatformInfo clPlatformInfo, ClDeviceInfo clDeviceInfo) {
        this.clPlatformInfo = clPlatformInfo;
        this.clDeviceInfo = clDeviceInfo;
        this.deviceName = clDeviceInfo.getName().trim();
    }

    public ClDeviceInfo getClDeviceInfo() {
        return clDeviceInfo;
    }

    public ClPlatformInfo getClPlatformInfo() {
        return clPlatformInfo;
    }
    
    @Override
    public String toString() {
        return deviceName;
    }
}

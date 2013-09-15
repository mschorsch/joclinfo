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
package com.github.joclinfo.util;

import static org.jocl.CL.*;
import static com.github.joclinfo.util.ClConvertUtil.*;
import org.jocl.cl_platform_id;

/**
 *
 * @author Matthias Schorsch
 */
public class ClPlatformInfo {
    
    private final cl_platform_id platform;

    public ClPlatformInfo(cl_platform_id platform) {
        this.platform = platform;
    }

    public cl_platform_id getPlatform() {
        return platform;
    }
    
    public String getProfile() {
        return getString(platform, CL_PLATFORM_PROFILE);
    }

    public String getVersion() {
        return getString(platform, CL_PLATFORM_VERSION);
    }

    public String getName() {
        return getString(platform, CL_PLATFORM_NAME);
    }

    public String getVendor() {
        return getString(platform, CL_PLATFORM_VENDOR);
    }

    public String getExtensions() {
        return getString(platform, CL_PLATFORM_EXTENSIONS);
    }
    
    public String getIcdSufficKhr() {
        return getString(platform, CL_PLATFORM_ICD_SUFFIX_KHR);
    }
}

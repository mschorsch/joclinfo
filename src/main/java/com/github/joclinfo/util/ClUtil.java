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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static org.jocl.CL.*;
import org.jocl.cl_context;
import org.jocl.cl_device_id;
import org.jocl.cl_platform_id;
import org.jocl.cl_program;

/**
 *
 * @author Matthias Schorsch
 */
public class ClUtil {
    
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    
    public static cl_device_id[] getDevices(cl_platform_id platform, long device_type) {
        int numDevices = getNumDevices(platform, device_type);
        cl_device_id devices[] = new cl_device_id[numDevices];
        clGetDeviceIDs(platform, device_type, numDevices, devices, null);
        return devices;
    }

    public static int getNumDevices(cl_platform_id platform, long device_type) {
        int numDevicesArray[] = new int[1];
        clGetDeviceIDs(platform, device_type, 0, null, numDevicesArray);
        return numDevicesArray[0];
    }

    public static cl_platform_id[] getPlatforms() {
        int numPlatforms = getNumPlatforms();
        cl_platform_id[] platforms = new cl_platform_id[numPlatforms];
        clGetPlatformIDs(numPlatforms, platforms, null);
        return platforms;
    }

    public static int getNumPlatforms() {
        int numPlatformsArray[] = new int[1];
        clGetPlatformIDs(0, null, numPlatformsArray);
        return numPlatformsArray[0];
    }
    
    public static cl_program getProgramFromSource(cl_context context, InputStream inputStream) throws IOException {
        List<String> sourceList = readProgramSource(inputStream);
        
        String[] source = new String[sourceList.size()];
        long[] lengths = new long[sourceList.size()];
        
        for (int i = 0; i < sourceList.size(); i++) {
            String sourceLine = sourceList.get(i);
            source[i] = sourceLine;
            lengths[i] = sourceLine.length();
        }
        
        return getProgramFromSource(context, source, lengths);
    }
    
    private static List<String> readProgramSource(InputStream inputStream) throws IOException {
        List<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line = br.readLine()) != null) {
            list.add(line + LINE_SEPARATOR);
        }
        return list;
    }
    
    public static cl_program getProgramFromSource(cl_context context, String[] sourcecode, long[] lengths) {
        cl_program program = clCreateProgramWithSource(context, sourcecode.length, sourcecode, lengths, null);
        clBuildProgram(program, 0, null, null, null, null);
        return program;
    }
}

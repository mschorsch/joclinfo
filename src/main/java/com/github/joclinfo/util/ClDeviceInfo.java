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
import java.util.EnumSet;
import org.jocl.cl_device_id;

/**
 *
 * @author Matthias Schorsch
 */
public class ClDeviceInfo {

    public static enum DeviceTye {

        CPU, GPU, ACCELERATOR, DEFAULT;
    }
    
    public static enum DeviceProfile {

        FULL, EMBEDDED;
    }
    
    public static enum DeviceFpConfig {

        DENORM, INF_NAN, ROUND_TO_NEAREST, ROUND_TO_ZERO,
        ROUND_TO_INF, FMA, SOFT_FLOAT;
    }
    
    public static enum DeviceExecCapabilities {

        KERNEL, NATIVE_KERNEL;
    }

    public static enum DeviceQueueProperties {

        OUT_OF_ORDER_EXEC_MODE_ENABLE, PROFILING_ENABLE;
    }

    public static enum DeviceAffinityDomain {

        NUMA, L4_CACHE, L3_CACHE, L2_CACHE, L1_CACHE, NEXT_PARTITIONABLE;
    }
    
    public static enum DeviceMemType {
        GLOBAL, LOCAL, NONE;
    }        

    public static enum DeviceMemCacheType {
        NONE, READ_ONLY, READ_WRITE;
    }        
    
    private final cl_device_id device;

    public ClDeviceInfo(cl_device_id device) {
        this.device = device;
    }

    public cl_device_id getDevice() {
        return device;
    }

    public String getName() {
        return getString(device, CL_DEVICE_NAME);
    }

    public String getVendor() {
        return getString(device, CL_DEVICE_VENDOR);
    }

    public String getDriverVersion() {
        return getString(device, CL_DRIVER_VERSION);
    }
    
    public DeviceProfile getProfile() {
        final String string = getString(device, CL_DEVICE_PROFILE).trim();
        
        if("FULL_PROFILE".equals(string)) {
            return DeviceProfile.FULL;
        } else if("EMBEDDED_PROFILE".equals(string)) {
            return DeviceProfile.EMBEDDED;
        }
        return null;
    }

    public String getVersion() {
        return getString(device, CL_DEVICE_VERSION);
    }

    public String[] getExtensions() {
        final String string = getString(device, CL_DEVICE_EXTENSIONS);
        return string != null ? string.split("[ ]+") : new String[0];
    }

//    public cl_platform_id getPlatform() {
//        return getPlatform(device, CL_DEVICE_PLATFORM);
//    }
    
    public EnumSet<DeviceTye> getType() {
        EnumSet<DeviceTye> set = EnumSet.noneOf(DeviceTye.class);
        
        long deviceType = getLong(device, CL_DEVICE_TYPE);
        if ((deviceType & CL_DEVICE_TYPE_CPU) == CL_DEVICE_TYPE_CPU) {
            set.add(DeviceTye.CPU);
        }
        if ((deviceType & CL_DEVICE_TYPE_GPU) == CL_DEVICE_TYPE_GPU) {
            set.add(DeviceTye.GPU);
        }
        if ((deviceType & CL_DEVICE_TYPE_ACCELERATOR) == CL_DEVICE_TYPE_ACCELERATOR) {
            set.add(DeviceTye.ACCELERATOR);
        }
        if ((deviceType & CL_DEVICE_TYPE_DEFAULT) == CL_DEVICE_TYPE_DEFAULT) {
            set.add(DeviceTye.DEFAULT);
        }
        return set;
    }
    
    public long getVendorID() {
        return getLong(device, CL_DEVICE_VENDOR_ID);
    }
    
    public int getMaxComputeUnits() {
        return getInt(device, CL_DEVICE_MAX_COMPUTE_UNITS);
    }

    public long getMaxWorkItemDimensions() {
        return getLong(device, CL_DEVICE_MAX_WORK_ITEM_DIMENSIONS);
    }

    public long getMaxWorkGroupSize() {
        return getLong(device, CL_DEVICE_MAX_WORK_GROUP_SIZE);
    }

    public long[] getMaxWorkItemSizes() {
        long dimensions = getMaxWorkItemDimensions();
        return getSizes(device, CL_DEVICE_MAX_WORK_ITEM_SIZES, (int) dimensions);
    }
    
    public long getPreferredVectorWidthChar() {
        return getLong(device, CL_DEVICE_PREFERRED_VECTOR_WIDTH_CHAR);
    }

    public long getPreferredVectorWidthShort() {
        return getLong(device, CL_DEVICE_PREFERRED_VECTOR_WIDTH_SHORT);
    }

    public long getPreferredVectorWidthInt() {
        return getLong(device, CL_DEVICE_PREFERRED_VECTOR_WIDTH_INT);
    }

    public long getPreferredVectorWidthLong() {
        return getLong(device, CL_DEVICE_PREFERRED_VECTOR_WIDTH_LONG);
    }

    public long getPreferredVectorWidthFloat() {
        return getLong(device, CL_DEVICE_PREFERRED_VECTOR_WIDTH_FLOAT);
    }

    public long getPreferredVectorWidthDouble() {
        return getLong(device, CL_DEVICE_PREFERRED_VECTOR_WIDTH_DOUBLE);
    }
    
    public long getMaxClockFrequency() {
        return getLong(device, CL_DEVICE_MAX_CLOCK_FREQUENCY);
    }

    public int getAddressBits() {
        return getInt(device, CL_DEVICE_ADDRESS_BITS);
    }
    
    public int getMaxReadImageArgs() {
        return getInt(device, CL_DEVICE_MAX_READ_IMAGE_ARGS);
    }

    public int getMaxWriteImageArgs() {
        return getInt(device, CL_DEVICE_MAX_WRITE_IMAGE_ARGS);
    }
    
    public long getMaxMemAllocSize() {
        return getLong(device, CL_DEVICE_MAX_MEM_ALLOC_SIZE);
    }    

    public long getImage2DMaxWidth() {
        return getLong(device, CL_DEVICE_IMAGE2D_MAX_WIDTH);
    }    

    public long getImage2DMaxHeight() {
        return getLong(device, CL_DEVICE_IMAGE2D_MAX_HEIGHT);
    }    

    public long getImage3DMaxWidth() {
        return getLong(device, CL_DEVICE_IMAGE3D_MAX_WIDTH);
    }    

    public long getImage3DMaxHeight() {
        return getLong(device, CL_DEVICE_IMAGE3D_MAX_HEIGHT);
    }    

    public long getImage3DMaxDepth() {
        return getLong(device, CL_DEVICE_IMAGE3D_MAX_DEPTH);
    }    
    
    public boolean hasImagesSupport() {
        return getBool(device, CL_DEVICE_IMAGE_SUPPORT);
    }

    public long getMaxParamterSize() {
        return getSize(device, CL_DEVICE_MAX_PARAMETER_SIZE);
    }

    public long getMaxSamplers() {
        return getLong(device, CL_DEVICE_MAX_SAMPLERS);
    }        

    public long getMemBaseAddrAlign() {
        return getLong(device, CL_DEVICE_MEM_BASE_ADDR_ALIGN);
    }        

    public long getMinDataTypeAlignSize() {
        return getLong(device, CL_DEVICE_MIN_DATA_TYPE_ALIGN_SIZE);
    }        
    
    public EnumSet<DeviceFpConfig> getSingleFpConfig() {
        long singleFpConfig = getLong(device, CL_DEVICE_SINGLE_FP_CONFIG);
        return getFpConfig(singleFpConfig);
    }
    
    private EnumSet<DeviceFpConfig> getFpConfig(long fpConfig) {
        EnumSet<DeviceFpConfig> set = EnumSet.noneOf(DeviceFpConfig.class);
        
        if ((fpConfig & CL_FP_DENORM) == CL_FP_DENORM) {
            set.add(DeviceFpConfig.DENORM);
        } 
        
        if((fpConfig & CL_FP_INF_NAN) == CL_FP_INF_NAN) {
            set.add(DeviceFpConfig.INF_NAN);
        } 
        
        if((fpConfig & CL_FP_ROUND_TO_NEAREST) == CL_FP_ROUND_TO_NEAREST) {
            set.add(DeviceFpConfig.ROUND_TO_NEAREST);
        }
        
        if((fpConfig & CL_FP_ROUND_TO_ZERO) == CL_FP_ROUND_TO_ZERO) {
            set.add(DeviceFpConfig.ROUND_TO_ZERO);
        }
        
        if((fpConfig & CL_FP_ROUND_TO_INF) == CL_FP_ROUND_TO_INF) {
            set.add(DeviceFpConfig.ROUND_TO_INF);
        }
        
        if((fpConfig & CL_FP_FMA) == CL_FP_FMA) {
            set.add(DeviceFpConfig.FMA);
        }
        
        if((fpConfig & CL_FP_SOFT_FLOAT) == CL_FP_SOFT_FLOAT) {
            set.add(DeviceFpConfig.SOFT_FLOAT);
        }

        return set;        
    }
    
    public DeviceMemCacheType getGlobalMemCacheType() {
        final int cacheType = getInt(device, CL_DEVICE_GLOBAL_MEM_CACHE_TYPE);
        if(cacheType == 0) {
            return DeviceMemCacheType.NONE;
        } else if(cacheType == 1) {
            return DeviceMemCacheType.READ_ONLY;
        } else if(cacheType == 2) {
            return DeviceMemCacheType.READ_WRITE;
        }
        return DeviceMemCacheType.NONE;
    }

    public long getGlobalMemCachelineSize() {
        return getLong(device, CL_DEVICE_GLOBAL_MEM_CACHELINE_SIZE);
    }    

    public long getGlobalMemCacheSize() {
        return getLong(device, CL_DEVICE_GLOBAL_MEM_CACHE_SIZE);
    }    

    public long getGlobalMemSize() {
        return getLong(device, CL_DEVICE_GLOBAL_MEM_SIZE);
    }    

    public long getMaxConstantBufferSize() {
        return getLong(device, CL_DEVICE_MAX_CONSTANT_BUFFER_SIZE);
    }    

    public long getMaxConstantArgs() {
        return getLong(device, CL_DEVICE_MAX_CONSTANT_ARGS);
    }    

    public DeviceMemType getLocalMemType() {
        final int memType = getInt(device, CL_DEVICE_LOCAL_MEM_TYPE);
        if(memType == 2) {
            return DeviceMemType.GLOBAL;
        } else if(memType == 1) {
            return DeviceMemType.LOCAL;
        } else {
            return DeviceMemType.NONE;
        }
    }

    public long getLocalMemSize() {
        return getLong(device, CL_DEVICE_LOCAL_MEM_SIZE);
    }        

    public boolean hasErrorCorrectionSupport() {
        return getBool(device, CL_DEVICE_ERROR_CORRECTION_SUPPORT);
    }
    
    public long getProfilingTimerResolution() {
        return getSize(device, CL_DEVICE_PROFILING_TIMER_RESOLUTION);
    }        
    
    public boolean isEndianLittle() {
        return getBool(device, CL_DEVICE_ENDIAN_LITTLE);
    }

    public boolean isAvailable() {
        return getBool(device, CL_DEVICE_AVAILABLE);
    }

    public boolean isCompilerAvailable() {
        return getBool(device, CL_DEVICE_COMPILER_AVAILABLE);
    }    

    public EnumSet<DeviceExecCapabilities> getExecutionCapabilities() {
        EnumSet<DeviceExecCapabilities> set = EnumSet.noneOf(DeviceExecCapabilities.class);
        
        long capas = getLong(device, CL_DEVICE_EXECUTION_CAPABILITIES);
        if((capas & CL_EXEC_KERNEL) == CL_EXEC_KERNEL) {
            set.add(DeviceExecCapabilities.KERNEL);
        }
        if((capas & CL_EXEC_NATIVE_KERNEL) == CL_EXEC_NATIVE_KERNEL) {
            set.add(DeviceExecCapabilities.NATIVE_KERNEL);
        }
        
        return set;
    }

    public EnumSet<DeviceQueueProperties> getQueueProperties() {
        EnumSet<DeviceQueueProperties> set = EnumSet.noneOf(DeviceQueueProperties.class);
        
        long properties = getLong(device, CL_DEVICE_QUEUE_PROPERTIES);
        if((properties & CL_QUEUE_OUT_OF_ORDER_EXEC_MODE_ENABLE) == CL_QUEUE_OUT_OF_ORDER_EXEC_MODE_ENABLE) {
            set.add(DeviceQueueProperties.OUT_OF_ORDER_EXEC_MODE_ENABLE);
        }
        if((properties & CL_QUEUE_PROFILING_ENABLE) == CL_QUEUE_PROFILING_ENABLE) {
            set.add(DeviceQueueProperties.PROFILING_ENABLE);
        }
        
        return set;
    }
    
    // OPENCL_1_1
    public long getPreferredVectorWidthHalf() {
        return getLong(device, CL_DEVICE_PREFERRED_VECTOR_WIDTH_HALF);
    }
    
    public boolean isHostUnifiedMemory() {
        return getBool(device, CL_DEVICE_HOST_UNIFIED_MEMORY);
    }
    
    public long getNativeVectorWidthChar() {
        return getLong(device, CL_DEVICE_NATIVE_VECTOR_WIDTH_CHAR);
    }

    public long getNativeVectorWidthShort() {
        return getLong(device, CL_DEVICE_NATIVE_VECTOR_WIDTH_SHORT);
    }

    public long getNativeVectorWidthInt() {
        return getLong(device, CL_DEVICE_NATIVE_VECTOR_WIDTH_INT);
    }

    public long getNativeVectorWidthLong() {
        return getLong(device, CL_DEVICE_NATIVE_VECTOR_WIDTH_LONG);
    }

    public long getNativeVectorWidthFloat() {
        return getLong(device, CL_DEVICE_NATIVE_VECTOR_WIDTH_FLOAT);
    }

    public long getNativeVectorWidthDouble() {
        return getLong(device, CL_DEVICE_NATIVE_VECTOR_WIDTH_DOUBLE);
    }
    
    public long getNativeVectorWidthHalf() {
        return getLong(device, CL_DEVICE_NATIVE_VECTOR_WIDTH_HALF);
    }    
    
    public String getOpenCLCVersion() {
        return getString(device, CL_DEVICE_OPENCL_C_VERSION);
    }
    
    // OPENCL_1_2
    public boolean isLinkerAvailable() {
        return getBool(device, CL_DEVICE_LINKER_AVAILABLE);
    }

//    public String[] getBuiltInKernels() {
//        final String string = getString(device, CL_DEVICE_BUILT_IN_KERNELS);
//        return string != null ? string.split(";") : new String[0];
//    }

    public long getImageMaxBufferSize() {
        return getLong(device, CL_DEVICE_IMAGE_MAX_BUFFER_SIZE);
    }    

    public long getImageMaxArraySize() {
        return getLong(device, CL_DEVICE_IMAGE_MAX_ARRAY_SIZE);
    }    

//    public long getParentDevice() {
//        return getLong(device, CL_DEVICE_PARENT_DEVICE);
//    }    

    public long getPartitionMaxSubDevices() {
        return getLong(device, CL_DEVICE_PARTITION_MAX_SUB_DEVICES);
    }    

//    public static final int CL_DEVICE_PARTITION_PROPERTIES              = 0x1044;

    public EnumSet<DeviceAffinityDomain> getPartitionAffinityDomain() {
        EnumSet<DeviceAffinityDomain> set = EnumSet.noneOf(DeviceAffinityDomain.class);
        
        long affinityDomain = getLong(device, CL_DEVICE_PARTITION_AFFINITY_DOMAIN);
        if((affinityDomain & CL_DEVICE_AFFINITY_DOMAIN_NUMA) == CL_DEVICE_AFFINITY_DOMAIN_NUMA) {
            set.add(DeviceAffinityDomain.NUMA);
        }
        if((affinityDomain & CL_DEVICE_AFFINITY_DOMAIN_L4_CACHE) == CL_DEVICE_AFFINITY_DOMAIN_L4_CACHE) {
            set.add(DeviceAffinityDomain.L4_CACHE);
        }
        if((affinityDomain & CL_DEVICE_AFFINITY_DOMAIN_L3_CACHE) == CL_DEVICE_AFFINITY_DOMAIN_L3_CACHE) {
            set.add(DeviceAffinityDomain.L3_CACHE);
        }
        if((affinityDomain & CL_DEVICE_AFFINITY_DOMAIN_L2_CACHE) == CL_DEVICE_AFFINITY_DOMAIN_L2_CACHE) {
            set.add(DeviceAffinityDomain.L2_CACHE);
        }
        if((affinityDomain & CL_DEVICE_AFFINITY_DOMAIN_L1_CACHE) == CL_DEVICE_AFFINITY_DOMAIN_L1_CACHE) {
            set.add(DeviceAffinityDomain.L1_CACHE);
        }
        if((affinityDomain & CL_DEVICE_AFFINITY_DOMAIN_NEXT_PARTITIONABLE) == CL_DEVICE_AFFINITY_DOMAIN_NEXT_PARTITIONABLE) {
            set.add(DeviceAffinityDomain.NEXT_PARTITIONABLE);
        }

        return set;
    }    
    
//    public static final int CL_DEVICE_PARTITION_TYPE                    = 0x1046;
    
    public long getReferenceCount() {
        return getLong(device, CL_DEVICE_REFERENCE_COUNT);
    }    
    
    public boolean isPrederredInteropUserSync() {
        return getBool(device, CL_DEVICE_PREFERRED_INTEROP_USER_SYNC);
    }
    
    public long getPrintfBufferSize() {
        return getSize(device, CL_DEVICE_PRINTF_BUFFER_SIZE);
    }

    // CL_EXT
    public EnumSet<DeviceFpConfig> getDoubleFpConfig() {
        long doubleFpConfig = getLong(device, CL_DEVICE_DOUBLE_FP_CONFIG);
        return getFpConfig(doubleFpConfig);
    }

    public EnumSet<DeviceFpConfig> getHalfFpConfig() {
        long halfFpConfig = getLong(device, CL_DEVICE_HALF_FP_CONFIG);
        return getFpConfig(halfFpConfig);
    }
}

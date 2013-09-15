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
import com.github.joclinfo.util.ClDeviceInfo.DeviceExecCapabilities;
import com.github.joclinfo.util.ClDeviceInfo.DeviceFpConfig;
import com.github.joclinfo.util.ClDeviceInfo.DeviceQueueProperties;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Matthias Schorsch
 */
public class CapabilitiesPanel extends JPanel implements PanelUpdater {

    private static final String GENERAL_GROUP = "General";
    private static final String MEMORY_GROUP = "Memory";
    private static final String KERNEL_GROUP = "Kernel";
    private static final String FLOATING_POINT_GROUP = "Floating-Point Support";
    private static final String VECTOR_SIZE_GROUP = "Vector Size";
    private static final String IMAGES_GROUP = "Images";
    private static final String OPENCL12_GROUP = "OpenCL 1.2";

    public CapabilitiesPanel() {
        initComponents();
    }

    public CapabilitiesPanel(LayoutManager layout) {
        super(layout);
    }

    public CapabilitiesPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public CapabilitiesPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    @Override
    public void update(PlatformDevice platformDevice) {
        final ClDeviceInfo clDeviceInfo = platformDevice.getClDeviceInfo();

        final List<CapabilitiesRow> rows = new ArrayList<CapabilitiesRow>();
        rows.addAll(createGeneralGroup(clDeviceInfo));
        rows.addAll(createMemoryGroup(clDeviceInfo));
        rows.addAll(createKernelGroup(clDeviceInfo));
        rows.addAll(createFloatingPointSupportGroup(clDeviceInfo));
        rows.addAll(createVectorSizeGroup(clDeviceInfo));
        rows.addAll(createImagesGroup(clDeviceInfo));
        rows.addAll(createOpenCl12Group(clDeviceInfo));

        getTableModel().updateModel(rows);
        tableCapabilities.packAll();
    }
    
    private List<CapabilitiesRow> createGeneralGroup(ClDeviceInfo clDeviceInfo) {
        List<CapabilitiesRow> rows = new ArrayList<CapabilitiesRow>();
        rows.add(row(GENERAL_GROUP, "CL_DEVICE_NAME", "Name", clDeviceInfo.getName()));
        rows.add(row(GENERAL_GROUP, "CL_DEVICE_VENDOR", "Vendor", clDeviceInfo.getVendor()));
        rows.add(row(GENERAL_GROUP, "CL_DEVICE_VENDOR_ID", "Vendor ID", clDeviceInfo.getVendorID()));
        rows.add(row(GENERAL_GROUP, "CL_DRIVER_VERSION", "Driver Version", clDeviceInfo.getDriverVersion()));
        rows.add(row(GENERAL_GROUP, "CL_DEVICE_VERSION", "Version", clDeviceInfo.getVersion()));
        rows.add(row(GENERAL_GROUP, "CL_DEVICE_PROFILE", "Profile", clDeviceInfo.getProfile()));
        
        final EnumSet<DeviceQueueProperties> queueProperties = clDeviceInfo.getQueueProperties();
        final boolean outOfOrder = queueProperties.contains(DeviceQueueProperties.OUT_OF_ORDER_EXEC_MODE_ENABLE);
        rows.add(row(GENERAL_GROUP, "CL_QUEUE_OUT_OF_ORDER_EXEC_MODE_ENABLE", "Out of Order Execution", outOfOrder));
        
        final boolean profiling = queueProperties.contains(DeviceQueueProperties.PROFILING_ENABLE);
        rows.add(row(GENERAL_GROUP, "CL_QUEUE_PROFILING_ENABLE", "Code Profiling", profiling));
        
        final long profilingTimerResolution = clDeviceInfo.getProfilingTimerResolution();
        rows.add(row(GENERAL_GROUP, "CL_DEVICE_PROFILING_TIMER_RESOLUTION", "Timer Resolution", profilingTimerResolution + " nsec"));
        
        rows.add(row(GENERAL_GROUP, "CL_DEVICE_AVAILABLE", "Available", clDeviceInfo.isAvailable()));
        rows.add(row(GENERAL_GROUP, "CL_DEVICE_COMPILER_AVAILABLE", "Compiler Available", clDeviceInfo.isCompilerAvailable()));
        rows.add(row(GENERAL_GROUP, "CL_DEVICE_MAX_COMPUTE_UNITS", "Max. Compute Units", clDeviceInfo.getMaxComputeUnits()));
        
        return rows;
    }

    private List<CapabilitiesRow> createMemoryGroup(ClDeviceInfo clDeviceInfo) {
        List<CapabilitiesRow> rows = new ArrayList<CapabilitiesRow>();
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_ADDRESS_BITS", "Adress Space", clDeviceInfo.getAddressBits() + " Bits"));
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_ENDIAN_LITTLE", "Byte Order", clDeviceInfo.isEndianLittle() ? "Little Endian" : "Big Endian"));
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_ERROR_CORRECTION_SUPPORT", "Error Correction", clDeviceInfo.hasErrorCorrectionSupport()));
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_HOST_UNIFIED_MEMORY", "Unified Memory", clDeviceInfo.isHostUnifiedMemory()));
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_GLOBAL_MEM_CACHELINE_SIZE", "Global Memory Cacheline Size", clDeviceInfo.getGlobalMemCachelineSize()));
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_GLOBAL_MEM_CACHE_SIZE", "Global Memory Cache Size", Units.byteToRString(clDeviceInfo.getGlobalMemCacheSize())));        
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_GLOBAL_MEM_SIZE", "Global Memory", Units.byteToRString(clDeviceInfo.getGlobalMemSize())));
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_MAX_MEM_ALLOC_SIZE", "Max. Allocation", Units.byteToRString(clDeviceInfo.getMaxMemAllocSize())));
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_LOCAL_MEM_SIZE", "Local Memory", Units.byteToRString(clDeviceInfo.getLocalMemSize())));
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_GLOBAL_MEM_CACHE_TYPE", "Global Memory Cache Type", clDeviceInfo.getGlobalMemCacheType()));
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_LOCAL_MEM_TYPE", "Local Memory Type", clDeviceInfo.getLocalMemType()));
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_MEM_BASE_ADDR_ALIGN", "Block Alignment", clDeviceInfo.getMemBaseAddrAlign()));
        rows.add(row(MEMORY_GROUP, "CL_DEVICE_MIN_DATA_TYPE_ALIGN_SIZE", "Data Alignment", clDeviceInfo.getMinDataTypeAlignSize()));        
        return rows;
    }
    
    private List<CapabilitiesRow> createKernelGroup(ClDeviceInfo clDeviceInfo) {
        List<CapabilitiesRow> rows = new ArrayList<CapabilitiesRow>();
        EnumSet<DeviceExecCapabilities> execCapas = clDeviceInfo.getExecutionCapabilities();
        rows.add(row(KERNEL_GROUP, "CL_DEVICE_EXECUTION_CAPABILITIES", "OpenCL Kernels", execCapas.contains(DeviceExecCapabilities.KERNEL)));
        rows.add(row(KERNEL_GROUP, "CL_DEVICE_EXECUTION_CAPABILITIES", "Native Kernels", execCapas.contains(DeviceExecCapabilities.NATIVE_KERNEL)));
        rows.add(row(KERNEL_GROUP, "CL_DEVICE_MAX_WORK_GROUP_SIZE", "Max. Work Group Size", clDeviceInfo.getMaxWorkGroupSize()));
        rows.add(row(KERNEL_GROUP, "CL_DEVICE_MAX_WORK_ITEM_DIMENSIONS", "Work Group Item Dimensions", clDeviceInfo.getMaxWorkItemDimensions()));
        rows.add(row(KERNEL_GROUP, "CL_DEVICE_MAX_WORK_ITEM_SIZES", "Max. Work Group Items", Arrays.toString(clDeviceInfo.getMaxWorkItemSizes())));
        rows.add(row(KERNEL_GROUP, "CL_DEVICE_MAX_SAMPLERS", "Max. Samplers", clDeviceInfo.getMaxSamplers()));
        rows.add(row(KERNEL_GROUP, "CL_DEVICE_MAX_CONSTANT_ARGS", "Max. Constant Arguments", clDeviceInfo.getMaxConstantArgs()));
        rows.add(row(KERNEL_GROUP, "CL_DEVICE_MAX_CONSTANT_BUFFER_SIZE", "Max. Constant Buffer", Units.byteToRString(clDeviceInfo.getMaxConstantBufferSize())));
        rows.add(row(KERNEL_GROUP, "CL_DEVICE_MAX_PARAMETER_SIZE", "Max. Parameter Size", clDeviceInfo.getMaxParamterSize()));
        return rows;
    }
    
    private List<CapabilitiesRow> createFloatingPointSupportGroup(ClDeviceInfo clDeviceInfo) {
        List<CapabilitiesRow> rows = new ArrayList<CapabilitiesRow>();
        
        final String half_subgroup = "Half (16 Bit)";
        EnumSet<DeviceFpConfig> halfFpConfig = clDeviceInfo.getHalfFpConfig();
        rows.addAll(createFloatingPointSupportSubGroup(half_subgroup, "CL_DEVICE_HALF_FP_CONFIG", halfFpConfig));
        
        final String float_subgroup = "Float (32 Bit)";
        EnumSet<DeviceFpConfig> singleFpConfig = clDeviceInfo.getSingleFpConfig();
        rows.addAll(createFloatingPointSupportSubGroup(float_subgroup, "CL_DEVICE_SINGLE_FP_CONFIG", singleFpConfig));

        final String double_subgroup = "Double (64 Bit)";
        EnumSet<DeviceFpConfig> doubleFpConfig = clDeviceInfo.getDoubleFpConfig();
        rows.addAll(createFloatingPointSupportSubGroup(double_subgroup, "CL_DEVICE_DOUBLE_FP_CONFIG", doubleFpConfig));
        
        return rows;
    }
    
    private List<CapabilitiesRow> createFloatingPointSupportSubGroup(String subGroup, String paramName, EnumSet<DeviceFpConfig> fpConfig) {
        List<CapabilitiesRow> rows = new ArrayList<CapabilitiesRow>();
        rows.add(row(FLOATING_POINT_GROUP, subGroup, paramName, "Denormalized Numbers", fpConfig.contains(DeviceFpConfig.DENORM)));
        rows.add(row(FLOATING_POINT_GROUP, subGroup, paramName, "NaN", fpConfig.contains(DeviceFpConfig.INF_NAN)));
        rows.add(row(FLOATING_POINT_GROUP, subGroup, paramName, "Infinity", fpConfig.contains(DeviceFpConfig.INF_NAN)));
        rows.add(row(FLOATING_POINT_GROUP, subGroup, paramName, "Round to Nearest", fpConfig.contains(DeviceFpConfig.ROUND_TO_NEAREST)));
        rows.add(row(FLOATING_POINT_GROUP, subGroup, paramName, "Round to Zero", fpConfig.contains(DeviceFpConfig.ROUND_TO_ZERO)));
        rows.add(row(FLOATING_POINT_GROUP, subGroup, paramName, "Round to Infinity", fpConfig.contains(DeviceFpConfig.ROUND_TO_INF)));
        rows.add(row(FLOATING_POINT_GROUP, subGroup, paramName, "Fused Multiply-Add", fpConfig.contains(DeviceFpConfig.FMA)));
        return rows;
    }    
    
    private List<CapabilitiesRow> createVectorSizeGroup(ClDeviceInfo clDeviceInfo) {
        List<CapabilitiesRow> rows = new ArrayList<CapabilitiesRow>();

        final String preferredSubGroup = "Preferred";
        rows.add(row(VECTOR_SIZE_GROUP, preferredSubGroup, "CL_DEVICE_PREFERRED_VECTOR_WIDTH_CHAR", "Char", clDeviceInfo.getPreferredVectorWidthChar()));
        rows.add(row(VECTOR_SIZE_GROUP, preferredSubGroup, "CL_DEVICE_PREFERRED_VECTOR_WIDTH_SHORT", "Short", clDeviceInfo.getPreferredVectorWidthShort()));
        rows.add(row(VECTOR_SIZE_GROUP, preferredSubGroup, "CL_DEVICE_PREFERRED_VECTOR_WIDTH_INT", "Int", clDeviceInfo.getPreferredVectorWidthInt()));
        rows.add(row(VECTOR_SIZE_GROUP, preferredSubGroup, "CL_DEVICE_PREFERRED_VECTOR_WIDTH_LONG", "Long", clDeviceInfo.getPreferredVectorWidthLong()));
        rows.add(row(VECTOR_SIZE_GROUP, preferredSubGroup, "CL_DEVICE_PREFERRED_VECTOR_WIDTH_HALF", "Half", clDeviceInfo.getPreferredVectorWidthHalf()));
        rows.add(row(VECTOR_SIZE_GROUP, preferredSubGroup, "CL_DEVICE_PREFERRED_VECTOR_WIDTH_FLOAT", "Float", clDeviceInfo.getPreferredVectorWidthFloat()));
        rows.add(row(VECTOR_SIZE_GROUP, preferredSubGroup, "CL_DEVICE_PREFERRED_VECTOR_WIDTH_DOUBLE", "Double", clDeviceInfo.getPreferredVectorWidthDouble()));

        final String nativeSubGroup = "Native";
        rows.add(row(VECTOR_SIZE_GROUP, nativeSubGroup, "CL_DEVICE_NATIVE_VECTOR_WIDTH_CHAR", "Char", clDeviceInfo.getNativeVectorWidthChar()));
        rows.add(row(VECTOR_SIZE_GROUP, nativeSubGroup, "CL_DEVICE_NATIVE_VECTOR_WIDTH_SHORT", "Short", clDeviceInfo.getNativeVectorWidthShort()));
        rows.add(row(VECTOR_SIZE_GROUP, nativeSubGroup, "CL_DEVICE_NATIVE_VECTOR_WIDTH_INT", "Int", clDeviceInfo.getNativeVectorWidthInt()));
        rows.add(row(VECTOR_SIZE_GROUP, nativeSubGroup, "CL_DEVICE_NATIVE_VECTOR_WIDTH_LONG", "Long", clDeviceInfo.getNativeVectorWidthLong()));
        rows.add(row(VECTOR_SIZE_GROUP, nativeSubGroup, "CL_DEVICE_NATIVE_VECTOR_WIDTH_HALF", "Half", clDeviceInfo.getNativeVectorWidthHalf()));
        rows.add(row(VECTOR_SIZE_GROUP, nativeSubGroup, "CL_DEVICE_NATIVE_VECTOR_WIDTH_FLOAT", "Float", clDeviceInfo.getNativeVectorWidthFloat()));
        rows.add(row(VECTOR_SIZE_GROUP, nativeSubGroup, "CL_DEVICE_NATIVE_VECTOR_WIDTH_DOUBLE", "Double", clDeviceInfo.getNativeVectorWidthDouble()));
        return rows;
    }    
    
    private List<CapabilitiesRow> createImagesGroup(ClDeviceInfo clDeviceInfo) {
        List<CapabilitiesRow> rows = new ArrayList<CapabilitiesRow>();
        rows.add(row(IMAGES_GROUP, "CL_DEVICE_IMAGE_SUPPORT", "Images Supported", clDeviceInfo.hasImagesSupport()));
        rows.add(row(IMAGES_GROUP, "2D", "CL_DEVICE_IMAGE2D_MAX_WIDTH", "Max. Width", clDeviceInfo.getImage2DMaxWidth() + " Pixels"));
        rows.add(row(IMAGES_GROUP, "2D", "CL_DEVICE_IMAGE2D_MAX_HEIGHT", "Max. Height", clDeviceInfo.getImage2DMaxHeight() + " Pixels"));
        rows.add(row(IMAGES_GROUP, "3D", "CL_DEVICE_IMAGE3D_MAX_WIDTH", "Max. Width", clDeviceInfo.getImage3DMaxWidth() + " Pixels"));
        rows.add(row(IMAGES_GROUP, "3D", "CL_DEVICE_IMAGE3D_MAX_HEIGHT", "Max. Height", clDeviceInfo.getImage3DMaxHeight() + " Pixels"));
        rows.add(row(IMAGES_GROUP, "3D", "CL_DEVICE_IMAGE3D_MAX_DEPTH", "Max. Depth", clDeviceInfo.getImage3DMaxDepth() + " Pixels"));
        rows.add(row(IMAGES_GROUP, "Max. Images per Kernel", "CL_DEVICE_MAX_READ_IMAGE_ARGS", "Read", clDeviceInfo.getMaxReadImageArgs()));
        rows.add(row(IMAGES_GROUP, "Max. Images per Kernel", "CL_DEVICE_MAX_WRITE_IMAGE_ARGS", "Write", clDeviceInfo.getMaxWriteImageArgs()));
        return rows;
    }        
    
    private List<CapabilitiesRow> createOpenCl12Group(ClDeviceInfo clDeviceInfo) {
        List<CapabilitiesRow> rows = new ArrayList<CapabilitiesRow>();
        rows.add(row(OPENCL12_GROUP, "CL_DEVICE_LINKER_AVAILABLE", "Linker Available", clDeviceInfo.isLinkerAvailable()));
        rows.add(row(OPENCL12_GROUP, "CL_DEVICE_IMAGE_MAX_BUFFER_SIZE", "Image Max Buffer Size", Units.byteToRString(clDeviceInfo.getImageMaxBufferSize())));
        rows.add(row(OPENCL12_GROUP, "CL_DEVICE_IMAGE_MAX_ARRAY_SIZE", "Image Max Array Size", clDeviceInfo.getImageMaxArraySize()));
        rows.add(row(OPENCL12_GROUP, "CL_DEVICE_PARTITION_MAX_SUB_DEVICES", "Partition Max Sub Devices", clDeviceInfo.getPartitionMaxSubDevices()));
        rows.add(row(OPENCL12_GROUP, "CL_DEVICE_PARTITION_AFFINITY_DOMAIN", "Partition Affinity Domain", clDeviceInfo.getPartitionAffinityDomain()));
        rows.add(row(OPENCL12_GROUP, "CL_DEVICE_REFERENCE_COUNT", "Reference Count", clDeviceInfo.getReferenceCount()));
        rows.add(row(OPENCL12_GROUP, "CL_DEVICE_PREFERRED_INTEROP_USER_SYNC", "Preferred Interop User Sync", clDeviceInfo.isPrederredInteropUserSync()));
        rows.add(row(OPENCL12_GROUP, "CL_DEVICE_PRINTF_BUFFER_SIZE", "Printf Buffer Size", Units.byteToRString(clDeviceInfo.getPrintfBufferSize())));
        return rows;
    }    
    
    private CapabilitiesRow row(String group, String paramName, String description, Object value) {
        return new CapabilitiesRow(group, paramName, description, value);
    }

    private CapabilitiesRow row(String group, String subGroup, String paramName, String description, Object value) {
        return new CapabilitiesRow(group, subGroup, paramName, description, value);
    }
    
    private CapabilitiesTableModel getTableModel() {
        return (CapabilitiesTableModel) tableCapabilities.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        scpCapabilities = new javax.swing.JScrollPane();
        tableCapabilities = new org.jdesktop.swingx.JXTable();

        setPreferredSize(new java.awt.Dimension(600, 500));
        setLayout(new java.awt.GridBagLayout());

        tableCapabilities.setModel(new CapabilitiesTableModel());
        tableCapabilities.setColumnControlVisible(true);
        tableCapabilities.setHighlighters(TableUtil.TABLE_HIGLIGHTER);
        scpCapabilities.setViewportView(tableCapabilities);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(scpCapabilities, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scpCapabilities;
    private org.jdesktop.swingx.JXTable tableCapabilities;
    // End of variables declaration//GEN-END:variables
}

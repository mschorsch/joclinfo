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
import com.github.joclinfo.util.ClDeviceInfo.DeviceProfile;
import com.github.joclinfo.util.ClDeviceInfo.DeviceTye;
import java.awt.LayoutManager;
import java.util.Arrays;
import java.util.EnumSet;
import javax.swing.JPanel;

/**
 *
 * @author Matthias Schorsch
 */
public class DevicePanel extends JPanel implements PanelUpdater {

    public DevicePanel() {
        initComponents();
    }

    public DevicePanel(LayoutManager layout) {
        super(layout);
    }

    public DevicePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public DevicePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    @Override
    public void update(PlatformDevice platformDevice) {
        ClDeviceInfo clDeviceInfo = platformDevice.getClDeviceInfo();
        fillDescription(clDeviceInfo);
        fillComputing(clDeviceInfo);
        fillAdditional(clDeviceInfo);
    }
    
    private void fillDescription(ClDeviceInfo clDeviceInfo) {
        labDeviceName.setText(clDeviceInfo.getName());
        labVendor.setText(clDeviceInfo.getVendor());
        labDriver.setText(clDeviceInfo.getDriverVersion());
        labOpenCL.setText(clDeviceInfo.getVersion());        
    }
    
    private void fillComputing(ClDeviceInfo clDeviceInfo) {
        fillHardware(clDeviceInfo);
        fillMemory(clDeviceInfo);
    }
    
    private void fillHardware(ClDeviceInfo clDeviceInfo) {
        labMaxFrequency.setText(clDeviceInfo.getMaxClockFrequency() + " MHz");
        labComputeUnits.setText(String.valueOf(clDeviceInfo.getMaxComputeUnits()));
        labWorkItemDimensions.setText(String.valueOf(clDeviceInfo.getMaxWorkItemDimensions()));
        labWorkGroupSize.setText(String.valueOf(clDeviceInfo.getMaxWorkGroupSize()));
        labWorkItemSizesPerDim.setText(Arrays.toString(clDeviceInfo.getMaxWorkItemSizes()));
    }
    
    private void fillMemory(ClDeviceInfo clDeviceInfo) {
        labMaxAllocationSize.setText(Units.byteToRString(clDeviceInfo.getMaxMemAllocSize()));
        labGlobalMemory.setText(Units.byteToRString(clDeviceInfo.getGlobalMemSize()));        
        labGlobalMemoryCache.setText(Units.byteToRString(clDeviceInfo.getGlobalMemCacheSize()));
        labGlobalCacheType.setText(clDeviceInfo.getGlobalMemCacheType().toString());
        labConstantBufferSize.setText(Units.byteToRString(clDeviceInfo.getMaxConstantBufferSize()));
        labLocalMemory.setText(Units.byteToRString(clDeviceInfo.getLocalMemSize()));
    }
    
    private void fillAdditional(ClDeviceInfo clDeviceInfo) {
        cbHalf.setSelected(clDeviceInfo.getPreferredVectorWidthHalf() != 0L);
        cbFloat.setSelected(clDeviceInfo.getPreferredVectorWidthFloat() != 0L);
        cbDouble.setSelected(clDeviceInfo.getPreferredVectorWidthDouble() != 0L);
        
        EnumSet<DeviceTye> types = clDeviceInfo.getType();
        cbCpu.setSelected(types.contains(DeviceTye.CPU));
        cbGpu.setSelected(types.contains(DeviceTye.GPU));
        cbAccelerator.setSelected(types.contains(DeviceTye.ACCELERATOR));
        cbDefault.setSelected(types.contains(DeviceTye.DEFAULT));
        
        DeviceProfile profile = clDeviceInfo.getProfile();
        cbProfileFull.setSelected(profile == DeviceProfile.FULL);
        cbProfileEmbedded.setSelected(profile == DeviceProfile.EMBEDDED);
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

        plBackground = new javax.swing.JPanel();
        plDescription = new javax.swing.JPanel();
        labOpenCLDesc = new javax.swing.JLabel();
        labDeviceNameDesc = new javax.swing.JLabel();
        labVendorDesc = new javax.swing.JLabel();
        labDriverDesc = new javax.swing.JLabel();
        labDeviceName = new javax.swing.JLabel();
        labVendor = new javax.swing.JLabel();
        labDriver = new javax.swing.JLabel();
        labOpenCL = new javax.swing.JLabel();
        plComputing = new javax.swing.JPanel();
        plMemory = new javax.swing.JPanel();
        labGlobalMemoryDesc = new javax.swing.JLabel();
        labGlobalMemory = new javax.swing.JLabel();
        labGlobalMemoryCacheDesc = new javax.swing.JLabel();
        labGlobalMemoryCache = new javax.swing.JLabel();
        labConstantBufferSizeDesc = new javax.swing.JLabel();
        labConstantBufferSize = new javax.swing.JLabel();
        labLocalMemoryDesc = new javax.swing.JLabel();
        labLocalMemory = new javax.swing.JLabel();
        labMaxAllocationSizeDesc = new javax.swing.JLabel();
        labMaxAllocationSize = new javax.swing.JLabel();
        labGlobalCacheTypeDesc = new javax.swing.JLabel();
        labGlobalCacheType = new javax.swing.JLabel();
        plHardware = new javax.swing.JPanel();
        labComputeUnitsDesc = new javax.swing.JLabel();
        labComputeUnits = new javax.swing.JLabel();
        labMaxFrequencyDesc = new javax.swing.JLabel();
        labMaxFrequency = new javax.swing.JLabel();
        labWorkItemDimensionsDesc = new javax.swing.JLabel();
        labWorkItemDimensions = new javax.swing.JLabel();
        labWorkGroupSizeDesc = new javax.swing.JLabel();
        labWorkGroupSize = new javax.swing.JLabel();
        labWorkItemSizesPerDimDesc = new javax.swing.JLabel();
        labWorkItemSizesPerDim = new javax.swing.JLabel();
        plAdditional = new javax.swing.JPanel();
        plProfile = new javax.swing.JPanel();
        cbProfileFull = new javax.swing.JCheckBox();
        cbProfileEmbedded = new javax.swing.JCheckBox();
        plType = new javax.swing.JPanel();
        cbCpu = new javax.swing.JCheckBox();
        cbGpu = new javax.swing.JCheckBox();
        cbAccelerator = new javax.swing.JCheckBox();
        cbDefault = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        cbHalf = new javax.swing.JCheckBox();
        cbFloat = new javax.swing.JCheckBox();
        cbDouble = new javax.swing.JCheckBox();

        setLayout(new java.awt.GridBagLayout());

        plBackground.setLayout(new java.awt.GridBagLayout());

        plDescription.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        plDescription.setLayout(new java.awt.GridBagLayout());

        labOpenCLDesc.setText("OpenCL:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plDescription.add(labOpenCLDesc, gridBagConstraints);

        labDeviceNameDesc.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plDescription.add(labDeviceNameDesc, gridBagConstraints);

        labVendorDesc.setText("Vendor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plDescription.add(labVendorDesc, gridBagConstraints);

        labDriverDesc.setText("Driver:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plDescription.add(labDriverDesc, gridBagConstraints);

        labDeviceName.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plDescription.add(labDeviceName, gridBagConstraints);

        labVendor.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plDescription.add(labVendor, gridBagConstraints);

        labDriver.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plDescription.add(labDriver, gridBagConstraints);

        labOpenCL.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plDescription.add(labOpenCL, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plBackground.add(plDescription, gridBagConstraints);

        plComputing.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Computing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        plComputing.setLayout(new java.awt.GridBagLayout());

        plMemory.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Memory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        plMemory.setLayout(new java.awt.GridBagLayout());

        labGlobalMemoryDesc.setText("Global Memory:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labGlobalMemoryDesc, gridBagConstraints);

        labGlobalMemory.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labGlobalMemory, gridBagConstraints);

        labGlobalMemoryCacheDesc.setText("Global Memory Cache:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labGlobalMemoryCacheDesc, gridBagConstraints);

        labGlobalMemoryCache.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labGlobalMemoryCache, gridBagConstraints);

        labConstantBufferSizeDesc.setText("Constant Buffer Size:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labConstantBufferSizeDesc, gridBagConstraints);

        labConstantBufferSize.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labConstantBufferSize, gridBagConstraints);

        labLocalMemoryDesc.setText("Local Memory:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labLocalMemoryDesc, gridBagConstraints);

        labLocalMemory.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labLocalMemory, gridBagConstraints);

        labMaxAllocationSizeDesc.setText("Max. Allocation Size:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labMaxAllocationSizeDesc, gridBagConstraints);

        labMaxAllocationSize.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labMaxAllocationSize, gridBagConstraints);

        labGlobalCacheTypeDesc.setText("Global Cache Type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labGlobalCacheTypeDesc, gridBagConstraints);

        labGlobalCacheType.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plMemory.add(labGlobalCacheType, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plComputing.add(plMemory, gridBagConstraints);

        plHardware.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hardware", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        plHardware.setLayout(new java.awt.GridBagLayout());

        labComputeUnitsDesc.setText("Compute Units:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plHardware.add(labComputeUnitsDesc, gridBagConstraints);

        labComputeUnits.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plHardware.add(labComputeUnits, gridBagConstraints);

        labMaxFrequencyDesc.setText("Max. Frequency:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plHardware.add(labMaxFrequencyDesc, gridBagConstraints);

        labMaxFrequency.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plHardware.add(labMaxFrequency, gridBagConstraints);

        labWorkItemDimensionsDesc.setText("Work Item Dimensions:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plHardware.add(labWorkItemDimensionsDesc, gridBagConstraints);

        labWorkItemDimensions.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plHardware.add(labWorkItemDimensions, gridBagConstraints);

        labWorkGroupSizeDesc.setText("Work Group Size:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plHardware.add(labWorkGroupSizeDesc, gridBagConstraints);

        labWorkGroupSize.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plHardware.add(labWorkGroupSize, gridBagConstraints);

        labWorkItemSizesPerDimDesc.setText("Work Item Sizes (per Dimension):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plHardware.add(labWorkItemSizesPerDimDesc, gridBagConstraints);

        labWorkItemSizesPerDim.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plHardware.add(labWorkItemSizesPerDim, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plComputing.add(plHardware, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plBackground.add(plComputing, gridBagConstraints);

        plAdditional.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Addtional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        plAdditional.setLayout(new java.awt.GridBagLayout());

        plProfile.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        plProfile.setLayout(new java.awt.GridBagLayout());

        cbProfileFull.setText("Full");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plProfile.add(cbProfileFull, gridBagConstraints);

        cbProfileEmbedded.setText("Embedded");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        plProfile.add(cbProfileEmbedded, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plAdditional.add(plProfile, gridBagConstraints);

        plType.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        plType.setLayout(new java.awt.GridBagLayout());

        cbCpu.setText("CPU");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plType.add(cbCpu, gridBagConstraints);

        cbGpu.setText("GPU");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        plType.add(cbGpu, gridBagConstraints);

        cbAccelerator.setText("Accelerator");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        plType.add(cbAccelerator, gridBagConstraints);

        cbDefault.setText("Default");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        plType.add(cbDefault, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plAdditional.add(plType, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Floating Point", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        cbHalf.setText("Half");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(cbHalf, gridBagConstraints);

        cbFloat.setText("Float");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(cbFloat, gridBagConstraints);

        cbDouble.setText("Double");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(cbDouble, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plAdditional.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plBackground.add(plAdditional, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(plBackground, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbAccelerator;
    private javax.swing.JCheckBox cbCpu;
    private javax.swing.JCheckBox cbDefault;
    private javax.swing.JCheckBox cbDouble;
    private javax.swing.JCheckBox cbFloat;
    private javax.swing.JCheckBox cbGpu;
    private javax.swing.JCheckBox cbHalf;
    private javax.swing.JCheckBox cbProfileEmbedded;
    private javax.swing.JCheckBox cbProfileFull;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labComputeUnits;
    private javax.swing.JLabel labComputeUnitsDesc;
    private javax.swing.JLabel labConstantBufferSize;
    private javax.swing.JLabel labConstantBufferSizeDesc;
    private javax.swing.JLabel labDeviceName;
    private javax.swing.JLabel labDeviceNameDesc;
    private javax.swing.JLabel labDriver;
    private javax.swing.JLabel labDriverDesc;
    private javax.swing.JLabel labGlobalCacheType;
    private javax.swing.JLabel labGlobalCacheTypeDesc;
    private javax.swing.JLabel labGlobalMemory;
    private javax.swing.JLabel labGlobalMemoryCache;
    private javax.swing.JLabel labGlobalMemoryCacheDesc;
    private javax.swing.JLabel labGlobalMemoryDesc;
    private javax.swing.JLabel labLocalMemory;
    private javax.swing.JLabel labLocalMemoryDesc;
    private javax.swing.JLabel labMaxAllocationSize;
    private javax.swing.JLabel labMaxAllocationSizeDesc;
    private javax.swing.JLabel labMaxFrequency;
    private javax.swing.JLabel labMaxFrequencyDesc;
    private javax.swing.JLabel labOpenCL;
    private javax.swing.JLabel labOpenCLDesc;
    private javax.swing.JLabel labVendor;
    private javax.swing.JLabel labVendorDesc;
    private javax.swing.JLabel labWorkGroupSize;
    private javax.swing.JLabel labWorkGroupSizeDesc;
    private javax.swing.JLabel labWorkItemDimensions;
    private javax.swing.JLabel labWorkItemDimensionsDesc;
    private javax.swing.JLabel labWorkItemSizesPerDim;
    private javax.swing.JLabel labWorkItemSizesPerDimDesc;
    private javax.swing.JPanel plAdditional;
    private javax.swing.JPanel plBackground;
    private javax.swing.JPanel plComputing;
    private javax.swing.JPanel plDescription;
    private javax.swing.JPanel plHardware;
    private javax.swing.JPanel plMemory;
    private javax.swing.JPanel plProfile;
    private javax.swing.JPanel plType;
    // End of variables declaration//GEN-END:variables
}

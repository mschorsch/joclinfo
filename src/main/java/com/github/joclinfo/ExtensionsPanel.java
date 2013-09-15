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
import java.util.Arrays;
import javax.swing.JPanel;

/**
 *
 * @author Matthias Schorsch
 */
public class ExtensionsPanel extends JPanel implements PanelUpdater {

    public ExtensionsPanel() {
        initComponents();
    }

    @Override
    public void update(PlatformDevice platformDevice) {
        ClDeviceInfo clDeviceInfo = platformDevice.getClDeviceInfo();
        String[] extensions = clDeviceInfo.getExtensions();
        getTableModel().updateModel(Arrays.asList(extensions));
        tableExtensions.packAll();
    }
    
    private ExtensionTableModel getTableModel() {
        return (ExtensionTableModel) tableExtensions.getModel();
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

        scpExtensions = new javax.swing.JScrollPane();
        tableExtensions = new org.jdesktop.swingx.JXTable();

        setLayout(new java.awt.GridBagLayout());

        tableExtensions.setModel(new ExtensionTableModel());
        tableExtensions.setColumnControlVisible(true);
        tableExtensions.setHighlighters(TableUtil.TABLE_HIGLIGHTER);
        scpExtensions.setViewportView(tableExtensions);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(scpExtensions, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scpExtensions;
    private org.jdesktop.swingx.JXTable tableExtensions;
    // End of variables declaration//GEN-END:variables
}

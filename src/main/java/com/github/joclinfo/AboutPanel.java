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

import java.net.URI;
import javax.swing.JPanel;

/**
 *
 * @author Matthias Schorsch
 */
public class AboutPanel extends JPanel {

    public AboutPanel() {
        initComponents();
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
        labDescription = new javax.swing.JLabel();
        plAuthor = new javax.swing.JPanel();
        hlSwingx = new org.jdesktop.swingx.JXHyperlink();
        labAuthor = new javax.swing.JLabel();
        labThirdPartyDesc = new javax.swing.JLabel();
        labAuthorDesc = new javax.swing.JLabel();
        hlJocl = new org.jdesktop.swingx.JXHyperlink();
        labVersionDesc = new javax.swing.JLabel();
        labVersion = new javax.swing.JLabel();
        plKhronos = new javax.swing.JPanel();
        hlKhronosGroup = new org.jdesktop.swingx.JXHyperlink();
        jLabel4 = new javax.swing.JLabel();
        labProductsMentioned = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        plBackground.setLayout(new java.awt.GridBagLayout());

        labDescription.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        labDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDescription.setText("JOCL Info");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plBackground.add(labDescription, gridBagConstraints);

        plAuthor.setLayout(new java.awt.GridBagLayout());

        hlSwingx.setText("https://java.net/projects/swingx/");
        hlSwingx.setURI(URI.create("https://java.net/projects/swingx/"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plAuthor.add(hlSwingx, gridBagConstraints);

        labAuthor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labAuthor.setText("Copyright (c) 2013 Matthias Schorsch");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plAuthor.add(labAuthor, gridBagConstraints);

        labThirdPartyDesc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labThirdPartyDesc.setText("Third party libraries:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plAuthor.add(labThirdPartyDesc, gridBagConstraints);

        labAuthorDesc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labAuthorDesc.setText("Author:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plAuthor.add(labAuthorDesc, gridBagConstraints);

        hlJocl.setText("http://www.jocl.org/");
        hlJocl.setURI(URI.create("http://www.jocl.org/"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plAuthor.add(hlJocl, gridBagConstraints);

        labVersionDesc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labVersionDesc.setText("Version:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plAuthor.add(labVersionDesc, gridBagConstraints);

        labVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labVersion.setText("0.1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plAuthor.add(labVersion, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plBackground.add(plAuthor, gridBagConstraints);

        plKhronos.setLayout(new java.awt.GridBagLayout());

        hlKhronosGroup.setText("http://www.khronos.org/opencl/");
        hlKhronosGroup.setURI(URI.create("http://www.khronos.org/opencl/"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plKhronos.add(hlKhronosGroup, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("OpenCL was created by Khronos Group");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plKhronos.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plBackground.add(plKhronos, gridBagConstraints);

        labProductsMentioned.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labProductsMentioned.setText("Products and company names mentioned may be trademarks of their respective owners.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        plBackground.add(labProductsMentioned, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(plBackground, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXHyperlink hlJocl;
    private org.jdesktop.swingx.JXHyperlink hlKhronosGroup;
    private org.jdesktop.swingx.JXHyperlink hlSwingx;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labAuthor;
    private javax.swing.JLabel labAuthorDesc;
    private javax.swing.JLabel labDescription;
    private javax.swing.JLabel labProductsMentioned;
    private javax.swing.JLabel labThirdPartyDesc;
    private javax.swing.JLabel labVersion;
    private javax.swing.JLabel labVersionDesc;
    private javax.swing.JPanel plAuthor;
    private javax.swing.JPanel plBackground;
    private javax.swing.JPanel plKhronos;
    // End of variables declaration//GEN-END:variables
}
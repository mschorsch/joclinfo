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
import com.github.joclinfo.util.ClUtil;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.jocl.CL;
import org.jocl.cl_device_id;
import org.jocl.cl_platform_id;

/**
 *
 * @author Matthias Schorsch
 */
public class JoclInfo {

    public static void main(String args[]) {
        try {
            initLookAndFeel();
            startJoclInfoFrame(initPlaformDevices());
        } catch (RuntimeException ex) {
            Logger.getLogger(JoclInfo.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void startJoclInfoFrame(final List<PlatformDevice> plaformDevices) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new JoclInfoFrame(plaformDevices).setVisible(true);
                } catch (RuntimeException ex) {
                    Logger.getLogger(JoclInfo.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
            }
        });
    }

    private static List<PlatformDevice> initPlaformDevices() {
        List<PlatformDevice> platformDevices = new ArrayList<PlatformDevice>();

        for (cl_platform_id platform : ClUtil.getPlatforms()) {
            ClPlatformInfo clPlatformInfo = new ClPlatformInfo(platform);

            for (cl_device_id device : ClUtil.getDevices(platform, CL.CL_DEVICE_TYPE_ALL)) {
                ClDeviceInfo clDeviceInfo = new ClDeviceInfo(device);
                platformDevices.add(new PlatformDevice(clPlatformInfo, clDeviceInfo));
            }
        }

        return platformDevices;
    }

    private static void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

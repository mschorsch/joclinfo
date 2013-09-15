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

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Matthias Schorsch
 */
class CapabilitiesTableModel extends AbstractTableModel {

    private static enum CapabilitiesColumn {
        
        GROUP("Group", String.class),
        SUB_GROUP("Sub-Group", String.class),
        PARAM_NAME("Parametername", String.class),
        DESCRIPTION("Description", String.class),
        VALUE("Value", Object.class);
        
        private final String columnName;
        private final Class<?> columnClass;

        private CapabilitiesColumn(String columnName, Class<?> columnClass) {
            this.columnName = columnName;
            this.columnClass = columnClass;
        }

        public String getColumnName() {
            return columnName;
        }

        public Class<?> getColumnClass() {
            return columnClass;
        }
        
        public static CapabilitiesColumn toColumn(int columnIndex) {
            return CapabilitiesColumn.values()[columnIndex];
        }
    }

    private final List<CapabilitiesRow> rows;
    
    public CapabilitiesTableModel() {
        this.rows = new ArrayList<CapabilitiesRow>();
    }
    
    public void updateModel(List<CapabilitiesRow> rows) {
        this.rows.clear();
        this.rows.addAll(rows);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return CapabilitiesColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CapabilitiesRow row = rows.get(rowIndex);
        CapabilitiesColumn column = CapabilitiesColumn.toColumn(columnIndex);
        
        if(column == CapabilitiesColumn.GROUP) {
            return row.getGroup();
        } else if(column == CapabilitiesColumn.SUB_GROUP) {
            return row.getSubGroup();
        } else if(column == CapabilitiesColumn.PARAM_NAME) {
            return row.getParamName();
        } else if(column == CapabilitiesColumn.DESCRIPTION) {
            return row.getDescription();
        } else if(column == CapabilitiesColumn.VALUE) {
            return row.getValue();
        }
        
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return CapabilitiesColumn.toColumn(columnIndex).getColumnClass();
    }

    @Override
    public String getColumnName(int column) {
        return CapabilitiesColumn.toColumn(column).getColumnName();
    }
}

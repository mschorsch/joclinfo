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
class ExtensionTableModel extends AbstractTableModel {

    private static enum ExtensionsColumn {
        
        EXTENSION("Extension", String.class);
        
        private final String columnName;
        private final Class<?> columnClass;

        private ExtensionsColumn(String columnName, Class<?> columnClass) {
            this.columnName = columnName;
            this.columnClass = columnClass;
        }

        public String getColumnName() {
            return columnName;
        }

        public Class<?> getColumnClass() {
            return columnClass;
        }
        
        public static ExtensionsColumn toColumn(int columnIndex) {
            return ExtensionsColumn.values()[columnIndex];
        }
    }

    private final List<String> rows;
    
    public ExtensionTableModel() {
        this.rows = new ArrayList<String>();
    }
    
    public void updateModel(List<String> rows) {
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
        return ExtensionsColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String row = rows.get(rowIndex);
        ExtensionsColumn column = ExtensionsColumn.toColumn(columnIndex);
        
        if(column == ExtensionsColumn.EXTENSION) {
            return row;
        }
        
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return ExtensionsColumn.toColumn(columnIndex).getColumnClass();
    }

    @Override
    public String getColumnName(int column) {
        return ExtensionsColumn.toColumn(column).getColumnName();
    }   
}

/*
 * Copyright 2006 Carsten Rambow
 *
 * Licensed under the GNU Public License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/gpl.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package de.elomagic.hl7inspector.gui.profiles.model;

import de.elomagic.hl7inspector.profile.TableItem;

import java.util.List;

import org.apache.log4j.Logger;

/**
 *
 * @author rambow
 */
public class TableModel<E extends TableItem> extends ProfileModel<TableItem> {

    private static final long serialVersionUID = 3848893502635683042L;

    public TableModel() {
        super();
    }

    /** Creates a new instance of DataTypeModel */
    public TableModel(List<E> list) {
        super();

        setModel(list);
    }

    public final void setModel(List<E> list) {
        clear();
        table.addAll(list);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TableItem item = getRow(rowIndex);

        switch (columnIndex) {
            case 0:
                return item.getId();
            case 1:
                return item.getType();
            case 2:
                return item.getValue();
            case 3:
                return item.getDescription();
            case 4:
                return item.getTableDescription();
            default:
                return "";
        }
    }

    /**
     *  This empty implementation is provided so users don't have to implement
     *  this method if their data model is not editable.
     *
     *
     * @param aValue   value to assign to cell
     * @param rowIndex   row of cell
     * @param columnIndex  column of cell
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            TableItem ti = getRow(rowIndex);

            switch (columnIndex) {
                case 0:
                    ti.setId(aValue.toString());
                    break;
                case 1:
                    ti.setType(aValue.toString());
                    break;
                case 2:
                    ti.setValue(aValue.toString());
                    break;
                case 3:
                    ti.setDescription(aValue.toString());
                    break;
                case 4:
                    ti.setTableDescription(aValue.toString());
                    break;
                default:
                    ;
            }

            fireTableCellUpdated(rowIndex, columnIndex);
        } catch (Exception ex) {
            Logger.getLogger(getClass()).error(ex.getMessage(), ex);
        }
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Deprecated
    public TableItem getTableItem(int rowIndex) {
        return getRow(rowIndex);
    }

    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Table Id";
            case 1:
                return "Type";
            case 2:
                return "Value";
            case 3:
                return "Description";
            case 4:
                return "Table Description";
            default:
                return "";
        }
    }

    @Override
    public Class getDefaultRowClass() {
        return TableItem.class;
    }

}

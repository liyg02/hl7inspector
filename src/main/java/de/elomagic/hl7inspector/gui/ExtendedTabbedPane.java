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
 */
package de.elomagic.hl7inspector.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTabbedPane;
import javax.swing.plaf.TabbedPaneUI;

/**
 *
 * @author rambow
 */
public class ExtendedTabbedPane extends JTabbedPane {
    private List<ActionListener> actionListener = new ArrayList<>();

    /**
     * Creates a new instance of ExtendedTabbedPane.
     */
    public ExtendedTabbedPane() {
        super.setUI(ui);
    }

    /**
     * Override JTabbedPane method.
     * <p/>
     * Does nothing.
     */
    @Override
    public void setUI(final TabbedPaneUI ui) {
    }

    public synchronized void addCloseListener(final ActionListener listener) {
        actionListener.add(listener);
    }

    public synchronized void removeCloseListener(final ActionListener listener) {
        actionListener.remove(listener);
    }

    public void fireCloseTabEvent() {
        ActionEvent event = new ActionEvent(this, 0, "");

        for(final ActionListener listener : actionListener) {
            listener.actionPerformed(event);
        }

        setVisible(false);
    }
    //private ExtendedTabbedPaneUI ui = new ExtendedTabbedPaneUI();
}

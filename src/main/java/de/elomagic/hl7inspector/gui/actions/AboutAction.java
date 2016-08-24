/*
 * Copyright 2016 Carsten Rambow
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
package de.elomagic.hl7inspector.gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import de.elomagic.hl7inspector.gui.dialogs.about.AboutDialog;

/**
 *
 * @author Carsten Rambow
 */
public class AboutAction extends BasicAction {

    /**
     * Creates a new instance of AboutAction.
     */
    public AboutAction() {
        super();

        putValue(NAME, "About...");
        putValue(SHORT_DESCRIPTION, "Shows version info");
        putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_L));
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        new AboutDialog().setVisible(true);
    }
}

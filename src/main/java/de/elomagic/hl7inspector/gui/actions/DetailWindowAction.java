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
package de.elomagic.hl7inspector.gui.actions;

import de.elomagic.hl7inspector.gui.framing.FramingSetupDialog;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author rambow
 */
public class DetailWindowAction extends BasicAction {
    /**
     * Creates a new instance of DetailWindowAction.
     */
    public DetailWindowAction() {
        super();

        putValue(NAME, "Detail window...");
        putValue(SHORT_DESCRIPTION, "Shows/Hide detail window");
        putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_L));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FramingSetupDialog dlg = new FramingSetupDialog();
        dlg.ask();
    }
}

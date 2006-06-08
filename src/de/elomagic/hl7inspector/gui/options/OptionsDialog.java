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

package de.elomagic.hl7inspector.gui.options;

import de.elomagic.hl7inspector.gui.Desktop;
import de.elomagic.hl7inspector.gui.PanelDialog;
import de.elomagic.hl7inspector.gui.ToolKit;

/**
 *
 * @author rambow
 */
public class OptionsDialog extends PanelDialog {
    
    /** Creates a new instance of OptionsDialog */
    public OptionsDialog() { super(Desktop.getInstance(), "Options", true); }
    
    @Override
    protected void init() {
        getPanelList().add(new GeneralOptionPanel(this));
        getPanelList().add(new TreeViewPanel(this));
        getPanelList().add(new ExternalToolsPanel(this));
        // FEATURE Font setup panel missing
        //getPanelList().add(new FontsColorOptionPanel(this));
        
        super.init();
        
        setSize(600, 500);        
        setBounds(ToolKit.centerFrame(this, Desktop.getInstance()));       
    }
}

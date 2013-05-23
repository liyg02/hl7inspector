/*
 * Copyright 2013 Carsten Rambow
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

import de.elomagic.hl7inspector.hl7.model.Message;
import java.util.List;

/**
 *
 * @author rambow
 */
public interface DesktopIntf {
    /**
     * Adds message to the view.
     *
     * @param messages List if messages
     * @param maxMessageInView Maximum message in the view
     * @param readBottom When true message will be removed from the top
     */
    void addMessages(List<Message> messages, int maxMessageInView, boolean readBottom);
}

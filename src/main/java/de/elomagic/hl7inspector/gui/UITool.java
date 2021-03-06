/*
 * Copyright 2016 Carsten Rambow
 * 
 * Licensed under the GNU Public License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.gnu.org/licenses/gpl.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.elomagic.hl7inspector.gui;

import java.io.File;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;

import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 *
 * @author Carsten Rambow
 */
public final class UITool {

    private UITool() {
    }

    public static Path chooseFile(final String title, final Window ownerStage, final Collection<? extends FileChooser.ExtensionFilter> filters, final Path initialDirectory) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        fileChooser.setInitialDirectory(initialDirectory.toFile());
        fileChooser.getExtensionFilters().addAll(filters == null ? Collections.EMPTY_LIST : filters);

        File selectedFile = fileChooser.showOpenDialog(ownerStage);

        return selectedFile == null ? null : selectedFile.toPath();
    }

    public static Path saveFile(final String title, final Window ownerStage, final Collection<? extends FileChooser.ExtensionFilter> filters, final Path initialDirectory) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        fileChooser.setInitialDirectory(initialDirectory.toFile());
        fileChooser.getExtensionFilters().addAll(filters == null ? Collections.EMPTY_LIST : filters);

        File selectedFile = fileChooser.showSaveDialog(ownerStage);

        return selectedFile == null ? null : selectedFile.toPath();
    }

}

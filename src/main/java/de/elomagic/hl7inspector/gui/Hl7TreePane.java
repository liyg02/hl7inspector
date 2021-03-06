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
package de.elomagic.hl7inspector.gui;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.apache.log4j.Logger;

import de.elomagic.hl7inspector.StartupProperties;
import de.elomagic.hl7inspector.gui.actions.EditMessageItemAction;
import de.elomagic.hl7inspector.gui.actions.FileRecentOpenAction;
import de.elomagic.hl7inspector.gui.actions.PasteTextAction;
import de.elomagic.hl7inspector.hl7.model.Hl7Object;
import de.elomagic.hl7inspector.hl7.model.Message;
import de.elomagic.hl7inspector.model.Hl7Tree;
import de.elomagic.hl7inspector.model.Hl7TreeModel;

/**
 *
 * @author Carsten Rambow
 */
public class Hl7TreePane extends JScrollPane implements DropTargetListener {

    private Hl7Tree tree;

    /**
     * Creates a new instance of Hl7TreePane.
     */
    public Hl7TreePane() {
        init(null);
    }

    public Hl7TreePane(Hl7TreeModel model) {
        init(model);
    }

    public final void init(Hl7TreeModel model) {
        tree = model == null ? new Hl7Tree() : new Hl7Tree(model);
        tree.setCellRenderer(new TreeCellRenderer());
        tree.setOpaque(false);
        tree.setComponentPopupMenu(new TreePopupMenu());
        tree.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent event) {

                if(event.getClickCount() == 2) {
                    TreePath path = tree.getPathForLocation(event.getX(), event.getY());
                    if(path != null) {
                        Hl7Object o = (Hl7Object)path.getLastPathComponent();

                        if(!(o instanceof Message) && ((o.getChildCount() == 0) || (StartupProperties.isTreeNodeDoubleClick()))) {
                            EditMessageItemAction action = new EditMessageItemAction();
                            action.actionPerformed(new ActionEvent(event.getSource(), event.getID(), ""));
                        }
                    }
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        new DropTarget(tree, this);

        setViewportView(tree);

    }

    public void setModel(TreeModel model) {
        tree.setModel(model);
    }

    public TreeModel getModel() {
        return tree.getModel();
    }

    public Hl7Tree getTree() {
        return tree;
    }

    // Interface implementationof drag an drop
    @Override
    public void drop(DropTargetDropEvent dtde) {
        try {
            Transferable tr = dtde.getTransferable();
            if(tr.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

                java.util.List fileList = (java.util.List)tr.getTransferData(DataFlavor.javaFileListFlavor);
                Iterator iterator = fileList.iterator();
                while(iterator.hasNext()) {
                    File file = (File)iterator.next();

                    Desktop.getInstance().getMainFrame().toFront();

                    //SimpleDialog.info(file.getPath());
                    new FileRecentOpenAction(file).actionPerformed(null);
                }

                //      if (dtde.getCurrentDataFlavorsAsList().size() == 1) {
                //          SimpleDialog.info(dtde.getCurrentDataFlavors()[0].getHumanPresentableName());
            } else if(tr.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

                String text = tr.getTransferData(DataFlavor.stringFlavor).toString();
                PasteTextAction.importText(text);
            }
        } catch(UnsupportedFlavorException | IOException e) {
            Logger.getLogger(getClass()).error(e.getMessage(), e);
            dtde.rejectDrop();
        }
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        /* SimpleDialog.info(dtde.toString()); */ }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        try {
            Transferable tr = dtde.getTransferable();
            if(!tr.isDataFlavorSupported(DataFlavor.javaFileListFlavor)
                       && !tr.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                dtde.rejectDrag();
            }
        } catch(Exception e) {
            Logger.getLogger(getClass()).error(e.getMessage(), e);
            dtde.rejectDrag();
        }
    }
}

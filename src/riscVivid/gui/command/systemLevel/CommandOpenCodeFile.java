/*******************************************************************************
 * riscVivid - A RISC-V processor simulator.
 * (C)opyright 2013-2016 The riscVivid project, University of Augsburg, Germany
 * https://github.com/unia-sik/riscVivid
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program, see <LICENSE>. If not, see
 * <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package riscVivid.gui.command.systemLevel;

import java.awt.Cursor;
import java.io.File;
import javax.swing.JOptionPane;

import riscVivid.gui.MainFrame;
import riscVivid.gui.command.Command;
import riscVivid.gui.dialog.CodeFileChooser;

public class CommandOpenCodeFile implements Command
{

    private MainFrame mf;
    private File codeFile = null; //out

    public CommandOpenCodeFile(MainFrame mf)
    {
        this.mf = mf;
    }

    @Override
    public void execute()
    {
        try
        {
            mf.getContentPane().setCursor(
                    Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            CodeFileChooser f = new CodeFileChooser();
            // in case of "cancel" codeFile is null
            codeFile = f.chooseFile();

        }
        catch (Exception e)
        {
            System.err.println(e.toString());
            e.printStackTrace();
            JOptionPane.showMessageDialog(mf, "Opening file failed / getting file path failed");
        }
        finally
        {
            mf.getContentPane().setCursor(
                    Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    public File getCodeFile()
    {
        return codeFile;
    }

}

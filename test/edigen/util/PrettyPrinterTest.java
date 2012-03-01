/*
 * Copyright (C) 2012 Matúš Sulír
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package edigen.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test of the PrettyPrinter class.
 * @author Matúš Sulír
 */
public class PrettyPrinterTest {

    /**
     * Test of writeLine method, of class PrettyPrinter.
     */
    @Test
    public void testWriteLine() {
        String[] input = {
            "if (a) {",
            "switch (b) {",
            "case 1:",
            "break;",
            "default:",
            "}",
            "} else {",
            "}"
        };

        String[] expectedLines = {
            "if (a) {",
            "    switch (b) {",
            "    case 1:",
            "        break;",
            "    default:",
            "    }",
            "} else {",
            "}"
        };

        StringBuilder expected = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        
        for (String line : expectedLines) {
            expected.append(line).append(lineSeparator);
        }
        
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        PrintStream printOutput = new PrintStream(byteOutput, true);
        PrettyPrinter printer = new PrettyPrinter(printOutput);

        for (String line : input) {
            printer.writeLine(line);
        }

        assertEquals(expected.toString(), byteOutput.toString());
    }
}
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
package edigen.disasm.tree;

import edigen.SemanticException;
import edigen.decoder.TreeNode;
import edigen.decoder.Visitor;

/**
 * A node representing a textual instruction format (used in a disassembler).
 * 
 * Consists of a format string and a list of values.
 * @author Matúš Sulír
 */
public class Format extends TreeNode {
    
    private String formatString;

    /**
     * Constructs the format node.
     * @param formatString the format string
     */
    public Format(String formatString) {
        this.formatString = formatString;
    }
    
    /**
     * Accepts the visitor.
     * @param visitor the visitor object
     * @throws SemanticException depends on the specific visitor
     */
    @Override
    public void accept(Visitor visitor) throws SemanticException {
        visitor.visit(this);
    }
    
    /**
     * Returns a string representation of the object.
     * @return the string
     */
    @Override
    public String toString() {
        return "Format: \"" + formatString + '"';
    }
}

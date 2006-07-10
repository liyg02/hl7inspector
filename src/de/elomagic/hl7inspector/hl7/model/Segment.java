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

package de.elomagic.hl7inspector.hl7.model;

/**
 *
 * @author rambow
 */
public class Segment extends Hl7Object {
    
    /** Creates a new instance of Segment */
    public Segment() { }
    
    public char getSubDelimiter() { return Delimiters.DEFAULT_FIELD; }
    
    public Class getChildClass() { return RepetitionField.class; }    
    
    @Override
    protected String toXmlString() {
        StringBuffer sb = new StringBuffer();
        
        String element = get(0).toString();
        
        sb.append("\t<" + element + ">\n");        
        
        for (int i=1; i<size(); i++) {
            if (!get(i).isNULL()) {
                sb.append(get(i).toXmlString());                
            }
        }
        
        sb.append("\t</" + element + ">\n");        
        
        return sb.toString();        
    }      
}

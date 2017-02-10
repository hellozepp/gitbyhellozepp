package org.Collection.mapandset;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by hadoop on 16-8-6.
 */

public class VectorTest
{
    public static void main(String[] args) {
        Vector<String> vector =new Vector<String>();
        vector.addElement("hah1");
        vector.addElement("aah21");
        vector.addElement("hah3");
        vector.addElement("hah4");
        vector.addElement("hah5");
        for (Enumeration en =vector.elements();en.hasMoreElements();)
        {
            System.out.println(en.nextElement());
        }
    }
}

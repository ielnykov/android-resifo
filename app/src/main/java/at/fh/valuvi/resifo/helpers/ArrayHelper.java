package at.fh.valuvi.resifo.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArrayHelper {

    private Collection<?> collection;

    public ArrayHelper(Collection<?> collection) {
        this.collection = collection;
    }

    public String join(String separator) {
        Iterator<?> iterator = collection.iterator();

        StringBuilder stringBuilder = new StringBuilder();

        if (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            while (iterator.hasNext()) {
                stringBuilder.append(separator).append(iterator.next());
            }
        }

        return stringBuilder.toString();
    }



}

package com.one.netease.complier.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @author diaokaibin@gmail.com on 2019-12-27.
 */
public class EmptyUtils {

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isEmpty(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isEmpty(final Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}

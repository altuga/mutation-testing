package org.jugistanbul.mutationtesting;

import java.util.Objects;

public class LowPassPredicate {

    private final int limit;

    public LowPassPredicate(int limit) {
        this.limit = limit;
    }

    public boolean filter(int i) {
        return i < limit;
    }


    public static boolean canEnterLoungeArea(Customer customer) {
        if (customer.goldMember() || customer.limit().intValue() > 90 ) {
            return true;
        }

        return false;
    }
}

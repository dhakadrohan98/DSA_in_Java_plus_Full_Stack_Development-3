package org.codeship.immutableclass;
//ImmutableClassMaking

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClassMaking {
    private final String name;
    private final List<String> degrees;

    public ImmutableClassMaking(String name, List<String> degrees) {
        this.name = name;
     // Defensive copying(deep copy) to maintain immutability
        this.degrees = new ArrayList<>(degrees);
    }

    public String getName() {
        return name;
    }

    public List<String> getDegrees() {
    	// Return a copy to prevent exposing the internal Address object
        return new ArrayList<>(degrees);
    }
}

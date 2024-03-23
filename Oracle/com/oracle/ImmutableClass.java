package com.oracle;

import java.util.*;

public final class ImmutableClass {

    private final int immutableField;
    private final List<String> mutableList;

    public ImmutableClass(int immutableField, List<String> mutableList) {
        this.immutableField = immutableField;
        this.mutableList = new ArrayList<>(mutableList); // defensively copy the mutable list
    }

    public int getImmutableField() {
        return immutableField;
    }

    public List<String> getMutableList() {
        return new ArrayList<>(mutableList); // defensively copy the mutable list before returning
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableClass that = (ImmutableClass) o;
        return immutableField == that.immutableField &&
                Objects.equals(mutableList, that.mutableList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(immutableField, mutableList);
    }

    public static void main(String[] args) {
    }
}

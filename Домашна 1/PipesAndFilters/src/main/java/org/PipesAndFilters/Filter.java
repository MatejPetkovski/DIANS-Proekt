package org.PipesAndFilters;

public interface Filter <T> {

    T execute(T input);
}

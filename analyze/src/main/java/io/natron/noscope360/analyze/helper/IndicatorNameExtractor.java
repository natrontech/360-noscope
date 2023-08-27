package io.natron.noscope360.analyze.helper;

@FunctionalInterface
public interface IndicatorNameExtractor<T> {
    String extract(T data);
}

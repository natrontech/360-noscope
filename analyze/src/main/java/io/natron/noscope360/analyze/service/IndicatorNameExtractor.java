package io.natron.noscope360.analyze.service;

@FunctionalInterface
interface IndicatorNameExtractor<T> {
    String extract(T data);
}

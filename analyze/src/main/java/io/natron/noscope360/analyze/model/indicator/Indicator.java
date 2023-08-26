package io.natron.noscope360.analyze.model.indicator;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.Function;


public abstract class Indicator<T> {

    protected String category; // TODO replace with enum
    protected String theme; // TODO replace with enum
    protected String name;
    protected LocalDate date;

    protected Map<String, T> values;

    protected Map<String, Function<T, Number>> mappings;

    public Number calculateScale() {

        return values.keySet().stream()
                .mapToDouble(k -> mappings.get(k).apply(values.get(k)).doubleValue())
                .average()
                .orElseThrow(IllegalStateException::new);
    }
}

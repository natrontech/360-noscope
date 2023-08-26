package io.natron.noscope360.analyze.model.indicator;

import io.natron.noscope360.analyze.model.enums.Dimension;
import io.natron.noscope360.analyze.model.enums.Theme;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.Function;

public abstract class Indicator<T> {

    protected Dimension dimension;
    protected Theme theme;
    protected String name;
    protected String canton;
    protected String municipality;
    protected int plz;
    protected String source;
    protected LocalDateTime timestamp;

    protected Map<String, T> values;

    protected Map<String, Function<T, Number>> mappings;

    public Number calculateScale() {

        return values.keySet().stream()
                .mapToDouble(k -> mappings.get(k).apply(values.get(k)).doubleValue())
                .average()
                .orElseThrow(IllegalStateException::new);
    }
}

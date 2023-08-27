package io.natron.noscope360.analyze.model.indicator;

import io.natron.noscope360.analyze.model.entity.QuantitativeData;
import org.springframework.data.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public abstract class AbstractQuantitativeData<T> {

    protected String name;

    protected Map<String, T> values = new HashMap<>();
    protected Map<String, Function<T, Number>> mappings = new HashMap<>();

    public static Pair<AbstractQuantitativeData<?>, List<QuantitativeData>> toIndicatorFromDocument(QuantitativeData doc, List<QuantitativeData> remainingIndicators) {

        switch (doc.getIndicator()) {
            case "Energieverbrauch pro Person":
                remainingIndicators.remove(doc);
                return Pair.of(new EnvironmentEnergyConsumptionScaleMapping(doc.getValue()), remainingIndicators);
            case "Potential Solarstrom":
            case "Erneuerbar Heizen":
            case "Fortschritt Ausbau Sonnenenergie":
            case "Anteil Elektroautos":
                List<QuantitativeData> parts = List.of(
                        remainingIndicators.stream().filter(d -> Objects.equals(d.getIndicator(), "Potential Solarstrom")).findFirst().orElseThrow(),
                        remainingIndicators.stream().filter(d -> Objects.equals(d.getIndicator(), "Erneuerbar Heizen")).findFirst().orElseThrow(),
                        remainingIndicators.stream().filter(d -> Objects.equals(d.getIndicator(), "Fortschritt Ausbau Sonnenenergie")).findFirst().orElseThrow(),
                        remainingIndicators.stream().filter(d -> Objects.equals(d.getIndicator(), "Anteil Elektroautos")).findFirst().orElseThrow()
                );
                remainingIndicators.removeAll(parts);
                return Pair.of(new EnvironmentEnergyQualityAbstractQuantitativeData(parts.get(2).getValue(), parts.get(3).getValue(), parts.get(0).getValue(), parts.get(1).getValue()), remainingIndicators);
            default:
                throw new IllegalArgumentException("cannot map " + doc.getIndicator());
        }
    }

    public Number calculateScale() {

        return values.keySet().stream()
                .mapToDouble(k -> mappings.get(k).apply(values.get(k)).doubleValue())
                .average()
                .orElseThrow(IllegalStateException::new);
    }
}

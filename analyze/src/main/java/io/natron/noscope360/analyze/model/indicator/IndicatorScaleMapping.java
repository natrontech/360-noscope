package io.natron.noscope360.analyze.model.indicator;

import java.util.HashMap;
import java.util.Map;

public class IndicatorScaleMapping {

    public static Map<String, ScaleConvertable> mapping = new HashMap<>();

    static {
        mapping.put("Energieverbrauch pro Person", new EnvironmentEnergyConsumptionScaleMapping());
    }
}

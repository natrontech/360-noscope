package io.natron.noscope360.analyze.model.indicator;

import io.natron.noscope360.analyze.model.dto.IndicatorDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScaleMappingDelegator {

    public Map<String, ScaleConvertable> mapping = new HashMap<>();

    public ScaleMappingDelegator() {
        init();
    }

    public void addIndicator(IndicatorDto dto, double value) {

        if (mapping.containsKey(dto.getName())) {
            mapping.get(dto.getName()).addValue(dto.getName(), value);
        }
    }

    public void bulkCalculateScales(List<IndicatorDto> dtos) {
        mapping.keySet()
                .stream()
                .map(key -> dtos.stream().filter(dto -> dto.getName().equals(key)).findFirst().orElseThrow())
                .forEach(dto -> mapping.get(dto.getName()).toScale(dto));
    }

    private void init() {

        mapping.put(EnvironmentEnergyConsumptionScaleMapping.INDICATOR_NAME, new EnvironmentEnergyConsumptionScaleMapping());

        EnvironmentEnergyQualityScaleMapping energyQualityMapping = new EnvironmentEnergyQualityScaleMapping();
        mapping.put(EnvironmentEnergyQualityScaleMapping.QUALITY_POTENTIAL, energyQualityMapping);
        mapping.put(EnvironmentEnergyQualityScaleMapping.QUALITY_ECARS, energyQualityMapping);
        mapping.put(EnvironmentEnergyQualityScaleMapping.QUALITY_INNOVATION, energyQualityMapping);
        mapping.put(EnvironmentEnergyQualityScaleMapping.QUALITY_RENEWABLE, energyQualityMapping);
    }
}

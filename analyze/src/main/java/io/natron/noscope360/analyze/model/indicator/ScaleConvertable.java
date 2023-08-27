package io.natron.noscope360.analyze.model.indicator;

import io.natron.noscope360.analyze.model.dto.IndicatorDto;

import java.util.List;

public interface ScaleConvertable {
    double toScale(IndicatorDto dto);
    void addValue(String name, double value);
}

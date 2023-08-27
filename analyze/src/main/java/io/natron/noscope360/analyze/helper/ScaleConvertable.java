package io.natron.noscope360.analyze.helper;

import io.natron.noscope360.analyze.model.dto.IndicatorDto;

public interface ScaleConvertable {
    double toScale(IndicatorDto dto);

    void addValue(String name, double value);
}

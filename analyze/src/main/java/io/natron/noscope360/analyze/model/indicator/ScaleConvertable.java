package io.natron.noscope360.analyze.model.indicator;

import java.util.List;

public interface ScaleConvertable {

    int toScale(List<Double> values);
}

package io.natron.noscope360.analyze.model.mapping;

import io.natron.noscope360.analyze.helper.ScaleConvertable;
import io.natron.noscope360.analyze.model.dto.IndicatorDto;

/**
 * Berechnung: Im Idealfall direkter Energiebrauch von Gemeinde nehmen
 * (von Gemeinde direkt oder anderen Daten). Ansonsten ersten Annährung:
 * <p>
 * Abgleichen, ob die Gemeinde Energiestadt ist oder ob sie 2000-Watt Areale aufweisen.
 * <p>
 * Skala für Energieverbrauch orientiert sich am Idealwert: der 2000 Watt
 * Gesellschaft sowie dem Minimum, Maximum und Mittelwert der Schweiz.
 */
public class EnvironmentEnergyConsumptionScaleMapping implements ScaleConvertable {

    public final static String INDICATOR_NAME = "Energieverbrauch pro Person";

    private double value;

    @Override
    public double toScale(IndicatorDto dto) {
        double v = mapConsumption(value);
        dto.setRating((int) v);
        return v;
    }

    @Override
    public void addValue(String name, double value) {
        if (name.equals(INDICATOR_NAME)) {
            this.value = value;
        }
    }

    /**
     * 10 < 2 MWh/Jahr pro Person
     * 9= 2-2.5 MWh/Jahr pro Person
     * 8= 2.5-3 MWh/Jahr pro Person
     * 7=3-4 MWh/Jahr pro Person
     * 6=4-5 MWh/Jahr pro Person
     * 5= 5-6 MWh/Jahr pro Person
     * 4= 6-8 MWh/Jahr pro Person
     * 3=8-10 MWh/Jahr pro Person
     * 2=10-15 MWh/Jahr pro Person
     * 1> 15 MWh/Jahr pro Person
     */
    private Integer mapConsumption(Double input) {

        if (input < 2) {
            return 10;
        } else if (input >= 2.0 && input < 2.5) {
            return 9;
        } else if (input >= 2.5 && input < 3.0) {
            return 8;
        } else if (input >= 3.0 && input < 4) {
            return 7;
        } else if (input >= 4 && input < 5) {
            return 6;
        } else if (input >= 5 && input < 6) {
            return 5;
        } else if (input >= 6 && input < 8) {
            return 4;
        } else if (input >= 8 && input < 10) {
            return 3;
        } else if (input >= 10 && input < 15) {
            return 2;
        }

        // input >= 15
        return 1;
    }
}

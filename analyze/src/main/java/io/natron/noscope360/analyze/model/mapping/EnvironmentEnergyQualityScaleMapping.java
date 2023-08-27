package io.natron.noscope360.analyze.model.mapping;

import io.natron.noscope360.analyze.helper.ScaleConvertable;
import io.natron.noscope360.analyze.model.dto.IndicatorDto;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentEnergyQualityScaleMapping implements ScaleConvertable {

    public static final String QUALITY_POTENTIAL = "Potential Solarstrom";
    public static final String QUALITY_RENEWABLE = "Erneuerbar Heizen";
    public static final String QUALITY_INNOVATION = "Fortschritt Ausbau Sonnenenergie";
    public static final String QUALITY_ECARS = "Anteil Elektroautos";
    private static final int QUALITY_POTENTIAL_INDEX = 0;
    private static final int QUALITY_RENEWABLE_INDEX = 1;
    private static final int QUALITY_INNOVATION_INDEX = 2;
    private static final int QUALITY_ECARS_INDEX = 3;
    private List<Double> values = new ArrayList<>(4);

    @Override
    public double toScale(IndicatorDto dto) {

        double result = (double) (mapDevelopment(values.get(QUALITY_INNOVATION_INDEX)) +
                mapECars(values.get(QUALITY_ECARS_INDEX)) +
                mapSolar(values.get(QUALITY_POTENTIAL_INDEX)) +
                mapRenewableHeating(values.get(QUALITY_RENEWABLE_INDEX))) / 4;

        dto.setRating((int) result);

        return result;
    }

    @Override
    public void addValue(String name, double value) {

        switch (name) {
            case QUALITY_RENEWABLE -> values.add(QUALITY_RENEWABLE_INDEX, value);
            case QUALITY_POTENTIAL -> values.add(QUALITY_POTENTIAL_INDEX, value);
            case QUALITY_ECARS -> values.add(QUALITY_ECARS_INDEX, value);
            case QUALITY_INNOVATION -> values.add(QUALITY_INNOVATION_INDEX, value);
            default -> throw new IllegalArgumentException("unknown indicator name " + name);
        }
    }

    /**
     * Fortschritt Ausbau Sonnenenergie:
     * 9>26%
     * 7= 20%
     * 5=14%
     * 3= 8%
     * 1 < 2.0%
     */
    private int mapDevelopment(Double input) {

        if (input < 2) {
            return 1;
        } else if (input <= 8) {
            return 3;
        } else if (input <= 14) {
            return 5;
        } else if (input <= 26) {
            return 7;
        }

        return 9;
    }

    /**
     * Anteil Elektroautos:
     * 10>15%
     * 8=10%
     * 6= 8%
     * 4= 6%
     * 2=4%
     */
    private int mapECars(Double input) {

        if (input < 4) {
            return 2;
        } else if (input <= 6) {
            return 4;
        } else if (input <= 8) {
            return 6;
        } else if (input < 15) {
            return 8;
        }

        return 10;
    }

    /**
     * Produktion Solarstrom
     * 10>70%
     * 8=50%
     * 6=30%
     * 4=15%
     * 2=5%
     */
    private int mapSolar(Double input) {

        if (input < 5) {
            return 2;
        } else if (input <= 15) {
            return 4;
        } else if (input <= 30) {
            return 6;
        } else if (input <= 70) {
            return 8;
        }

        return 10;
    }

    /**
     * Erneuerbar Heizen
     * 10>95%
     * 8=80%
     * 6=60%
     * 4= 40%
     * 2= 20%
     */
    private int mapRenewableHeating(Double input) {

        if (input <= 20) {
            return 2;
        } else if (input <= 40) {
            return 4;
        } else if (input <= 60) {
            return 6;
        } else if (input <= 80) {
            return 8;
        }

        return 10;
    }
}

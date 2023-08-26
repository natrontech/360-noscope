package io.natron.noscope360.analyze.model.indicator;

public class EnvironmentEnergyQualityAbstractQuantitativeData extends AbstractQuantitativeData<Double> {

    public static final String DEVELOPMENT_MAP_KEY = "development";
    public static final String ECARS_MAP_KEY = "ecars";
    public static final String SOLAR_MAP_KEY = "solar";
    public static final String RENEWABLE_HEATING_MAP_KEY = "renewable_heating";

    public EnvironmentEnergyQualityAbstractQuantitativeData(
            Double developmentValue,
            Double eCars,
            Double solar,
            Double renewableHeating) {
        super();

        values.put(DEVELOPMENT_MAP_KEY, developmentValue);
        values.put(ECARS_MAP_KEY, eCars);
        values.put(SOLAR_MAP_KEY, solar);
        values.put(RENEWABLE_HEATING_MAP_KEY, renewableHeating);

        mappings.put(DEVELOPMENT_MAP_KEY, this::mapDevelopment);
        mappings.put(ECARS_MAP_KEY, this::mapECars);
        mappings.put(SOLAR_MAP_KEY, this::mapSolar);
        mappings.put(RENEWABLE_HEATING_MAP_KEY, this::mapRenewableHeating);
    }

    /**
     * Fortschritt Ausbau Sonnenenergie:
     * 9>26%
     * 7= 20%
     * 5=14%
     * 3= 8%
     * 1 < 2.0%
     */
    private Number mapDevelopment(Double input) {

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
    private Number mapECars(Double input) {

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
    private Number mapSolar(Double input) {

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
    private Number mapRenewableHeating(Double input) {

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

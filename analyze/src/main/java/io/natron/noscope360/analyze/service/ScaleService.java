package io.natron.noscope360.analyze.service;

import io.natron.noscope360.analyze.model.enums.Dimension;
import io.natron.noscope360.analyze.model.enums.Theme;
import io.natron.noscope360.analyze.model.indicator.Indicator;
import io.natron.noscope360.analyze.repository.IndicatorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service responsible for handling operations related to scales.
 */
@Service
public class ScaleService {

    private static final Logger log = LoggerFactory.getLogger(ScaleService.class);

    private final IndicatorRepository indicatorRepository;

    /**
     * Constructs a new instance of the ScaleService.
     *
     * @param indicatorRepository Repository to interact with the Indicator data.
     */
    public ScaleService(IndicatorRepository indicatorRepository) {
        this.indicatorRepository = indicatorRepository;
    }

    /**
     * Retrieves all available dimensions.
     *
     * @return List of available dimensions.
     */
    public List<Dimension> getDimensions() {
        return Arrays.asList(Dimension.values());
    }

    /**
     * Retrieves all themes associated with a given dimension.
     *
     * @param dimension The name of the dimension for which themes are to be retrieved.
     * @return List of themes associated with the specified dimension.
     */
    public List<Theme> getThemes(String dimension) {
        List<Theme> themes = new ArrayList<>();
        for (Theme theme : Theme.values()) {
            if (theme.getDimension() == Dimension.valueOf(dimension)) {
                themes.add(theme);
            }
        }
        return themes;
    }

    /**
     * Retrieves all indicators associated with a specific theme within a given dimension.
     * Note: Implementation is pending.
     *
     * @param dimension The name of the dimension within which the theme resides.
     * @param theme     The name of the theme for which indicators are to be retrieved.
     * @return List of indicators associated with the specified theme.
     */
    public List<Indicator> getIndicatorsByTheme(String dimension, String theme) {
        return null; // implementation pending
    }

    /**
     * Retrieves all scales of the indicators associated with a specific municipality.
     * Note: Implementation is pending.
     *
     * @param municipality The name of the municipality for which the scales of the indicators are to be retrieved.
     * @return List of scales of the indicators associated with the specified municipality.
     */
    public List<Indicator> getIndicatorsByMunicipality(String municipality) {
        return null; // implementation pending
    }
}

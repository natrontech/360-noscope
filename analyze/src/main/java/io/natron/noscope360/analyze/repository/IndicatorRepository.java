package io.natron.noscope360.analyze.repository;

import io.natron.noscope360.analyze.model.entity.Indicator;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface IndicatorRepository extends ElasticsearchRepository<Indicator, String> {
    Optional<Indicator> findByName(String indicator);
}

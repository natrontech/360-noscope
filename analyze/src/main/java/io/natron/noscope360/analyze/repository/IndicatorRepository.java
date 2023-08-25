package io.natron.noscope360.analyze.repository;

import io.natron.noscope360.analyze.model.indicator.Indicator;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IndicatorRepository extends ElasticsearchRepository<Indicator, String> {
}

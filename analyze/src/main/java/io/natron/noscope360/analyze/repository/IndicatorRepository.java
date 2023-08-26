package io.natron.noscope360.analyze.repository;

import io.natron.noscope360.analyze.model.entity.IndicatorData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicatorRepository extends ElasticsearchRepository<IndicatorData, String> {
}

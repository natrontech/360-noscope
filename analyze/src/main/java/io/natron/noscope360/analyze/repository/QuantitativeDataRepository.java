package io.natron.noscope360.analyze.repository;

import io.natron.noscope360.analyze.model.entity.QuantitativeData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface QuantitativeDataRepository extends ElasticsearchRepository<QuantitativeData, String> {
}

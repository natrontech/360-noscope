package io.natron.noscope360.analyze.repository;

import io.natron.noscope360.analyze.model.entity.QualitativeData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface QualitativeDataRepository extends ElasticsearchRepository<QualitativeData, String> {
}

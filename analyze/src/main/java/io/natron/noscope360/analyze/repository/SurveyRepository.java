package io.natron.noscope360.analyze.repository;

import io.natron.noscope360.analyze.model.entity.SurveyData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SurveyRepository extends ElasticsearchRepository<SurveyData, String> {
}

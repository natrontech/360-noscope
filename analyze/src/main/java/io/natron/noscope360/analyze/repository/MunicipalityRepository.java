package io.natron.noscope360.analyze.repository;

import io.natron.noscope360.analyze.model.entity.Municipality;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MunicipalityRepository extends ElasticsearchRepository<Municipality, String> {
}

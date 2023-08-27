package io.natron.noscope360.analyze.repository;

import io.natron.noscope360.analyze.model.entity.Municipality;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface MunicipalityRepository extends ElasticsearchRepository<Municipality, String> {
    Optional<Municipality> findByBfsNr(int bfsNr);
}

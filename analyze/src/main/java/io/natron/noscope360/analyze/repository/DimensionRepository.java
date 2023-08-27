package io.natron.noscope360.analyze.repository;

import io.natron.noscope360.analyze.model.entity.Dimension;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface DimensionRepository extends ElasticsearchRepository<Dimension, String> {
    List<Dimension> findByName(String dimension);
}

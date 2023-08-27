package io.natron.noscope360.analyze.repository;

import io.natron.noscope360.analyze.model.entity.Theme;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ThemeRepository extends ElasticsearchRepository<Theme, String> {
    List<Theme> findByName(String theme);
}

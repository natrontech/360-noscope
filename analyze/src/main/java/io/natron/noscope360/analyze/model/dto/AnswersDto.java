package io.natron.noscope360.analyze.model.dto;

import java.time.LocalDateTime;

public record AnswersDto(String id, String question, String dimension, String theme, String indicator, int rating,
                         LocalDateTime participationDate) {
}

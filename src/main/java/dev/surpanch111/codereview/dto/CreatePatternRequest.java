package dev.surpanch111.codereview.dto;

import dev.surpanch111.codereview.model.Severity;

public record CreatePatternRequest(
        String id,
        String name,
        String description,
        String language,
        Severity severity,
        String category,
        String exampleBadCode,
        String exampleGoodCode,
        String explanation
) {
}

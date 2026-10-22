package dev.surpanch111.codereview.dto;

import dev.surpanch111.codereview.model.CodeSubmission;
import dev.surpanch111.codereview.model.ReviewFinding;

import java.util.List;

public record ReviewResponse(
        CodeSubmission submission,
        List<ReviewFinding> findings
) {
}

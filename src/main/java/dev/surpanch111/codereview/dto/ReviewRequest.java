package dev.surpanch111.codereview.dto;

public record ReviewRequest(
        String code,
        String language,
        String fileName
) {
}

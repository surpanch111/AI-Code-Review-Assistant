package dev.surpanch111.codereview.controller;

import dev.surpanch111.codereview.dto.CategoryCount;
import dev.surpanch111.codereview.dto.PatternFrequency;
import dev.surpanch111.codereview.dto.SeverityCount;
import dev.surpanch111.codereview.service.AnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/categories")
    public List<CategoryCount> getCategoryCounts() {
        return analyticsService.getCategoryCounts();
    }

    @GetMapping("/severity")
    public List<SeverityCount> getSeverityDistribution() {
        return analyticsService.getSeverityDistribution();
    }

    @GetMapping("/top-patterns")
    public List<PatternFrequency> getTopPatterns() {
        return analyticsService.getTopPatterns();
    }
}

package dev.surpanch111.codereview.controller;

import dev.surpanch111.codereview.dto.ReviewRequest;
import dev.surpanch111.codereview.dto.ReviewResponse;
import dev.surpanch111.codereview.model.ReviewFinding;
import dev.surpanch111.codereview.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse submitReview(@RequestBody ReviewRequest request) {
        return reviewService.reviewCode(request);
    }

    @GetMapping("/{submissionId}")
    public ReviewResponse getReview(@PathVariable String submissionId) {
        return reviewService.getReview(submissionId);
    }

    @GetMapping("/{submissionId}/findings")
    public List<ReviewFinding> getFindings(@PathVariable String submissionId) {
        return reviewService.getFindings(submissionId);
    }
}

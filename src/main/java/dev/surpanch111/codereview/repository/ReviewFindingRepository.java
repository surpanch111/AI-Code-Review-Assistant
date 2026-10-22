package dev.surpanch111.codereview.repository;

import dev.surpanch111.codereview.model.ReviewFinding;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewFindingRepository extends MongoRepository<ReviewFinding, String> {

    List<ReviewFinding> findBySubmissionId(String submissionId);
}

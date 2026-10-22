package dev.surpanch111.codereview.repository;

import dev.surpanch111.codereview.model.CodeSubmission;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CodeSubmissionRepository extends MongoRepository<CodeSubmission, String> {
}

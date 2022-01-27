package shop.janghj.mytrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.janghj.mytrip.domain.UserReview;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
}
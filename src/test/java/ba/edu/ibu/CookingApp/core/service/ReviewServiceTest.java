package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.Review;
import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.repository.ReviewRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest
public class ReviewServiceTest {

    @MockBean
    ReviewRepository  reviewRepository;

    @Autowired
    ReviewService reviewService;

    @Test
    public void shouldReturnReviewWhenCreated() {
        Review review = new Review();

        User user = new User();
        user.setName("Amela");

        Recipe recipe = new Recipe();
        recipe.setName("Cheesecake");

        review.setUser(user);
        review.setRecipe(recipe);
        review.setComment("Very good and delicious recipe.");

        Mockito.when(reviewRepository.save(ArgumentMatchers.any(Review.class))).thenReturn(review);
        Assertions.assertThat(review.getComment()).isEqualTo(review.getComment());
        Assertions.assertThat(review.getUser()).isNotNull();

    }

    @Test
    public void shouldReturnReviewById() {
        Review review = new Review();

        User user = new User();
        user.setName("Amela");

        Recipe recipe = new Recipe();
        recipe.setName("Cheesecake");

        review.setId("someMongoId");
        review.setUser(user);
        review.setRecipe(recipe);
        review.setComment("Very good!");

        Mockito.when(reviewRepository.findById("someMongoId")).thenReturn(Optional.of(review));

        Review foundReview = reviewService.getReviewByIdNoDTO("someMongoId");
        Assertions.assertThat(foundReview.getComment()).isEqualTo("Very good!");
    }
}

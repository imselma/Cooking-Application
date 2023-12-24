package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.core.exceptions.repository.ResourceNotFoundException;
import ba.edu.ibu.CookingApp.core.model.Review;
import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.repository.ReviewRepository;
import ba.edu.ibu.CookingApp.core.repository.UserRepository;
import ba.edu.ibu.CookingApp.rest.dto.ReviewDTO;
import ba.edu.ibu.CookingApp.rest.dto.ReviewRequestDTO;
import ba.edu.ibu.CookingApp.rest.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    public ReviewService (ReviewRepository reviewRepository, UserService userService, UserRepository userRepository)
    {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    //Add a new review
    public ReviewDTO addReview (ReviewRequestDTO reviewData){

        String userName = reviewData.getUserName();
        String userSurname = reviewData.getUserSurname();
        User user = userService.getUserByNameNotDTO(userName);
        Review newReview =reviewData.toEntity();

        newReview.setUser(user);
        reviewRepository.save(newReview);
        return new ReviewDTO(newReview);
    }

    //Get review by id
    public ReviewDTO getReviewById(String id){
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isEmpty()) {
            throw new ResourceNotFoundException("The review does not exist.");
        }
        return new ReviewDTO(review.get());
    }

    //Get all reviews
    public List<ReviewDTO> getAllReviews(){
        List<Review> reviews = reviewRepository.findAll();

        return reviews
                .stream()
                .map(ReviewDTO::new)
                .collect(toList());
    }

    //Update/Edit reviews
    public ReviewDTO updateReview (String id, ReviewRequestDTO reviewData){
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isEmpty()) {
            throw new ResourceNotFoundException("The review does not exist.");
        }

        Review updatedReview = reviewData.toEntity();
        updatedReview.setId((review.get().getId()));
        updatedReview = reviewRepository.save(updatedReview);

        return new ReviewDTO(updatedReview);
    }

    //Delete review
    public void deleteReview (String id){
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isEmpty()) {
            throw new ResourceNotFoundException("The review does not exist.");
        }
        review.ifPresent(reviewRepository :: delete);
    }

    //Get review by Id but as a Review model, not ReviewDTO
    public Review getReviewByIdNoDTO (String id){
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }
        System.out.println(review.get());

        return review.get();
    }
}

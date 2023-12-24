package ba.edu.ibu.CookingApp.rest.controllers;

import ba.edu.ibu.CookingApp.core.service.ReviewService;
import ba.edu.ibu.CookingApp.rest.dto.ReviewDTO;
import ba.edu.ibu.CookingApp.rest.dto.ReviewRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reviews")
@SecurityRequirement(name = "JWT Security")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController (ReviewService reviewService){this.reviewService = reviewService;}

    //Endpoint for getting all reviews
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<ReviewDTO>> getAllReviews (){
        return ResponseEntity.ok(reviewService.getAllReviews());
    }


    //Endpoint for adding new review
    @RequestMapping(method = RequestMethod.POST, path="/addReview")
    @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<ReviewDTO> addReview (@RequestBody ReviewRequestDTO review){
        return ResponseEntity.ok(reviewService.addReview(review));
    }

    //Endpoint for getting the review by ID
    @RequestMapping(method = RequestMethod.GET, path="/{id}")
    @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<ReviewDTO> getReviewById (@PathVariable String id){
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    /* Endpoint for editing/update a review */
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<ReviewDTO> updateReview (@PathVariable String id, @RequestBody ReviewRequestDTO review){
        return ResponseEntity.ok(reviewService.updateReview(id, review));
    }

    //Endpoint for deleting a review
    @RequestMapping (method = RequestMethod.DELETE, path ="/{id}")
    @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<Void> deleteReview (@PathVariable String id){
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

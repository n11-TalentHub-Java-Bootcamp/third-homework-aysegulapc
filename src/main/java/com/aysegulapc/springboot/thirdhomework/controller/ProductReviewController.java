package com.aysegulapc.springboot.thirdhomework.controller;

import com.aysegulapc.springboot.thirdhomework.entity.ProductReview;
import com.aysegulapc.springboot.thirdhomework.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    /** This endpoint gets all product review according to json format.
     * This endpoint was written for item 1 of question 3 in the homework.
     * @return MappingJacksonValue
     * **/
    @GetMapping("")
    public MappingJacksonValue findAllProductReviewList() {
        List<ProductReview> reviewList = productReviewService.findAll();
        MappingJacksonValue mapping = new MappingJacksonValue(reviewList);
        return mapping;
    }

    /** This endpoint gets a specific product review by id according to json format.
     * This endpoint was written for item 2 of question 3 in the homework.
     * @return MappingJacksonValue
     * **/
    @GetMapping("/{id}")
    public MappingJacksonValue findProductReviewById(@PathVariable String id) {
        ProductReview productReview = productReviewService.findById(id);
        WebMvcLinkBuilder linkToProduct = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).findAllProductReviewList()
        );

        EntityModel entityModel = EntityModel.of(productReview);
        entityModel.add(linkToProduct.withRel("all-reviews"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        return mapping;
    }

    /** This endpoint save a review to mongodb.
     * This endpoint was written for item 3 of question 3 in the homework.
     * @return ResponseEntity<Object>
     * **/
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductReview productReview) {
        productReview = productReviewService.save(productReview);
        return new ResponseEntity<>(productReview, HttpStatus.CREATED);
    }

    /** This endpoint delete a review from mongodb.
     * This endpoint was written for item 4 of question 3 in the homework.
     * **/
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productReviewService.delete(id);
    }
}

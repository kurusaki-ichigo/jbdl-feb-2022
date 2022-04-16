package com.example.L15.L15.entities;


import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@ToString
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Entity
public class CourseRating {


    @EmbeddedId
    CompositeCourseRatingId courseRatingId;


    @ManyToOne
    @MapsId(value="userId")
    UserInfo userInfo;

    @ManyToOne
    @MapsId(value = "courseId")
    Course course;


    Integer rating;
}

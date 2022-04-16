package com.example.L15.L15.entities;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
@ToString
public class CompositeCourseRatingId implements Serializable {
    private static final long serialVersionUID = 5391096286964360626L;

    Integer courseId;
    Integer userId;

}

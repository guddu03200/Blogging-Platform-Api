package com.Guddu.BloggingPlatformApi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "postLike")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "fk_lik_post_id")
    private Post post;


    @ManyToOne
    @JoinColumn(name = "fk_liker_id")
    private User liker;
}

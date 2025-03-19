package com.ticketsnap.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "movies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie extends BaseModel {

    private String name;
    private String language;
    @Column(nullable = true)
    private double rating;
    private int duration;
    private String category;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", rating=" + rating +
                ", duration=" + duration +
                ", category='" + category + '\'' +
                '}';
    }
}

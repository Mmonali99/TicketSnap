package com.ticketsnap.service;

import com.ticketsnap.models.Show;
import com.ticketsnap.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> recommendShows(String regionName) {
        // Simple recommendation logic based on region
        return showRepository.findAll().stream()
                .filter(show -> show.getScreen().getTheatre().getRegion().getName().equals(regionName))
                .toList();
    }
}
package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServicesImpl implements TrackServices {
   private TrackRepository trackRepository;
    @Autowired
    public TrackServicesImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack=trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrackComment(Track track) {
        Track tracktoUpdate=trackRepository.getOne(track.getTrackId());
        tracktoUpdate.setTrackComments(track.getTrackComments());
        trackRepository.save(tracktoUpdate);
        return tracktoUpdate;
    }

    @Override
    public void deleteTrack(Track track) {
        trackRepository.delete(track);
        
    }
}

package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;

import java.util.List;

public interface TrackServices {
    public Track saveTrack(Track track);
    public List<Track> getAllTracks();
    public  Track updateTrackComment(Track track);
    public void deleteTrack(Track track);
}

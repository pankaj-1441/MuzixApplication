package com.stackroute.MuzixApplication.controller;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.service.TrackServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1")
public class TrackController {
    @Autowired
    private TrackServices trackServices;

    public TrackController(TrackServices trackServices) {
        this.trackServices = trackServices;
    }


    @PostMapping("/track")
    public ResponseEntity<?> saveUser(@RequestBody Track track){
        ResponseEntity responseEntity;
        try{
            trackServices.saveTrack(track);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/getTrack")
    public  ResponseEntity<?> getAllUsers(){
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<List<Track>>(trackServices.getAllTracks(), HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/updateTrack")
    public ResponseEntity<?> updateTrackComment(@RequestBody Track track){
        ResponseEntity responseEntity;
        try{
            trackServices.updateTrackComment(track);
            responseEntity=new ResponseEntity<String>("Successfully Updated Comment",HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return  responseEntity;
    }

    @DeleteMapping("/deleteTrack")
    public ResponseEntity<?> deleteTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
           trackServices.deleteTrack(track);
           responseEntity=new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return  responseEntity;
    }
}

package com.brocade.dcm.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brocade.dcm.domain.model.Posts;
import com.brocade.dcm.server.service.ObjectCacheService;

@RestController
public class ObjectCacheServiceController {
	
	@Autowired
	private ObjectCacheService objectCacheService;
	
	@GetMapping("/dcm/posts")
	 public ResponseEntity<List<Posts>> getPostById(@RequestParam(required=false, defaultValue="-1") String id, 
			 @RequestParam(required=false, defaultValue="") String searchQuery) {
		return new ResponseEntity<>(objectCacheService.getPostById(id, searchQuery), HttpStatus.OK);
	}
	
}

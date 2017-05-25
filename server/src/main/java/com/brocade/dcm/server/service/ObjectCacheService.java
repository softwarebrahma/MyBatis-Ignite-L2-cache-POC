package com.brocade.dcm.server.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brocade.dcm.domain.criteria.PortsSearchCriteria;
import com.brocade.dcm.domain.mapper.PostsMapper;
import com.brocade.dcm.domain.model.Posts;

@Service
public class ObjectCacheService {
	
	@Autowired
	private PostsMapper postsMapper;
	
	@Transactional(readOnly = true)
	public List<Posts> getPostById(String id, String searchQuery) {
		System.out.println("==== in ObjectCacheService.getPostById ==== for id : " + id);
		System.out.println("==== in ObjectCacheService.getPostById ==== for searchQuery : " + searchQuery);
		List<Posts> posts = null;
		if (id.equals("-1")) {
			 PortsSearchCriteria criteria = new PortsSearchCriteria();
			 criteria.setSearchQuery(searchQuery);
			 posts = postsMapper.searchByCustomCriteria(criteria);
		 } else {
			 posts = Arrays.asList(postsMapper.selectByPrimaryKey(id));
		 }
		System.out.println("==== in ObjectCacheService.getPostById ==== returning : " + Arrays.deepToString(posts.toArray()));
		return posts;
	}
	
}

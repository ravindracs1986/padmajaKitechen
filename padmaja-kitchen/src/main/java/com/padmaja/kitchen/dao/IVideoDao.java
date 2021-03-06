package com.padmaja.kitchen.dao;

import java.util.List;
import java.util.Map;

import com.padmaja.kitchen.model.Video;


public interface IVideoDao {

	public Video submitVideo(Video video);
	public List<Video> getVideos();
	
	public List<Video> getNonVegVideos();
	public List<Video> getVegVideos();
	
}

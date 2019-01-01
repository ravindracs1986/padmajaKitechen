package com.padmaja.kitchen.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.padmaja.kitchen.dao.VideoDao;
import com.padmaja.kitchen.model.Video;

public class FindVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindVideoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("calling get video service");
		VideoDao videoDao = new VideoDao();
		HttpSession session = request.getSession();
		List<Video> videoListFromSession = (List<Video>) session.getAttribute("videoList");
		// List<Video> videoListFromSession =
		// (List<Video>)request.getAttribute("videoList");
		if (videoListFromSession != null) {
			System.out.println("getting from session&&&&&&&");
			request.setAttribute("videoList", videoListFromSession);
		} else {
			System.out.println("getting from database@@@@@@@@@@@@");
			List<Video> videoList = videoDao.getVideos();
			session.setAttribute("videoList", videoList);
			request.setAttribute("videoList", videoList);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

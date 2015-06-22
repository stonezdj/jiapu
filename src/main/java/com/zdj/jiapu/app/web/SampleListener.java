package com.zdj.jiapu.app.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SampleListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("zdjsession created");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("zdjsession destroyed");

	}

}

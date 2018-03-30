package com.tencent.blogservlet;

public class User {
	
	private String title;
	private String href;
	private String summary;
	private String writer;
	public User() {
	}
	public User(String title, String href, String summary, String writer) {
		this.title = title;
		this.href = href;
		this.summary = summary;
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}

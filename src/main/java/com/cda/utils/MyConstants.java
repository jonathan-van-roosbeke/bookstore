package com.cda.utils;

public class MyConstants {
	private static final String OS = System.getProperty("os.name").toLowerCase();
	public static final String SLASH = OS.contains("windows") ? "\\" : "/";
	public static final String HOME_DIR = System.getProperty("user.home");

}

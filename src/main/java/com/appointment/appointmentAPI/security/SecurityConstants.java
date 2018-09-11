package com.appointment.appointmentAPI.security;

public class SecurityConstants {

	public static final long EXPIRATION_TIME = 86400000; // 1 Day
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String PATIENT_SIGN_UP_URL = "/patient";
	public static final String TOKEN_SECRET = "jf9dfj7dfhhHHFs7";

	public static long getExpirationTime() {
		return EXPIRATION_TIME;
	}

	public static String getTokenPrefix() {
		return TOKEN_PREFIX;
	}

	public static String getHeaderString() {
		return HEADER_STRING;
	}

	public static String getPatientSignUpUrl() {
		return PATIENT_SIGN_UP_URL;
	}

	public static String getTokenSecret() {
		return TOKEN_SECRET;
	}

}
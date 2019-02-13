package com.dvimer.springboot.projecttest.inventory.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtils
{
	public static void main(String[] args)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("12345"));
	}

}

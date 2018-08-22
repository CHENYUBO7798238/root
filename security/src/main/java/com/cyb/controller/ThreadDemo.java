package com.cyb.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo implements Callable<Integer> {
	private int i;
	@Override
	public Integer call() throws Exception {
		Lock l = new ReentrantLock();
		System.out.println("fuck you,i:"+ ++i);
		return i;
	}

}

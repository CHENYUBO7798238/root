package com.cyb.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class Abs {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		FutureTask<Integer> future = new FutureTask<>(new ThreadDemo());
		FutureTask<Integer> future2 = new FutureTask<>(new ThreadDemo());
		FutureTask<Integer> future3 = new FutureTask<>(new ThreadDemo());
		FutureTask<Integer> future4 = new FutureTask<>(new ThreadDemo());
		
		new Thread(future, "第一次").start();
		new Thread(future2, "第二次").start();
		new Thread(future3, "第三次").start();
		new Thread(future4, "第四次").start();
		System.out.println(future.get());
	}
	
}

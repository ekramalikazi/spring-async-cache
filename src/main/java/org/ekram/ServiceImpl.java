package org.ekram;

import java.util.Random;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {

	@Override
	@Cacheable(value = "cache_1", key = "#p0.concat('-').concat(#p1)")
	public String cachedMethod1(String param1, String param2) {
		System.out.println("inside cachedMethod1...");
		return cachedMethod2(param1 + param2);
	}

	@Override
	@Async
	public void aSyncMethod(int value) {
		System.out.println("inside Async call... " + value);
	}

	@Override
	@Cacheable(value = "cache_1")
	public String cachedMethod2(String param) {
		System.out.println("inside cacheMethod2...");
		return param + new Random().nextInt();
	}
}
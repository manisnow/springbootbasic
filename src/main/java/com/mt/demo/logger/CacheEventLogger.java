package com.mt.demo.logger;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger 

	
	implements CacheEventListener<Object, Object> {
		 
	Logger log = LoggerFactory.getLogger(getClass());
	    
	 
	    @Override
	    public void onEvent(
	      CacheEvent<? extends Object, ? extends Object> cacheEvent) {
	        log.info("catche",   cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
	    }
}

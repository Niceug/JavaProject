package com.bittech.mybatis.plugin;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Author: secondriver
 * Created: 2018/6/30
 */
public class MyCache implements Cache {
    
    private final String id;
    
    private final Logger logger = LoggerFactory.getLogger(MyCache.class);
    
    private Integer maxSize = 1024;
    
    private final ConcurrentMap<Object, Object> cache = new ConcurrentHashMap<>(1024);
    
    public MyCache(final String id) {
        this.id = id;
        if (id == null) {
            throw new IllegalArgumentException("MyCache cache Instance id must be not null.");
        }
    }
    
    @Override
    public String getId() {
        return this.id;
    }
    
    @Override
    public void putObject(Object key, Object value) {
        logger.debug("putObject key={} value={}.", key, value);
        if (this.getSize() >= this.getMaxSize()) {
            this.cache.clear();
        }
        this.cache.put(key, value);
    }
    
    @Override
    public Object getObject(Object key) {
        Object value = this.cache.get(key);
        logger.debug("getObject key={} value={}.", key, value);
        return value;
    }
    
    @Override
    public Object removeObject(Object key) {
        Object value = this.cache.remove(key);
        logger.debug("removeObject key={} value={}.", key, value);
        return value;
    }
    
    @Override
    public void clear() {
        logger.debug("clear MyCache instance.");
        this.cache.clear();
    }
    
    @Override
    public int getSize() {
        return this.cache.size();
    }
    
    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
    
    public Integer getMaxSize() {
        return maxSize;
    }
    
    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}

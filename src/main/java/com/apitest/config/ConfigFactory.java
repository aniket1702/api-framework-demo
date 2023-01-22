package com.apitest.config;

import org.aeonbits.owner.ConfigCache;


/**
 * <p>Utility class caching Config instances that can be used as Singletons. This class is designed to be thread safe.</p>
 */
public final class ConfigFactory {
    private ConfigFactory(){}

    /**
     * <p>Gets from the cache or create, an instance of the given class using the given imports.</p>
     * @return an object implementing the given interface, that can be taken from the cache, which maps methods to property values.
     */
    public static ConfigReader getConfig(){return ConfigCache.getOrCreate(ConfigReader.class);}
}

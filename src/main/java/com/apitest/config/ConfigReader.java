package com.apitest.config;

import org.aeonbits.owner.Config;

/**
 * <p>The OWNER API is a Java library with the goal of minimizing the code required to handle application configuration via Java properties files.</p>
 * <p>The properties file for a mapping interface is automatically resolved by OWNER API by matching the class name and the file name </p>
 *
 * <p>
 *     Specifies the policy for loading the properties files.
 *     By default the first available properties file specified by Config.Sources will be loaded, see Config.LoadType.FIRST.
 *     User can also specify that the load policy is Config.LoadType.MERGE to have the properties files merged: properties are loaded in order from the first file to the last, if there are conflicts in properties names the earlier files loaded prevail.
 * </p>
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "system:env", "file:${user.dir}/src/main/resources/properties/config.properties" })
public interface ConfigReader extends Config {

    @Key("baseURI")
    String baseURI();

    @Key("environment")
    String environment();

    @Key("overrideReport")
    String overrideReport();
    

}

package org.zirbes.groovy.guavacache

import com.google.common.cache.CacheBuilder
import com.google.common.cache.LoadingCache

import java.util.concurrent.TimeUnit

class ChuckingService {

    private final LoadingCache cache

    ChuckingService(ChuckingApiService chuckingApiService) {
        // Initialize the cache loader
        ChuckingCacheLoader chuckingCacheLoader = new ChuckingCacheLoader(chuckingApiService)
        // Build the cache
        this.cache = CacheBuilder.newBuilder()
           .maximumSize(10)
           .expireAfterAccess(1, TimeUnit.MINUTES)
           .build(chuckingCacheLoader)
    }

    /** Local service to obfuscate setup for calculating wood chucking amount */
    Integer chuck(WoodChuck woodChuck, WoodType woodType) {
        if (woodChuck.canChuckWood) { return chuckWood(woodType) }
        return 0
    }

    /** Private method wrapper to expensive call to ChuckingApiService */
    private Integer chuckWood(WoodType woodType) {
        cache.get(woodType)
    }

}

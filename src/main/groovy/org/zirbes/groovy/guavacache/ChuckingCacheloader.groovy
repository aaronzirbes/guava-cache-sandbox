package org.zirbes.groovy.guavacache

import com.google.common.cache.CacheLoader

class ChuckingCacheLoader extends CacheLoader<WoodType, Integer> {

    ChuckingApiService chuckingApiService

    ChuckingCacheLoader(ChuckingApiService chuckingApiService) {
        this.chuckingApiService = chuckingApiService
    }

    Integer load(WoodType woodType) {
        return chuckingApiService.chuck(woodType)
    }

}

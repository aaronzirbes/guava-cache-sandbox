package org.zirbes.groovy.guavacache

class ChuckingService {

    ChuckingApiService chuckingApiService

    /** Local service to obfuscate setup for calculating wood chucking amount */
    Integer chuck(WoodChuck woodChuck, WoodType woodType) {
        if (woodChuck.canChuckWood) { return chuckWood(woodType) }
        return 0
    }

    /** Private method wrapper to expensive call to ChuckingApiService */
    Integer chuckWood(WoodType woodType) {
        chuckingApiService.chuck(woodType)
    }

}

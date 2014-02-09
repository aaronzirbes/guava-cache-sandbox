package org.zirbes.groovy.guavacache

import spock.lang.Specification

class WoodChuckSpec extends Specification {

    ChuckingApiService chuckingApiService

    void setup() {
        chuckingApiService = Mock()
    }

    void 'how much wood could a wood chuck chuck'() {
        given: 'a wood chuck than can chuck wood'
        WoodChuck woodChuck = new WoodChuck(canChuckWood: true)
        ChuckingService chuckingService = new ChuckingService(chuckingApiService)

        and: 'an incoming barage of request as to how much wood can said wood chuck chuck'
        List<WoodType> checkTypeQueue = [
            WoodType.OAK,
            WoodType.ASH,
            WoodType.ZEBRA,
            WoodType.OAK,
            WoodType.ZEBRA,
            WoodType.OAK,
            WoodType.PINE,
            WoodType.OAK,
            WoodType.ZEBRA,
            WoodType.OAK,
            WoodType.PINE,
            WoodType.WILLOW,
            WoodType.OAK,
            WoodType.MAPLE,
            WoodType.OAK,
            WoodType.OAK,
            WoodType.OAK,
            WoodType.CHERRY,
            WoodType.PINE,
            WoodType.WILLOW
        ]

        when: 'we process the queue to see how much wood the wood chuck and chuck in each scenario in the queue'
        checkTypeQueue.each{ WoodType woodType ->
            chuckingService.chuck(woodChuck, woodType)
        }

        then: 'we hit the ChuckingApiService 13 less times since we are using a cache'
        //20 * chuckingApiService.chuck(_) >> 42
        7 * chuckingApiService.chuck(_) >> 42
        
    }
}

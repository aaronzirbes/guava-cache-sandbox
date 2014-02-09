package org.zirbes.groovy.guavacache

import java.util.Random

class ChuckingApiService {

    /** Simulated expensive API call to a complex calculation */
    Integer chuck(WoodType woodType) {
        int total = 0
        10000.each{
            woodType.strength.each{
                total++
            }
        }
        return total
    }

}

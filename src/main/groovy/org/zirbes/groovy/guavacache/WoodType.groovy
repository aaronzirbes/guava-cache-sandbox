package org.zirbes.groovy.guavacache

enum WoodType {

    ASH(4),
    CHERRY(6),
    MAPLE(8),
    OAK(9),
    PINE(3),
    WALNUT(5),
    WILLOW(2),
    ZEBRA(7)

    WoodType(int strength) {
        this.strength = strength
    }

    int strength

}

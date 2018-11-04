package pork.model.data;

import pork.model.suitPatterns.*;

public enum SuitPatternsEnum {
    Single("单张", pork.model.suitPatterns.Single.class),Pair("对子", pork.model.suitPatterns.Pair.class), ShiftedPairs("连对", ShiftedParis.class),Plane("飞机", pork.model.suitPatterns.Plane.class), Straight("顺子", pork.model.suitPatterns.Straight.class), Bomb("炸弹",pork.model.suitPatterns.Bomb.class),
    TripletOnly("三不带", pork.model.suitPatterns.TripletOnly.class),TripletWithSingle("三带一", pork.model.suitPatterns.TripletWithSingle.class),TripletWithPair("三带对", pork.model.suitPatterns.TripletWithPair.class),KingAndQueen("王炸", pork.model.suitPatterns.KingAndQueen.class);

    private String name;

    private Class type;

    SuitPatternsEnum(String name,Class type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}

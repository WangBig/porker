package pork.model.suitPatterns;

import javafx.util.Pair;
import pork.model.data.SuitPatterns;
import pork.model.data.SuitPatternsEnum;
import pork.model.pork.PorkEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static pork.model.data.SuitPatternsEnum.Bomb;

public class Bomb extends SuitPatterns {
    Integer weight;
    SuitPatternsEnum suitPattern;


    public Bomb() {
        this.suitPattern=Bomb;
    }

    @Override
    public SuitPatternsEnum getSuitPattern() {
        return Bomb;
    }

    @Override
    public Integer getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(ArrayList<PorkEntity> porks) {
        if(check(porks)==null)
            return;
        weight=check(porks).getValue();
    }

    @Override
    public void setSuitPattern(SuitPatternsEnum suitPattern) {
            this.suitPattern=suitPattern;
    }

    @Override
    public Pair<SuitPatternsEnum,Integer> check(ArrayList<PorkEntity> porks) {
        if (porks==null||porks.size()!=4)
            return null;
        Set<Integer> set = new HashSet<>();
        for(PorkEntity p : porks)
            set.add(p.getPoint());
        if (set.size()!=1)
            return null;
        return new Pair(null,porks.get(0).getWeight());
    }
}

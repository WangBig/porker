package pork.model.suitPatterns;

import javafx.util.Pair;
import pork.Exception.PorkException;
import pork.model.data.SuitPatterns;
import pork.model.data.SuitPatternsEnum;
import pork.model.pork.PorkEntity;

import java.util.ArrayList;
import java.util.Collections;

public class Straight extends SuitPatterns {
    private SuitPatternsEnum suitPattern;
    private Integer weight;

    public Straight() {
     suitPattern=SuitPatternsEnum.Straight;
    }

    @Override
    public SuitPatternsEnum getSuitPattern() {
        return suitPattern;
    }

    @Override
    public Integer getWeight() {
        return weight;
    }

    @Override
    public void setWeight(ArrayList<PorkEntity> porkEntities) {
        if(porkEntities==null)
            throw new PorkException("Input can not be null");
        if(check(porkEntities)==null)
            return;
        weight=check(porkEntities).getValue();
    }

    @Override
    public void setSuitPattern(SuitPatternsEnum suitPattern) {
        this.suitPattern=suitPattern;
    }

    public Pair<SuitPatternsEnum,Integer> check(ArrayList<PorkEntity> porks) {
        if(porks==null)
            return null;
        if(porks.size()<5)
            return null;
        Collections.sort(porks);
        PorkEntity preEntity=porks.get(0);
        if(!groupCan(preEntity))
            return null;
        for(int i =1;i<porks.size();i++){
            if(!groupCan(porks.get(i)))
                return null;
            if(porks.get(i).getPoint()-preEntity.getPoint()!=1)
                return null;
            preEntity=porks.get(i);
        }
        return new Pair<>(null,porks.get(0).getWeight());
    }
}

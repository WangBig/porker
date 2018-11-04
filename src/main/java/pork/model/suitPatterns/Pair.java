package pork.model.suitPatterns;

import pork.model.data.SuitPatterns;
import pork.model.data.SuitPatternsEnum;
import pork.model.pork.PorkEntity;

import java.util.ArrayList;

public class Pair extends SuitPatterns {
    private SuitPatternsEnum suitPattern;
    private Integer weight;

    public Pair() {
        this.suitPattern=SuitPatternsEnum.Pair;
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
        javafx.util.Pair<SuitPatternsEnum,Integer> result = check(porkEntities);
        if(result==null)
            return;
        weight=result.getValue();
    }

    @Override
    public void setSuitPattern(SuitPatternsEnum suitPattern) {
        this.suitPattern=suitPattern;
    }

    public javafx.util.Pair<SuitPatternsEnum,Integer> check(ArrayList<PorkEntity> porks) {
        if(porks.size()!=2){
            return null;
        }
        if(porks.get(0).getPoint()!=porks.get(1).getPoint()){
            return null;
        }
        return new javafx.util.Pair<>(null,porks.get(0).getWeight());
    }
}

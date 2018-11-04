package pork.model.suitPatterns;

import javafx.util.Pair;
import lombok.Data;
import pork.Exception.PorkException;
import pork.model.data.SuitPatterns;
import pork.model.data.SuitPatternsEnum;
import pork.model.pork.PorkEntity;

import java.util.ArrayList;
import java.util.Collections;

public class ShiftedParis extends SuitPatterns {
    private SuitPatternsEnum suitPattern;
    private Integer weight;

    public ShiftedParis() {
        suitPattern=SuitPatternsEnum.ShiftedPairs;

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
        Pair<SuitPatternsEnum,Integer> result = check(porkEntities);
        if(result==null)
            return;
        weight=result.getValue();
    }

    @Override
    public void setSuitPattern(SuitPatternsEnum suitPattern) {
        this.suitPattern=suitPattern;
    }

    @Override
    public Pair<SuitPatternsEnum,Integer> check(ArrayList<PorkEntity> porks) {
        if(porks.size()<6)
            return null;
        Collections.sort(porks);
        for(int i=0;i<porks.size()-2;i=i+2){
            for(int j=0;j<4;j++){
                if(!groupCan(porks.get(i+j)))
                    return null;
            }
            if(porks.get(i).getPoint()!=porks.get(i+1).getPoint()||porks.get(i+2).getPoint()!=porks.get(i+3).getPoint())
                return null;
            if(porks.get(i+2).getPoint()-porks.get(i+1).getPoint()!=1)
                return null;
        }
        return new Pair(null,porks.get(0).getWeight());
    }
}

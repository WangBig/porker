package pork.model.suitPatterns;

import javafx.util.Pair;
import lombok.Data;
import pork.Exception.PorkException;
import pork.model.data.SuitPatterns;
import pork.model.data.SuitPatternsEnum;
import pork.model.pork.PorkEntity;

import java.util.*;

import static pork.model.data.SuitPatternsEnum.*;

@Data
public class TripletOnly extends SuitPatterns{

    private SuitPatternsEnum suitPattern;
    private Integer weight;

    public TripletOnly() {
        suitPattern=TripletOnly;
    }

    @Override
    public Integer getWeight() {
        return weight;
    }


    @Override
    public SuitPatternsEnum getSuitPattern() {
        return suitPattern;
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

    public Pair<SuitPatternsEnum,Integer> check(ArrayList<PorkEntity> porks) {

        if(porks.size()!=3)
            return null;
        if (porks.get(0).getPoint()!=porks.get(1).getPoint()||porks.get(1).getPoint()!=porks.get(2).getPoint())
                return null;
        return new Pair<>(null,porks.get(0).getWeight());
    }
}

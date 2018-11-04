package pork.model.suitPatterns;

import javafx.util.Pair;
import pork.Exception.PorkException;
import pork.model.data.SuitPatterns;
import pork.model.data.SuitPatternsEnum;
import pork.model.pork.PorkEntity;

import java.util.ArrayList;

import static pork.model.data.SuitPatternsEnum.Single;

public class Single extends SuitPatterns {
    private ArrayList<PorkEntity> ps ;
    private SuitPatternsEnum suitPattern;
    private Integer weight;
    @Override
    public SuitPatternsEnum getSuitPattern() {
        return suitPattern;
    }

    public Single() {
      suitPattern=Single;
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

    public Pair<SuitPatternsEnum,Integer> check(ArrayList<PorkEntity> porks) {
        if(porks.size()!=1||porks==null)
            return null;
        return new Pair<>(null,porks.get(0).getWeight());
    }

}

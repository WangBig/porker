package pork.model.suitPatterns;

import javafx.util.Pair;
import pork.Exception.PorkException;
import pork.model.data.SuitPatterns;
import pork.model.data.SuitPatternsEnum;
import pork.model.pork.PorkEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TripletWithSingle extends SuitPatterns {
    private SuitPatternsEnum suitPattern;
    private Integer weight;

    public TripletWithSingle() {
        suitPattern=SuitPatternsEnum.TripletWithSingle;
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
    public void setWeight(ArrayList<PorkEntity> porks) {
        if(porks==null)
            throw new PorkException("Input can not be null");
        Pair<SuitPatternsEnum,Integer> result = check(porks);
        if(result==null)
            return;
        weight=result.getValue();
    }

    @Override
    public void setSuitPattern(SuitPatternsEnum suitPattern) {

    }

    @Override
    public Pair<SuitPatternsEnum,Integer> check(ArrayList<PorkEntity> porks) {
        if(porks.size()!=4)
            return null;
        Map<Integer,Integer> porkEntityMap = new HashMap<>();
        for (PorkEntity p : porks){
            Integer pCount= porkEntityMap.get(p.getWeight());
            if(pCount==null){
                porkEntityMap.put(p.getWeight(),1);
            }else{
                porkEntityMap.put(p.getWeight(),++pCount);
            }
        }
        int porkEntityMapSize = porkEntityMap.size();
        if(porkEntityMapSize>2)
            return null;
        Integer weight =null;
        for(Map.Entry<Integer,Integer> entry:porkEntityMap.entrySet()){
            int porkCount =entry.getValue();
            if(porkCount==3){
                weight=entry.getKey();
            };
        }
        if(weight==null)
            return null;
        return new Pair<>(null,weight);
    }
}

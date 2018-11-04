package pork.model.suitPatterns;

import javafx.util.Pair;
import pork.Exception.PorkException;
import pork.model.data.Suit;
import pork.model.data.SuitPatterns;
import pork.model.data.SuitPatternsEnum;
import pork.model.pork.PorkEntity;

import java.util.ArrayList;

public class KingAndQueen extends SuitPatterns{

    private Integer weight;
    private SuitPatternsEnum suitPattern;


    public KingAndQueen() {
        suitPattern=SuitPatternsEnum.KingAndQueen;
    }

    @Override
    public SuitPatternsEnum getSuitPattern() {
        return SuitPatternsEnum.KingAndQueen;
    }

    @Override
    public Integer getWeight() {
        return weight;
    }

    @Override
    public void setWeight(ArrayList<PorkEntity> porkEntities) {
       Pair<SuitPatternsEnum,Integer> result= check(porkEntities);
       if (result==null)
           return;
       weight=999;
    }

    @Override
    public void setSuitPattern(SuitPatternsEnum suitPattern) {
        this.suitPattern=suitPattern;
    }

    @Override
    public Pair<SuitPatternsEnum,Integer> check(ArrayList<PorkEntity> porks) {
        if (porks.size()!=2)
            return null;
        for(PorkEntity p: porks){
            if(p.getWeight()<998) return null;
        }
        return  new Pair<>(null,998);
    }
}

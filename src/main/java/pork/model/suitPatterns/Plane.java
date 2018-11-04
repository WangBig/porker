package pork.model.suitPatterns;
import javafx.util.Pair;
import pork.Exception.PorkException;
import pork.model.data.SuitPatterns;
import pork.model.data.SuitPatternsEnum;
import pork.model.pork.PorkEntity;

import java.util.*;

public class Plane extends SuitPatterns {

    private SuitPatternsEnum suitPattern;
    private Integer weight;
    private SuitPatternsEnum subSuitPattern;

    public Plane() {
        subSuitPattern=SuitPatternsEnum.Plane;
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
        subSuitPattern=result.getKey();
    }

    @Override
    public void setSuitPattern(SuitPatternsEnum suitPattern) {
        this.suitPattern=suitPattern;
    }

    @Override
    public Pair<SuitPatternsEnum,Integer> check(ArrayList<PorkEntity> porks) {
        if(porks.size()<6||porks.size()%3!=0||porks.size()%4!=0||porks.size()%5!=0)
            return  null;
        Map<Integer,Integer> porksMap = new HashMap<>();
        for (PorkEntity p : porks){
            if(porksMap.get(p.getWeight())==null)
                porksMap.put(p.getWeight(),1);
            else
                porksMap.put(p.getWeight(),porksMap.get(p.getWeight())+1);
        }
        ArrayList<Integer> triplets = new ArrayList<>();
        Map<Integer,Integer> tails = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry:porksMap.entrySet()){
            if(entry.getKey()==3){
                triplets.add(entry.getKey());
            }else{
                tails.put(entry.getKey(),entry.getValue());
            }

        }
        if (triplets.size()<2)
            return null;
        Collections.sort(triplets);

        for(int m=0;m<triplets.size();m++){
            if(triplets.get(m)==1||triplets.get(m)==2)
                return null;
        }

        Integer weight=triplets.get(0);

        for(int i=0 ;i <triplets.size()-1;i++){
            if(triplets.get(i+1)-triplets.get(i)!=1){
                return null;
            }
        }

        int remindCount = porks.size()-triplets.size()*3;
        SuitPatternsEnum type = null;
        if(triplets.size()*2==remindCount){
            for(Map.Entry<Integer,Integer> e:tails.entrySet()){
                if(e.getValue()!=2)
                    return null;
            }
            type =SuitPatternsEnum.TripletWithPair;
        }else  if(remindCount==0)
            type =SuitPatternsEnum.TripletOnly;
        else
            type = SuitPatternsEnum.TripletWithSingle;
        return new Pair<>(type,weight);

    }
}

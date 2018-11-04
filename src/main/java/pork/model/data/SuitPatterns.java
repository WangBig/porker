package pork.model.data;

import javafx.util.Pair;
import pork.Exception.PorkException;
import pork.model.pork.PorkEntity;

import java.util.ArrayList;

public abstract class  SuitPatterns implements Comparable<SuitPatterns>  {
      public abstract SuitPatternsEnum getSuitPattern();
      public abstract Integer getWeight();
      public abstract void setWeight(ArrayList<PorkEntity> porkEntities);
      public abstract void setSuitPattern(SuitPatternsEnum suitPattern);
      public abstract Pair<SuitPatternsEnum,Integer> check(ArrayList<PorkEntity> ps);

    @Override
    public int compareTo(SuitPatterns o) {
        if (this.getSuitPattern()==SuitPatternsEnum.KingAndQueen)
            return 1;
        if(o.getSuitPattern()==SuitPatternsEnum.KingAndQueen)
            return -1;
        if(this.getSuitPattern()!=SuitPatternsEnum.Bomb &&o.getSuitPattern()==SuitPatternsEnum.Bomb)
            return -1;
        if(this.getSuitPattern()==SuitPatternsEnum.Bomb &&o.getSuitPattern()!=SuitPatternsEnum.Bomb)
            return 1;
        if (this.getSuitPattern()==o.getSuitPattern()){
            return this.getWeight()-o.getWeight();
        }else
            return 1;
    }

    public static boolean groupCan(PorkEntity p){
        if(p.getSuit()==Suit.King||p.getSuit()==Suit.Queen||p.getPoint()==1||p.getPoint()==2)
            return false;
        return true;
    }
}

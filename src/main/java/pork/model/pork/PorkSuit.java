package pork.model.pork;

import pork.model.data.Suit;

import java.util.ArrayList;
import java.util.Random;

public class PorkSuit {
    private ArrayList<PorkEntity> porks=new ArrayList<>();

    public PorkSuit() {
        for (Suit suit : Suit.values()){
            if (suit.getFlag()==0){
                for(int i=1;i<14;i++){
                    porks.add(new PorkEntity(i,suit));
                }
            }
        }
        porks.add(new PorkEntity(16,Suit.Queen));
        porks.add(new PorkEntity(17,Suit.King));
    }

    public PorkEntity getAnPork(){
        Random random = new Random();
        int size = porks.size();
        PorkEntity p= porks.remove(random.nextInt(size));
        return p;
    }

    public int  remained(){
        return porks.size();
    }

}

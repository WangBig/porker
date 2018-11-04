package pork.service;

import pork.model.data.Suit;
import pork.model.data.SuitPatterns;
import pork.model.data.SuitPatternsEnum;
import pork.model.pork.PorkEntity;
import pork.model.pork.PorkSuit;

import java.util.ArrayList;

public class SuitePatternsCheck {
    public SuitPatterns patternsCheck(ArrayList<PorkEntity> porks){
        SuitPatterns suite=null;
        for(SuitPatternsEnum e:SuitPatternsEnum.values()){
            try {
                SuitPatterns suitPattern=(SuitPatterns) e.getType().newInstance();
                if(suitPattern.check(porks)!=null){
                    suite=(SuitPatterns) e.getType().newInstance();
                    suite.setWeight(porks);
                    break;
                }
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }
        return suite;

    }

    public static void main(String[] args) {
        PorkSuit porkSuit = new PorkSuit();
        ArrayList<PorkEntity> a = new ArrayList<>();
        a.add(new PorkEntity(13,Suit.Diamonds));
        a.add(new PorkEntity(13,Suit.Hearts));
        a.add(new PorkEntity(12,Suit.Spade));
        a.add(new PorkEntity(12,Suit.Spade));
        a.add(new PorkEntity(11,Suit.Spade));
        a.add(new PorkEntity(11,Suit.Spade));
        //a.add(new PorkEntity(9,Suit.Diamonds));
        ArrayList<PorkEntity> b = new ArrayList<>();
        b.add(new PorkEntity(7,Suit.Spade));
        b.add(new PorkEntity(8,Suit.Spade));
        b.add(new PorkEntity(3,Suit.Spade));
        b.add(new PorkEntity(4,Suit.Spade));
        b.add(new PorkEntity(5,Suit.Spade));
        b.add(new PorkEntity(6,Suit.Spade));

        SuitePatternsCheck check = new SuitePatternsCheck();
        SuitPatterns suitea= check.patternsCheck(a);
        SuitPatterns suiteb=check.patternsCheck(b);
        System.out.println(suitea);
        System.out.println(suiteb);
        System.out.println(suitea.compareTo(suiteb));

    }

}


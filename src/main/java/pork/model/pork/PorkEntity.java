package pork.model.pork;

import pork.model.data.Suit;

public class PorkEntity implements Comparable<PorkEntity>{
    private Suit suit;
    private Integer point;
    private Integer weight;

    public PorkEntity(Suit suit, int point) {
        this.suit = suit;
        this.point = point;
    }

    public PorkEntity(int point, Suit suit) {
        this.suit = suit;
        this.point = point;
        if (point==1||point==2){
            weight=point+13;
        }else {
            weight= point;
        }
        if(suit==Suit.King)
            weight=999;
        if(suit==Suit.Queen)
            weight=998;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(PorkEntity o) {
        return this.getWeight()-o.getWeight();
    }

    @Override
    public String toString() {
        return "PorkEntity{" +
                "suit=" + suit +
                ", point=" + point +
                '}';
    }
}

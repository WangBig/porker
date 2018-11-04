package pork.service;
import org.springframework.stereotype.Service;
import pork.model.data.ActorEnum;
import pork.model.data.Player;
import pork.model.pork.PorkEntity;
import pork.model.pork.PorkSuit;

import java.util.ArrayList;

@Service
public class newRound {

    public void start(){
        PorkSuit porkSuit = new PorkSuit();
        ArrayList<ArrayList<PorkEntity>> dealResult= deal(porkSuit);
        Player landlord=new Player(ActorEnum.Landlord);
        Player farmerA = new Player(ActorEnum.farmer);
        Player farmerB = new Player(ActorEnum.farmer);
        landlord.setPorkes(dealResult.get(0));
        landlord.getPorkes().addAll(dealResult.get(3));
        farmerA.setPorkes(dealResult.get(1));
        farmerB.setPorkes(dealResult.get(2));
    }



    private  ArrayList<ArrayList<PorkEntity>> deal(PorkSuit porkSuit){
        ArrayList<ArrayList<PorkEntity>> result =
                new ArrayList<>();
        ArrayList<PorkEntity> cards1 = new ArrayList<>();
        ArrayList<PorkEntity> cards2 = new ArrayList<>();
        ArrayList<PorkEntity> cards3 = new ArrayList<>();
        ArrayList<PorkEntity> holeCards = new ArrayList<>();

        while (porkSuit.remained()>3){
            cards1.add(porkSuit.getAnPork());
            cards2.add(porkSuit.getAnPork());
            cards3.add(porkSuit.getAnPork());
        }
        while (porkSuit.remained()>0){
            holeCards.add(porkSuit.getAnPork());
        }
        result.add(cards1);
        result.add(cards2);
        result.add(cards3);
        result.add(holeCards);
        return result;
    }

    public static void main(String[] args) {
        newRound round = new newRound();
        round.start();

    }
}

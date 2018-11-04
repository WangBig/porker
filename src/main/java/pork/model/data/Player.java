package pork.model.data;

import pork.model.pork.PorkEntity;

import java.util.ArrayList;

public class Player {
    private ActorEnum actor;
    ArrayList<PorkEntity> porkes=new ArrayList();

    public Player(ActorEnum actor) {
        this.actor = actor;
    }

    public ActorEnum getActor() {
        return actor;
    }

    public void setActor(ActorEnum actor) {
        this.actor = actor;
    }

    public ArrayList<PorkEntity> getPorkes() {
        return porkes;
    }

    public void setPorkes(ArrayList<PorkEntity> porkes) {
        this.porkes = porkes;
    }
}

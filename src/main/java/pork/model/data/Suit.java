package pork.model.data;

public enum Suit {
    Spade("Spade","黑桃",0,0),Hearts("Hearts","红桃",1,0),Club("Club","梅花",2,0), Diamonds("Diamonds","方块",3,0),King("King","大王",4,1),Queen("Queen","小王",5,1);
    private String englishName;
    private String chineseName;
    private int id;
    private int flag;

    private Suit (String englishName,String chineseName,int id,int flag){
        this.chineseName=chineseName;
        this.englishName=englishName;
        this.id=id;
        this.flag=flag;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

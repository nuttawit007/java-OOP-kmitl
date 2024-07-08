package FootballPlayer2;
public class FootballPlayer extends Player{ // extends >> การสืบทอด
    private int playerNumber;
    private String position;
    
    public void setPlayerNumber (int n){
        playerNumber = n;
    }
    
    public int getPlayerNumber (){
        return playerNumber;
    }
    
    public void setPosition (String p){
        position = p;
    }
    
    public String getPosition (){
        return position;
    }
    
    public boolean isSamePosition (FootballPlayer p){
        if (this.position == p.position){
            return true;
        } else {
            return false;
        }
        
    }

//    // 2.1
//    public boolean isSamePosition (FootballPlayer p){
//        if ((p.getPosition().equals(this.getPosition())) & (p.getTeam().equals(this.getTeam()))){
//            return true;
//        } else {
//            return false;
//        }
//    }

//    // 2.2
//    public boolean isSamePosition (FootballPlayer p){
//        if ((p.getPosition().equals(this.position)) & (p.getTeam().equals(this.team))){
//            return true;
//        } else {
//            return false;
//        }
//    }
}

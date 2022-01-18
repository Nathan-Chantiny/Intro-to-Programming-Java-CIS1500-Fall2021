package finalproject;

import static finalproject.FinalProject.room;
import java.util.Random;

public class NPC {
    
    private int monsterHitPoints;
    private int monsterStrength;
    private int monsterDexterity;
    private int monsterIntelligence;

    public NPC() {
        monsterHitPoints = randomNumber(6) + 1;
        monsterStrength = monsterHitPoints * 2;
        monsterDexterity = monsterHitPoints * 2;
        monsterIntelligence = monsterHitPoints * 2;
    }
    
    public int getMonsterHitPoints() {
        return monsterHitPoints;
    }

    public int getMonsterStrength() {
        return monsterStrength;
    }

    public int getMonsterDexterity() {
        return monsterDexterity;
    }

    public int getMonsterIntelligence() {
        return monsterIntelligence;
    }

    public void setMonsterHitPoints(int monsterHitPoints) {
        this.monsterHitPoints = monsterHitPoints;
    }

    public void setMonsterStrength(int monsterStrength) {
        this.monsterStrength = monsterStrength;
    }

    public void setMonsterDexterity(int monsterDexterity) {
        this.monsterDexterity = monsterDexterity;
    }

    public void setMonsterIntelligence(int monsterIntelligence) {
        this.monsterIntelligence = monsterIntelligence;
    }
    
    public void applyITEM3Effect() {
        setMonsterIntelligence(-1);
    }
    
    public void applyITEM5Effect() {
        setMonsterStrength(-1);
    }
    
    public void applyITEM6Effect() {
        setMonsterDexterity(-1);
    }
    
    public void applyITEM7Effect() {
        setMonsterStrength(-1);
        setMonsterDexterity(-1);
        setMonsterIntelligence(-1);
    }
    
    public void applyITEM8Effect() {
        if (room.isIsThereAMonster()) {
            setMonsterHitPoints(0);
            room.setIsThereAMonster(false);
        } else {
            System.out.println("There is no monster");
        }
    }
    
    private int randomNumber(int i) {
        Random rNG = new Random();

        int number = rNG.nextInt(i);

        return number;
    }
}

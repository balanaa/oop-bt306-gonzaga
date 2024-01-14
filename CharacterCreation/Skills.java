package CharacterCreation;

import java.util.Scanner;
import java.util.InputMismatchException;

abstract class PlayerSkills {
    Scanner input = new Scanner(System.in);
    protected String pitchingSkill;
    protected String battingSkill;
    protected String fieldingSkill;
    protected static final String BOLD = "\u001B[1m";
    protected static final String UNDERLINE = "\u001B[4m";
    protected static final String RESET = "\u001B[0m";

    public PlayerSkills(String pitchingSkill, String battingSkill, String fieldingSkill) {
        this.pitchingSkill = pitchingSkill;
        this.battingSkill = battingSkill;
        this.fieldingSkill = fieldingSkill;
    }

    public abstract void setSkill(String skill);
    public abstract String getSkill();
    public abstract void handleSkills();
    public abstract boolean skillConfirmation( String skill, String skillDescription);
}
class PitchingSkill extends PlayerSkills{

    public PitchingSkill(String pitchingSkill, String battingSkill, String fieldingSkill) {
        super(pitchingSkill, battingSkill, fieldingSkill);
    }

    public void setSkill(String pitchingSkill) {
        this.pitchingSkill = pitchingSkill;
    }
    public String getSkill(){
        return pitchingSkill;
    }
    public void handleSkills() {
        boolean pitchingSkillsLoop = true;
        String pitchingSkill = "";
        String pitchingSkillDescription = "";
        while (pitchingSkillsLoop) {
            try{
                System.out.printf(BOLD+UNDERLINE+"%13sPITCHING SKILLS%17s\n", "",RESET);
                System.out.println("1: Bull's Eye");
                System.out.println("2: Jack of All Trades");
                System.out.println("3: Ace Pitcher");
                System.out.println("4: Go Back to Skill Menu");
                int pitchingSkillChoice = input.nextInt();
                
                switch (pitchingSkillChoice) {
                    case 1:
                        pitchingSkill = "Bull's Eye";
                        pitchingSkillDescription = "See the current batter's weakness in the strike zone";
                        break;
                    case 2:
                        pitchingSkill = "Jack of All Trades";
                        pitchingSkillDescription = "Get all the Pitching Styles for an entire inning";
                        break;
                    case 3:
                        pitchingSkill = "Ace Pitcher";
                        pitchingSkillDescription = "Gain 1+ point on Pitching Attributes after every consecutive strike-outs ";
                        break;
                    case 4:
                        return;
                    default:
                    System.out.println("Invalid Input (1-4)");                
                    continue;
                }
                if(skillConfirmation(pitchingSkill, pitchingSkillDescription)){
                    pitchingSkillsLoop = false;
                }
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }
    }
    public boolean skillConfirmation(String pitchingSkill, String pitchingSkillDescription){
        boolean confirm = true;
        boolean confirmLoop = true;
        while(confirmLoop){
        	System.out.println(BOLD+UNDERLINE+" "+ pitchingSkill+" "+RESET);
            System.out.println(pitchingSkillDescription);
            System.out.print("Press \'Y\' to confirm or enter any key to exit: ");
            char skillConfirm = input.next().toUpperCase().charAt(0);

            if (skillConfirm == 'Y'){
                setSkill(pitchingSkill);
                System.out.println("Pitching Skill set to: " + getSkill());
                confirm = true;
            } else {
                confirm = false;
            }
            confirmLoop = false; 
        }
        return confirm;
    }
}

class BattingSkill extends PlayerSkills{

    public BattingSkill(String pitchingSkill, String battingSkill, String fieldingSkill) {
        super(pitchingSkill, battingSkill, fieldingSkill);
    }
    public void setSkill(String battingSkill) {
        this.battingSkill = battingSkill;
    }
    public String getSkill(){
        return battingSkill;
    }
    public void handleSkills() {
        boolean battingSkillsLoop = true;
        String battingSkill = "";
        String battingSkillDescription = "";
        while (battingSkillsLoop) {
            try{
            	System.out.printf(BOLD+UNDERLINE+"%15sBATTING SKILLS%16s\n", "",RESET);
                System.out.println("1: Warming-Up");
                System.out.println("2: Pot of Gold");
                System.out.println("3: Eagle Eye");
                System.out.println("4: Go Back to Skill Menu");
                int battingSkillChoice = input.nextInt();
                switch (battingSkillChoice) {
                    case 1:
                        battingSkill = "Warming-Up";
                        battingSkillDescription = "Increase Power every successful hit as a batter";
                        break;
                    case 2:
                        battingSkill = "Pot of Gold";
                        battingSkillDescription = "+15 Luck after a home-run";
                        break;
                    case 3:
                        battingSkill = "Eagle Eye";
                        battingSkillDescription = "See where the ball will hit the strike zone";
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid Input (1-4)");
                        continue;
                }
                if(skillConfirmation(battingSkill, battingSkillDescription)){
                    battingSkillsLoop = false;
                }
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }
    }
    public boolean skillConfirmation(String battingSkill, String battingSkillDescription){
        boolean confirm = true;
        boolean confirmLoop = true;
        while(confirmLoop){
        	System.out.println(BOLD+UNDERLINE+" "+ battingSkill+" "+RESET);
            System.out.println(battingSkillDescription);
            System.out.print("Press \'Y\' to confirm or enter any key to exit: ");
            char skillConfirm = input.next().toUpperCase().charAt(0);

            if (skillConfirm == 'Y'){
                setSkill(battingSkill);
                System.out.println("Batting Skill set to: " + getSkill());
            confirm = true;
            } else {
                confirm = false;
            }
            confirmLoop = false; 
        }
        return confirm;
    }
}

class FieldingSkill extends PlayerSkills{

    public FieldingSkill(String pitchingSkill, String battingSkill, String fieldingSkill) {
        super(pitchingSkill, battingSkill, fieldingSkill);
    }
    public void setSkill(String fieldingSkill) {
        this.fieldingSkill = fieldingSkill;
    }
    public String getSkill(){
        return fieldingSkill;
    }
    public void handleSkills() {
        boolean fieldingSkillsLoop = true;
        String fieldingSkill = "";
        String fieldingSkillDescription = "";
        while (fieldingSkillsLoop) {
            try{
            	System.out.printf(BOLD+UNDERLINE+"%13sFIELDING SKILLS%17s\n", "",RESET);
                System.out.println("1: Speedster");
                System.out.println("2: Psychic");
                System.out.println("3: Buff Me Up");
                System.out.println("4: Go Back to Skill Menu");
                int fieldingSkillChoice = input.nextInt();
                
                switch (fieldingSkillChoice) {
                    case 1:
                        fieldingSkill = "Speedster";
                        fieldingSkillDescription = "+10 Running Speed last up to 3 Batters";
                        break;
                    case 2:
                        fieldingSkill = "Psychic";
                        fieldingSkillDescription = "See the ball's right after a hit Landing Point";
                        break;
                    case 3:
                        fieldingSkill = "Buff Me Up";
                        fieldingSkillDescription = "Throw the ball from Outer Field to Catcher";
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid Input (1-4)");
                        continue;
                }
                if(skillConfirmation(fieldingSkill, fieldingSkillDescription)){
                   fieldingSkillsLoop = false; 
                }
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }
    }
    public boolean skillConfirmation(String fieldingSkill, String fieldingSkillDescription){
        boolean confirm = true;
        boolean confirmLoop = true;
        while(confirmLoop){
        	System.out.println(BOLD+UNDERLINE+" "+ fieldingSkill+" "+RESET);
            System.out.println(fieldingSkillDescription);
            System.out.print("Press \'Y\' to confirm or enter any key to exit: ");
            char skillConfirm = input.next().toUpperCase().charAt(0);

            if (skillConfirm == 'Y'){
                setSkill(fieldingSkill);
                System.out.println("Fielding Skill set to: " + getSkill());
                confirm = true;
            } else {
                confirm = false;
            }
            confirmLoop = false; 
        }
        return confirm; 
    }
}

class Skills{
    Scanner input = new Scanner(System.in);
    PitchingSkill pitching;
    BattingSkill batting;
    FieldingSkill fielding;
    private static final String BOLD = "\u001B[1m";
    private static final String UNDERLINE = "\u001B[4m";
    private static final String RESET = "\u001B[0m";

    public Skills(String pitchingSkill, String battingSkill, String fieldingSkill) {
        this.pitching = new PitchingSkill(pitchingSkill, battingSkill, fieldingSkill);
        this.batting = new BattingSkill(pitchingSkill, battingSkill, fieldingSkill);
        this.fielding = new FieldingSkill(pitchingSkill, battingSkill, fieldingSkill);
    }

    public void showSkills(String playerPosition){
    	System.out.printf(BOLD+UNDERLINE+"%17sSKILLS%22s\n", "",RESET);
        if (playerPosition == "[P] Pitcher"){
        	System.out.printf("Pitching Skill%7s%18s\n", ":", pitching.getSkill());
        }else{
        	System.out.printf("Batting Skill%8s%18s\n", ":", batting.getSkill());
        }
        System.out.printf("Fielding Skill%7s%18s\n", ":", fielding.getSkill());
    }    

    public void skillsMenu(String playerPosition){
        boolean skillMenuLoop = true;
        while (skillMenuLoop) {
            try{
            	System.out.printf(BOLD+UNDERLINE+"%17sSKILLS%22s\n", "",RESET);
                System.out.println("1: Pitching");
                System.out.println("2: Batting");
                System.out.println("3: Fielding");
                System.out.println("4: Show Values");
                System.out.println("5: Go Back to Main Menu");
                int skillMenuChoice = input.nextInt();
                switch (skillMenuChoice) {
                    case 1: 
                        if (playerPosition == "[P] Pitcher"){
                            pitching.handleSkills();
                            break; 
                        } else {
                            System.out.println("Player Type: Batter. Pitching Skills Unavailable");
                            continue;
                        }
                    case 2:
                        if (playerPosition == "[P] Pitcher"){
                            System.out.println("Player Type: Pitcher. Batting Skills Unavailable");
                            continue;
                        } else {
                            batting.handleSkills();
                            break;
                        }
                    case 3:
                        fielding.handleSkills();
                        break;
                    case 4:
                        showSkills(playerPosition);
                        break;
                    case 5:
                        skillMenuLoop = false;
                        break;
                    default:
                        System.out.println("Invalid Input (1-5)");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }
    }
}
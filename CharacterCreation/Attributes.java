package CharacterCreation;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

interface Attributes {

    void setPitchingAttributes();
    void setBattingAttributes();
    void setFieldingAttributes();
    int generateAttributePoints();

    int getBallControlPoints();
    int getPitchingSpeedPoints();
    int getStaminaPoints();
    int getBattingPowerPoints();
    int getBattingAccuracyPoints();
    int getBuntingPoints();
    int getAgilityPoints();
    int getReactionTimePoints();
    int getThrowingAccuracyPoints();
    int getThrowingRangePoints();

    void showAttributes(String fieldPosition);
}

interface AttributesHandler {
    Scanner input = new Scanner(System.in);

    void handleAttribute(PlayerAttributes playerAtt);
    void displayAttributeChoices(PlayerAttributes playerAtt);

}

class GeneralAttributes extends PlayerAttributes implements AttributesHandler {
    
    public void displayAttributeChoices(PlayerAttributes playerAtt) {
        System.out.println("Available Points: "+ "["+playerAtt.getPlayerPoints()+"]");
        System.out.println(BOLD+UNDERLINE+" GENERAL "+RESET);
        System.out.printf("1: Endurance%13s%7d\n",":", playerAtt.getEndurancePoints());
        System.out.printf("2: Luck%18s%7d\n", ":", playerAtt.getLuckPoints());
        System.out.printf("3: Running Speed%9s%7d\n",":", playerAtt.getRunningSpeedPoints());
        System.out.printf("4: Training Aptitude%5s%7d\n",":", playerAtt.getTrainingAptitudePoints());
        System.out.println("5: [⚄] Roll the Dice");
        System.out.println("6: Go Back to Attribute Menu");
    }

    public void handleAttribute(PlayerAttributes playerAtt) {
        boolean generalAttributeLoop = true;
        while (generalAttributeLoop) {
            try {
                displayAttributeChoices(playerAtt);
                int generalAttributeChoice = super.input.nextInt();

                switch (generalAttributeChoice) {
                case 1:
                    addPoints("Endurance", "Makes you last perform better for longer", playerAtt.getEndurancePoints(), playerAtt);
                    break;
                case 2:
                    addPoints("Luck", "Less likely to get a fly-out. Better prediction of the ball trajectory", playerAtt.getLuckPoints(), playerAtt);
                    break;
                case 3:
                    addPoints("Running Speed", "Easier to catch a fly-out. Faster progressing to bases.", playerAtt.getRunningSpeedPoints(), playerAtt);
                    break;
                case 4:
                    addPoints("Training Aptitude", "Easier to catch a fly-out. Faster progressing to bases.", playerAtt.getTrainingAptitudePoints(), playerAtt);
                    break;
                case 5:
                    playerAtt.setGeneralAttributes();
                    continue;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Input (1-6)");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                super.input.nextLine();
                continue;
            }
        }
    }
}
class PitchingAttributes extends PlayerAttributes implements AttributesHandler {

    public void displayAttributeChoices(PlayerAttributes playerAtt) {
        System.out.println("Available Points: "+ "["+playerAtt.getPlayerPoints()+"]");
        System.out.println(BOLD+UNDERLINE+" PITCHING "+RESET);
        System.out.printf("1: Ball Control%10s%7d\n",":", playerAtt.getBallControlPoints());
        System.out.printf("2: Pitching Speed%8s%7d\n",":", playerAtt.getPitchingSpeedPoints());
        System.out.printf("3: Stamina%15s%7d\n",":", playerAtt.getStaminaPoints());
        System.out.println("4: [⚄] Roll the Dice");
        System.out.println("5: Go Back to Attribute Menu");
    }

    public void handleAttribute(PlayerAttributes playerAtt) {
        boolean pitchingAttributeLoop = true;
        while (pitchingAttributeLoop) {
            try{
                displayAttributeChoices(playerAtt);
                int pitchingAttributeChoice = super.input.nextInt();
                switch (pitchingAttributeChoice) {
                case 1:
                    addPoints("Ball Control", "Improves control over the pitch trajectory.", playerAtt.getBallControlPoints(), playerAtt);
                    break;
                case 2:
                    addPoints("Pitching Speed", "Increases the speed of your pitches.", playerAtt.getPitchingSpeedPoints(), playerAtt);
                    break;
                case 3:
                    addPoints("Stamina", "Enhances your stamina for prolonged pitching sessions.", playerAtt.getStaminaPoints(), playerAtt);
                    break;
                case 4:
                    playerAtt.setPitchingAttributes();
                    continue;
                case 5:
                    return;
                default:
                    System.out.println("Invalid Input (1-5)");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                super.input.nextLine();
                continue;
            }
        }
    }
}

class BattingAttributes extends PlayerAttributes implements AttributesHandler {
    
    public void displayAttributeChoices(PlayerAttributes playerAtt) {
        System.out.println("Available Points: "+ "["+playerAtt.getPlayerPoints()+"]");
        System.out.println(BOLD+UNDERLINE+" BATTING "+RESET);
        System.out.printf("1: Batting Power%9s%7d\n",":", playerAtt.getBattingPowerPoints());
        System.out.printf("2: Batting Accuracy%6s%7d\n",":", playerAtt.getBattingAccuracyPoints());
        System.out.printf("3: Bunting%15s%7d\n",":", playerAtt.getBuntingPoints());
        System.out.println("4: [⚄] Roll the Dice");
        System.out.println("5: Go Back to Attribute Menu");
    }

    public void handleAttribute(PlayerAttributes playerAtt) {
        boolean battingAttributeLoop = true;
        while (battingAttributeLoop) {
            try{
                displayAttributeChoices(playerAtt);
                int battingAttributeChoice = super.input.nextInt();
                switch (battingAttributeChoice) {
                case 1:
                    addPoints("Batting Power", "Increases the power of your swings.", playerAtt.getBattingPowerPoints(), playerAtt);
                    break;
                case 2:
                    addPoints("Batting Accuracy", "Improves your accuracy in hitting the ball.", playerAtt.getBattingAccuracyPoints(), playerAtt);
                    break;
                case 3:
                    addPoints("Bunting", "Enhances your bunting skills.", playerAtt.getBuntingPoints(), playerAtt);
                    break;
                case 4:
                    playerAtt.setBattingAttributes();
                    continue;
                case 5:
                    return;
                default:
                    System.out.println("Invalid Input (1-5)");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                super.input.nextLine();
                continue;
            }
        }
    }
}

class FieldingAttributes extends PlayerAttributes implements AttributesHandler {

    public void displayAttributeChoices(PlayerAttributes playerAtt) {
        System.out.println("Available Points: "+ "["+playerAtt.getPlayerPoints()+"]");
        System.out.println(BOLD+UNDERLINE+" FIELDING "+RESET);
        System.out.printf("1: Agility%15s%7d\n",":", playerAtt.getAgilityPoints());
        System.out.printf("2: Reaction Time%9s%7d\n",":", playerAtt.getReactionTimePoints());
        System.out.printf("3: Throwing Accuracy%5s%7d\n",":", playerAtt.getThrowingAccuracyPoints());
        System.out.printf("4: Throwing Range%8s%7d\n",":", playerAtt.getThrowingRangePoints());
        System.out.println("5: [⚄] Roll the Dice");
        System.out.println("6: Go Back to Attribute Menu");
    }

    public void handleAttribute(PlayerAttributes playerAtt) {
        boolean fieldingAttributeLoop = true;
        while (fieldingAttributeLoop) {
            try{
                displayAttributeChoices(playerAtt);
                int fieldingAttributeChoice = super.input.nextInt();
                switch (fieldingAttributeChoice) {
                case 1:
                    addPoints("Agility", "Improves your overall agility on the field.", playerAtt.getAgilityPoints(), playerAtt);
                    break;
                case 2:
                    addPoints("Reaction Time", "Enhances your reaction time to make quick plays.", playerAtt.getReactionTimePoints(), playerAtt);
                    break;
                case 3:
                    addPoints("Throwing Accuracy", "Improves accuracy when throwing the ball.", playerAtt.getThrowingAccuracyPoints(), playerAtt);
                    break;
                case 4:
                    addPoints("Throwing Range", "Increases the distance you can throw the ball accurately.", playerAtt.getThrowingRangePoints(), playerAtt);
                    break;
                case 5:
                    playerAtt.setFieldingAttributes();
                    continue;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Input (1-6)");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                super.input.nextLine();
                continue;
            }
        }
    }
}



class PlayerAttributes implements Attributes{ 
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    final String BOLD = "\u001B[1m";
    final String UNDERLINE = "\u001B[4m";
    final String RESET = "\u001B[0m";

    private int playerPoints;
   
    private int endurancePoints;
    private int luckPoints;
    private int runningSpeedPoints;
    private int trainingAptitudePoints;

    private int ballControlPoints;
    private int pitchingSpeedPoints;
    private int staminaPoints;
    private int battingPowerPoints;
    private int battingAccuracyPoints;
    private int buntingPoints;
    private int agilityPoints;
    private int reactionTimePoints;
    private int throwingAccuracyPoints;
    private int throwingRangePoints;


    public PlayerAttributes() {
        if (endurancePoints == 0){
            setGeneralAttributes();
            setPitchingAttributes();
            setBattingAttributes();
            setFieldingAttributes();
        }
        playerPoints = 10;
    }

    public void setGeneralAttributes(){
        endurancePoints = generateAttributePoints();
        luckPoints = generateAttributePoints();
        runningSpeedPoints = generateAttributePoints();
        trainingAptitudePoints = generateAttributePoints();
    }
    public void setPitchingAttributes(){
        ballControlPoints = generateAttributePoints();
        pitchingSpeedPoints = generateAttributePoints();
        staminaPoints = generateAttributePoints();
    }
    public void setBattingAttributes(){
        battingPowerPoints = generateAttributePoints();
        battingAccuracyPoints = generateAttributePoints();
        buntingPoints = generateAttributePoints();
    }
    public void setFieldingAttributes(){
        agilityPoints = generateAttributePoints();
        reactionTimePoints = generateAttributePoints();
        throwingAccuracyPoints = generateAttributePoints();
        throwingRangePoints = generateAttributePoints();
    }

    public void setPlayerPoints(int deductPoints){
        this.playerPoints -= deductPoints;
    }
    public int getPlayerPoints(){
        return playerPoints;
    }

    public void setEndurancePoints(int endurancePoints) {
        this.endurancePoints = endurancePoints;
    }
    public int getEndurancePoints() {
        return endurancePoints;
    }

    public void setLuckPoints(int luckPoints) {
        this.luckPoints = luckPoints;
    }
    public int getLuckPoints() {
        return luckPoints;
    }

    public void setRunningSpeedPoints(int runningSpeedPoints) {
        this.runningSpeedPoints = runningSpeedPoints;
    }
    public int getRunningSpeedPoints() {
        return runningSpeedPoints;
    }

    public void setTrainingAptitudePoints(int trainingAptitudePoints) {
        this.trainingAptitudePoints = trainingAptitudePoints;
    }
    public int getTrainingAptitudePoints() {
        return trainingAptitudePoints;
    }

    public void setBallControlPoints(int ballControlPoints) {
        this.ballControlPoints = ballControlPoints;
    }
    public int getBallControlPoints() {
        return ballControlPoints;
    }

    public void setPitchingSpeedPoints(int pitchingSpeedPoints) {
        this.pitchingSpeedPoints = pitchingSpeedPoints;
    }
    public int getPitchingSpeedPoints() {
        return pitchingSpeedPoints;
    }

    public void setStaminaPoints(int staminaPoints) {
        this.staminaPoints = staminaPoints;
    }
    public int getStaminaPoints() {
        return staminaPoints;
    }

    public void setBattingPowerPoints(int battingPowerPoints) {
        this.battingPowerPoints = battingPowerPoints;
    }
    public int getBattingPowerPoints() {
        return battingPowerPoints;
    }

    public void setBattingAccuracyPoints(int battingAccuracyPoints) {
        this.battingAccuracyPoints = battingAccuracyPoints;
    }
    public int getBattingAccuracyPoints() {
        return battingAccuracyPoints;
    }

    public void setBuntingPoints(int buntingPoints) {
        this.buntingPoints = buntingPoints;
    }
    public int getBuntingPoints() {
        return buntingPoints;
    }

    public void setAgilityPoints(int agilityPoints) {
        this.agilityPoints = agilityPoints;
    }
    public int getAgilityPoints() {
        return agilityPoints;
    }

    public void setReactionTimePoints(int reactionTimePoints) {
        this.reactionTimePoints = reactionTimePoints;
    }
    public int getReactionTimePoints() {
        return reactionTimePoints;
    }

    public void setThrowingAccuracyPoints(int throwingAccuracyPoints) {
        this.throwingAccuracyPoints = throwingAccuracyPoints;
    }
    public int getThrowingAccuracyPoints() {
        return throwingAccuracyPoints;
    }

    public void setThrowingRangePoints(int throwingRangePoints) {
        this.throwingRangePoints = throwingRangePoints;
    }
    public int getThrowingRangePoints() {
        return throwingRangePoints;
    }


	public int generateAttributePoints(){
        int randomlyGeneratedPoints = rand.nextInt(10)+1;      
        return randomlyGeneratedPoints;
    }

    public void showAttributes(String playerPosition){
    	System.out.printf(BOLD+UNDERLINE+"%16sATTRIBUTES%19s\n", "",RESET);
        System.out.println(BOLD+"GENERAL"+RESET);
        System.out.printf("%3sEndurance%13s%7d\n", "",":", getEndurancePoints());
        System.out.printf("%3sLuck%18s%7d\n", "",":", getLuckPoints());
        System.out.printf("%3sRunning Speed%9s%7d\n", "",":", getRunningSpeedPoints());
        System.out.printf("%3sTraining Aptitude%5s%7d\n", "",":", getTrainingAptitudePoints());
        if (playerPosition == "[P] Pitcher") {
            System.out.println(BOLD+"PITCHING"+RESET);
            System.out.printf("%3sBall Control%10s%7d\n", "",":", getBallControlPoints());
            System.out.printf("%3sPitching Speed%8s%7d\n", "",":", getPitchingSpeedPoints());
            System.out.printf("%3sStamina%15s%7d\n", "",":", getStaminaPoints());
        } else {
            System.out.println(BOLD+"BATTING"+RESET);
            System.out.printf("%3sBatting Power%9s%7d\n", "",":", getBattingPowerPoints());
            System.out.printf("%3sBatting Accuracy%6s%7d\n", "",":", getBattingAccuracyPoints());
            System.out.printf("%3sBunting%15s%7d\n", "",":", getBuntingPoints());
        }
        System.out.println(BOLD+"FIELDING"+RESET);
        System.out.printf("%3sAgility%15s%7d\n", "",":", getAgilityPoints());
        System.out.printf("%3sReaction Time%9s%7d\n", "",":", getReactionTimePoints());
        System.out.printf("%3sThrowing Accuracy%5s%7d\n", "",":", getThrowingAccuracyPoints());
        System.out.printf("%3sThrowing Range%8s%7d\n", "",":", getThrowingRangePoints());
    }
    
    public void attributesMenu(String playerPosition){
        boolean attributeLoop = true;
        while (attributeLoop){
            try{
                this.setPlayerPoints(0);
                showAttributes(playerPosition);
                System.out.println("Available Points: "+ "["+this.getPlayerPoints()+"]");
                System.out.println("Which would you like to edit:"); 
                System.out.println("1: General");
                System.out.println("2: Pitching");
                System.out.println("3: Batting");
                System.out.println("4: Fielding");
                System.out.println("5: Go Back to Main Menu"); 
            
                int editCategoryChoice = input.nextInt();
                switch (editCategoryChoice) {
                case 1:
                    GeneralAttributes genAtt = new GeneralAttributes();
                    genAtt.handleAttribute(this);
                    break;
                case 2: 
                    if (playerPosition == "[P] Pitcher"){
                        PitchingAttributes pitAtt = new PitchingAttributes();
                        pitAtt.handleAttribute(this);
                        break; 
                    } else {
                        System.out.println("Player Type: Batter. Pitching Attributes Unavailable");
                        continue;
                    }
                case 3:
                    if (playerPosition == "[P] Pitcher"){
                        System.out.println("Player Type: Pitcher. Batting Attributes Unavailable");
                        continue;
                    } else {
                        BattingAttributes batAtt = new BattingAttributes();
                        batAtt.handleAttribute(this);
                        break;
                    }
                case 4:
                    FieldingAttributes fielAtt = new FieldingAttributes();
                    fielAtt.handleAttribute(this);
                    break;   
                case 5:
                    attributeLoop = false;
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

	public void addPoints(String attributeType, String attributeDescription, int attributePoints, PlayerAttributes playerAtt){
		boolean addPointsLoop = true;
		while (addPointsLoop) {
            try {
                System.out.println(attributeType+ ": " +attributePoints);
                System.out.println(attributeDescription);
                if (playerAtt.getPlayerPoints() > 0){
                    System.out.println("Available Points: "+ "["+playerAtt.getPlayerPoints()+"]");
                    System.out.println("How many points do you want to add?");
                    int addPoints = input.nextInt();
                    if (addPoints < 0){
                        System.out.println("Invalid Input. Cannot Add Negative");
                        continue;
                    } else if (playerAtt.getPlayerPoints() < addPoints){
                        System.out.println("Insufficient Points");
                        continue;
                    } else {
                        playerAtt.setPlayerPoints(addPoints);
                        switch (attributeType) {
                            case "Endurance":
                                playerAtt.setEndurancePoints(attributePoints + addPoints);
                                break;
                            case "Luck":
                                playerAtt.setLuckPoints(attributePoints + addPoints);
                                break;
                            case "Running Speed":
                                playerAtt.setRunningSpeedPoints(attributePoints + addPoints);
                                break;
                            case "Training Aptitude":
                                playerAtt.setTrainingAptitudePoints(attributePoints + addPoints);
                                break;
                            case "Ball Control":
                                playerAtt.setBallControlPoints(attributePoints + addPoints);
                                break;
                            case "Pitching Speed":
                                playerAtt.setPitchingSpeedPoints(attributePoints + addPoints);
                                break;
                            case "Stamina":
                                playerAtt.setStaminaPoints(attributePoints + addPoints);
                                break;
                            case "Batting Power":
                                playerAtt.setBattingPowerPoints(attributePoints + addPoints);
                                break;
                            case "Batting Accuracy":
                                playerAtt.setBattingAccuracyPoints(attributePoints + addPoints);
                                break;
                            case "Bunting":
                                playerAtt.setBuntingPoints(attributePoints + addPoints);
                                break;
                            case "Agility":
                                playerAtt.setAgilityPoints(attributePoints + addPoints);
                                break;
                            case "Reaction Time":
                                playerAtt.setReactionTimePoints(attributePoints + addPoints);
                                break;
                            case "Throwing Accuracy":
                                playerAtt.setThrowingAccuracyPoints(attributePoints + addPoints);
                                break;
                            case "Throwing Range":
                                playerAtt.setThrowingRangePoints(attributePoints + addPoints);
                                break;
                            default:
                                System.out.println("[DEBUG]: Typo");
                                continue;
                        }
                        System.out.println("Added "+ addPoints +" to "+attributeType);
                    }	
                } else {
                    System.out.println("No more points available");
                }
                addPointsLoop = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
		}
	}
}

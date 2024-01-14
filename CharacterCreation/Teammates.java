package CharacterCreation;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

class NPCAttributes implements Attributes{
    Random rand = new Random();
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String RESET = "\u001B[0m";
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
    
    public void showAttributes(String npcPosition){
        System.out.printf("     "+BOLD+UNDERLINE+"%10sATTRIBUTES%14s\n", "",RESET);
        if (npcPosition == "[P] Pitcher") {
            setPitchingAttributes();
            System.out.println("     "+BOLD+"PITCHING"+RESET);
            System.out.printf("       "+"Ball Control%9s%4d\n", ":", getBallControlPoints());
            System.out.printf("       "+"Pitching Speed%7s%4d\n", ":", getPitchingSpeedPoints());
            System.out.printf("       "+"Stamina%14s%4d\n", ":", getStaminaPoints());
        } else {
            setBattingAttributes();
            System.out.println("     "+BOLD+"BATTING"+RESET);
            System.out.printf("       "+"Batting Power%8s%4d\n", ":", getBattingPowerPoints());
            System.out.printf("       "+"Batting Accuracy%5s%4d\n", ":", getBattingAccuracyPoints());
            System.out.printf("       "+"Bunting%14s%4d\n", ":", getBuntingPoints());
        }
        System.out.println("     "+BOLD+"FIELDING"+RESET);
        setFieldingAttributes();
        System.out.printf("       "+"Agility%14s%4d\n", ":", getAgilityPoints());
        System.out.printf("       "+"Reaction Time%8s%4d\n", ":", getReactionTimePoints());
        System.out.printf("       "+"Throwing Accuracy%4s%4d\n", ":", getThrowingAccuracyPoints());
        System.out.printf("       "+"Throwing Range%7s%4d\n\n", ":", getThrowingRangePoints());
    }
    
    public void setPitchingAttributes(){
        this.ballControlPoints = generateAttributePoints();
        this.pitchingSpeedPoints = generateAttributePoints();
        this.staminaPoints = generateAttributePoints();
    }
    public void setBattingAttributes(){
        this.battingPowerPoints = generateAttributePoints();
        this.battingAccuracyPoints = generateAttributePoints();
        this.buntingPoints = generateAttributePoints();
    }
    public void setFieldingAttributes(){
        this.agilityPoints = generateAttributePoints();
        this.reactionTimePoints = generateAttributePoints();
        this.throwingAccuracyPoints = generateAttributePoints();
        this.throwingRangePoints = generateAttributePoints();
    }
    
    public int generateAttributePoints(){
        int randomlyGeneratedPoints = rand.nextInt(10)+1;
        return randomlyGeneratedPoints;
    }
    
    public int getBallControlPoints() { return ballControlPoints; }
    public int getPitchingSpeedPoints() { return pitchingSpeedPoints; }
    public int getStaminaPoints() { return staminaPoints; }

    public int getBattingPowerPoints() { return battingPowerPoints; }
    public int getBattingAccuracyPoints() { return battingAccuracyPoints; }
    public int getBuntingPoints() { return buntingPoints; }

    public int getAgilityPoints() { return agilityPoints; }
    public int getReactionTimePoints() { return reactionTimePoints; }
    public int getThrowingAccuracyPoints() { return throwingAccuracyPoints; }
    public int getThrowingRangePoints() { return throwingRangePoints; }
    
}


abstract class NPCFace {
    private String[][] npcFace = {
            {"=", " ", "="},
            {"0", " ", "0"},
            {" ", "<", " "},
            {" ", "_", " "}
    };

    public Random rand = new Random();

    public String[][] getNPCFace() {
        return npcFace;
    }

    public abstract String[] getEyebrowChoices();
    public abstract String[] getEyeChoices();
    public abstract String[] getNoseChoices();
    public abstract String[] getMouthChoices();

    public void setEyebrowsOnFace(String eyebrows) {
        getNPCFace()[0][0] = eyebrows;
        getNPCFace()[0][2] = eyebrows;
    }

    public void setEyesOnFace(String eyes) {
        getNPCFace()[1][0] = eyes;
        getNPCFace()[1][2] = eyes;
    }

    public void setNoseOnFace(String nose) {
        getNPCFace()[2][1] = nose;
    }

    public void setMouthOnFace(String mouth) {
        getNPCFace()[3][1] = mouth;
    }

    public void generateEyebrows() {
        int randomEyebrows = rand.nextInt(getEyebrowChoices().length);
        setEyebrowsOnFace(getEyebrowChoices()[randomEyebrows]);
    }

    public void generateEyes() {
        int randomEyes = rand.nextInt(getEyeChoices().length);
        setEyesOnFace(getEyeChoices()[randomEyes]);
    }

    public void generateNose() {
        int randomNose = rand.nextInt(getNoseChoices().length);
        setNoseOnFace(getNoseChoices()[randomNose]);
    }

    public void generateMouth() {
        int randomMouth = rand.nextInt(getMouthChoices().length);
        setMouthOnFace(getMouthChoices()[randomMouth]);
    }

    public void showNPCFace() {
        for (int y=0; y<4; y++){
            System.out.printf("%18s","");
            for(int x=0; x<3;x++){
                System.out.print(getNPCFace()[y][x]);
            }
            System.out.println();
        }
    }
}

class MaleNPC extends NPCFace {
    private String[] eyebrowChoices = {"^", "=", "‘", "_"};
    private String[] eyeChoices = {"◉", "╥", "◡", "❛", "ರ", "¬", "●"};
    private String[] noseChoices = {"C","<", ">", "└"};
    private String[] mouthChoices = {"﹃", "◡", "ヮ", "O", "□", "ᗣ", "ε" ,"︹"};
    
    public MaleNPC(){
        generateEyebrows();
        generateEyes();
        generateNose();
        generateMouth();
        showNPCFace();
    }

    public String[] getEyebrowChoices() {
        return eyebrowChoices;
    }
    public String[] getEyeChoices() {
        return eyeChoices;
    }
    public String[] getNoseChoices() {
        return noseChoices;
    }
    public String[] getMouthChoices() {
        return mouthChoices;
    }
}

class FemaleNPC extends NPCFace {
    private String[] eyebrowChoices = {"^", "=", "‘"};
    private String[] eyeChoices = {"⛣", "◕", "Ȍ", "ఠ", "Ӫ"};
    private String[] noseChoices = {"ʖ", "໒", "└"};
    private String[] mouthChoices = {"❥", "◡", "◡", "~"};
    
    public FemaleNPC(){
        generateEyebrows();
        generateEyes();
        generateNose();
        generateMouth();
        showNPCFace();
    }


    public String[] getEyebrowChoices() {
        return eyebrowChoices;
    }

    public String[] getEyeChoices() {
        return eyeChoices;
    }

    public String[] getNoseChoices() {
        return noseChoices;
    }

    public String[] getMouthChoices() {
        return mouthChoices;
    }
    
    public void generateMouth() {
        int randomMouth = rand.nextInt(getMouthChoices().length);
        setMouthOnFace("\u001B[91m"+ getMouthChoices()[randomMouth] +"\u001B[0m");
    }
}

class Teammates{
    Random rand = new Random();
    CharacterInformation info = new CharacterInformation();

    public String generateTeamPosition(){
        int randomPosition = rand.nextInt(info.getFieldPositions().length);
        return info.getFieldPositions()[randomPosition];
        
    }
    
    public String generateGender(){
        int randomGender = rand.nextInt(3);
        if (randomGender == 2){
            return "\u001B[48;2;255;145;234m[F]\u001B[0m";
        } else {
            return "\u001B[104m[M]\u001B[0m";
        }
    }
    
    public String generateName(String gender){
        int randomName = rand.nextInt(8);
        if (gender == "\u001B[104m[M]\u001B[0m"){
            ArrayList<String> maleNames = new ArrayList<>
            (Arrays.asList("John", "Mark", "Stephen", "David", "Michael", "Robert", "William", "Richard"));
            return maleNames.get(randomName);
        } else {
            ArrayList<String> femaleNames = new ArrayList<>
            (Arrays.asList("Maria", "Tiffany", "Sophie", "Emily", "Jessica", "Jennifer", "Melissa", "Linda"));
            return femaleNames.get(randomName);
        }
    }
    
    public void showTeammates(CharacterInformation info){
        ArrayList<String> printedPositions = new ArrayList<>();
        ArrayList<String> printedNames = new ArrayList<>();
        int printedTeammates = 0;
        String teammatePosition = generateTeamPosition();

        System.out.println("Generating teammates ...");
        
        while (printedTeammates < 8) {
            teammatePosition = generateTeamPosition();
            String teammateCurrentGender = generateGender();
            String teammateName = generateName(teammateCurrentGender);
            
            if (!(teammatePosition == info.getPlayerPosition()) && !printedPositions.contains(teammatePosition) && !printedNames.contains(teammateName)){
                printedPositions.add(teammatePosition);
                printedNames.add(teammateName);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
	            if (teammateCurrentGender == "\u001B[104m[M]\u001B[0m"){
	                new MaleNPC();
	            } else{
	                new FemaleNPC();
	            }
	            System.out.println("\n     \u001B[1m"+teammateCurrentGender + " \u001B[1m" +teammateName+"     "+teammatePosition+"\u001B[0m\n");
	            
                NPCAttributes npc = new NPCAttributes();
                npc.showAttributes(teammatePosition);
                printedTeammates++;
            }
            
        }
    }
}

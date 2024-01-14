package CharacterCreation;

import java.util.Scanner;
import java.util.InputMismatchException;

class CharacterInformation{
    Scanner input = new Scanner(System.in);
    private static final String BOLD = "\u001B[1m";
    private static final String UNDERLINE = "\u001B[4m";
    private static final String RESET = "\u001B[0m";
    private String playerName;
    private String characterGender;
    private String jerseyNumber;
    private String playerPosition;
    private String[] positions = {
        "[P] Pitcher",
        "[C] Catcher",
        "[1B] First Base", 
        "[2B] Second Base",
        "[3B] Third Base", 
        "[SS] Shortstop",
        "[LF] Left Field", 
        "[CF] Center Field",
        "[RF] Right Field" 
    };
       
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    public String getPlayerName(){
        return this.playerName;
    }
    public void handlePlayerName(){
        boolean playerNameLoop = true;
        input.nextLine();
        System.out.printf(BOLD+UNDERLINE+"%13sCHARACTER NAME%18s\n", "",RESET);
        while (playerNameLoop){
            System.out.print("Name your Character: ");
            String playerName = input.nextLine();
            if (validateName(playerName)){
               playerNameLoop = false; 
            }
  
        }
    }
    public boolean validateName(String playerName){
        try {
            for (int i = 0; i < playerName.length(); i++) {
                char currentChar = playerName.charAt(i);
                if (!Character.isLetter(currentChar)) {
                    if (Character.isDigit(currentChar)) {
                        throw new InvalidNumberException();
                    } else {
                        throw new InvalidSpecialCharacterException();
                    }
                }
            }   
            if (playerName.length() > 10) {
                throw new InvalidLengthException();
            }
            setPlayerName(playerName);
            System.out.println("Player Name set to: " + playerName);
            return true;
            } catch (InvalidLengthException ile) {
                System.out.println(ile.getMessage());
                return false;
            } catch (InvalidNumberException ine) {
                System.out.println(ine.getMessage());
                return false;
            } catch (InvalidSpecialCharacterException isce) {
                System.out.println(isce.getMessage());
                return false;
            } 
    }
    

    public void setCharacterGender(String characterGender){
        this.characterGender = characterGender;
    }
    public String getCharacterGender(){
        return characterGender;
    }

    public void handleCharacterGender(CharacterFace face){
        boolean genderLoop= true;
        while(genderLoop){
            try {
            	System.out.printf(BOLD+UNDERLINE+"%12sCHARACTER GENDER%17s\n", "",RESET);
                System.out.println("1: [♂] Masculine");
                System.out.println("2: [♀] Feminine");
                int genderChoice = input.nextInt();
                
                if (genderChoice == 1 ){
                    setCharacterGender("[♂] Masculine");
                    face.setFace("[♂] Masculine");
                } else if (genderChoice == 2){
                    setCharacterGender("[♀] Feminine");
                    face.setFace("[♀] Feminine");
                } else if (genderChoice < 0 || genderChoice  > 2 ) {
                    System.out.println("Invalid Input (1-2)");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
			System.out.println("Character Gender set to: "+getCharacterGender());
			genderLoop = false;
        }
    }
    
    public void setJerseyNumber(String jerseyNumber){
        this.jerseyNumber = jerseyNumber;
    }
    public String getJerseyNumber(){
        return jerseyNumber;
    }
    public void handleJerseyNumber() {
        boolean jerseyNumberLoop = true;
        input.nextLine();
        System.out.printf(BOLD+UNDERLINE+"%14sJERSEY NUMBER%18s\n", "",RESET);
        while (jerseyNumberLoop) {
            System.out.print("Enter Jersey Number: ");
            String jerseyNumberChoice = input.nextLine();

            if (jerseyNumberChoice.length() == 1 || jerseyNumberChoice.length() == 2) {
                try {
                    int jerseyNumber = Integer.parseInt(jerseyNumberChoice);
                    if (jerseyNumber >= 0 && jerseyNumber <= 99) {
                        setJerseyNumber(jerseyNumberChoice);
                        System.out.println("Jersey Number set to: " + getJerseyNumber());
                        jerseyNumberLoop = false;
                    } else {
                        System.out.println("Invalid Input (00-99)");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input. Enter a Number");
                }
            } else {
                System.out.println("Invalid Input. Enter a number 1-2 digits.");
            }
        }
    }
    
    public String[] getFieldPositions(){
        return positions;
    }
    public void setPlayerPosition(int playerPosition){
        this.playerPosition = this.positions[playerPosition];
    }
    public String getPlayerPosition(){
        return playerPosition;
    }
    public void handleFieldPosition(){ 
        boolean playerTypeLoop = true;
        boolean fieldPositionLoop = true;
        String fieldPosition="";
        String positionDescription="";
        String chosenMessage ="";
       
        while (playerTypeLoop) {
            try {
            	System.out.printf(BOLD+UNDERLINE+"%15sPLAYING TYPE%18s\n", "",RESET);
                System.out.println("1: Pitcher");
                System.out.println("2: Batter");
                int playerTypeChoice = input.nextInt();
        boolean pitcherLoop = true;
                if (playerTypeChoice == 1) {
                    while(pitcherLoop){
                        fieldPosition = "PITCHER";
                        positionDescription = "Pitches the ball with different styles. Goal is to strike-out the batter.";
                        chosenMessage = "You chose Pitcher. Great choice!";
                        if (fieldPositionConfirmation(0, fieldPosition, positionDescription, chosenMessage)){
                            fieldPositionLoop = false;
                            playerTypeLoop = false;
                        }
                        pitcherLoop = false;
                       }
                } else if (playerTypeChoice == 2) {
                    playerTypeLoop = false;
                } else {
                    System.out.println("Invalid Input (1-2)");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }

        while (fieldPositionLoop) {
            try{
            	System.out.printf(BOLD+UNDERLINE+"%13sFIELD POSITION%18s\n", "",RESET);
                for (int i = 1; i<getFieldPositions().length;i++){
                    System.out.println(i+": "+getFieldPositions()[i]);
                }
            
                int fieldPositionChoice = input.nextInt();
            
                switch (fieldPositionChoice) {
                    case 1:
                        fieldPosition = "CATCHER";
                        positionDescription = "Crouches behind home plate to receive pitches. Plays a crucial role in defense.";
                        chosenMessage = "You chose Catcher. Excellent!";
                        break;
                    case 2:
                        fieldPosition = "FIRST BASE";
                        positionDescription = "Covers the area near first base. Involved in fielding and catching throws.";
                        chosenMessage = "You chose First Base. Awesome!";
                        break;
                    case 3:
                        fieldPosition = "SECOND BASE";
                        positionDescription = "Covers the area near second base. Involved in double plays and fielding.";
                        chosenMessage = "You chose Second Base. Good choice!";
                        break;
                    case 4:
                        fieldPosition = "THIRD BASE";
                        positionDescription = "Covers the area near third base. Important in defending against bunts and grounders.";
                        chosenMessage = "You chose Third Base. Nice!";
                        break;
                    case 5:
                        fieldPosition = "SHORT STOP";
                        positionDescription = "Covers the area between second and third base. Involved in various defensive plays.";
                        chosenMessage = "You chose Shortstop. Solid pick!";
                        break;
                    case 6:
                        fieldPosition = "LEFT FIELD";
                        positionDescription = "Covers the area in left field. Involved in catching fly balls and throwing to bases.";
                        chosenMessage = "You chose Left Field. Well done!";
                        break;
                    case 7:
                        fieldPosition = "CENTER FIELD";
                        positionDescription = "Covers the area in center field. Covers a lot of ground and catches fly balls.";
                        chosenMessage = "You chose Center Field. Impressive!";
                        break;
                    case 8:
                        fieldPosition = "RIGHT FIELD";
                        positionDescription = "Covers the area in right field. Involved in catching fly balls and throwing to bases.";
                        chosenMessage = "You chose Right Field. Good call!";
                        break;
                    default:
                        System.out.println("Invalid choice (1-8)");
                        continue;
                } 
                if (fieldPositionConfirmation(fieldPositionChoice, fieldPosition, positionDescription, chosenMessage)){
                    fieldPositionLoop = false; 
                }
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        } 
    }
    public boolean fieldPositionConfirmation(int playerPosition, String fieldPosition, String positionDescription, String chosenMessage){
        boolean confirmLoop = true;
        boolean confirmed = false;
        while (confirmLoop) {
        	System.out.println(BOLD+UNDERLINE+" "+ fieldPosition+" "+RESET);
            System.out.println(positionDescription);
            System.out.print("Press 'Y' to confirm or enter any key to exit: ");
            char fieldPositionConfirm = input.next().toUpperCase().charAt(0);

            if (fieldPositionConfirm == 'Y') {
                setPlayerPosition(playerPosition);
                System.out.println(chosenMessage);
                confirmed = true;
            } else {
                confirmed = false; 
            }
            confirmLoop = false;
        }
        return confirmed;
    }
    
    public void characterInformationMenu(CharacterFace face){
        boolean characterInformationLoop = true;
        while (characterInformationLoop){
            try{
                System.out.printf(BOLD+UNDERLINE+"%10sCHARACTER INFORMATION%14s\n", "",RESET);
                System.out.println("1: Character Name");
                System.out.println("2: Gender");
                System.out.println("3: Jersey Number");
                System.out.println("4: Field Position");
                System.out.println("5: Show Values");
                System.out.println("6: Go Back to Main Menu");
                int characterInformationMenuChoice = input.nextInt();
                switch (characterInformationMenuChoice){
                    case 1:
                    handlePlayerName();
                    break;
                case 2:
                    handleCharacterGender(face);
                    break;
                    case 3:
                    handleJerseyNumber();
                    break;
                case 4:
                    handleFieldPosition();
                    break;
                case 5:
                    showCharacterInformation();
                    break;
                case 6:
                    characterInformationLoop = false;    
                    break;
                default:
                    System.out.println("Invalid Input (1-6)");
                    continue; 
                } 
            } catch(InputMismatchException e){
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }
    }
    public void showCharacterInformation(){
    	System.out.printf(BOLD+UNDERLINE+"%10sCHARACTER INFORMATION%14s\n", "",RESET);
        System.out.println("Character Name: "+getPlayerName());
        System.out.println("Character Gender: "+getCharacterGender());
        System.out.println("Jersey Number: "+getJerseyNumber());
        System.out.println("Field Position: "+getPlayerPosition());
    }
}
class InvalidLengthException extends Exception {
    public InvalidLengthException() {
        super("Name should not exceed 10 characters");
    }
}

class InvalidNumberException extends Exception {
    public InvalidNumberException() {
        super("Name cannot contain numbers!");
    }
}

class InvalidSpecialCharacterException extends Exception {
    public InvalidSpecialCharacterException() {
        super("Name cannot contain special characters!");
    }
}
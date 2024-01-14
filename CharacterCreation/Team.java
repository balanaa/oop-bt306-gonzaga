package CharacterCreation;

import java.util.Scanner;
import java.util.InputMismatchException;

class Team{
	Scanner input = new Scanner(System.in);
	private static final String BOLD = "\u001B[1m";
    private static final String UNDERLINE = "\u001B[4m";
    private static final String RESET = "\u001B[0m";
	private String teamName;
	private String teamMascot;
    private String teamEmblem;
    private String teamBaseColor;
    private String teamAccentColor;
    
    public void showTeamInformation (){
    	System.out.printf(BOLD+UNDERLINE+"%18sTEAM%23s\n", "",RESET);
        System.out.println("Team Name: " + getTeamBaseColor()+ getTeamAccentColor()+getTeamName()+RESET);
        System.out.println("Team Emblem:");
        System.out.println(getEmblem());
        System.out.println("Team Mascot: "+ getTeamMascot());
    }

    public void setEmblem(String emblem){
        teamEmblem = emblem;
    }
    public String getEmblem(){
        return teamEmblem;
    }
    public void setTeamMascot(String teamMascot){
        this.teamMascot = teamMascot;
    }
    public String getTeamMascot(){
        return teamMascot;
    }
    public void handleTeamMascot(){
        boolean mascotLoop = true;
        while(mascotLoop){
            try{
            	System.out.printf(BOLD+UNDERLINE+"%15sTEAM MASCOT%19s\n", "",RESET);
                System.out.println("1: Cat"); 
                System.out.println("2: Cub");
                System.out.println("3: Rhino");
                System.out.println("4: Killers");
                System.out.println("5: Monkey");
                System.out.println("6: Gators");

                System.out.println("7: Go Back to Team Menu");
                int mascotChoice = input.nextInt();
                String teamMascot = "";
                String emblem = "";
                switch (mascotChoice) {
                case 1:
                    teamMascot = "Cats";
                    emblem = "──────▄▀▄─────▄▀▄\n"
                        + "─────▄█░░▀▀▀▀▀░░█▄\n"
                        + "─▄▄──█░░░░░░░░░░░█──▄▄\n"
                        + "█▄▄█─█░░▀░░┬░░▀░░█─█▄▄█";
                    break;
                case 2:
                teamMascot = "Cubs";
                    emblem = "───▄▀▀▀▄▄▄▄▄▄▄▀▀▀▄───\n"
                        + "───█▒▒░░░░░░░░░▒▒█───\n"
                        + "────█░░█░░░░░█░░█────\n"
                        + "─▄▄──█░░░▀█▀░░░█──▄▄─\n"
                        + "█░░█─▀▄░░░░░░░▄▀─█░░█";
                    break;
                case 3:
                teamMascot = "Rhinos";
                    emblem = "░░░░░░░░░░░░▄░░▄░▀█▄░░\n"
                        + "░░▄████████▄██▄██▄██░░\n"
                        + "░░█████████████▄████▌░\n"
                        + "░░▌████████████▀▀▀▀▀░░\n"
                        + "▒▀▒▐█▄▐█▄▐█▄▐█▄▒░▒░▒░▒";
                    break;
                case 4:
                teamMascot = "Killers";
                    emblem = "───▄█▌─▄─▄─▐█▄\n"
                        + "───██▌▀▀▄▀▀▐██\n"
                        + "───██▌─▄▄▄─▐██\n"
                        + "───▀██▌▐█▌▐██▀\n"
                        + "▄██████─▀─██████▄";
                    break;
                case 5:
                teamMascot = "Monkeys";
                    emblem = "───▄██▄─────────────▄▄\n"
                            + "──█████▄▄▄▄───────▄▀\n"
                            + "────▀██▀▀████▄───▄▀\n"
                            + "───▄█▀▄██▄████▄─▄█\n"
                            + "▄▄█▀▄▄█─▀████▀██▀";
                break;
                case 6:
                teamMascot = "Gators";
                    emblem = "░░░░░▄▄▄▄▄░▄░▄░▄░▄\n"
                            + "▄▄▄▄██▄████▀█▀█▀█▀██▄\n"
                            + "▀▄▀▄▀▄████▄█▄█▄█▄█████\n"
                            + "▒▀▀▀▀▀▀▀▀██▀▀▀▀██▀▒▄██\n"
                            + "▒▒▒▒▒▒▒▒▀▀▒▒▒▒▀▀▄▄██▀▒";
                break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid Input (1-7)");
                    continue;
                }
                System.out.println(emblem);
                System.out.println("Team Mascot: " + teamMascot);
                setEmblem(emblem);
                setTeamName(getTeamName(), teamMascot);
                setTeamMascot(teamMascot);

                mascotLoop = false;
            } catch(InputMismatchException e){
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }
    }

    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    public void setTeamName(String teamName, String teamMascot){
        this.teamName = teamName + " " +teamMascot;
    }
    public String getTeamName(){
        return teamName;
    }
    public void handleTeamName(){
        boolean teamNameLoop = true;
        input.nextLine();
        System.out.printf(BOLD+UNDERLINE+"%15sTEAM NAME%18s\n", "",RESET);
        while (teamNameLoop){
            System.out.print("Name your Team: ");
            String teamName = input.nextLine();
            if (validateName(teamName)){
               teamNameLoop = false; 
            }
        }
    }
    public boolean validateName(String teamName){
        try {
            for (int i = 0; i < teamName.length(); i++) {
                char currentChar = teamName.charAt(i);
                if (!Character.isLetter(currentChar)) {
                    if (Character.isDigit(currentChar)) {
                        throw new InvalidNumberException();
                    } else {
                        throw new InvalidSpecialCharacterException();
                    }
                }
            }   
            if (teamName.length() > 10) {
                throw new InvalidLengthException();
            }
            setTeamName(teamName);
            System.out.println("Team Name set to: " + teamName);
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
    public void handleColor(){
        boolean colorLoop = true;
        while(colorLoop){
            try{
            	System.out.printf(BOLD+UNDERLINE+"%18sCOLOR%22s\n", "",RESET);
                System.out.println("1: Base Color");
                System.out.println("2: Accent Color");
                System.out.println("3: Go Back to Team Menu");
                int colorChoice = input.nextInt();
                switch(colorChoice){
                case 1:
                    handleTeamBaseColor();
                    break;
                case 2:
                    handleTeamAccentColor();    
                    break;
                case 3:
                    colorLoop = false;
                    break;
                default:
                    System.out.println("Invalid Input (1-4)");
                    continue;
                }
            } catch(InputMismatchException e){
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }       
    }

    public void setTeamBaseColor(String teamBaseColor){
        this.teamBaseColor = teamBaseColor;
    }
    public String getTeamBaseColor(){
        return teamBaseColor;
    }
    
    public void handleTeamBaseColor(){
        boolean teamBaseColorLoop = true;
        while(teamBaseColorLoop){
            if (getTeamBaseColor() == null && getTeamAccentColor() == null){
                System.out.println("Team Color: "+getTeamName());
            } else if (getTeamBaseColor() == null){
                System.out.println("Team Color: "+getTeamAccentColor()+getTeamName()+"\u001B[0m");
            } else if (getTeamAccentColor() == null){
                System.out.println("Team Color: "+getTeamBaseColor()+getTeamName()+"\u001B[0m");
            } else{
                System.out.println("Team Color: "+getTeamAccentColor()+getTeamBaseColor()+getTeamName()+"\u001B[0m");
            }
            try{
               System.out.printf(BOLD+UNDERLINE+"%16sBASE COLOR%18s\n", "",RESET);
                System.out.println("1: Black");
                System.out.println("2: Red");
                System.out.println("3: Green");
                System.out.println("4: Yellow");
                System.out.println("5: Blue");
                System.out.println("6: Purple");
                System.out.println("7: Cyan");
                System.out.println("8: White");
                System.out.println("9: Go Back to Color Menu");
                int teamBaseColorChoice = input.nextInt();
                String teamBaseColor ="";
                switch (teamBaseColorChoice) {
                case 1:
                    teamBaseColor = "\u001B[40m";
                    break;
                case 2:
                    teamBaseColor = "\u001B[41m";
                    break;
                case 3:
                    teamBaseColor = "\u001B[42m";
                    break;
                case 4:
                    teamBaseColor = "\u001B[103m";
                    break;
                case 5:
                    teamBaseColor = "\u001B[44m";
                    break;
                case 6:
                    teamBaseColor = "\u001B[45m";
                    break;
                case 7:
                    teamBaseColor = "\u001B[106m";
                    break;
                case 8:
                    teamBaseColor = "\u001B[108m";
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid Input (1-9)");
                    continue;
                }
                setTeamBaseColor(teamBaseColor);
            } catch(InputMismatchException e){
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }
    }

    public void setTeamAccentColor(String teamAccentColor){
        this.teamAccentColor = teamAccentColor;
    }
    public String getTeamAccentColor(){
        return teamAccentColor;
    }
    
    public void handleTeamAccentColor(){
        boolean teamAccentColorLoop = true;
        while(teamAccentColorLoop){
            if (getTeamBaseColor() == null && getTeamAccentColor() == null){
                System.out.println("Team Color: "+getTeamName());
            } else if (getTeamBaseColor() == null){
                System.out.println("Team Color: "+getTeamAccentColor()+getTeamName()+"\u001B[0m");
            } else if (getTeamAccentColor() == null){
                System.out.println("Team Color: "+getTeamBaseColor()+getTeamName()+"\u001B[0m");
            } else{
                System.out.println("Team Color: "+getTeamAccentColor()+getTeamBaseColor()+getTeamName()+"\u001B[0m");
            }
            try {
                System.out.printf(BOLD+UNDERLINE+"%15sACCENT COLOR%17s\n", "",RESET);
                System.out.println("1: Black");
                System.out.println("2: Red");
                System.out.println("3: Green");
                System.out.println("4: Yellow");
                System.out.println("5: Blue");
                System.out.println("6: Purple");
                System.out.println("7: Cyan");
                System.out.println("8: White");
                System.out.println("9: Go Back to Color Menu");
                int teamAccentColorChoice = input.nextInt();
                String teamAccentColor ="";
                switch (teamAccentColorChoice) {
                case 1:
                    teamAccentColor = "\u001B[30m";
                    break;
                case 2:
                    teamAccentColor = "\u001B[91m";
                    break;
                case 3:
                    teamAccentColor = "\u001B[92m";
                    break;
                case 4:
                    teamAccentColor = "\u001B[33m";
                    break;
                case 5:
                    teamAccentColor = "\u001B[94m";
                    break;
                case 6:
                    teamAccentColor = "\u001B[95m"; 
                    break;
                case 7:
                    teamAccentColor = "\u001B[96m"; 
                    break;
                case 8:
                    teamAccentColor = "\u001B[97m";  
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid Input (1-9)");
                    continue;
                }
                setTeamAccentColor(teamAccentColor);
            } catch(InputMismatchException e){
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        } 
    }

	public void teamMenu(CharacterInformation info) {
        boolean teamLoop = true;
        while (teamLoop) {
            try{
            	System.out.printf(BOLD+UNDERLINE+"%18sTEAM%23s\n", "",RESET);
                System.out.println("1: Team Name");
                System.out.println("2: Team Mascot");
                System.out.println("3: Team Color");
                System.out.println("4: Show Values");
                System.out.println("5: Go Back to Main Menu");
                int teamMenuChoice = input.nextInt();
                switch (teamMenuChoice) {
                case 1:
                    handleTeamName();
                    break;
                case 2:
                    handleTeamMascot();
                    break;
                case 3:
                    handleColor();
                    break;
                case 4:
                    showTeamInformation();
                    break;
                case 5:
                    teamLoop = false;
                    break;
                default:
                    System.out.println("Invalid Input (1-5)");
                    continue;
                }
            } catch(InputMismatchException e){
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }
    }
}
package CharacterCreation;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main{
    Scanner input = new Scanner(System.in);
    private static final String BOLD = "\u001B[1m";
    private static final String UNDERLINE = "\u001B[4m";
    private static final String RESET = "\u001B[0m";
    private boolean coach;

    public void setCoach(boolean unlocked){
        coach = unlocked;
    }
    public boolean isCoachUnlocked(){
        return coach;
    }

    public void handleDifficulty(){
        boolean dificultyLoop = true;
        while (dificultyLoop){
            System.out.print("Play on Hard Mode?(Y/N) ");
            char difficultyChoice = input.next().toUpperCase().charAt(0);
                if(difficultyChoice == 'Y'){
                    System.out.println("Difficulty set to : "+BOLD+"\u001B[31mHARD MODE"+RESET);
    
                }else if(difficultyChoice == 'N'){
                    System.out.println("Difficulty set to : "+BOLD+"\u001B[34mEASY MODE"+RESET);
                    System.out.println("__________________1¶¶¶1_______________¶¶¶¶________\n"+
                            "________________¶¶¶¶¶¶¶¶¶¶________¶¶¶¶¶¶¶¶¶_______\n"+
                            "_______________¶¶¶¶¶¶¶¶¶¶¶¶_____¶¶¶¶¶¶¶¶¶¶¶_______\n"+
                            "_______________¶¶¶¶¶¶¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶_______\n"+
                            "_______________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶__________\n"+
                            "_______________¶¶_¶___¶_¶¶¶¶¶¶¶¶¶¶¶¶¶_____________\n"+
                            "_______________¶¶___1____¶¶¶¶¶¶¶¶¶________________\n"+
                            "_______________¶¶__1_____¶¶¶¶¶¶¶__________________\n"+
                            "________________¶1__¶¶___¶¶¶¶1____________________\n"+
                            "________________1¶_______¶¶_______________________\n"+
                            "________________¶¶¶111___1¶¶¶¶¶¶__________________\n"+
                            "______________¶¶¶¶______1¶¶¶_¶¶¶¶¶¶¶1_____________\n"+
                            "____________¶¶¶¶¶¶¶_1¶¶¶¶¶_______¶¶¶¶¶¶___________\n"+
                            "__________¶¶¶¶¶¶__¶¶¶¶¶¶_____________1¶¶__________\n"+
                            "_________¶¶¶¶1_________________________¶¶¶________\n"+
                            "_______¶¶¶¶______________________________¶¶¶______\n"+
                            "1¶¶¶¶¶¶¶¶¶________________________________¶¶¶¶____\n"+
                            "¶____¶¶¶¶__________¶¶¶¶¶¶¶¶_________________1¶¶¶__\n"+
                            "¶111¶_¶¶¶1______________¶¶____________________¶¶¶_\n"+
                            "¶¶___¶11¶______________¶¶_____________________¶¶¶_\n"+
                            "_¶¶__¶¶¶____¶_________¶¶___________1¶¶______¶¶__¶¶\n"+
                            "__¶¶___¶¶___¶_________¶¶_____________¶¶¶__¶¶¶____¶\n"+
                            "___¶____¶¶¶¶¶¶________¶¶_____________¶¶¶¶¶¶¶_____¶\n"+
                            "___¶¶_____1¶¶¶________¶¶____________¶¶__1¶¶_____¶¶\n"+
                            "____¶¶_______¶________¶¶____________¶¶_1¶¶_____¶¶_\n"+
                            "_____1¶_____¶¶______________________¶¶1¶¶_____¶¶__\n"+
                            "______¶¶1¶¶¶¶¶_____________________¶¶_¶¶____¶¶¶___\n"+
                            "_______¶¶¶¶_¶¶_____________________¶¶¶¶____¶¶1____\n"+
                            "________¶¶¶1¶¶____________________¶¶¶___¶¶¶¶______\n"+
                            "_________1¶¶¶¶_________________¶¶¶¶___1¶¶¶1_______\n"+
                            "_____________¶¶______________¶¶1_____¶¶¶¶_________\n"+
                            "_____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶______¶¶¶1___________\n"+
                            "_____________¶____¶¶¶¶¶___¶¶1_1__¶¶¶______________\n"+
                            "____________¶¶___________¶¶¶¶¶¶¶¶¶¶_______________\n"+
                            "____________¶¶1____________¶¶_¶___¶_______________\n"+
                            "______________¶¶¶¶¶¶¶¶11¶¶¶¶¶¶¶¶¶¶¶¶¶_____________\n");
                            System.out.println("COACH UNLOCKED");
                            System.out.println("Gives player tips & tricks");
                }else{
                    continue;
                }
            dificultyLoop = false;
        }
    }
	public static void main(String[] args) {
        Main main = new Main();
        CharacterInformation info = new CharacterInformation();
        CharacterFace face = new CharacterFace();
		PlayerAttributes playerAttributes = new PlayerAttributes();
        Skills skills = new Skills("Unselected","Unselected","Unselected");
		Team team = new Team();

		boolean mainMenuLoop = true;
        while (mainMenuLoop) {
        	System.out.println("([[[[[[[[[>==O "+BOLD+"GRAND SLAM! "+RESET+"O==<]]]]]]]]])");
            System.out.println("1: Character Information");
            System.out.println("2: Face");
            System.out.println("3: Attributes");
            System.out.println("4: Skills");
            System.out.println("5: Team");
            System.out.println("6: Start Game");

            try {
                int mainMenuChoice = main.input.nextInt();
                switch (mainMenuChoice) {
                    case 1:
                        info.characterInformationMenu(face);
                        break;
                    case 2:
                        face.faceSelectionMenu();
                        break;
                    case 3:
                        playerAttributes.attributesMenu(info.getPlayerPosition());
                        break;
                    case 4:
                        skills.skillsMenu(info.getPlayerPosition());
                        break;
                    case 5:
                        team.teamMenu(info);
                        break;
                    case 6:
                        info.showCharacterInformation();
                        face.showFace();
                        playerAttributes.showAttributes(info.getPlayerPosition());
                        skills.showSkills(info.getPlayerPosition());
                        team.showTeamInformation();
                        mainMenuLoop = false;
                        break;
                    default:
                        System.out.println("Invalid Input (1-6)");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                main.input.nextLine();
            }
        }
        main.handleDifficulty();
        Teammates t = new Teammates();
        t.showTeammates(info);
	}
}
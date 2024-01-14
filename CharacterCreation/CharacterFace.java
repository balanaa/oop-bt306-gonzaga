package CharacterCreation;

import java.util.Scanner;
import java.util.InputMismatchException;

interface FaceFeatures{
	String BOLD = "\u001B[1m";
    String UNDERLINE = "\u001B[4m";
    String RESET = "\u001B[0m";
    
	final String[] eyebrowChoices = {
        "^ Pointed Up", "= Thick", "‘ Thin", "_ Low", "‿ Down-Turned"
    };
	final String[] eyeChoices = {
        "◉ Fisheye", "╥ Crying", "◕ Cute " , "◡ Closed", "ᗜ Big", "๏ Small", "¬ Side Eye", "ಠ Wide", "● Dot"
    };
	final String[] noseChoices = {
        "ʖ Rounded", "C Big", "໒ Swirl", "< Pointed", "└ Straight", "ʃ Curved"
    };
	final String[] mouthChoices = {
        "‿ Grin", "◡ Smile", "¯ Hmm ", "ᴥ Animal", "O Wow", "~ Skeptical", "❥ Kiss", "□ Shocked", "ᗣ Sad",
    };
	
	public char getFeatureFromChoices(int index);
	public void setFeature(char feature, CharacterFace face);
	public void handleFeature(CharacterFace face);
}


class CharacterFace {
	Scanner input = new Scanner(System.in);
    char[][] characterFace;
    private static final String BOLD = "\u001B[1m";
    private static final String UNDERLINE = "\u001B[4m";
    private static final String RESET = "\u001B[0m";
          
    public void setFace(String characterGender){
        if (characterGender == "[♂] Masculine") {
            char[][] maleFace = {
    		{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, // space
    	    {' ', ' ', ' ', ' ', '.', ';', ';', ';', ';',';', ';', ';', '.', ' ', ' ', ' ', ' '}, // hair
    	    {' ', ' ', ' ', ';', ';', ';', ';', ';', ';', ';', ';', ';', ';',';', ' ', ' ', ' '}, // hair line
    	    {' ', ' ', ' ', ';', ';', ' ', '=', ' ', '\'', ' ', '=', ' ', ';', ';', ' ', ' ', ' '}, // 3 eyebrow
    	    {' ', ' ', ' ', '|', ' ', ' ', '¬', ' ', ' ', ' ', '¬', ' ', ' ', '|', ' ',' ', ' '}, // 4 eyes
    	    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', '<', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' '}, // line 6
    	    {' ', ' ', ' ', '!', ' ', ' ', ' ', ' ', '_', ' ', ' ', ' ', ' ', '!', ' ', ' ', ' '}, // line 7
    	    {' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ',  ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' '}, // line 8
    	    {' ', ' ', ' ', ' ', ' ', '`', '.', '_', ' ', '_', '.', '´', ' ', ' ', ' ', ' ', ' '}, // line 9
    	    {' ', ' ', ' ',  ' ', ' ', '|', ' ', ' ', '◡', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '} // line 10
    	};
        characterFace = maleFace;
        } else {
            char[][] femaleFace = {
			{' ', ' ', ',', ' ', '¯', '¯', '.', ' ', '_', ' ', ',', ' ', '¯', '¯', '.', ' ', ' '}, // top of hair
		    {';', ' ', ' ', ' ', ',', '~', ' ', ' ', ' ', ' ', ' ', '~', '.', ' ', ' ', ' ', ':'}, // hair
		    {'¡', ' ', ' ', '¡', '_', '_', '_', '_', '_', '/', '\\', '_', '_', '¡', ' ', ' ', '¡'}, // bangs end
		    {'|', ' ', ' ', '¡', ' ', ' ', '=', ' ', ' ', ' ', '=', ' ', ' ', '¡', ' ', ' ', '|'}, // 3 eyebrow
		    {'|', ' ', ' ', '|', ' ', ' ', '¬', ' ', ' ', ' ', '¬', ' ', ' ', '|', ' ', ' ', '|'}, // 4 eyes
		    {'|', ' ', ' ', '!', ' ', ' ', ' ', ' ', '<', ' ', ' ', ' ', ' ', '!', ' ', ' ', '|'}, // 5 nose
		    {'|', ' ', ' ', ' ', '\\', ' ', ' ', ' ', '_', ' ', ' ', ' ', '/', ' ', ' ', ' ', '|'}, // 6 mouth
		    {'|', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', '|'}, // chin
		    {'└', '-', '-', '-', '-', ' ', '`', ' ', '-', ' ', '´', ' ', '-', '-', '-', '-', '┘'}, // jaw
		    {' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ',' '} // neck
		};
        characterFace = femaleFace;
        }
    }
    public char[][] getPlayerFace(){
        return characterFace;
    }
    public void showFace() {
    	if (characterFace != null) {
            System.out.printf(BOLD + UNDERLINE + "%13sCHARACTER FACE%18s\n", "", RESET);
            for (int y = 0; y < 10; y++) {
                System.out.printf("%12s", "");
                for (int x = 0; x < 17; x++) {
                    System.out.print(getPlayerFace()[y][x]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Character face not initialized. Set Character Gender first.");
        }
    }
	public void faceSelectionMenu(){
		boolean faceLoop = true;
		while(faceLoop) {
            try{
                showFace();
                System.out.println("Which would you like to change?");
                System.out.println("1: Eyebrows");
                System.out.println("2: Eyes");
                System.out.println("3: Nose");
                System.out.println("4: Mouth");
                System.out.println("5: Go Back to Main Menu");
                int faceFeatureChoice = input.nextInt();
                switch (faceFeatureChoice) {
                case 1:
                    Eyebrows eyebrows = new Eyebrows();
                    eyebrows.handleFeature(this); 
                    break;
                case 2:
                    Eyes eyes = new Eyes();
                    eyes.handleFeature(this);
                    break;
                case 3:
                    Nose nose = new Nose();
                    nose.handleFeature(this);
                    break;				
                case 4:
                    Mouth mouth = new Mouth();
                    mouth.handleFeature(this);
                    break;				
                case 5:
                    faceLoop = false;
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

class Eyebrows implements FaceFeatures{
	Scanner input = new Scanner(System.in);
	
	public char getFeatureFromChoices(int indexOfEyebrows) {
		return eyebrowChoices[indexOfEyebrows].charAt(0);
	}
	public void setFeature(char eyebrows, CharacterFace face){
	    face.getPlayerFace()[3][6] = eyebrows;
	    face.getPlayerFace()[3][10] = eyebrows;
	}
	public void handleFeature(CharacterFace face) {
		boolean eyebrowLoop = true;
		char eyebrows = '=';
		while (eyebrowLoop) {
            try {
                face.showFace();
            	System.out.printf(BOLD+UNDERLINE+"%16sEYEBROWS%21s\n", "",RESET);                
                for (int i = 0; i<eyebrowChoices.length; i++) {
                    System.out.println((i+1)+": "+eyebrowChoices[i]);
                }
                System.out.println((eyebrowChoices.length+1)+": NONE");
                System.out.println((eyebrowChoices.length+2)+": Go Back to Character Face");
                int eyebrowChoice = input.nextInt();
                
                switch (eyebrowChoice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    eyebrows = getFeatureFromChoices(eyebrowChoice-1);
                    break;
                case 6:
                    eyebrows = ' ';
                    break;
                case 7:
                    eyebrowLoop = false;
                    break;
                default:
                    System.out.println("Invalid Input (1-7)");
                    continue;
                } 
                setFeature(eyebrows, face);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
		}
	}
}

class Eyes implements FaceFeatures {
    private Scanner input = new Scanner(System.in);
    

    public char getFeatureFromChoices(int indexOfEyes) {
        return eyeChoices[indexOfEyes].charAt(0);
    }

    public void setFeature(char eyes, CharacterFace face) {
        face.getPlayerFace()[4][6] = eyes;
        face.getPlayerFace()[4][10] = eyes;
    }

    public void handleFeature(CharacterFace face) {
        boolean eyeLoop = true;
        char eyes = '¬';
        while (eyeLoop) {
            try{
                face.showFace();
                System.out.printf(BOLD+UNDERLINE+"%18sEYES%23s\n", "",RESET);
                for (int i = 0; i < eyeChoices.length; i++) {
                    System.out.println((i + 1) + ": " + eyeChoices[i]);
                }
                System.out.println((eyeChoices.length + 1) + ": NONE");
                System.out.println((eyeChoices.length + 2) + ": Go Back to Character Face");
                int eyeChoice = input.nextInt();

                switch (eyeChoice) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        eyes = getFeatureFromChoices(eyeChoice - 1);
                        break;
                    case 10:
                        eyes = ' ';
                        break;
                    case 11:
                        eyeLoop = false;
                        break;
                    default:
                        System.out.println("Invalid Input (1-11)");
                        continue;
                }
                setFeature(eyes, face);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }
    }
}
class Nose implements FaceFeatures {
    private Scanner input = new Scanner(System.in);

    public char getFeatureFromChoices(int indexOfNose) {
        return noseChoices[indexOfNose].charAt(0);
    }

    public void setFeature(char nose, CharacterFace face) {
        face.getPlayerFace()[5][8] = nose;
    }

    public void handleFeature(CharacterFace face) {
        boolean noseLoop = true;
        char nose = '<';
        while (noseLoop) {
            try{
                face.showFace();
                System.out.printf(BOLD+UNDERLINE+"%18sNOSE%23s\n", "",RESET);
                for (int i = 0; i < noseChoices.length; i++) {
                    System.out.println((i + 1) + ": " + noseChoices[i]);
                }
                System.out.println((noseChoices.length + 1) + ": NONE");
                System.out.println((noseChoices.length + 2) + ": Go Back to Character Face");
                int noseChoice = input.nextInt();

                switch (noseChoice) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        nose = getFeatureFromChoices(noseChoice - 1);
                        break;
                    case 7:
                        nose = ' ';
                        break;
                    case 8:
                        noseLoop = false;
                        break;
                    default:
                        System.out.println("Invalid Input (1-8)");
                        continue;
                }
                setFeature(nose, face);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }
    }
}
class Mouth implements FaceFeatures {
    private Scanner input = new Scanner(System.in);

    public char getFeatureFromChoices(int indexOfMouth) {
        return mouthChoices[indexOfMouth].charAt(0);
    }

    public void setFeature(char mouth, CharacterFace face) {
        face.getPlayerFace()[6][8] = mouth;
    }

    public void handleFeature(CharacterFace face) {
        boolean mouthLoop = true;
        char mouth = '‿';
        while (mouthLoop) {
            try{
                face.showFace();
                System.out.printf(BOLD+UNDERLINE+"%18sMOUTH%22s\n", "",RESET);
                for (int i = 0; i < mouthChoices.length; i++) {
                    System.out.println((i + 1) + ": " + mouthChoices[i]);
                }
                System.out.println((mouthChoices.length + 1) + ": NONE");
                System.out.println((mouthChoices.length + 2) + ": Go Back to Character Face");
                int mouthChoice = input.nextInt();

                switch (mouthChoice) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        mouth = getFeatureFromChoices(mouthChoice - 1);
                        break;
                    case 10:
                        mouth = ' ';
                        break;
                    case 11:
                        mouthLoop = false;
                        break;
                    default:
                        System.out.println("Invalid Input (1-11)");
                        continue;
                }
                setFeature(mouth, face);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Numbers Only");
                input.nextLine();
                continue;
            }
        }
    }
}
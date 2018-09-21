package player;
import java.util.Scanner;

public class Player {
    private String firstName = "";
    private String lastName = "";
    private String division = "";
    private int execution = 0;
    private int control = 0;
    private int trickDiversity = 0;
    private int spaceUseAndEmphasis = 0;
    private int choreograhpy = 0;
    private int construction = 0;
    private int bodyControl = 0;
    private int showmanship = 0;
    private float clickerScore = 0f;

    Scanner scanner = new Scanner(System.in);

    public void getPlayerInformation() {
        System.out.println("The start of a yo-yo judging application");
        System.out.println("Player first name: ");
        firstName = scanner.nextLine();
        System.out.println("Player last name: ");
        lastName = scanner.nextLine();
        System.out.println("Player division: ");
        division = scanner.nextLine();
        System.out.println("Input the length of the routine in seconds: ");
        int routineLength = scanner.nextInt();
    }

    public void getPerformanceEvals () {
        System.out.println("Execution score is: ");
        execution = scanner.nextInt();
        System.out.println("Control score is: ");
        control = scanner.nextInt();
        System.out.println("Trick Diversity score is: ");
        trickDiversity = scanner.nextInt();
        System.out.println("Space Use & Emphasis score is: ");
        spaceUseAndEmphasis = scanner.nextInt();
        System.out.println("Music Use 1: Choreography score is: ");
        choreograhpy = scanner.nextInt();
        System.out.println("Music Use 2: Consruction score is: ");
        construction = scanner.nextInt();
        System.out.println("Body Control score is: ");
        bodyControl = scanner.nextInt();
        System.out.println("Showmanship score is: ");
        showmanship = scanner.nextInt();
    }

    public void awardClick() {
        clickerScore++;
    }

    public void removeClick() {
        clickerScore--;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDivision() {
        return division;
    }

    public float getScore() {
        return clickerScore;
    }

    public int getExecution(){
        return execution;
    }

    public int getControl(){
        return control;
    }

    public int getTrickDiversity(){
        return trickDiversity;
    }

    public int getSpaceUseAndEmphasis(){
        return spaceUseAndEmphasis;
    }

    public int getChoreography(){
        return choreograhpy;
    }

    public int getConstruction(){
        return construction;
    }

    public int getBodyControl (){
        return bodyControl;
    }

    public int getShowmanship (){
        return showmanship;
    }
}


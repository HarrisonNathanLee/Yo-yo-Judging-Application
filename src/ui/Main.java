package ui;

import clicker.Score;

class YoYoJudge {

    public int clickerscore = 0;

    public YoYoJudge(){
    }

    public void start() {
        System.out.println("The start of a yo-yo judging application");
        Score sco = new Score();
        sco.awardClick();
        sco.awardClick();
        sco.awardClick();
        sco.removeClick();
        System.out.println("Player's final clickerscore is: " + sco.getScore());
    }

    public static void main(String[] args) {
        YoYoJudge yyjh = new YoYoJudge();
        yyjh.start(); 
    }
}


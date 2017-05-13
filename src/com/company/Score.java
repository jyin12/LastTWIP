package com.company;

import java.util.Scanner;

/**
 * Created by Yin on 5/12/2017.
 */
public class Score {
    public static double score;
    public static String secNum;
    public static String s;

    public Score(String a)
    {
        score = 0;
        secNum = "";
        s = a;
    }

    public static double totalScore()
    {
        Scanner sc = new Scanner(s);
        sc.useDelimiter("\\+\\s*");
        int count = 0;
        double d = 0;
        while(sc.hasNext())
        {
            String s1 = sc.next();
            String s2 = "";
            for(int i = 0; i < s1.length(); i++)
            {
                char ch = s1.charAt(i);
                if(Character.isLetter(ch) )
                    break;
                if(ch == '.' || Character.isDigit(ch))
                {
                    s2 = s2 + ch;
                }
            }
            if(count == 0)
            {
                secNum = s2;
                //System.out.println(secNum);
            }
            else
            {
                if(!s2.isEmpty())
                {
                    d = Double.parseDouble(s2);
                    //System.out.println(d);
                }
            }
            count++;
            score = score + d;
        }
        //System.out.println(score);
        //System.out.println(score + "/19");
        return score;
    }
    public static String getSecNum()
    {
        return secNum;
    }
}

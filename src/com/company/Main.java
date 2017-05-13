package com.company;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner a = new Scanner(System.in);
        System.out.println("Ready to see the scores?");
        System.out.println("1 for \"yes\" and \"2\" for no");
        int ans = a.nextInt();
        if(ans == 2)
            System.out.println("Have a nice day!");
        else
        {
            Scanner sf = new Scanner(new File("rawData.txt"));
            List<String> lines = new ArrayList<String>();
            while(sf.hasNextLine())
            {
                lines.add(sf.nextLine());
            }
            String [] arr = lines.toArray(new String[0]);
            String info [][] = new String[28][4];

            for(int i = 1; i < arr.length; i++)
            {
                String s = arr[i];
                Score sco = new Score(s);
                double sc = sco.totalScore();
                String sN = sco.getSecNum();
                String sc1 = Double.toString(sc);
                //System.out.println(sN);
                //System.out.println(sc1);
                int j2 = Integer.parseInt(sN)-1;
                if (info[j2][0] == null)
                {
                    info[j2][0] = sN;
                    info[j2][2] = sc1;
                }
                else
                {
                    info[j2][3] = sc1;
                }
                if (info[j2][3] != null)
                {
                    double sc2 = Double.parseDouble(info[j2][2]) + Double.parseDouble(info[j2][3]);
                    sc2 = sc2 / 2;
                    String sc3 = Double.toString(sc2);
                    info[j2][1] = sc3 + "/19";
                }
                else
                {
                    info[j2][1] = info[j2][2] + "/19";
                    info[j2][3] = "N/A";
                }
            }
            /*for(int j = 0; j < info.length; j++)
            {
                for (int k = 0; k < 4; k++)
                {
                    System.out.print(info[j][k] + " ");
                }
                System.out.println();
            }*/
            Scanner sf1 = new Scanner(new File("name.txt"));
            List<String> lines1 = new ArrayList<String>();
            while(sf1.hasNextLine())
            {
                lines1.add(sf1.nextLine());
            }
            String [] arr1 = lines1.toArray(new String[0]);
            Arrays.sort(arr1);
            String info2 [][] = new String[29][2];
            for(int ac = 0; ac < arr1.length; ac++)
            {
                Scanner sc1 = new Scanner(arr1[ac]);
                sc1.useDelimiter("\\s");
                int kk = 0;
                while(sc1.hasNext())
                {
                    info2[ac][kk] = sc1.next();
                    kk++;
                }
            }
            /*for(int ab = 0; ab < info2.length; ab++){
                for(int bc = 0; bc < info2[ab].length; bc++)
                    System.out.print(info2[ab][bc] + " ");
                System.out.println();
            }*/

            System.out.println("Name        SN    Avg    FRQ1       FRQ2");
            for(int row = 0; row < info2.length; row++)
            {
                System.out.print(info2[row][0] + "\t\t");
                for(int i = 0; i < info.length; i++)
                {
                    if(info2[row][1].equals(info[i][0]))
                    {
                        for(int j = 0; j < info[i].length; j++)
                        {
                            System.out.print(info[i][j] + "\t\t");
                        }

                    }
                }
                System.out.println();
            }

            sf.close();
        }
    }
}

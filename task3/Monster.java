package HW02.task3;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import HW02.task3.Matrix.Position;

import java.io.*;

import java.util.Random;

public class Monster implements Linable {

    public static final int L = 256;

    static Monster[] monster = new Monster[L];
    private final int r;
    private final int g;
    private final int b;
    public int Rank;

    private Position position;

    Monster(int r, int g, int b,int Rank) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.Rank = Rank;
    }

    public static Monster getMonsterByRank(int rank) {

        for (int i=0;i<L;i++) {
            Monster m = monster[i];
            if (m.rank() == rank) {
                return m;
            }
        }
        return null;

    }

    public int rank() {
        return this.Rank;
    }

    @Override
    public String toString() {
        if(this.rank()<10) {
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank() + "    \033[0m";
        }
        if(this.rank()>9 && this.rank()<100){
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank() + "   \033[0m";
        }
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank() + "  \033[0m";
    }

    @Override
    public void setPosition(HW02.task3.Matrix.Position position) {
        this.position = position;
        
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void swapPosition(Monster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank();
    }

    public static void getRGB(String FileName) throws IOException{

        int[] rgb = new int[3];
        File file = new  File(FileName);
        BufferedImage bi = ImageIO.read(file); // 
        
        int width=bi.getWidth();
        int height=bi.getHeight();
        /*
        int minx=bi.getMinX();
        int miny=bi.getMinY();
        */
        /*
        for(int i=0;i<L;i++) { //38
            int k = 38 * i;
            int pixel=bi.getRGB(k,200);
            rgb[0] = (pixel &  0xff0000) >> 16;
            rgb[1] = (pixel &  0xff00) >> 8;
            rgb[2] = (pixel &  0xff);
            Monster.monster[i] = new Monster(rgb[0],rgb[1],rgb[2],i);  
        }
        */
        for(int i=0;i<L/16; i++) { //38
            for(int j =0;j<L/16; j++){
                int k = 35 * i + 1;
                int l = 26 * j + 1;
                int pixel=bi.getRGB(k,l);
                rgb[0] = (pixel &  0xff0000) >> 16;
                rgb[1] = (pixel &  0xff00) >> 8;
                rgb[2] = (pixel &  0xff);
                Monster.monster[j*L/16 + i] = new Monster(rgb[0],rgb[1],rgb[2], j*L/16 + i);  
            }
        }
        System.out.println("width="+width+" height="+height);
    }

    public static void setLocation(int[] array){

        Random R = new Random();
    
        for(int i=0; i<L; i++) {
            int randomNum = R.nextInt(L);
            while(existed(randomNum, array, i)) {
                randomNum = R.nextInt(L);
            }
            array[i] = randomNum;
        }

    }

    public static boolean existed(int num, int[] array, int index) {
		for(int i=0; i<index; i++) {
			if(num == array[i]) {
				return true;
			}
		}
		return false;
	}
    
}
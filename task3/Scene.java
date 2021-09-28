package HW02.task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static final int L = 256;
    public static void main(String[] args) throws IOException {

        Matrix matrix = new Matrix(L/16,L/16); // 建立队伍长度  

        int[] IRP = new int[L]; // Initial Random Position

        Monster.setLocation(IRP);

        Monster.getRGB("c256.png");

        for(int i=0;i<L;i++)
        {
            matrix.put(Monster.monster[i],IRP[i]/(L/16),IRP[i]%(L/16)); 
        }
        

        Snake theSnake = Snake.getTheSnake();

        Sorter sorter = new QuickSorter();

        theSnake.setSorter(sorter);

        String log = theSnake.lineUp(matrix);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }
    
}

package HW02.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static final int L = 16;
    public static void main(String[] args) throws IOException {

        Line line = new Line(L); // 建立队伍长度

        int[] IRP = new int[L]; // Initial Random Position

        Monster.setLocation(IRP);

        /* 随机颜色
        for(int i=0;i<L;i++){
            int R1 = R.nextInt(255);
            int B1 = R.nextInt(255);
            int G1 = R.nextInt(255);
            Gourd.monster[i] = new Gourd(R1,B1,G1,i);
            line.put(Gourd.monster[i],luckNums[i]); // luckNum为初始位置
        }
        */

        Monster.getRGB("c256.png");

        for(int i=0;i<L;i++)
        {
            line.put(Monster.monster[i],IRP[i]);
        }
        

        Snake theGeezer = Snake.getTheSnake();

        Sorter sorter = new QuickSorter();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }
}

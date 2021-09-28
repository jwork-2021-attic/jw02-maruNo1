package HW02.task3;

public class Snake {

    private static Snake theSnake;

    public static Snake getTheSnake() {
        if (theSnake == null) {
            theSnake = new Snake();
        }
        return theSnake;
    }

    private Snake() {

    }

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String lineUp(Matrix matrix) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[][] linables = matrix.toArray();
        int[] ranks = new int[linables.length*linables[0].length];

        for (int i = 0; i < linables.length; i++) {
            for (int j = 0; j < linables[i].length; j++) {
                ranks[i*linables.length + j] = linables[i][j].getValue();
            }
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step);
            log += matrix.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step) {
        String[] couple = step.split("<->");
        Monster.getMonsterByRank(Integer.parseInt(couple[0]))
                .swapPosition(Monster.getMonsterByRank(Integer.parseInt(couple[1])));
    }

}

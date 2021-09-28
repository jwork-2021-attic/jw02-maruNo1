package HW02.task3;

public class Matrix {

    public Matrix(int length, int width ) {
        this.positions = new Position[length][];
        for(int i = 0; i < length; i++)
        {
            this.positions[i] = new Position[width];
        }
    }

    private Position[][] positions;

    public void put(Linable linable, int i, int j) {
        if (this.positions[i][j] == null) {
            this.positions[i][j] = new Position(null);
        }
        this.positions[i][j].setLinable(linable);
    }

    /*
    public Linable get(int i) {
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[i].linable;
        }
    }
    */

    class Position {

        private Linable linable;

        Position(Linable linable) {
            this.linable = linable;
        }

        public void setLinable(Linable linable) {
            this.linable = linable;
            linable.setPosition(this);
        }

    }

    @Override
    public String toString() {
        String lineString = "\t";
        for (int i=0;i<positions.length;i++) {
            for(int j=0;j<positions[i].length;j++) {
                lineString += positions[i][j].linable.toString();
            }
            lineString += "\n\t";
        }
        return lineString;
    }

    public Linable[][] toArray() {

        Linable[][] linables = new Linable[this.positions.length][];
        for(int i=0; i<this.positions.length;i++){
            linables[i] = new Linable[this.positions[i].length];
        }
        for (int i = 0; i < linables.length; i++) {
            for (int j =0; j< linables[i].length;j++){
                linables[i][j] = positions[i][j].linable;
            }
        }
        return linables;
    }

}
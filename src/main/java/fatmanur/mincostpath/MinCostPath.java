package fatmanur.mincostpath;

public class MinCostPath {

    public int find(int[][] field, Point startpoint, Point endpoint) {

    validateIfTheCellIsOutOfMatrixBound(field,startpoint,endpoint);
        if (startpoint.equals(endpoint)) {
        return field[startpoint.getRow()][startpoint.getColumn()];
    }
        return findMinCostPath(field, startpoint, endpoint);
}

    private int findMinCostPath(int[][] matrix, Point start, Point target) {

        if (start.getRow() > target.getRow() || start.getColumn() > target.getColumn()) {
            return Integer.MAX_VALUE;
        }

        if (start.equals(target)) {
            return matrix[start.getRow()][start.getColumn()];
        }

        int rightPathCost = findMinCostPath(matrix, new Point(start.getRow(), start.getColumn() + 1), target);
        int downPathCost = findMinCostPath(matrix, new Point(start.getRow() + 1, start.getColumn()), target);
        int diagonalPathCost = findMinCostPath(matrix, new Point(start.getRow() + 1, start.getColumn() + 1), target);

        final int min = Math.min(rightPathCost, Math.min(downPathCost, diagonalPathCost));

        return min + matrix[start.getRow()][start.getColumn()];

    }

    private void validateIfTheCellIsOutOfMatrixBound(int[][] field, Point start, Point end) {
        if ((start.getRow() >= field.length || start.getRow() < 0) ||(end.getColumn() >= field[0].length || end.getColumn() < 0) ) {
            throw  new IllegalArgumentException();
        }

    }
}

package fatmanur.mincostpath;

import lombok.Data;

@Data
public class Point {
    private final int row,column;

    @Override
    public boolean equals(Object obj) {
        if (!Point.class.isInstance(obj)) {
            return false;
        }
        final Point cell2 = (Point) obj;
        return cell2.getRow() == this.getRow() && cell2.getColumn() == this.getColumn();
    }
}


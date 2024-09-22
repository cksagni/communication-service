package movieticketbooking.entity;

import movieticketbooking.constants.SeatType;

public class Seat {
    int seatId;
    int row;
    int column;
    SeatType seatType;

    public Seat(int seatId, int row, int column, SeatType seatType) {
        this.seatId = seatId;
        this.row = row;
        this.column = column;
        this.seatType = seatType;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", row=" + row +
                ", column=" + column +
                ", seatType=" + seatType +
                '}';
    }
}

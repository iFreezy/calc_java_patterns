package sample;

import javafx.fxml.FXML;
import lombok.Data;

@Data
public class Model {

    @FXML
    private long num1 = 0;
    private long num2 = 0;

    private boolean start = true;

    private String operator = "";

    public void setNum1(long num1) {
        this.num1 = num1;
    }

    public void setNum2(long num2) {
        this.num2 = num2;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public long getNum1() {
        return this.num1;
    }

    public long getNum2() {
        return this.num2;
    }

    public boolean isStart() {
        return this.start;
    }

    public String getOperator() {
        return this.operator;
    }
}

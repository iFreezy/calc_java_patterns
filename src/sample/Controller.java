package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text output;

    private Model model = new Model();

    public long calculation(long a, long b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) return 0;
                return a / b;
        }
        System.out.println("Неизвестный оператор " + operator);
        return 0;
    }

    @FXML
    private void processNum(ActionEvent event) {
        if (model.isStart()) {
            output.setText("");
            model.setStart(false);
        }
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)){
            if(!model.getOperator().isEmpty()) return;
            model.setOperator(value);
            model.setNum1(Long.parseLong(output.getText()));
            output.setText("");
        }
        else {
            if(model.getOperator().isEmpty()) return;
            output.setText(String.valueOf(calculation(model.getNum1(), Long.parseLong(output.getText()), model.getOperator())));
            model.setOperator("");
            model.setStart(true);
        }
    }

}

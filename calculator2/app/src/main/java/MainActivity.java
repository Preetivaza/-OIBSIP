import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2;
    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI components
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        result = findViewById(R.id.result);

        // Set listeners for each operation button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    // Calculation method
    private void calculate(char operator) {
        String inputText1 = input1.getText().toString();
        String inputText2 = input2.getText().toString();

        if (inputText1.isEmpty() || inputText2.isEmpty()) {
            result.setText("Please enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(inputText1);
        double num2 = Double.parseDouble(inputText2);
        double calculationResult = 0;

        switch (operator) {
            case '+':
                calculationResult = num1 + num2;
                break;
            case '-':
                calculationResult = num1 - num2;
                break;
            case '*':
                calculationResult = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                calculationResult = num1 / num2;
                break;
        }

        result.setText("Result: " + calculationResult);
    }
}

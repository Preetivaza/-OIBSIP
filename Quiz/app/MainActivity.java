import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup optionsGroup;
    private RadioButton option1, option2, option3, option4;
    private Button nextButton, submitButton;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = findViewById(R.id.questionText);
        optionsGroup = findViewById(R.id.optionsGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextButton = findViewById(R.id.nextButton);
        submitButton = findViewById(R.id.submitButton);

        questions = loadQuestions();
        displayQuestion(currentQuestionIndex);

        nextButton.setOnClickListener(v -> {
            checkAnswer();
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.size()) {
                displayQuestion(currentQuestionIndex);
            } else {
                submitButton.setVisibility(View.VISIBLE);
                nextButton.setVisibility(View.GONE);
            }
        });

        submitButton.setOnClickListener(v -> {
            checkAnswer();
            Toast.makeText(this, "Your Score: " + score + "/" + questions.size(), Toast.LENGTH_LONG).show();
        });
    }

    private List<Question> loadQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, 0));
        questions.add(new Question("Who developed the theory of relativity?", new String[]{"Newton", "Einstein", "Tesla", "Curie"}, 1));
        // Add more questions as needed
        return questions;
    }

    private void displayQuestion(int index) {
        Question question = questions.get(index);
        questionText.setText(question.getQuestionText());
        option1.setText(question.getOptions()[0]);
        option2.setText(question.getOptions()[1]);
        option3.setText(question.getOptions()[2]);
        option4.setText(question.getOptions()[3]);
        optionsGroup.clearCheck();
    }

    private void checkAnswer() {
        int selectedOptionIndex = optionsGroup.indexOfChild(findViewById(optionsGroup.getCheckedRadioButtonId()));
        if (selectedOptionIndex == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
            score++;
        }
    }
}

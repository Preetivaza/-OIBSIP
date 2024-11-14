import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView timerText;
    private Button startButton, stopButton, holdButton;

    private Handler handler = new Handler();
    private int seconds = 0;
    private boolean isRunning = false;
    private boolean isHold = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI components
        timerText = findViewById(R.id.timerText);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        holdButton = findViewById(R.id.holdButton);

        // Start Button functionality
        startButton.setOnClickListener(v -> {
            isRunning = true;
            isHold = false;
            runTimer();
        });

        // Stop Button functionality
        stopButton.setOnClickListener(v -> {
            isRunning = false;
            seconds = 0;
            updateTimerDisplay();
        });

        // Hold Button functionality
        holdButton.setOnClickListener(v -> isHold = !isHold);
    }

    // Timer logic
    private void runTimer() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isRunning && !isHold) {
                    seconds++;
                }
                updateTimerDisplay();
                handler.postDelayed(this, 1000);
            }
        });
    }

    // Update the timer display in HH:MM:SS format
    private void updateTimerDisplay() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
        timerText.setText(time);
    }
}

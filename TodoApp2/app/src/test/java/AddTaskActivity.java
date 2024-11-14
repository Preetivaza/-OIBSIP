import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddTaskActivity extends AppCompatActivity {

    private EditText taskInput;
    private Button saveTaskButton;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskInput = findViewById(R.id.taskInput);
        saveTaskButton = findViewById(R.id.saveTaskButton);
        databaseReference = FirebaseDatabase.getInstance().getReference("tasks").child(FirebaseAuth.getInstance().getUid());

        saveTaskButton.setOnClickListener(v -> {
            String task = taskInput.getText().toString();
            if (!task.isEmpty()) {
                databaseReference.push().setValue(task);
                Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Please enter a task", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

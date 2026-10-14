
package com.example.studentattendanceregister;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private EditText studentNameInput;
    private Button addStudentButton;
    private TextView summaryText;
    private TextView emptyText;
    private ListView studentList;

    private final ArrayList<String> studentNames = new ArrayList<>();
    private final ArrayList<Boolean> attendance = new ArrayList<>();

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Connect Java components to the XML layout
        studentNameInput = findViewById(R.id.studentNameInput);
        addStudentButton = findViewById(R.id.addStudentButton);
        summaryText = findViewById(R.id.summaryText);
        emptyText = findViewById(R.id.emptyText);
        studentList = findViewById(R.id.studentList);

        // Create the student list adapter
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                studentNames
        ) {
            @Override
            public View getView(
                    int position,
                    View convertView,
                    ViewGroup parent) {

                View row = convertView;

                if (row == null) {
                    row = LayoutInflater.from(MainActivity.this)
                            .inflate(
                                    R.layout.student_item,
                                    parent,
                                    false
                            );
                }

                TextView nameText =
                        row.findViewById(R.id.studentNameText);

                TextView statusText =
                        row.findViewById(R.id.studentStatusText);

                Button presentButton =
                        row.findViewById(R.id.presentButton);

                Button absentButton =
                        row.findViewById(R.id.absentButton);

                // Display the student's name
                nameText.setText(studentNames.get(position));

                // Display attendance status and colour
                if (attendance.get(position)) {
                    statusText.setText("Status: Present");
                    statusText.setTextColor(
                            Color.rgb(22, 101, 52)
                    );
                } else {
                    statusText.setText("Status: Absent");
                    statusText.setTextColor(
                            Color.rgb(185, 28, 28)
                    );
                }

                // Mark student as present
                presentButton.setOnClickListener(v -> {
                    attendance.set(position, true);
                    updateDisplay();

                    Toast.makeText(
                            MainActivity.this,
                            studentNames.get(position) + " marked Present",
                            Toast.LENGTH_SHORT
                    ).show();
                });

                // Mark student as absent
                absentButton.setOnClickListener(v -> {
                    attendance.set(position, false);
                    updateDisplay();

                    Toast.makeText(
                            MainActivity.this,
                            studentNames.get(position) + " marked Absent",
                            Toast.LENGTH_SHORT
                    ).show();
                });

                return row;
            }
        };

        studentList.setAdapter(adapter);

        // Add student button
        addStudentButton.setOnClickListener(v -> {

            String name = studentNameInput.getText()
                    .toString()
                    .trim();

            // Check for an empty name
            if (name.isEmpty()) {
                Toast.makeText(
                        MainActivity.this,
                        "Please enter a student's name",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Add the student
            studentNames.add(name);

            // New students are initially absent
            attendance.add(false);

            // Clear the input field
            studentNameInput.setText("");

            // Refresh the screen
            updateDisplay();

            Toast.makeText(
                    MainActivity.this,
                    "Student added successfully",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // Display the initial summary
        updateDisplay();
    }

    // Update the student list and attendance summary
    private void updateDisplay() {

        adapter.notifyDataSetChanged();

        int total = studentNames.size();
        int present = 0;
        int absent = 0;

        // Count present and absent students
        for (Boolean isPresent : attendance) {
            if (isPresent) {
                present++;
            } else {
                absent++;
            }
        }

        // Update the summary text
        summaryText.setText(
                "Total: " + total
                        + " | Present: " + present
                        + " | Absent: " + absent
        );

        // Show or hide the empty register message
        if (total == 0) {
            emptyText.setVisibility(View.VISIBLE);
        } else {
            emptyText.setVisibility(View.GONE);
        }
    }
}

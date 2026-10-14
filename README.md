# Student Attendance Register

An Android application for recording and managing student attendance.
The application allows users to add students, mark them as present
or absent, and view attendance summaries.

## Contributors
-Leon Kandie (https://github.com/LeonKandie456)

-Andy Kalia (https://github.com/Elkaparo)


## Overview

The Student Attendance Register is a beginner-friendly Android
development project built to demonstrate fundamental Android
components, event handling, and dynamic user interfaces.

## Features

- Add students to an attendance register.
- Display students in a list.
- Mark students as present or absent.
- Update attendance statuses.
- Automatically calculate attendance totals.
- Display the total number of students.
- Validate empty student names.
- Use colours to distinguish attendance statuses.
- Display a message when the register is empty.

## Technologies Used

- Java
- XML
- Android Studio
- Android SDK
- Git and GitHub

## Application Components

The application uses Android components including:

- Activity
- EditText
- Button
- TextView
- ListView
- LinearLayout
- Toast
- ArrayList
- ArrayAdapter

## Getting Started

### Prerequisites

- Android Studio
- Android SDK
- An Android emulator or Android device

### Installation

1. Clone this repository:

   ```bash
   git clone https://github.com/YOUR_USERNAME/StudentAttendanceRegister.git
   ```

2. Open Android Studio.

3. Select **Open** and choose the cloned project folder.

4. Allow Gradle to synchronize the project.

5. Run the application on an emulator or connected Android device.

## Project Structure

```text
StudentAttendanceRegister/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/studentattendanceregister/
│           │       └── MainActivity.java
│           ├── res/
│           │   └── layout/
│           │       ├── activity_main.xml
│           │       └── student_item.xml
│           └── AndroidManifest.xml
├── README.md
└── ...
```

## Data Storage

The current implementation stores student names and attendance
statuses in memory. Attendance records are not permanently saved
when the application process is restarted.


## Project Objective

To develop an Android application that records student attendance,
allows attendance statuses to be updated, and displays attendance
summaries.

## License

No license has been specified yet.

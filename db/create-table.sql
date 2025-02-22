-- 1. Crear tablas base primero (sin dependencias)
CREATE TABLE IF NOT EXISTS Roles (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Grades (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Types_Schedule (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Attendance_Statuses (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Payment_Types (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Monthly_Fees (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Payment_Methods (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Levels (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Academic_Periods (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- 2. Crear tablas que dependen de las anteriores
CREATE TABLE IF NOT EXISTS Users (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role_id int,
    grade_id int,
    schedule_type_id int,
    FOREIGN KEY (role_id) REFERENCES Roles(id),
    FOREIGN KEY (grade_id) REFERENCES Grades(id),
    FOREIGN KEY (schedule_type_id) REFERENCES Types_Schedule(id)
);

CREATE TABLE IF NOT EXISTS Subjects (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    teacher_id int,
    level_id int,
    section int,
    academic_period_id int,
    days_of_week int,
    start_time TIME,
    end_time TIME,
    classroom VARCHAR(100),
    FOREIGN KEY (academic_period_id) REFERENCES Academic_Periods(id),
    FOREIGN KEY (level_id) REFERENCES Levels(id),
    FOREIGN KEY (teacher_id) REFERENCES Users(id)
);

CREATE TABLE IF NOT EXISTS Payments (
    id int NOT NULL PRIMARY KEY,
    student_id int,
    amount_paid FLOAT,
    payment_method_id int,
    payment_date TIMESTAMP,
    guardian_id int,
    monthly_fee_id int,
    payment_type_id int,
    FOREIGN KEY (payment_type_id) REFERENCES Payment_Types(id),
    FOREIGN KEY (monthly_fee_id) REFERENCES Monthly_Fees(id),
    FOREIGN KEY (payment_method_id) REFERENCES Payment_Methods(id),
    FOREIGN KEY (student_id) REFERENCES Users(id),
    FOREIGN KEY (guardian_id) REFERENCES Users(id)
);

-- 3. Crear tablas de relación
CREATE TABLE IF NOT EXISTS Schedules_Users (
    id int NOT NULL PRIMARY KEY,
    user_id int NOT NULL,
    shift VARCHAR(100) NOT NULL,
    day int,
    start_time TIME,
    end_time TIME,
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE IF NOT EXISTS Assistances_Subjects (
    id int NOT NULL PRIMARY KEY,
    user_id int NOT NULL,
    subject_id int NOT NULL,
    attendance_status_id int NOT NULL,
    comment VARCHAR(255),
    arrival_time TIME,
    date TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (subject_id) REFERENCES Subjects(id),
    FOREIGN KEY (attendance_status_id) REFERENCES Attendance_Statuses(id)
);

CREATE TABLE IF NOT EXISTS Subject_Students (
    subject_id int NOT NULL,
    student_id int NOT NULL,
    PRIMARY KEY (subject_id, student_id),
    FOREIGN KEY (subject_id) REFERENCES Subjects(id),
    FOREIGN KEY (student_id) REFERENCES Users(id)
);

CREATE TABLE IF NOT EXISTS Subject_Grades (
    grade_id int NOT NULL,
    subject_id int NOT NULL,
    PRIMARY KEY (grade_id, subject_id),
    FOREIGN KEY (grade_id) REFERENCES Grades(id),
    FOREIGN KEY (subject_id) REFERENCES Subjects(id)
);

CREATE TABLE IF NOT EXISTS Qualification_Subjects (
    id int NOT NULL PRIMARY KEY,
    qualification int NOT NULL,
    subject_id int NOT NULL,
    user_id int NOT NULL,
    FOREIGN KEY (subject_id) REFERENCES Subjects(id),
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE Users { 
    id int NOT NULL,
    name VARCHAR(255) NOT NULL,
    role_id int,
    grade_id int,
    schedule_type_id int,
    FOREIGN KEY (role_id) REFERENCES Roles(id),
    FOREIGN KEY (grade_id) REFERENCES Grades(id),
    FOREIGN KEY (schedule_type_id) REFERENCES Schedule_Types(id)
};

CREATE TABLE Schedules_Users {
    id int NOT NULL,
    user_id int NOT NULL,
    shift VARCHAR(100) NOT NULL,
    day int,
    start_time TIME,
    end_time TIME,
    FOREIGN KEY (user_id) REFERENCES Users(id)
};

CREATE TABLE Assistances_Subjects{
    user_id int NOT NULL,
    subject_id int NOT NULL,
    attendance_status_id int NOT NULL,
    comment VARCHAR(255),
    arrival_time TIME,
    date DATETIME,
    PRIMARY KEY (user_id, subject_id,),
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (subject_id) REFERENCES Subjects(id),
    FOREIGN KEY (attendance_status_id) REFERENCES Attendance_Statuses(id)
},

CREATE TABLE Attendance_Statuses{
    id int NOT NULL,
    name VARCHAR(100) NOT NULL
}

CREATE TABLE Payments {
    id int NOT NULL,
    student_id int,
    amount_paid FLOAT,
    payment_method_id int,
    payment_date DATETIME,
    guardian_id int,
    monthly_fee_id int,
    payment_type_id int,
    FOREIGN KEY (payment_type_id) REFERENCES Payment_Types(id),
    FOREIGN KEY (monthly_fee_id) REFERENCES Monthly_Fees(id),
    FOREIGN KEY (payment_method_id) REFERENCES Payment_Methods(id),
    FOREIGN KEY (student_id) REFERENCES Users(id),
    FOREIGN KEY (guardian_id) REFERENCES Users(id)
};

CREATE TABLE Payment_Types {
    id int NOT NULL,
    name VARCHAR(100) NOT NULL
};

CREATE TABLE Monthly_Fees {
    id int NOT NULL,
    name VARCHAR(50)
};

CREATE TABLE Payment_Methods {
    id int NOT NULL,
    name VARCHAR(50)
};

CREATE TABLE Roles {
    id int NOT NULL,
    name VARCHAR(50) NOT NULL
};

CREATE TABLE Grades {
    id int NOT NULL,
    name VARCHAR(50) NOT NULL
};

CREATE TABLE Types_Schedule{
    id int NOT NULL,
    name VARCHAR(50) NOT NULL
};

CREATE TABLE Subjects {
    id int NOT NULL,
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
};

CREATE TABLE Levels {
    id int NOT NULL,
    name VARCHAR(50) NOT NULL
};

CREATE TABLE Academic_Periods {
    id int NOT NULL,
    name VARCHAR(50) NOT NULL
};

CREATE TABLE Subject_Students {
    subject_id int NOT NULL,
    student_id int NOT NULL,
    -- qualification_final int NOT NULL,
    PRIMARY KEY (subject_id, student_id),
    FOREIGN KEY (subject_id) REFERENCES Subjects(id),
    FOREIGN KEY (student_id) REFERENCES Users(id)
};

CREATE TABLE Subject_Grades {
    grade_id int NOT NULL,
    subject_id int NOT NULL,
    PRIMARY KEY (grade_id, subject_id),
    FOREIGN KEY (grade_id) REFERENCES Grades(id),
    FOREIGN KEY (subject_id) REFERENCES Subjects(id)
};

CREATE TABLE Qualification_Subjects{
    qualification int NULL NULL,
    subject_id int NOT NULL,
    user_id int NOT NULL,
    PRIMARY KEY (subject_id, user_id),
    FOREIGN KEY (subject_id) REFERENCES Subjects(id),
    FOREIGN KEY (user_id) REFERENCES Users(id)
}
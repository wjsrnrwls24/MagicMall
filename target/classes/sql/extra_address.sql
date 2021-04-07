CREATE TABLE extra_address(

add_no INT PRIMARY KEY AUTO_INCREMENT,

user_no INT NOT NULL,

add_name VARCHAR(100),

address VARCHAR(200),

FOREIGN KEY(user_no)REFERENCES user(user_no) ON DELETE CASCADE
);

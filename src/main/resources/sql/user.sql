CREATE TABLE user(

user_no INT AUTO_INCREMENT PRIMARY KEY,

id VARCHAR(50) NOT NULL UNIQUE,

password VARCHAR(50) NOT NULL,

name VARCHAR(20) NOT NULL ,

email VARCHAR(100) NOT NULL,

p_number INT NOT NULL,

pass_check_question VARCHAR(100) NOT NULL,

pass_check_answer VARCHAR(100) NOT NULL,

reg_date timestamp DEFAULT NOW(),

saved_money int default 0

);
DROP TABLE IF EXISTS USER;
 
CREATE TABLE USER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_id VARCHAR(250) NOT NULL,
  user_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO USER (user_id, user_name, password) VALUES
  ('shalini', 'shalu', 'shalini23'),
  ('gayathri', 'gayu', 'gayathri23');

-- Drop if the user is exist
DROP USER if exists 'DeepakTest'@'localhost';

CREATE USER 'DeepakTest'@'localhost' IDENTIFIED BY 'Pass#123';

GRANT ALL PRIVILEGES ON *.* TO 'DeepakTest'@'localhost';
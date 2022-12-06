CREATE SCHEMA `row-match`;

CREATE TABLE `row-match`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`userId`)
  );

CREATE TABLE `row-match`.`profile` (
  `userid` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `userlevel` INT NULL,
  `usercoin` INT NULL,
  PRIMARY KEY (`userid`),
  CONSTRAINT `userid`
    FOREIGN KEY (`userid`)
    REFERENCES `row-match`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- to avoid complications, I dropped the 'user' table, and renamed 'profile' as 'user'
/*
CREATE TABLE `row-match`.`user`(`userid` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(45) NULL,
`userlevel` INT NULL,
`usercoin` INT NULL,
PRIMARY KEY (`userid`)
);
*/


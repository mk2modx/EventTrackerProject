-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jobappdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jobappdb` ;

-- -----------------------------------------------------
-- Schema jobappdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jobappdb` DEFAULT CHARACTER SET utf8 ;
USE `jobappdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(200) NULL,
  `last_name` VARCHAR(200) NULL,
  `email` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `job_Application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job_Application` ;

CREATE TABLE IF NOT EXISTS `job_Application` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(500) NOT NULL,
  `link` VARCHAR(1000) NULL,
  `date_Apply` DATE NULL,
  `date_Interview` DATE NULL,
  `contact_Name` VARCHAR(200) NULL,
  `contact_Notes` TEXT NULL,
  `additional_Notes` TEXT NULL,
  `status` VARCHAR(100) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_job_Application_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_job_Application_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `technology`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `technology` ;

CREATE TABLE IF NOT EXISTS `technology` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `link` VARCHAR(500) NULL,
  `job_Application_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_technology_job_Application1_idx` (`job_Application_id` ASC),
  INDEX `fk_technology_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_technology_job_Application1`
    FOREIGN KEY (`job_Application_id`)
    REFERENCES `job_Application` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_technology_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS jobappuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'jobappuser'@'localhost' IDENTIFIED BY 'jobappuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'jobappuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobappdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`) VALUES (1, 'Mark', 'Agbayani', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `job_Application`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobappdb`;
INSERT INTO `job_Application` (`id`, `title`, `link`, `date_Apply`, `date_Interview`, `contact_Name`, `contact_Notes`, `additional_Notes`, `status`, `user_id`) VALUES (1, 'Example Job Title', 'www.google.com', NULL, NULL, 'Jimmy John', NULL, NULL, NULL, 1);
INSERT INTO `job_Application` (`id`, `title`, `link`, `date_Apply`, `date_Interview`, `contact_Name`, `contact_Notes`, `additional_Notes`, `status`, `user_id`) VALUES (2, 'Example 2 Job Title', 'www.bing.com', '2019-09-20', '2019-09-21', NULL, NULL, NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `technology`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobappdb`;
INSERT INTO `technology` (`id`, `name`, `link`, `job_Application_id`, `user_id`) VALUES (1, 'Java', 'www.google.com', 1, 1);

COMMIT;


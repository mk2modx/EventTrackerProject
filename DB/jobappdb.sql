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
-- Table `job_application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job_application` ;

CREATE TABLE IF NOT EXISTS `job_application` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(500) NOT NULL,
  `link` VARCHAR(1000) NULL,
  `date_apply` DATE NULL,
  `date_interview` DATE NULL,
  `contact_name` VARCHAR(200) NULL,
  `contact_notes` TEXT NULL,
  `additional_notes` TEXT NULL,
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
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `job_application_technology`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job_application_technology` ;

CREATE TABLE IF NOT EXISTS `job_application_technology` (
  `job_application_id` INT NOT NULL,
  `technology_id` INT NOT NULL,
  PRIMARY KEY (`job_application_id`, `technology_id`),
  INDEX `fk_job_application_has_technology_technology1_idx` (`technology_id` ASC),
  INDEX `fk_job_application_has_technology_job_application1_idx` (`job_application_id` ASC),
  CONSTRAINT `fk_job_application_has_technology_job_application1`
    FOREIGN KEY (`job_application_id`)
    REFERENCES `job_application` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_job_application_has_technology_technology1`
    FOREIGN KEY (`technology_id`)
    REFERENCES `technology` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `technology_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `technology_user` ;

CREATE TABLE IF NOT EXISTS `technology_user` (
  `technology_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`technology_id`, `user_id`),
  INDEX `fk_technology_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_technology_has_user_technology1_idx` (`technology_id` ASC),
  CONSTRAINT `fk_technology_has_user_technology1`
    FOREIGN KEY (`technology_id`)
    REFERENCES `technology` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_technology_has_user_user1`
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
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`) VALUES (1, 'Mark', 'Agbayani', 'marxo2aych@gmail.com');
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`) VALUES (2, 'Test', 'Tester', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `job_application`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobappdb`;
INSERT INTO `job_application` (`id`, `title`, `link`, `date_apply`, `date_interview`, `contact_name`, `contact_notes`, `additional_notes`, `status`, `user_id`) VALUES (1, 'Example Job Title', 'www.google.com', '2019-09-21', NULL, 'Jimmy John', NULL, NULL, NULL, 1);
INSERT INTO `job_application` (`id`, `title`, `link`, `date_apply`, `date_interview`, `contact_name`, `contact_notes`, `additional_notes`, `status`, `user_id`) VALUES (2, 'Example 2 Job Title', 'www.bing.com', '2019-09-20', '2019-09-21', NULL, NULL, NULL, NULL, 1);
INSERT INTO `job_application` (`id`, `title`, `link`, `date_apply`, `date_interview`, `contact_name`, `contact_notes`, `additional_notes`, `status`, `user_id`) VALUES (3, 'Full Stack Java Developer', 'https://www.google.com/search?sxsrf=ACYBGNSZv4VGauRS6Hag2ujIzgYw39ZDxw:1569692083929&ei=s5mPXbutONfT-wTV8quIDA&q=java+jobs+colorado+springs+entry+level&oq=java+jobs+colorado+springs+entry+level&gs_l=psy-ab.3..33i22i29i30l10.6797.10163..10380...0.0..0.141.1487.0j12......0....1..gws-wiz.tt-lnTlgSDI&uact=5&ibp=htl;jobs&sa=X&ved=2ahUKEwj4z_7dhvTkAhUMsp4KHf1bAZoQiYsCKAB6BAgJEAM#fpstate=tldetail&htidocid=Ju_6pgOePhfryzbPAAAAAA%3D%3D&htivrt=jobs', NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `job_application` (`id`, `title`, `link`, `date_apply`, `date_interview`, `contact_name`, `contact_notes`, `additional_notes`, `status`, `user_id`) VALUES (4, 'Entry Level Software Engineer', 'https://www.google.com/search?sxsrf=ACYBGNSZv4VGauRS6Hag2ujIzgYw39ZDxw:1569692083929&ei=s5mPXbutONfT-wTV8quIDA&q=java+jobs+colorado+springs+entry+level&oq=java+jobs+colorado+springs+entry+level&gs_l=psy-ab.3..33i22i29i30l10.6797.10163..10380...0.0..0.141.1487.0j12......0....1..gws-wiz.tt-lnTlgSDI&uact=5&ibp=htl;jobs&sa=X&ved=2ahUKEwj4z_7dhvTkAhUMsp4KHf1bAZoQiYsCKAB6BAgJEAM#fpstate=tldetail&htidocid=KLdF-foxvXyTmuNhAAAAAA%3D%3D&htivrt=jobs', NULL, NULL, NULL, NULL, NULL, NULL, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `technology`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobappdb`;
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (1, 'Java', 'www.google.com');
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (2, 'MySQL', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (3, 'JavaScript', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (4, 'Eclipse', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (5, 'Gradle', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (6, 'Atom', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (7, 'GitHub', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (8, 'MAMP', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (9, 'SPRING', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (10, 'REST API', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (11, 'Apache', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (12, 'Tomcat', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (13, 'CSS', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (14, 'HTML5', NULL);
INSERT INTO `technology` (`id`, `name`, `link`) VALUES (15, 'Mysql Workbench', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `job_application_technology`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobappdb`;
INSERT INTO `job_application_technology` (`job_application_id`, `technology_id`) VALUES (1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `technology_user`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobappdb`;
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (1, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (2, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (3, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (4, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (5, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (6, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (7, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (8, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (9, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (10, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (11, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (12, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (13, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (14, 1);
INSERT INTO `technology_user` (`technology_id`, `user_id`) VALUES (15, 1);

COMMIT;


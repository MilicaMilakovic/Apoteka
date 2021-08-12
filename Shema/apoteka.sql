-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bp_apoteka
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bp_apoteka` ;

-- -----------------------------------------------------
-- Schema bp_apoteka
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bp_apoteka` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `bp_apoteka` ;

-- -----------------------------------------------------
-- Table `bp_apoteka`.`DOKTOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`DOKTOR` (
  `DoktorID` INT NOT NULL AUTO_INCREMENT,
  `JMB` CHAR(13) NOT NULL,
  `Ime` VARCHAR(20) NOT NULL,
  `Prezime` VARCHAR(20) NOT NULL,
  `SifraTima` CHAR(5) NOT NULL,
  `Ambulanta` VARCHAR(45) NOT NULL,
  `KontaktTelefon` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`DoktorID`),
  UNIQUE INDEX `JMB_UNIQUE` (`JMB` ASC) VISIBLE,
  UNIQUE INDEX `SifraTima_UNIQUE` (`SifraTima` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`PACIJENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`PACIJENT` (
  `PacijentID` INT NOT NULL AUTO_INCREMENT,
  `JMB` CHAR(13) NOT NULL,
  `Ime` VARCHAR(20) NOT NULL,
  `Prezime` VARCHAR(20) NOT NULL,
  `DatumRodjenja` DATE NOT NULL,
  `Adresa` VARCHAR(50) NOT NULL,
  `Terapija` VARCHAR(50) NOT NULL,
  `Alergije` VARCHAR(100) NULL,
  `Osiguranje` VARCHAR(25) NULL,
  `DOKTOR_DoktorID` INT NOT NULL,
  PRIMARY KEY (`PacijentID`),
  UNIQUE INDEX `JMB_UNIQUE` (`JMB` ASC) VISIBLE,
  INDEX `fk_PACIJENT_DOKTOR1_idx` (`DOKTOR_DoktorID` ASC) VISIBLE,
  CONSTRAINT `fk_PACIJENT_DOKTOR1`
    FOREIGN KEY (`DOKTOR_DoktorID`)
    REFERENCES `bp_apoteka`.`DOKTOR` (`DoktorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`LIJEK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`LIJEK` (
  `LijekID` INT NOT NULL AUTO_INCREMENT,
  `GenerickiNaziv` VARCHAR(50) NOT NULL,
  `Kategorija` VARCHAR(45) NOT NULL,
  `ProdajnaCijena` DECIMAL(6,2) NOT NULL,
  `NabavnaCijena` DECIMAL(6,2) NULL,
  `Kontraindikacije` VARCHAR(100) BINARY NOT NULL,
  `DatumProizvodnje` DATE NOT NULL,
  `RokUpotrebe` DATE NOT NULL,
  `Kolicina` INT NOT NULL,
  `DodatniOpis` VARCHAR(100) NULL,
  `FarmaceutskiOblik` VARCHAR(45) NULL,
  `JacinaLijeka` VARCHAR(45) NULL,
  PRIMARY KEY (`LijekID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`RECEPT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`RECEPT` (
  `ReceptID` INT NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(20) NOT NULL,
  `Prezime` VARCHAR(20) NOT NULL,
  `BrojZdravstvenogKartona` VARCHAR(45) NULL,
  `NazivZdravstveneUstanove` VARCHAR(45) NULL,
  `AdresaZdravstveneUstanove` VARCHAR(45) NULL,
  `DatumPropisivanjaLijeka` DATETIME NOT NULL,
  `LicniBrojOsiguranika` VARCHAR(45) NULL,
  `Napomena` VARCHAR(45) NULL,
  `PACIJENT_PacijentID` INT NOT NULL,
  `DOKTOR_DoktorID` INT NOT NULL,
  `LIJEK_LijekID` INT NOT NULL,
  PRIMARY KEY (`ReceptID`, `DOKTOR_DoktorID`, `PACIJENT_PacijentID`),
  INDEX `fk_RECEPT_PACIJENT1_idx` (`PACIJENT_PacijentID` ASC) VISIBLE,
  INDEX `fk_RECEPT_DOKTOR1_idx` (`DOKTOR_DoktorID` ASC) VISIBLE,
  INDEX `fk_RECEPT_LIJEK1_idx` (`LIJEK_LijekID` ASC) VISIBLE,
  CONSTRAINT `fk_RECEPT_PACIJENT1`
    FOREIGN KEY (`PACIJENT_PacijentID`)
    REFERENCES `bp_apoteka`.`PACIJENT` (`PacijentID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RECEPT_DOKTOR1`
    FOREIGN KEY (`DOKTOR_DoktorID`)
    REFERENCES `bp_apoteka`.`DOKTOR` (`DoktorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RECEPT_LIJEK1`
    FOREIGN KEY (`LIJEK_LijekID`)
    REFERENCES `bp_apoteka`.`LIJEK` (`LijekID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`ZAPOSLENI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`ZAPOSLENI` (
  `ZaposleniID` INT NOT NULL AUTO_INCREMENT,
  `JMB` CHAR(13) NOT NULL,
  `Ime` VARCHAR(20) NOT NULL,
  `Prezime` VARCHAR(20) NOT NULL,
  `KorisnickoIme` VARCHAR(45) NOT NULL,
  `Lozinka` VARCHAR(45) NOT NULL,
  `DatumRodjenja` DATE NOT NULL,
  `Plata` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`ZaposleniID`),
  UNIQUE INDEX `JMB_UNIQUE` (`JMB` ASC) VISIBLE,
  UNIQUE INDEX `KorisnickoIme_UNIQUE` (`KorisnickoIme` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`FARMACEUTSKI_TEHNICAR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`FARMACEUTSKI_TEHNICAR` (
  `ZAPOSLENI_ZaposleniID` INT NOT NULL,
  PRIMARY KEY (`ZAPOSLENI_ZaposleniID`),
  INDEX `fk_FARMACEUTSKI_TEHNICAR_ZAPOSLENI1_idx` (`ZAPOSLENI_ZaposleniID` ASC) VISIBLE,
  CONSTRAINT `fk_FARMACEUTSKI_TEHNICAR_ZAPOSLENI1`
    FOREIGN KEY (`ZAPOSLENI_ZaposleniID`)
    REFERENCES `bp_apoteka`.`ZAPOSLENI` (`ZaposleniID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`MAGISTAR_FARMACIJE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`MAGISTAR_FARMACIJE` (
  `ZAPOSLENI_ZaposleniID` INT NOT NULL,
  PRIMARY KEY (`ZAPOSLENI_ZaposleniID`),
  INDEX `fk_MAGISTAR_FARMACIJE_ZAPOSLENI1_idx` (`ZAPOSLENI_ZaposleniID` ASC) VISIBLE,
  CONSTRAINT `fk_MAGISTAR_FARMACIJE_ZAPOSLENI1`
    FOREIGN KEY (`ZAPOSLENI_ZaposleniID`)
    REFERENCES `bp_apoteka`.`ZAPOSLENI` (`ZaposleniID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`PROIZVODJAC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`PROIZVODJAC` (
  `ProizvodjacID` INT NOT NULL AUTO_INCREMENT,
  `NazivFarmaceutskeKompanije` VARCHAR(45) NOT NULL,
  `Adresa` VARCHAR(20) NULL,
  `KontaktTelefon` VARCHAR(20) NULL,
  `Email` VARCHAR(20) NULL,
  PRIMARY KEY (`ProizvodjacID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`IZDAVANJE_LIJEKA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`IZDAVANJE_LIJEKA` (
  `ZAPOSLENI_ZaposleniID` INT NOT NULL,
  `LIJEK_LijekID` INT NOT NULL,
  `SifraIzdatogLijeka` VARCHAR(45) NOT NULL,
  `KolicinaIzdatogLijeka` DECIMAL(6,2) NOT NULL,
  `DatumIzdavanja` DATETIME NOT NULL,
  PRIMARY KEY (`ZAPOSLENI_ZaposleniID`, `LIJEK_LijekID`),
  INDEX `fk_ZAPOSLENI_has_LIJEK_LIJEK1_idx` (`LIJEK_LijekID` ASC) VISIBLE,
  INDEX `fk_ZAPOSLENI_has_LIJEK_ZAPOSLENI1_idx` (`ZAPOSLENI_ZaposleniID` ASC) VISIBLE,
  CONSTRAINT `fk_ZAPOSLENI_has_LIJEK_ZAPOSLENI1`
    FOREIGN KEY (`ZAPOSLENI_ZaposleniID`)
    REFERENCES `bp_apoteka`.`ZAPOSLENI` (`ZaposleniID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ZAPOSLENI_has_LIJEK_LIJEK1`
    FOREIGN KEY (`LIJEK_LijekID`)
    REFERENCES `bp_apoteka`.`LIJEK` (`LijekID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`PROIZVODJAC_LIJEKA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`PROIZVODJAC_LIJEKA` (
  `LIJEK_LijekID` INT NOT NULL,
  `PROIZVODJAC_ProizvodjacID` INT NOT NULL,
  `ZasticeniNazivLijeka` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`LIJEK_LijekID`, `PROIZVODJAC_ProizvodjacID`),
  INDEX `fk_LIJEK_has_PROIZVODJAC_PROIZVODJAC1_idx` (`PROIZVODJAC_ProizvodjacID` ASC) VISIBLE,
  INDEX `fk_LIJEK_has_PROIZVODJAC_LIJEK1_idx` (`LIJEK_LijekID` ASC) VISIBLE,
  CONSTRAINT `fk_LIJEK_has_PROIZVODJAC_LIJEK1`
    FOREIGN KEY (`LIJEK_LijekID`)
    REFERENCES `bp_apoteka`.`LIJEK` (`LijekID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LIJEK_has_PROIZVODJAC_PROIZVODJAC1`
    FOREIGN KEY (`PROIZVODJAC_ProizvodjacID`)
    REFERENCES `bp_apoteka`.`PROIZVODJAC` (`ProizvodjacID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`RACUN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`RACUN` (
  `RacunID` INT NOT NULL AUTO_INCREMENT,
  `DatumIzdavanja` DATETIME NOT NULL,
  `Cijena` DECIMAL(6,2) NOT NULL,
  `IZDAVANJE_LIJEKA_ZAPOSLENI_ZaposleniID` INT NOT NULL,
  `IZDAVANJE_LIJEKA_LIJEK_LijekID` INT NOT NULL,
  PRIMARY KEY (`RacunID`),
  INDEX `fk_RACUN_IZDAVANJE_LIJEKA1_idx` (`IZDAVANJE_LIJEKA_ZAPOSLENI_ZaposleniID` ASC, `IZDAVANJE_LIJEKA_LIJEK_LijekID` ASC) VISIBLE,
  CONSTRAINT `fk_RACUN_IZDAVANJE_LIJEKA1`
    FOREIGN KEY (`IZDAVANJE_LIJEKA_ZAPOSLENI_ZaposleniID` , `IZDAVANJE_LIJEKA_LIJEK_LijekID`)
    REFERENCES `bp_apoteka`.`IZDAVANJE_LIJEKA` (`ZAPOSLENI_ZaposleniID` , `LIJEK_LijekID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`DOBAVLJAC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`DOBAVLJAC` (
  `DobavljacID` INT NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(20) NOT NULL,
  `KontaktTelefon` VARCHAR(15) NOT NULL,
  `Adresa` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`DobavljacID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`NABAVKA_LIJEKA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`NABAVKA_LIJEKA` (
  `LIJEK_LijekID` INT NOT NULL,
  `ZAPOSLENI_ZaposleniID` INT NOT NULL,
  `DostupnaKolicna` DECIMAL(6,2) NOT NULL,
  `DatumNabavke` DATE NOT NULL,
  `NarucenaKolicina` DECIMAL(6,2) NOT NULL,
  `DatumIsporuke` DATE NOT NULL,
  `IsporucenaKolicina` DECIMAL NOT NULL,
  `DOBAVLJAC_DobavljacID` INT NOT NULL,
  PRIMARY KEY (`LIJEK_LijekID`, `ZAPOSLENI_ZaposleniID`, `DOBAVLJAC_DobavljacID`),
  INDEX `fk_LIJEK_has_ZAPOSLENI_ZAPOSLENI1_idx` (`ZAPOSLENI_ZaposleniID` ASC) VISIBLE,
  INDEX `fk_LIJEK_has_ZAPOSLENI_LIJEK1_idx` (`LIJEK_LijekID` ASC) VISIBLE,
  INDEX `fk_NABAVKA_LIJEKA_DOBAVLJAC1_idx` (`DOBAVLJAC_DobavljacID` ASC) VISIBLE,
  CONSTRAINT `fk_LIJEK_has_ZAPOSLENI_LIJEK1`
    FOREIGN KEY (`LIJEK_LijekID`)
    REFERENCES `bp_apoteka`.`LIJEK` (`LijekID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LIJEK_has_ZAPOSLENI_ZAPOSLENI1`
    FOREIGN KEY (`ZAPOSLENI_ZaposleniID`)
    REFERENCES `bp_apoteka`.`ZAPOSLENI` (`ZaposleniID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NABAVKA_LIJEKA_DOBAVLJAC1`
    FOREIGN KEY (`DOBAVLJAC_DobavljacID`)
    REFERENCES `bp_apoteka`.`DOBAVLJAC` (`DobavljacID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`APOTEKA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`APOTEKA` (
  `ApotekaID` INT NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(20) NOT NULL,
  `Adresa` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(20) NULL,
  PRIMARY KEY (`ApotekaID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`ZAPOSLENJE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`ZAPOSLENJE` (
  `ZAPOSLENI_ZaposleniID` INT NOT NULL,
  `APOTEKA_ApotekaID` INT NOT NULL,
  `DatumOd` DATE NOT NULL,
  `DatumDo` DATE NOT NULL,
  PRIMARY KEY (`ZAPOSLENI_ZaposleniID`, `APOTEKA_ApotekaID`),
  INDEX `fk_ZAPOSLENI_has_APOTEKA_APOTEKA1_idx` (`APOTEKA_ApotekaID` ASC) VISIBLE,
  INDEX `fk_ZAPOSLENI_has_APOTEKA_ZAPOSLENI1_idx` (`ZAPOSLENI_ZaposleniID` ASC) VISIBLE,
  CONSTRAINT `fk_ZAPOSLENI_has_APOTEKA_ZAPOSLENI1`
    FOREIGN KEY (`ZAPOSLENI_ZaposleniID`)
    REFERENCES `bp_apoteka`.`ZAPOSLENI` (`ZaposleniID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ZAPOSLENI_has_APOTEKA_APOTEKA1`
    FOREIGN KEY (`APOTEKA_ApotekaID`)
    REFERENCES `bp_apoteka`.`APOTEKA` (`ApotekaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`TELEFON_APOTEKE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`TELEFON_APOTEKE` (
  `Telefon` VARCHAR(20) NOT NULL,
  `APOTEKA_ApotekaID` INT NOT NULL,
  PRIMARY KEY (`Telefon`, `APOTEKA_ApotekaID`),
  INDEX `fk_TELEFON_APOTEKE_APOTEKA1_idx` (`APOTEKA_ApotekaID` ASC) VISIBLE,
  CONSTRAINT `fk_TELEFON_APOTEKE_APOTEKA1`
    FOREIGN KEY (`APOTEKA_ApotekaID`)
    REFERENCES `bp_apoteka`.`APOTEKA` (`ApotekaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

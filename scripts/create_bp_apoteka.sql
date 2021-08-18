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
  `SifraBolesti` VARCHAR(50) NOT NULL,
  `Alergije` VARCHAR(100) NULL,
  `Osiguranje` VARCHAR(25) NULL,
  `DoktorID` INT NOT NULL,
  PRIMARY KEY (`PacijentID`),
  UNIQUE INDEX `JMB_UNIQUE` (`JMB` ASC) VISIBLE,
  INDEX `fk_PACIJENT_DOKTOR1_idx` (`DoktorID` ASC) VISIBLE,
  CONSTRAINT `fk_PACIJENT_DOKTOR1`
    FOREIGN KEY (`DoktorID`)
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
  `IzdavanjeNaRecept` TINYINT(1) NULL DEFAULT 0,
  `Aktivan` TINYINT(1) NULL DEFAULT 1,
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
  `DatumPropisivanjaLijeka` DATE NOT NULL,
  `LicniBrojOsiguranika` VARCHAR(45) NULL,
  `PropisanaKolicina` DECIMAL(6,2) NULL,
  `Vazeci` TINYINT(1) NULL DEFAULT 1,
  `PacijentID` INT NOT NULL,
  `DoktorID` INT NOT NULL,
  `LijekID` INT NOT NULL,
  PRIMARY KEY (`ReceptID`),
  INDEX `fk_RECEPT_PACIJENT1_idx` (`PacijentID` ASC) VISIBLE,
  INDEX `fk_RECEPT_DOKTOR1_idx` (`DoktorID` ASC) VISIBLE,
  INDEX `fk_RECEPT_LIJEK1_idx` (`LijekID` ASC) VISIBLE,
  CONSTRAINT `fk_RECEPT_PACIJENT1`
    FOREIGN KEY (`PacijentID`)
    REFERENCES `bp_apoteka`.`PACIJENT` (`PacijentID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RECEPT_DOKTOR1`
    FOREIGN KEY (`DoktorID`)
    REFERENCES `bp_apoteka`.`DOKTOR` (`DoktorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RECEPT_LIJEK1`
    FOREIGN KEY (`LijekID`)
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
  `Aktivan` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`ZaposleniID`),
  UNIQUE INDEX `JMB_UNIQUE` (`JMB` ASC) VISIBLE,
  UNIQUE INDEX `KorisnickoIme_UNIQUE` (`KorisnickoIme` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`FARMACEUTSKI_TEHNICAR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`FARMACEUTSKI_TEHNICAR` (
  `ZaposleniID` INT NOT NULL,
  PRIMARY KEY (`ZaposleniID`),
  INDEX `fk_FARMACEUTSKI_TEHNICAR_ZAPOSLENI1_idx` (`ZaposleniID` ASC) VISIBLE,
  CONSTRAINT `fk_FARMACEUTSKI_TEHNICAR_ZAPOSLENI1`
    FOREIGN KEY (`ZaposleniID`)
    REFERENCES `bp_apoteka`.`ZAPOSLENI` (`ZaposleniID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`MAGISTAR_FARMACIJE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`MAGISTAR_FARMACIJE` (
  `ZaposleniID` INT NOT NULL,
  PRIMARY KEY (`ZaposleniID`),
  INDEX `fk_MAGISTAR_FARMACIJE_ZAPOSLENI1_idx` (`ZaposleniID` ASC) VISIBLE,
  CONSTRAINT `fk_MAGISTAR_FARMACIJE_ZAPOSLENI1`
    FOREIGN KEY (`ZaposleniID`)
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
-- Table `bp_apoteka`.`FISKALNI_RACUN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`FISKALNI_RACUN` (
  `RacunID` INT NOT NULL AUTO_INCREMENT,
  `DatumIzdavanja` DATETIME NOT NULL,
  `CijenaUkupno` DECIMAL(6,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`RacunID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`IZDAVANJE_LIJEKA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`IZDAVANJE_LIJEKA` (
  `ZaposleniID` INT NOT NULL,
  `LijekID` INT NOT NULL,
  `ReceptID` INT NULL,
  `KolicinaIzdatogLijeka` DECIMAL(6,2) NOT NULL,
  `DatumIzdavanja` DATETIME NOT NULL,
  `RacunID` INT NULL,
  PRIMARY KEY (`LijekID`, `ZaposleniID`, `DatumIzdavanja`),
  INDEX `fk_ZAPOSLENI_has_LIJEK_LIJEK1_idx` (`LijekID` ASC) VISIBLE,
  INDEX `fk_ZAPOSLENI_has_LIJEK_ZAPOSLENI1_idx` (`ZaposleniID` ASC) VISIBLE,
  INDEX `fk_ZAPOSLENI_has_LIJEK_LIJEK1_idx1` (`ReceptID` ASC) VISIBLE,
  INDEX `fk_IZDAVANJE_LIJEKA_FISKALNI_RACUN1_idx` (`RacunID` ASC) VISIBLE,
  CONSTRAINT `fk_ZAPOSLENI_has_LIJEK_ZAPOSLENI1`
    FOREIGN KEY (`ZaposleniID`)
    REFERENCES `bp_apoteka`.`ZAPOSLENI` (`ZaposleniID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ZAPOSLENI_has_LIJEK_LIJEK1`
    FOREIGN KEY (`LijekID`)
    REFERENCES `bp_apoteka`.`LIJEK` (`LijekID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ZAPOSLENI_has_LIJEK_RECEPT1`
    FOREIGN KEY (`ReceptID`)
    REFERENCES `bp_apoteka`.`RECEPT` (`ReceptID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IZDAVANJE_LIJEKA_FISKALNI_RACUN1`
    FOREIGN KEY (`RacunID`)
    REFERENCES `bp_apoteka`.`FISKALNI_RACUN` (`RacunID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`PROIZVODJAC_LIJEKA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`PROIZVODJAC_LIJEKA` (
  `LijekID` INT NOT NULL,
  `ProizvodjacID` INT NOT NULL,
  `ZasticeniNazivLijeka` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`LijekID`, `ProizvodjacID`),
  INDEX `fk_LIJEK_has_PROIZVODJAC_PROIZVODJAC1_idx` (`ProizvodjacID` ASC) VISIBLE,
  INDEX `fk_LIJEK_has_PROIZVODJAC_LIJEK1_idx` (`LijekID` ASC) VISIBLE,
  CONSTRAINT `fk_LIJEK_has_PROIZVODJAC_LIJEK1`
    FOREIGN KEY (`LijekID`)
    REFERENCES `bp_apoteka`.`LIJEK` (`LijekID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LIJEK_has_PROIZVODJAC_PROIZVODJAC1`
    FOREIGN KEY (`ProizvodjacID`)
    REFERENCES `bp_apoteka`.`PROIZVODJAC` (`ProizvodjacID`)
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
  `BrojNabavke` VARCHAR(45) NOT NULL,
  `DatumNabavke` DATE NOT NULL,
  `DatumIsporuke` DATE NOT NULL,
  `ZaposleniID` INT NOT NULL,
  `DobavljacID` INT NOT NULL,
  PRIMARY KEY (`BrojNabavke`),
  INDEX `fk_LIJEK_has_ZAPOSLENI_ZAPOSLENI1_idx` (`ZaposleniID` ASC) VISIBLE,
  INDEX `fk_NABAVKA_LIJEKA_DOBAVLJAC1_idx` (`DobavljacID` ASC) VISIBLE,
  CONSTRAINT `fk_LIJEK_has_ZAPOSLENI_ZAPOSLENI1`
    FOREIGN KEY (`ZaposleniID`)
    REFERENCES `bp_apoteka`.`ZAPOSLENI` (`ZaposleniID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NABAVKA_LIJEKA_DOBAVLJAC1`
    FOREIGN KEY (`DobavljacID`)
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
  `ZaposleniID` INT NOT NULL,
  `ApotekaID` INT NOT NULL,
  `DatumOd` DATE NOT NULL,
  `DatumDo` DATE NULL,
  PRIMARY KEY (`ZaposleniID`, `ApotekaID`),
  INDEX `fk_ZAPOSLENI_has_APOTEKA_APOTEKA1_idx` (`ApotekaID` ASC) VISIBLE,
  INDEX `fk_ZAPOSLENI_has_APOTEKA_ZAPOSLENI1_idx` (`ZaposleniID` ASC) VISIBLE,
  CONSTRAINT `fk_ZAPOSLENI_has_APOTEKA_ZAPOSLENI1`
    FOREIGN KEY (`ZaposleniID`)
    REFERENCES `bp_apoteka`.`ZAPOSLENI` (`ZaposleniID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ZAPOSLENI_has_APOTEKA_APOTEKA1`
    FOREIGN KEY (`ApotekaID`)
    REFERENCES `bp_apoteka`.`APOTEKA` (`ApotekaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`TELEFON_APOTEKE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`TELEFON_APOTEKE` (
  `Telefon` VARCHAR(20) NOT NULL,
  `ApotekaID` INT NOT NULL,
  PRIMARY KEY (`Telefon`, `ApotekaID`),
  INDEX `fk_TELEFON_APOTEKE_APOTEKA1_idx` (`ApotekaID` ASC) VISIBLE,
  CONSTRAINT `fk_TELEFON_APOTEKE_APOTEKA1`
    FOREIGN KEY (`ApotekaID`)
    REFERENCES `bp_apoteka`.`APOTEKA` (`ApotekaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`BANKA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`BANKA` (
  `BankaID` INT NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(50) NOT NULL,
  `Adresa` VARCHAR(45) NOT NULL,
  `KontaktTelefon` VARCHAR(20) NULL,
  PRIMARY KEY (`BankaID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`RACUN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`RACUN` (
  `BrojRacuna` INT NOT NULL AUTO_INCREMENT,
  `BankaID` INT NOT NULL,
  `ApotekaID` INT NOT NULL,
  PRIMARY KEY (`BrojRacuna`),
  INDEX `fk_RACUN_BANKA1_idx` (`BankaID` ASC) VISIBLE,
  INDEX `fk_RACUN_APOTEKA1_idx` (`ApotekaID` ASC) VISIBLE,
  CONSTRAINT `fk_RACUN_BANKA1`
    FOREIGN KEY (`BankaID`)
    REFERENCES `bp_apoteka`.`BANKA` (`BankaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RACUN_APOTEKA1`
    FOREIGN KEY (`ApotekaID`)
    REFERENCES `bp_apoteka`.`APOTEKA` (`ApotekaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`ISPLATA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`ISPLATA` (
  `BrojIsplate` INT NOT NULL AUTO_INCREMENT,
  `BrojRacuna` INT NOT NULL,
  `Iznos` DECIMAL(6,2) NULL,
  `DatumIsplate` DATE NULL,
  PRIMARY KEY (`BrojIsplate`),
  INDEX `fk_ISPLATA_RACUN1_idx` (`BrojRacuna` ASC) VISIBLE,
  CONSTRAINT `fk_ISPLATA_RACUN1`
    FOREIGN KEY (`BrojRacuna`)
    REFERENCES `bp_apoteka`.`RACUN` (`BrojRacuna`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`NABAVKA_LIJEKA_STAVKA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`NABAVKA_LIJEKA_STAVKA` (
  `LijekID` INT NOT NULL,
  `BrojNabavke` VARCHAR(45) NOT NULL,
  `NarucenaKolicina` DECIMAL(6,2) NOT NULL,
  `BrojIsplate` INT NULL,
  PRIMARY KEY (`LijekID`, `BrojNabavke`),
  INDEX `fk_LIJEK_has_NABAVKA_LIJEKA_NABAVKA_LIJEKA1_idx` (`BrojNabavke` ASC) VISIBLE,
  INDEX `fk_LIJEK_has_NABAVKA_LIJEKA_LIJEK1_idx` (`LijekID` ASC) VISIBLE,
  INDEX `fk_NABAVKA_LIJEKA_STAVKA_ISPLATA1_idx` (`BrojIsplate` ASC) VISIBLE,
  CONSTRAINT `fk_LIJEK_has_NABAVKA_LIJEKA_LIJEK1`
    FOREIGN KEY (`LijekID`)
    REFERENCES `bp_apoteka`.`LIJEK` (`LijekID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LIJEK_has_NABAVKA_LIJEKA_NABAVKA_LIJEKA1`
    FOREIGN KEY (`BrojNabavke`)
    REFERENCES `bp_apoteka`.`NABAVKA_LIJEKA` (`BrojNabavke`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NABAVKA_LIJEKA_STAVKA_ISPLATA1`
    FOREIGN KEY (`BrojIsplate`)
    REFERENCES `bp_apoteka`.`ISPLATA` (`BrojIsplate`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bp_apoteka`.`FISKALNI_RACUN_STAVKA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bp_apoteka`.`FISKALNI_RACUN_STAVKA` (
  `LijekID` INT NOT NULL,
  `RacunID` INT NOT NULL,
  `Kolicina` DECIMAL(6,2) NOT NULL DEFAULT 1,
  `Cijena` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`LijekID`, `RacunID`),
  INDEX `fk_LIJEK_has_FISKALNI_RACUN_FISKALNI_RACUN1_idx` (`RacunID` ASC) VISIBLE,
  INDEX `fk_LIJEK_has_FISKALNI_RACUN_LIJEK1_idx` (`LijekID` ASC) VISIBLE,
  CONSTRAINT `fk_LIJEK_has_FISKALNI_RACUN_LIJEK1`
    FOREIGN KEY (`LijekID`)
    REFERENCES `bp_apoteka`.`LIJEK` (`LijekID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LIJEK_has_FISKALNI_RACUN_FISKALNI_RACUN1`
    FOREIGN KEY (`RacunID`)
    REFERENCES `bp_apoteka`.`FISKALNI_RACUN` (`RacunID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

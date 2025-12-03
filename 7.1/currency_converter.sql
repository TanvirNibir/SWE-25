DROP DATABASE IF EXISTS currency_converter;

CREATE DATABASE currency_converter;

USE currency_converter;

CREATE TABLE CURRENCY (
    abbreviation CHAR(3) NOT NULL,
    name         VARCHAR(100) NOT NULL,
    rate_to_usd  DECIMAL(12, 6) NOT NULL,
    PRIMARY KEY (abbreviation)
);

INSERT INTO CURRENCY (abbreviation, name, rate_to_usd) VALUES
    ('USD', 'United States Dollar', 1.000000),
    ('EUR', 'Euro',                 1.080000), 
    ('GBP', 'British Pound',        1.270000),
    ('JPY', 'Japanese Yen',         0.006600),
    ('CHF', 'Swiss Franc',          1.120000),
    ('CAD', 'Canadian Dollar',      0.740000),
    ('AUD', 'Australian Dollar',    0.670000),
    ('SEK', 'Swedish Krona',        0.095000);

DROP USER IF EXISTS 'appuser'@'localhost';

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT
ON currency_converter.CURRENCY
TO 'appuser'@'localhost';

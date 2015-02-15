CREATE DATABASE coinsmarket;

USE coinsmarket;

CREATE TABLE country (
  name VARCHAR(10) NOT NULL,
  full_name VARCHAR(100) NOT NULL,
  PRIMARY KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE coin (
  id INT NOT NULL AUTO_INCREMENT,
  description VARCHAR(1000) NOT NULL,
  composition VARCHAR(50) NOT NULL,
  country_name VARCHAR(10) NOT NULL,
  year INT(4) NOT NULL,
  circulation INT NOT NULL,
  grade VARCHAR(50) NOT NULL,
  price DECIMAL,
  PRIMARY KEY (id),
  FOREIGN KEY (country_name)
    REFERENCES country(name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE subscriber (
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE subscriber_country (
  subscriber_email VARCHAR(100) NOT NULL,
  country_name VARCHAR(10) NOT NULL,
  PRIMARY KEY  (subscriber_email, country_name),
  FOREIGN KEY (subscriber_email)
    REFERENCES subscriber(email),
  FOREIGN KEY (country_name)
    REFERENCES country(name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

commit;
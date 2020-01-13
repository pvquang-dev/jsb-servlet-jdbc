use jspservlet122019;

CREATE TABLE user (
id bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(30) NOT NULL,
fullname VARCHAR(30) NOT NULL,
password VARCHAR(30) NOT NULL
);

CREATE TABLE role (
id bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
code VARCHAR(30) NOT NULL
);

CREATE TABLE user_role (
id bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY,
userid bigint NOT null,
roleid bigint NOT null
);

ALTER TABLE user_role ADD FOREIGN KEY (userid) REFERENCES user(id);
ALTER TABLE user_role ADD FOREIGN KEY (roleid) REFERENCES role(id);

CREATE TABLE building (
id bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NULL,
ward VARCHAR(30) NULL,
street VARCHAR(30) NULL,
structure VARCHAR(30) NULL,
numberofbasement int NULL,
floorarea int null,
direction VARCHAR(30) NULL,
rankz VARCHAR(30) NULL,
rentareadescription text NULL,
rentcost int NULL,
costdescription text NULL,
servicecost VARCHAR(255) NULL,
carcost VARCHAR(30) NULL,
motocost VARCHAR(30) NULL,
overtimecost VARCHAR(30) NULL,
electricbuill VARCHAR(30) NULL,
deposit VARCHAR(30) NULL,
payment VARCHAR(30) NULL,
timerent VARCHAR(30) NULL,
timedecorator VARCHAR(30) NULL,
managername VARCHAR(30) NULL,
managerphone VARCHAR(30) NULL,
timerent VARCHAR(30) NULL,
dictrict VARCHAR(30) NULL,
type VARCHAR(30) NULL
);

CREATE TABLE rentarea (
id bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY,
value int NOT NULL,
buildingid bigint NOT NULL
);

CREATE TABLE assignmentbuilding (
id bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY, 
staffid bigint NOT NULL,
buildingid bigint NOT NULL
);

ALTER TABLE assignmentbuilding ADD FOREIGN KEY (buildingid) REFERENCES building(id);
ALTER TABLE assignmentbuilding ADD FOREIGN KEY (staffid) REFERENCES user(id);
ALTER TABLE rentarea ADD FOREIGN KEY (buildingid) REFERENCES building(id);

use jspservlet122019;

CREATE TABLE user (
id bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(30) NOT NULL,
fullname VARCHAR(30) NOT NULL,
password VARCHAR(30) NOT NULL,
createdate DATETIME NULL,
modifieddate DATETIME NULL,
createdby VARCHAR(255) NULL,
modifiedby varchar(255) NULL
);

CREATE TABLE role (
id bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
code VARCHAR(30) NOT NULL,
createdate DATETIME NULL,
modifieddate DATETIME NULL,
createdby VARCHAR(255) NULL,
modifiedby varchar(255) NULL
);

CREATE TABLE user_role (
id bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY,
userid bigint NOT null,
roleid bigint NOT null,
createdate DATETIME NULL,
modifieddate DATETIME NULL,
createdby VARCHAR(255) NULL,
modifiedby varchar(255) NULL
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
dictrict VARCHAR(30) NULL,
type VARCHAR(30) NULL,
createdate DATETIME NULL,
modifieddate DATETIME NULL,
createdby VARCHAR(255) NULL,
modifiedby varchar(255) NULL
);

CREATE TABLE rentarea (
id bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY,
value int NOT NULL,
buildingid bigint NOT NULL,
createdate DATETIME NULL,
modifieddate DATETIME NULL,
createdby VARCHAR(255) NULL,
modifiedby varchar(255) NULL
);

CREATE TABLE assignmentbuilding (
id bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY, 
staffid bigint NOT NULL,
buildingid bigint NOT NULL,
createdate DATETIME NULL,
modifieddate DATETIME NULL,
createdby VARCHAR(255) NULL,
modifiedby varchar(255) NULL
);

ALTER TABLE assignmentbuilding ADD FOREIGN KEY (buildingid) REFERENCES building(id);
ALTER TABLE assignmentbuilding ADD FOREIGN KEY (staffid) REFERENCES user(id);
ALTER TABLE rentarea ADD FOREIGN KEY (buildingid) REFERENCES building(id);

INSERT INTO user (username, fullname, password) VALUES ('nguyenvana', 'nguyen van a', '123456a@');
INSERT INTO user (username, fullname, password) VALUES ('nguyenvanb', 'nguyen van b', '123456a@');
INSERT INTO user (username, fullname, password) VALUES ('nguyenvanc', 'nguyen van c', '123456a@');
INSERT INTO user (username, fullname, password) VALUES ('nguyenvand', 'nguyen van d', '123456a@');

INSERT INTO role (name, code) VALUES ('quản lí', 'manager');
INSERT INTO role (name, code) VALUES ('nhân viên', 'staff');

INSERT INTO user_role (userid, roleid) VALUES (1, 1);
INSERT INTO user_role (userid, roleid) VALUES (2, 2);
INSERT INTO user_role (userid, roleid) VALUES (3, 2);
INSERT INTO user_role (userid, roleid) VALUES (4, 2);

INSERT INTO building (name, numberofbasement, floorarea, dictrict, ward, street, rentcost, costdescription, managername, managerphone, type) VALUES ('Nam Giao Building Tower', 2, 500, 'QUAN_1', 'Phường 2', '59 phan xích long', 15, '15 triệu/m2', 'thoa', '0357540288', 'TANG_TRET,NGUYEN_CAN');

INSERT INTO building (name, numberofbasement, floorarea, dictrict, ward, street, rentcost, costdescription, managername, managerphone, type) VALUES ('ACM Tower', 2, 650, 'QUAN_2', 'Phường 4', '96 cao thắng', 18, '18 triệu/m2', 'cuong', '0357540288', 'NGUYEN_CAN');

INSERT INTO building (name, numberofbasement, floorarea, dictrict, ward, street, rentcost, costdescription, managername, managerphone, type) VALUES ('Alpha 2 Building Tower', 1, 200, 'QUAN_1', 'Phường 6', '153 nguyễn đình chiểu', 20, '20 triệu/m2', 'huy', '0357540288', 'NOI_THAT');

INSERT INTO building (name, numberofbasement, floorarea, dictrict, ward, street, rentcost, costdescription, managername, managerphone, type) VALUES ('IDD 1 Building', 1, 200, 'QUAN_4', 'Phường 7', '111 Lý chính thắng', 12, '12 triệu/m2', 'vy', '0357540288', 'TANG_TRET,NGUYEN_CAN,NOI_THAT');

INSERT INTO rentarea (value, buildingid) VALUES (100, 1);
INSERT INTO rentarea (value, buildingid) VALUES (200, 1);
INSERT INTO rentarea (value, buildingid) VALUES (200, 2);
INSERT INTO rentarea (value, buildingid) VALUES (300, 2);
INSERT INTO rentarea (value, buildingid) VALUES (400, 2);
INSERT INTO rentarea (value, buildingid) VALUES (300, 3);
INSERT INTO rentarea (value, buildingid) VALUES (400, 3);
INSERT INTO rentarea (value, buildingid) VALUES (500, 3);
INSERT INTO rentarea (value, buildingid) VALUES (100, 4);
INSERT INTO rentarea (value, buildingid) VALUES (250, 4);
INSERT INTO rentarea (value, buildingid) VALUES (400, 4);

INSERT INTO assignmentbuilding (staffid, buildingid) VALUES (2, 1);
INSERT INTO assignmentbuilding (staffid, buildingid) VALUES (2, 3);
INSERT INTO assignmentbuilding (staffid, buildingid) VALUES (3, 1);
INSERT INTO assignmentbuilding (staffid, buildingid) VALUES (3, 4);

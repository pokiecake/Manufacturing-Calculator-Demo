USE manufacturing;

DROP TABLE IF EXISTS PartsCost;
DROP TABLE IF EXISTS Parts;

CREATE TABLE Parts(
	part_id INT AUTO_INCREMENT,
    part_name VARCHAR(200) NOT NULL,
    company VARCHAR(200) NOT NULL,
    PRIMARY KEY (part_id)
);

INSERT INTO Parts(part_name, company)
VALUES
("23' wheel", "wheels-ready"),
("22' wheel", "better-wheels"),
("hardened bolt", "bolt-forge"),
("4-inch bolt", "bolts-to-go");

CREATE TABLE PartsCost(
	part_id INT NOT NULL,
    amount INT NOT NULL,
    cost FLOAT NOT NULL,
    PRIMARY KEY(part_id, amount),
    CONSTRAINT FK_part_id FOREIGN KEY (part_id) REFERENCES Parts(part_id)
);

INSERT INTO PartsCost(part_id, amount, cost)
VALUES
(1, 1, 7.50),
(2, 1, 6.25),
(3, 1, 1.50),
(4, 1, 1.25),
(3, 20, 23.00),
(4, 15, 14.25);
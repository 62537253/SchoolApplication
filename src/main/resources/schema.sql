CREATE TABLE Classes
(
    id_class INT AUTO_INCREMENT PRIMARY KEY,
    quantity	INT           NOT NULL,
    name_class  NVARCHAR(250) NOT NULL,
    headman   	NVARCHAR(250) NOT NULL
);

CREATE TABLE Students
(
    id_student    INT AUTO_INCREMENT PRIMARY KEY,
    id_class   	  INT REFERENCES Classes(id_class),
    name_student  NVARCHAR(250) NOT NULL,
    dater  	  DATE          NOT NULL,
    addresses     NVARCHAR(250) NOT NULL,
    gender	  BOOLEAN       NOT NULL,
    estimation   INT        NOT NULL
);
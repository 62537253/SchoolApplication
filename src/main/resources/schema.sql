CREATE TABLE Card
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    concentration  long NOT NULL,
    student  	  boolean          NOT NULL,
    gallery     long NOT NULL,
    gender	  BOOLEAN       NOT NULL,
    scheme   INT        NOT NULL,
    drink   double        NOT NULL
);
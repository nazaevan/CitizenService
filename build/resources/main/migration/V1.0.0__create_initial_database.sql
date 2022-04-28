CREATE SCHEMA IF NOT EXISTS mentoring;

CREATE TABLE IF NOT EXISTS mentoring.department (
  id Serial PRIMARY KEY,
  description varchar(255)
);

INSERT INTO mentoring.department (description) VALUES ('Mayors Office');
INSERT INTO mentoring.department (description) VALUES ('Municipal Civil Registry');
INSERT INTO mentoring.department (description) VALUES ('Municipal Public Works');
INSERT INTO mentoring.department (description) VALUES ('Municipal Regulations and Events');
INSERT INTO mentoring.department (description) VALUES ('Municipal Water and Sewage');
INSERT INTO mentoring.department (description) VALUES ('Municipal Public Lighting');
INSERT INTO mentoring.department (description) VALUES ('SYSTEM');

CREATE TABLE  IF NOT EXISTS mentoring.record (
  id Serial PRIMARY KEY,
  id_status varchar(25),
  is_public boolean NOT NULL DEFAULT false
);

CREATE TABLE  IF NOT EXISTS mentoring.status (
  id varchar(25) PRIMARY KEY,
  description varchar(255)
);

INSERT INTO mentoring.status VALUES ('1', 'Opened');
INSERT INTO mentoring.status(id, description) VALUES ('2', 'In progress');
INSERT INTO mentoring.status(id, description) VALUES ('3', 'Closed');

CREATE TABLE  IF NOT EXISTS mentoring.reviewer (
  id Serial PRIMARY KEY,
  name varchar(255),
  last_name varchar(255),
  id_department bigint,
  created_at timestamp(0) without time zone NOT NULL DEFAULT now(),
  updated_at timestamp(0) without time zone NOT NULL DEFAULT now(),
  CONSTRAINT id_department_fk FOREIGN KEY (id_department) REFERENCES mentoring.department(id)
);

INSERT INTO mentoring.reviewer (name, last_name, id_department) VALUES ('SYSTEM', 'SYSTEM', 7);

CREATE TABLE  IF NOT EXISTS mentoring.request (
  id Serial PRIMARY KEY,
  id_status varchar(25),
  id_record bigint,
  id_reviewer bigint,
  requester_name varchar(255),
  created_at timestamp(0) without time zone NOT NULL DEFAULT now(),
  updated_at timestamp(0) without time zone NOT NULL DEFAULT now(),
  CONSTRAINT id_status_fk FOREIGN KEY (id_status) REFERENCES mentoring.status(id),
  CONSTRAINT id_record_fk FOREIGN KEY (id_record) REFERENCES mentoring.record(id),
  CONSTRAINT id_reviewer_fk FOREIGN KEY (id_reviewer) REFERENCES mentoring.reviewer(id)
);

CREATE TABLE  IF NOT EXISTS mentoring.binnacle (
  id Serial PRIMARY KEY,
  id_request Serial,
  id_reviewer bigint,
  comment varchar(500),
  CONSTRAINT id_request_fk FOREIGN KEY (id_request) REFERENCES mentoring.request(id),
  CONSTRAINT id_reviewer_fk FOREIGN KEY (id_reviewer) REFERENCES mentoring.reviewer(id)
);
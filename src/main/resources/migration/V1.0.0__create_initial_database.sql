CREATE SCHEMA IF NOT EXISTS mentoring;

CREATE TABLE IF NOT EXISTS mentoring.department (
  id Serial PRIMARY KEY,
  description varchar(25)
);

CREATE TABLE  IF NOT EXISTS mentoring.record (
  id varchar(25) PRIMARY KEY,
  id_status varchar(25),
  is_public boolean NOT NULL DEFAULT false
);

CREATE TABLE  IF NOT EXISTS mentoring.status (
  id varchar(25) PRIMARY KEY,
  description varchar(255)
);

CREATE TABLE  IF NOT EXISTS mentoring.reviewer (
  id Serial PRIMARY KEY,
  name varchar(255),
  last_name varchar(255),
  id_department bigint,
  created_at timestamp(0) without time zone NOT NULL DEFAULT now(),
  updated_at timestamp(0) without time zone NOT NULL DEFAULT now(),
  CONSTRAINT id_department_fk FOREIGN KEY (id_department) REFERENCES mentoring.department(id)
);

CREATE TABLE  IF NOT EXISTS mentoring.request (
  id Serial PRIMARY KEY,
  id_status varchar(25),
  id_record varchar(255),
  id_reviewer bigint,
  created_at timestamp(0) without time zone NOT NULL DEFAULT now(),
  updated_at timestamp(0) without time zone NOT NULL DEFAULT now(),
  CONSTRAINT id_status_fk FOREIGN KEY (id_status) REFERENCES mentoring.status(id),
  CONSTRAINT id_record_fk FOREIGN KEY (id_record) REFERENCES mentoring.record(id),
  CONSTRAINT id_reviewer_fk FOREIGN KEY (id_reviewer) REFERENCES mentoring.reviewer(id)
);


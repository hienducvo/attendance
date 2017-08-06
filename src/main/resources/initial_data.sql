
INSERT INTO authority (id, name) VALUES (1,'ROLE_STUDENT');
INSERT INTO authority (id, name) VALUES (2,'ROLE_FACULTY');
INSERT INTO authority (id, name) VALUES (3,'ROLE_ADMIN');

INSERT INTO USER (id, enabled, password, username, authorityId) VALUES (1, 1, 'password', 'hienvo',1);
INSERT INTO STUDENT (studentId, barCode, firstName, lastName, user_id) VALUES ('000-98-5433', '1100103493806', 'Hien','Vo',1);
INSERT INTO USER (id, enabled, password, username, authorityId) VALUES (2, 1, 'password', 'abebe',1);
INSERT INTO STUDENT (studentId, barCode, firstName, lastName, user_id) VALUES ('000-98-1201', '1100107816179', 'Abebe Tekle','Yalew',1);


INSERT INTO USER (id, enabled, password, username, authorityId) VALUES (3, 1, 'password', 'faculty1',2);
INSERT INTO FACULTY (facultyId, department, fullName, user_id) VALUES ('fa001', 'HR', 'Davi Moise', 3);
INSERT INTO USER (id, enabled, password, username, authorityId) VALUES (4, 1, 'password', 'faculty1', 2);
INSERT INTO FACULTY (facultyId, department, fullName, user_id) VALUES ('fa002', 'IT', 'Michel Carrick', 4);

INSERT INTO USER (id, enabled, password, username, authorityId) VALUES (5, 1, 'password', 'admin1',3);
INSERT INTO ADMIN (id, name, user_id) VALUES (1, 'Admin', 5);
INSERT INTO USER (id, enabled, password, username, authorityId) VALUES (6, 1, 'password', 'admin2',3);
INSERT INTO ADMIN (id, name, user_id) VALUES (2, 'Admin 2', 6);

INSERT INTO TIMESLOT (abbreviation, beginTime, description, endTime) VALUES ('AM', '9:45', 'Morning Session', '10:30');
INSERT INTO TIMESLOT (abbreviation, beginTime, description, endTime) VALUES ('PM', '13:15', 'Afternoon Session', '14:00');

INSERT INTO LOCATION (locationId, name) VALUES ('DB', 'Dalby Hall');
INSERT INTO LOCATION (locationId, name) VALUES ('VH', 'Viral Hall');

INSERT INTO COURSE (courseId, description, name) VALUES ('cs544', 'Enterprise Architecture', 'EA');
INSERT INTO COURSE (courseId, description, name) VALUES ('cs435', 'Algorithm', 'AG');

INSERT INTO COURSEOFFERING (courseOfferingId, endDate, startDate, courseId, locationId) VALUES ('CS544-2017-01A-01D', '2017/10/10', '2017/09/09','cs544','DB');

INSERT INTO SESSION (id, date, courseOfferingId, timeSlotId) VALUES (1, '2017/10/10', 'CS544-2017-01A-01D', 'AM');
INSERT INTO SESSION (id, date, courseOfferingId, timeSlotId) VALUES (2, '2017/10/10', 'CS544-2017-01A-01D', 'PM');

INSERT INTO REGISTRATION (id, gpa, courseOfferingId, studentId) VALUES (1, 7, 'CS544-2017-01A-01D','000-98-1201');
INSERT INTO REGISTRATION (id, gpa, courseOfferingId, studentId) VALUES (2, 8, 'CS544-2017-01A-01D','000-98-5433');

-----------------------------------------------
INSERT INTO TUTORES(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,fecha_solicitud,fecha_matriculacion)values
	('marrambla2','Believer123','88645678C','Maribel Ramos','maribel.r@gmail.com','667825431','mi casa','2000-06-22','2015-06-22','2018-07-22');
INSERT INTO TUTORES(nick_usuario,contraseya,dni_usuario,fecha_solicitud,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,fecha_matriculacion)values
	('eveyugyug','Believer123','88645678J','2018-04-07','Evelyn Yugsi','ev.r@gmail.com','667825431','mi casa','2000-04-07','2018-07-22');
INSERT INTO TUTORES(nick_usuario,contraseya,dni_usuario,fecha_solicitud,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,fecha_matriculacion)values
	('carmen123','Believer123','88645678Z','2018-04-07','Carmen Garcia','carm1@gmail.com','667825431','mi casa','2000-04-07','2018-07-22');
INSERT INTO TUTORES(nick_usuario,contraseya,dni_usuario,fecha_solicitud,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,fecha_matriculacion)values
	('carmen124','Believer123','88645678A','2018-04-07','Carmen Rodriguez','carm2@gmail.com','667825431','mi casa','2000-04-07','2018-07-22');
INSERT INTO TUTORES(nick_usuario,contraseya,dni_usuario,fecha_solicitud,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,fecha_matriculacion)values
	('carmen125','Believer123','88645678B','2018-04-07','Carmen Martin','carm3@gmail.com','667825431','mi casa','2000-04-07','2018-07-22');
INSERT INTO TUTORES(nick_usuario,contraseya,dni_usuario,fecha_solicitud,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,fecha_matriculacion)values
	('carmen126','Believer123','88645670A','2018-04-07','Carmen Lopez','carm4@gmail.com','667825431','mi casa','2000-04-07','2018-07-22');
INSERT INTO TUTORES(nick_usuario,contraseya,dni_usuario,fecha_solicitud,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,fecha_matriculacion)values
	('carmen127','Believer123','88645678D','2018-04-07','Carmen Vilariño','carm5@gmail.com','667825431','mi casa','2000-04-07','2018-07-22');
INSERT INTO TUTORES(nick_usuario,contraseya,dni_usuario,fecha_solicitud,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,fecha_matriculacion)values
	('carmen128','Believer123','88645678X','2018-04-07','Carmen Ramos','carm6@gmail.com','667825431','mi casa','2000-04-07', null);
INSERT INTO TUTORES(nick_usuario,contraseya,dni_usuario,fecha_solicitud,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,fecha_matriculacion)values
	('carmen129','Believer123','88645678Y','2018-04-07','Carmen Blanco','carm7@gmail.com','667825431','mi casa','2000-04-07', null);
INSERT INTO TUTORES(nick_usuario,contraseya,dni_usuario,fecha_solicitud,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,fecha_matriculacion)values
	('carmen130','Believer123','88645678M','2018-04-07','Carmen Mayo','carm8@gmail.com','667825431','mi casa','2000-04-07', null);
INSERT INTO TUTORES(nick_usuario,contraseya,dni_usuario,fecha_solicitud,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,fecha_matriculacion)values
	('carmen131','Believer123','88645678R','2018-04-07','Carmen Yugsi','carm9@gmail.com','667825431','mi casa','2000-04-07', null);

INSERT INTO cursos(curso_de_ingles) values ('A1');
INSERT INTO cursos(curso_de_ingles) values ('A2');
INSERT INTO cursos(curso_de_ingles) values ('B1');
INSERT INTO cursos(curso_de_ingles) values ('B2');
INSERT INTO cursos(curso_de_ingles) values ('C1');
INSERT INTO cursos(curso_de_ingles) values ('C2');
INSERT INTO cursos(curso_de_ingles) values ('APRENDIZAJELIBRE');

INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo1', 'B1');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo2', 'B1');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo3', 'B1');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo4', 'B2');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo5', 'B2');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo6', 'A1');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo7', 'A1');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo8', 'A2');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo9', 'A2');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo10', 'A2');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo11', 'C2');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo12', 'C2');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo13', 'C2');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo14', 'C1');
INSERT INTO grupos(nombre_grupo, cursos_curso_de_ingles) values ('grupo15', 'C1');


INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_solicitud,tutores_nick_usuario,grupos_nombre_grupo,fecha_matriculacion) VALUES 
    ('Javi','Bebesita7','55635286F','Javi Martínez','martinez@gmail.com','626222111','Calle Junio de agosto','2000-06-23',0,'2012-12-11','marrambla2','grupo1','2020-2-7');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_solicitud,tutores_nick_usuario,grupos_nombre_grupo,fecha_matriculacion) VALUES 
    ('antoniope','NahDeLocos88','55635286U','Antonio Pérez','jvii@gmail.com','622119555','Calle Junio de agosto','2000-06-23',0,'2012-12-11','marrambla2','grupo1','2020-2-7');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_solicitud,tutores_nick_usuario) VALUES 
    ('patri25','NahDeLocos88','55635286S','Patricia Gómez','jvii@gmail.com','622119555','Calle Junio de agosto','2000-06-23',0,'2012-12-11','eveyugyug');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_solicitud,tutores_nick_usuario) VALUES 
    ('natalia42','NahDeLocos88','55635286A','Natalia García','jvii@gmail.com','622119555','Calle Junio de agosto','2000-06-23',0,'2012-12-11','carmen128');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
    ('Gonzalo','NahDeLocos88','20502441B','Gonzalo Rodríguez','alumno@gmail.com','622119555','Calle Yucatan','1998-10-03',0, null,'carmen131',null,'2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria123','NahDeLocos88','10502441B','Maria Rodríguez','maria123@gmail.com','622119555','Calle Yucatan','1998-10-03',0, null,'carmen130',null,'2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria124','NahDeLocos88','30502441B','Maria Garcia','maria124@gmail.com','622119555','Calle Yucatan','1998-10-03',0, null,'carmen129',null,'2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria125','NahDeLocos88','40502441B','Maria Velazquez','alumno1@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen127','grupo2','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria126','NahDeLocos88','50502441B','Maria Rodríguez','alumno2@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen127','grupo2','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria127','NahDeLocos88','60502441B','Maria Rodríguez','alumno3@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen127','grupo3','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria128','NahDeLocos88','70502441B','Maria Rodríguez','alumno4@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen123','grupo4','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria129','NahDeLocos88','80502441B','Maria Rodríguez','alumno5@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen124','grupo5','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria130','NahDeLocos88','90502441B','Maria Rodríguez','alumno6@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen125','grupo6','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria131','NahDeLocos88','22502441B','Maria Rodríguez','alumno7@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen126','grupo7','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
    ('maria132','NahDeLocos88','23502441B','Maria Rodríguez','alumno8@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen125','grupo8','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria133','NahDeLocos88','24502441B','Maria Rodríguez','alumno9@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen126','grupo9','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria134','NahDeLocos88','25502441B','Maria Rodríguez','alumno10@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen124','grupo10','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria135','NahDeLocos88','26502441B','Maria Rodríguez','alumno11@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen123','grupo11','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria136','NahDeLocos88','27502441B','Maria Rodríguez','alumno12@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen123','grupo12','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria137','NahDeLocos88','28502441B','Maria Rodríguez','alumno13@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','eveyugyug','grupo13','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria138','NahDeLocos88','29502441B','Maria Rodríguez','alumno14@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','marrambla2','grupo14','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria139','NahDeLocos88','33502441B','Maria Rodríguez','alumno15@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen126','grupo15','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria140','NahDeLocos88','34502441B','Maria Rodríguez','alumno16@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen124','grupo4','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria141','NahDeLocos88','35502441B','Maria Rodríguez','alumno17@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','carmen124','grupo3','2020-11-26');
INSERT INTO alumnos(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento,num_tareas_entregadas,fecha_matriculacion,tutores_nick_usuario,grupos_nombre_grupo,fecha_solicitud) VALUES 
	('maria142','NahDeLocos88','36502441B','Maria Rodríguez','alumno18@gmail.com','622119555','Calle Yucatan','1998-10-03',0,'2012-12-11','eveyugyug','grupo5','2020-11-26');


INSERT INTO profesores(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento) VALUES 
    ('MaribelJavi','NahDeLocos88','20505441B','Maribel de los Javieres','mrbajvi@gmail.com','622119555','Calle Yucatan','1998-10-03');
INSERT INTO profesores(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento) VALUES 
	('Maribel','NahDeLocos88','20507441B','Maribel Ramos','mrb220@gmail.com','622119555','Calle Yucatan','1998-10-03');
INSERT INTO profesores(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento) VALUES 
	('JavielV','NahDeLocos88','20509441B','Javier Vilariño','javiel8@gmail.com','622119555','Calle Yucatan','1998-10-03');
INSERT INTO profesores(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento) VALUES 
	('Lola99','NahDeLocos88','20500441B','Lola Flores','lolitaflorecita@gmail.com','622119555','Calle Yucatan','1998-10-03');
INSERT INTO profesores(nick_usuario,contraseya,dni_usuario,nombre_completo_usuario,correo_electronico_usuario,num_telefono_usuario,direccion_usuario,fecha_nacimiento) VALUES 
	('Julia25','NahDeLocos88','20502442Z','Julia Medina','juls23@gmail.com','622119555','Calle Yucatan','1998-10-03');

INSERT INTO walloffames(fechawall) VALUES ('2020-W50');
INSERT INTO walloffames(fechawall) VALUES ('2020-W51');
INSERT INTO walloffames(fechawall) VALUES ('2020-W45');
INSERT INTO walloffames(fechawall) VALUES ('2020-W40');
INSERT INTO walloffames(fechawall) VALUES ('2019-W12');
INSERT INTO walloffames(fechawall) VALUES ('2019-W20');
INSERT INTO premiados(descripcion,foto,alumnos_nick_usuario,walloffames_fechawall) VALUES ('He has done a very good job this week','antoniope.jpg','antoniope','2020-W50');
INSERT INTO premiados(descripcion,foto,alumnos_nick_usuario,walloffames_fechawall) VALUES ('He has done a very good job this week','maria125.jpg','maria125','2020-W51');
INSERT INTO premiados(descripcion,foto,alumnos_nick_usuario,walloffames_fechawall) VALUES ('He has done a very good job this week','maria127.jpg','maria127','2020-W45');
INSERT INTO premiados(descripcion,foto,alumnos_nick_usuario,walloffames_fechawall) VALUES ('He has done a very good job this week','maria128.jpg','maria128','2020-W50');
INSERT INTO premiados(descripcion,foto,alumnos_nick_usuario,walloffames_fechawall) VALUES ('He has done a very good job this week','maria129.jpg','maria129','2020-W40');
INSERT INTO premiados(descripcion,foto,alumnos_nick_usuario,walloffames_fechawall) VALUES ('He has done a very good job this week','maria130.jpg','maria130','2019-W12');
INSERT INTO premiados(descripcion,foto,alumnos_nick_usuario,walloffames_fechawall) VALUES ('He has done a great job','Javi.jpg','Javi','2019-W20');

INSERT INTO tipos_eventos(tipo) VALUES ('internal');
INSERT INTO tipos_eventos(tipo) VALUES ('external');

INSERT INTO tipos_pagos(tipo) VALUES ('bizum');
INSERT INTO tipos_pagos(tipo) VALUES ('efectivo');
INSERT INTO tipos_pagos(tipo) VALUES ('transferencia');

INSERT INTO eventos(title,descripcion,start,tipo_tipo,color) VALUES ('The Champions','Amazing','2021-01-23','internal','red');
INSERT INTO eventos(title,descripcion,start,end,tipo_tipo) VALUES ('HoolaHoop','Amzing play','2020-12-23','2020-12-25','external');
INSERT INTO eventos(title,descripcion,start,tipo_tipo,color) VALUES ('Fall Guys','Amazing wow','2021-01-15','internal','purple');


INSERT INTO inscripciones(fecha,registrado,evento_id,alumno_nick_usuario) VALUES ('2021-01-15','false','1','Javi');

INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (1,'bizum', 'Pago matricula','2019-10-03','Javi');
INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (2,'efectivo', 'Pago matricula','2018-10-03','antoniope');
INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (3,'transferencia', 'Primer plazo','2019-10-04','Javi');

INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (4,'bizum', 'Pago matricula','2019-10-03','maria123');
INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (5,'efectivo', 'Pago matricula','2018-10-03','maria124');
INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (6,'transferencia', 'Primer plazo','2018-12-04','maria126');

INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (7,'bizum', 'Pago matricula','2018-10-03','maria126');
INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (8,'efectivo', 'Pago matricula','2018-10-03','maria127');
INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (9,'transferencia', 'Primer plazo','2019-10-04','maria123');

INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (10,'bizum', 'Excursion','2019-12-03','maria123');
INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (11,'efectivo', 'Pago matricula','2017-10-03','maria128');
INSERT INTO pagos(id,tipo_tipo,concepto,fecha,alumnos_nick_usuario) VALUES (12,'transferencia', 'Primer plazo','2017-12-04','maria128');


INSERT INTO asignaciones_profesor VALUES ('MaribelJavi','grupo1', '2019-10-03');

INSERT INTO tipos_materiales VALUES ('Exam');
INSERT INTO tipos_materiales VALUES ('Homework');

INSERT INTO materiales(id, fecha_subida, nombre_material, profesores_nick_usuario, tipo_material_tipo) values (1,'2021-02-03','Relacion_colores.pdf','MaribelJavi','Homework');
INSERT INTO materiales(id, fecha_subida, nombre_material, profesores_nick_usuario, tipo_material_tipo) values (2,'2021-02-04','Verbos_Irregulares.pdf','MaribelJavi','Homework');
INSERT INTO materiales(id, fecha_subida, nombre_material, profesores_nick_usuario, tipo_material_tipo) values (3,'2021-02-04','colores.pdf','MaribelJavi','Homework');
INSERT INTO materiales(id, fecha_subida, nombre_material, profesores_nick_usuario, tipo_material_tipo) values (4,'2021-02-04','Inglés-Primaria-Sexto-2.pdf','MaribelJavi','Homework');
INSERT INTO materiales(id, fecha_subida, nombre_material, profesores_nick_usuario, tipo_material_tipo) values (5,'2021-02-04','Inglés-Primaria-Quinto-1.pdf','MaribelJavi','Exam');
INSERT INTO materiales(id, fecha_subida, nombre_material, profesores_nick_usuario, tipo_material_tipo) values (6,'2021-02-04','1-primaria-1INGLES.pdf','MaribelJavi','Exam');
INSERT INTO materiales(id, fecha_subida, nombre_material, profesores_nick_usuario, tipo_material_tipo) values (7,'2021-02-04','Days of the week.pdf','MaribelJavi','Homework');
INSERT INTO materiales(id, fecha_subida, nombre_material, profesores_nick_usuario, tipo_material_tipo) values (8,'2021-02-04','Verbs tenses.pdf.pdf','MaribelJavi','Exam');


INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(1,'A perfect way to learn','false',null,5,'Javi',1);
INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(2,'A perfect way to learn','false',null,2,'Javi',2);
INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(3,'A perfect way to learn','false',null,5,'maria125',2);
INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(4,'A perfect way to learn','false',null,4,'maria126',2);
INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(5,'A perfect way to learn','false',null,2,'maria127',1);
INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(6,'A perfect way to learn','false',null,2,'maria125',3);
INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(7,'A perfect way to learn','false',null,5,'maria127',3);
INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(8,'A perfect way to learn','false',null,3,'maria128',4);
INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(9,'A perfect way to learn','false',null,2,'maria128',5);
INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(10,'A perfect way to learn','false',null,4,'maria128',6);
INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(11,'A perfect way to learn','false',null,3,'maria126',7);
INSERT INTO feedbacks(id,comentario, completado, dia_entrega,valoracion, alumnos_nick_usuario,materiales_id) values(12,'A perfect way to learn','false',null,2,'antoniope',7);






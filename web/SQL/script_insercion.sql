
------------------- SCRIPT PARA LA INSERCION DE DATOS DE PRUEBA EN LA BD -------------------

-- INSERTAR USUARIOS

insert into usuario values ('Fernando','Zamora','hola@hola.com','calle','5','Valladolid','Valladolid', '47001', '1234');
insert into usuario values ('Fernando','Zamora','adios@adios.com','calle','5','Valladolid', 'Valladolid','47001', '1234');

-- INSERTAR CURSOS

-- INSERTAR PRODUCTOS 

insert into productos values (1, 500);
insert into productos values (2, 999);
insert into productos values (3, 1690);
insert into productos values (4, 19);
insert into productos values (5, 20);
insert into productos values (6, 22);

    -- INSERTAR IMPRESORAS

    insert into impresoras3d values (1, 'BQ', 'Hephestos', '(x)460 x (y)383 x (z)430 mm');
    insert into impresoras3d values (2, 'BQ', 'Hephestos 2', '(x)450 x (y)516 x (z)571 mm');
    insert into impresoras3d values (3, 'BQ', 'Witbox 2', '(x)508,06 x (y)485,08 x (z)461 mm');
       
    -- INSERTAR CONSUMIBLES

    insert into consumibles values (4, 'PLA - Blanco', 'SmartMaterials');
    insert into consumibles values (5, 'PLA - Azul', 'BQ');
    insert into consumibles values (6, 'ABS - Verde', 'FormFutura');

-- INSERTAR CURSOS --

insert into cursos values (1, 'Iniciacion a la impresion en 3D', 'Curso para gente que quiera iniciarse en este mundo con ningun conocimiento del tema - C/Falsa 123, Valladolid - 2018-05-21');
insert into cursos values (2, 'Curso avanzado de impresion 3d', 'Curso para gente que quiera especializarse en este mundo con una base amplia sobre el tema - 2018-05-22 - C/Falsa 123, Valladolid');





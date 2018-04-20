drop table usuario;
drop table producto;
drop table curso;
drop table admin;

create table usuario (
    nombre varchar(100),
    apellido varchar(100),
    dni varchar(9),
    email varchar(100),
    calle varchar(100),
    numero integer,
    ciudad varchar(100),
    cp integer,
    password varchar(100),
    PRIMARY KEY (dni)
);

create table producto (
    code integer,
    precio double,
    nombre varchar(100),
    descripcion varchar(100),
    PRIMARY KEY (code) 
);

create table curso (
    code integer,
    nombre varchar(100),
    PRIMARY KEY (code)
);

create table admin (
    email varchar(100),
    password varchar(100),
    PRIMARY KEY (email)
);


insert into usuario values ('Fernando','Zamora','12345678A','hola@hola.com','calle',5,'Valladolid', 47001, '1234');

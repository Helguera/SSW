drop table usuario;
drop table productos;
drop table impresoras3d;
drop table consumibles;
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

create table productos (
    id_producto integer,
    precio double,
    PRIMARY KEY (id_producto) 
);

create table impresoras3d (
    id_producto integer,
    marca varchar(100),
    modelo varchar(100),
    tamaño varchar(100),
    PRIMARY KEY (id_producto),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

create table consumibles (
    id_producto integer,
    nombre varchar(100),
    marca varchar(100),
    PRIMARY KEY (id_producto),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
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




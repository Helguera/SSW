drop table usuario;
drop table productos;
drop table archivos;
drop table impresoras3d;
drop table consumibles;
drop table cursos;
drop table admins;
drop table userCursos;


create table usuario (
    nombre varchar(100),
    apellido varchar(100),
    email varchar(100),
    calle varchar(100),
    numero varchar(100),
    ciudad varchar(100),
    provincia varchar(100),
    cp varchar(100),
    password varchar(100),
    PRIMARY KEY (email)
);


create table productos (
    id_producto integer,
    precio double,
    PRIMARY KEY (id_producto) 
);

create table archivos (
    nombre varchar(100),
    ruta varchar(100),
    usuario varchar(100),
    PRIMARY KEY (nombre),
    FOREIGN KEY (nombre) REFERENCES usuario(email)
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

create table cursos (
    id_curso integer,
    nombre varchar(100),
    descripcion varchar(200),
    PRIMARY KEY (id_curso)
);

create table admins (
    email varchar(100),
    password varchar(100),
    PRIMARY KEY (email)
);

create table userCursos (
    email varchar(100),
    password varchar(100),
    PRIMARY KEY (email)
)






INSERT INTO clientes (nombre, apellido, sexo, telefono) VALUES ("David", "Cogollo", "Hombre", 635472823);
INSERT INTO clientes (nombre, apellido, sexo, telefono) VALUES ("Juan Daniel", "Montiel", "Hombre", 624364755);
INSERT INTO clientes (nombre, apellido, sexo, telefono) VALUES ("Silvia", "Cañas Casado", "Mujer", 623627354);
INSERT INTO clientes (nombre, apellido, sexo, telefono) VALUES ("Catalin", "Petrehus", "Hombre", 643329097);


INSERT INTO productos (nombre, descripcion, p_unidad, existencias) VALUES ("IPhone XS", "320gb de almacenamiento", 300, 100);
INSERT INTO productos (nombre, descripcion, p_unidad, existencias) VALUES ("IPhone XR", "640gb de almacenamiento", 600, 50);
INSERT INTO productos (nombre, descripcion, p_unidad, existencias) VALUES ("IPhone 6", "50gb de almacenamiento", 100, 400);
INSERT INTO productos (nombre, descripcion, p_unidad, existencias) VALUES ("IPhone 13", "800gb de almacenamiento", 1000, 100);


INSERT INTO ventas (cod_cliente, cod_producto, cantidad, subtotal, iva, total) VALUES (3, 4, 2, 2000, 5, 2100);

INSERT INTO ventas (cod_cliente, cod_producto, cantidad, subtotal, iva, total) VALUES (1, 1, 1, 600, 5, 630);

INSERT INTO ventas (cod_cliente, cod_producto, cantidad, subtotal, iva, total) VALUES (2, 2, 1, 1200, 5, 1400);

INSERT INTO ventas (cod_cliente, cod_producto, cantidad, subtotal, iva, total) VALUES (4, 3, 2, 200, 5, 250);
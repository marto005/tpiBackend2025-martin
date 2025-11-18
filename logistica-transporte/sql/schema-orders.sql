CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE cliente (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  nombre VARCHAR(200) NOT NULL,
  email VARCHAR(200) NOT NULL,
  telefono VARCHAR(50)
);

CREATE TABLE contenedor (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  codigo_unico VARCHAR(100) UNIQUE NOT NULL,
  peso NUMERIC(10,2),
  volumen NUMERIC(10,2),
  estado VARCHAR(50)
);

CREATE TABLE solicitud (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  numero VARCHAR(50) UNIQUE NOT NULL,
  cliente_id UUID NOT NULL REFERENCES cliente(id),
  contenedor_id UUID NOT NULL REFERENCES contenedor(id),
  estado VARCHAR(50) DEFAULT 'borrador',
  costo_estimado NUMERIC(12,2),
  tiempo_estimado INT,
  costo_final NUMERIC(12,2),
  tiempo_real INT
);

CREATE TABLE tarifa (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  descripcion VARCHAR(100),
  valor_km_base NUMERIC(10,2),
  valor_litro_combustible NUMERIC(10,2),
  cargo_gestion_tramo NUMERIC(10,2)
);

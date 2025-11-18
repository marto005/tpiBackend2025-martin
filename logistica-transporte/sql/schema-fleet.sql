CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE deposito (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  nombre VARCHAR(200) NOT NULL,
  direccion TEXT NOT NULL,
  latitud NUMERIC(10,6),
  longitud NUMERIC(10,6),
  costo_estadia_diario NUMERIC(10,2)
);

CREATE TABLE camion (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  dominio VARCHAR(50) UNIQUE NOT NULL,
  nombre_transportista VARCHAR(200),
  telefono VARCHAR(50),
  capacidad_peso NUMERIC(10,2),
  capacidad_volumen NUMERIC(10,2),
  consumo_l_km NUMERIC(10,2),
  costo_base_km NUMERIC(10,2),
  disponible BOOLEAN DEFAULT true
);

CREATE TABLE ruta (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  solicitud_id UUID NOT NULL,
  cantidad_tramos INT DEFAULT 1
);

CREATE TABLE tramo (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  ruta_id UUID NOT NULL REFERENCES ruta(id) ON DELETE CASCADE,
  origen_lat NUMERIC(10,6),
  origen_lng NUMERIC(10,6),
  destino_lat NUMERIC(10,6),
  destino_lng NUMERIC(10,6),
  tipo VARCHAR(50),
  estado VARCHAR(50) DEFAULT 'estimado',
  costo_aproximado NUMERIC(10,2),
  costo_real NUMERIC(10,2),
  fecha_ini_estimada TIMESTAMP,
  fecha_fin_estimada TIMESTAMP,
  fecha_ini_real TIMESTAMP,
  fecha_fin_real TIMESTAMP,
  camion_id UUID REFERENCES camion(id)
);

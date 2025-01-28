CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE dapil
(
    id           UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nama_dapil   VARCHAR(255),
    provinsi     VARCHAR(255),
    jumlah_kursi INT
);

CREATE TABLE partai
(
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nama_partai VARCHAR(255),
    nomor_urut  INT
);

CREATE TABLE caleg
(
    id            UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    dapil_id      UUID NOT NULL,
    partai_id     UUID NOT NULL,
    nomor_urut    INT,
    nama          VARCHAR(255),
    jenis_kelamin VARCHAR(50),
    FOREIGN KEY (dapil_id) REFERENCES dapil (id),
    FOREIGN KEY (partai_id) REFERENCES partai (id)
);

CREATE TABLE wilayah_dapil
(
    dapil_id     UUID NOT NULL DEFAULT uuid_generate_v4(),
    nama_wilayah VARCHAR(255),
    PRIMARY KEY (dapil_id, nama_wilayah),
    FOREIGN KEY (dapil_id) REFERENCES dapil (id)
);

CREATE INDEX idx_caleg_dapil_id ON caleg (dapil_id);
CREATE INDEX idx_caleg_partai_id ON caleg (partai_id);
CREATE INDEX idx_wilayah_dapil_id ON wilayah_dapil (dapil_id);

ALTER TABLE caleg
    ADD CONSTRAINT chk_jenis_kelamin CHECK (jenis_kelamin IN ('LAKILAKI', 'PEREMPUAN'));
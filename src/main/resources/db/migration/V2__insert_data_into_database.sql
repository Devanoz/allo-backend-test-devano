INSERT INTO dapil (id, nama_dapil, provinsi, jumlah_kursi)
VALUES
(uuid_generate_v4(), 'Dapil 1', 'Jawa Barat', 20),
(uuid_generate_v4(), 'Dapil 2', 'Jawa Tengah', 11),
(uuid_generate_v4(), 'Dapil 3', 'Jawa Timur', 10);

INSERT INTO partai (id, nama_partai, nomor_urut)
VALUES
(uuid_generate_v4(), 'PDI Perjuangan', 1),
(uuid_generate_v4(), 'Gerindra', 2),
(uuid_generate_v4(), 'Golkar', 3),
(uuid_generate_v4(), 'Nasdem', 4),
(uuid_generate_v4(), 'Demokrat', 5),
(uuid_generate_v4(), 'PKB', 6),
(uuid_generate_v4(), 'PKS', 7),
(uuid_generate_v4(), 'PAN', 8),
(uuid_generate_v4(), 'PPP', 9),
(uuid_generate_v4(), 'Hanura', 10);

-- Dapil 1
INSERT INTO wilayah_dapil (dapil_id, nama_wilayah)
VALUES
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Bandung'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Bandung Barat'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Bekasi'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Bogor'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Ciamis'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Cianjur'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Cirebon'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Garut'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Indramayu'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Karawang'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Kuningan'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Majalengka'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Pangandaran'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Purwakarta'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Subang'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Sukabumi'),
((select dapil.id from dapil where nama_dapil = 'Dapil 1'), 'Kabupaten Sumedang');

-- Dapil 2
INSERT INTO wilayah_dapil (dapil_id, nama_wilayah)
VALUES
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Banjarnegara'),
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Banyumas'),
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Batang'),
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Blora'),
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Boyolali'),
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Brebes'),
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Cilacap'),
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Demak'),
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Grobogan'),
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Jepara'),
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Karanganyar'),
((select dapil.id from dapil where nama_dapil = 'Dapil 2'), 'Kabupaten Kebumen');

-- Dapil 3
INSERT INTO wilayah_dapil (dapil_id, nama_wilayah)
VALUES
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Bangkalan'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Banyuwangi'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Blitar'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Bojonegoro'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Bondowoso'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Gresik'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Jember'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Jombang'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Kediri'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Lamongan'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Lumajang'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Madiun'),
((select dapil.id from dapil where nama_dapil = 'Dapil 3'), 'Kabupaten Ponorogo');

-- Dapil 1
insert into caleg (id, dapil_id, partai_id, nomor_urut, nama, jenis_kelamin)
VALUES
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'PDI Perjuangan'), 1, 'Caleg 1', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'PDI Perjuangan'), 2, 'Caleg 2', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'Gerindra'), 1, 'Caleg 3', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'Gerindra'), 2, 'Caleg 4', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'Golkar'), 1, 'Caleg 5', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'Golkar'), 2, 'Caleg 6', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'Nasdem'), 1, 'Caleg 7', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'Nasdem'), 2, 'Caleg 8', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'Demokrat'), 1, 'Caleg 9', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'Demokrat'), 2, 'Caleg 10', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'PKB'), 1, 'Caleg 11', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'PKB'), 2, 'Caleg 12', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'PKS'), 1, 'Caleg 13', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'PKS'), 2, 'Caleg 14', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'PAN'), 1, 'Caleg 15', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'PAN'), 2, 'Caleg 16', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'PPP'), 1, 'Caleg 17', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'PPP'), 2, 'Caleg 18', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'Hanura'), 1, 'Caleg 19', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 1'), (select partai.id from partai where nama_partai = 'Hanura'), 2, 'Caleg 20', 'PEREMPUAN');

-- Dapil 2
insert into caleg (id, dapil_id, partai_id, nomor_urut, nama, jenis_kelamin)
VALUES
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 2'), (select partai.id from partai where nama_partai = 'PDI Perjuangan'), 1, 'Caleg 21', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 2'), (select partai.id from partai where nama_partai = 'PDI Perjuangan'), 2, 'Caleg 22', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 2'), (select partai.id from partai where nama_partai = 'Gerindra'), 1, 'Caleg 23', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 2'), (select partai.id from partai where nama_partai = 'Gerindra'), 2, 'Caleg 24', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 2'), (select partai.id from partai where nama_partai = 'Golkar'), 1, 'Caleg 25', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 2'), (select partai.id from partai where nama_partai = 'Golkar'), 2, 'Caleg 26', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 2'), (select partai.id from partai where nama_partai = 'Nasdem'), 1, 'Caleg 27', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 2'), (select partai.id from partai where nama_partai = 'Nasdem'), 2, 'Caleg 28', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 2'), (select partai.id from partai where nama_partai = 'Demokrat'), 1, 'Caleg 29', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 2'), (select partai.id from partai where nama_partai = 'Demokrat'), 2, 'Caleg 30', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 2'), (select partai.id from partai where nama_partai = 'PKB'), 1, 'Caleg 31', 'LAKILAKI');

-- Dapil 3
insert into caleg (id, dapil_id, partai_id, nomor_urut, nama, jenis_kelamin)
VALUES
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 3'), (select partai.id from partai where nama_partai = 'PDI Perjuangan'), 1, 'Caleg 31', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 3'), (select partai.id from partai where nama_partai = 'PDI Perjuangan'), 2, 'Caleg 32', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 3'), (select partai.id from partai where nama_partai = 'Gerindra'), 1, 'Caleg 33', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 3'), (select partai.id from partai where nama_partai = 'Gerindra'), 2, 'Caleg 34', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 3'), (select partai.id from partai where nama_partai = 'Golkar'), 1, 'Caleg 35', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 3'), (select partai.id from partai where nama_partai = 'Golkar'), 2, 'Caleg 36', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 3'), (select partai.id from partai where nama_partai = 'Nasdem'), 1, 'Caleg 37', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 3'), (select partai.id from partai where nama_partai = 'Nasdem'), 2, 'Caleg 38', 'PEREMPUAN'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 3'), (select partai.id from partai where nama_partai = 'Demokrat'), 1, 'Caleg 39', 'LAKILAKI'),
(uuid_generate_v4(), (select dapil.id from dapil where nama_dapil = 'Dapil 3'), (select partai.id from partai where nama_partai = 'Demokrat'), 2, 'Caleg 40', 'PEREMPUAN');
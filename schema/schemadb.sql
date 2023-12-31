
CREATE TABLE kategoris (
    kategoriId bigint UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    kategoriKode VARCHAR(200) NOT NULL,
    kategoriNama VARCHAR(200) NOT NULL,
    kategoriCreatedAt TIMESTAMP NULL DEFAULT NULL,
    kategoriUpdatedAt TIMESTAMP NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE bukus (
    bukuId bigint UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    bukuNama VARCHAR(200) NOT NULL,
    bukuPenulis VARCHAR(200) NOT NULL,
    bukuKode VARCHAR(200) NOT NULL,
    bukuTahunTerbit INT NOT NULL,
    bukuKategoriId BIGINT UNSIGNED NOT NULL,
    bukuStatusPublish TINYINT(1) NOT NULL COMMENT 'True publish buku, False no publish (draff buku)',
    bukuCreatedAt TIMESTAMP NULL DEFAULT NULL,
    bukuUpdatedAt TIMESTAMP NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE gambar_bukus (
    gambarbukuId bigint UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    gambarbukuBukuId BIGINT UNSIGNED NOT NULL,
    gambarbukuUrlGambar VARCHAR(400) NOT NULL,
    gambarbukuCreatedAt TIMESTAMP NULL DEFAULT NULL,
    gambarbukuUpdatedAt TIMESTAMP NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


ALTER TABLE kategoris
    ADD UNIQUE KEY kategoris_kategorikode_unique (kategoriKode);

ALTER TABLE bukus
    ADD UNIQUE KEY bukus_bukukode_unique (bukuKode),
    ADD KEY bukus_bukukategoriid_foreign (bukuKategoriId);

ALTER TABLE gambar_bukus
    ADD KEY gambar_bukus_gambarbukubukuid_foreign (gambarbukuBukuId);




ALTER TABLE bukus
    ADD CONSTRAINT bukus_bukukategoriid_foreign FOREIGN KEY (bukuKategoriId) REFERENCES kategoris (kategoriId);

ALTER TABLE gambar_bukus
    ADD CONSTRAINT gambar_bukus_gambarbukubukuid_foreign FOREIGN KEY (gambarbukuBukuId) REFERENCES bukus (bukuId);

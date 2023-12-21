
CREATE TABLE kategoris (
    KategoriId bigint UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    KategoriKode VARCHAR(200) NOT NULL,
    KategoriNama VARCHAR(200) NOT NULL,
    KategoriCreatedAt TIMESTAMP NULL DEFAULT NULL,
    KategoriUpdatedAt TIMESTAMP NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE bukus (
    BukuId bigint UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    BukuNama VARCHAR(200) NOT NULL,
    BukuPenulis VARCHAR(200) NOT NULL,
    BukuKode VARCHAR(200) NOT NULL,
    BukuTahunTerbit INT NOT NULL,
    BukuKategoriId BIGINT UNSIGNED NOT NULL,
    BukuStatusPublish TINYINT(1) NOT NULL COMMENT 'True publish buku, False no publish (draff buku)',
    BukuCreatedAt TIMESTAMP NULL DEFAULT NULL,
    BukuUpdatedAt TIMESTAMP NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE gambar_bukus (
    GambarBukuId bigint UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    GambarBukuBukuId BIGINT UNSIGNED NOT NULL,
    GambarBukuUrlGambar VARCHAR(400) NOT NULL,
    GambarBukuCreatedAt TIMESTAMP NULL DEFAULT NULL,
    GambarBukuUpdatedAt TIMESTAMP NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


ALTER TABLE kategoris
    ADD UNIQUE KEY kategoris_kategorikode_unique (KategoriKode);

ALTER TABLE bukus
    ADD UNIQUE KEY bukus_bukukode_unique (BukuKode),
    ADD KEY bukus_bukukategoriid_foreign (BukuKategoriId);

ALTER TABLE gambar_bukus
    ADD KEY gambar_bukus_gambarbukubukuid_foreign (GambarBukuBukuId);




ALTER TABLE bukus
    ADD CONSTRAINT bukus_bukukategoriid_foreign FOREIGN KEY (BukuKategoriId) REFERENCES kategoris (KategoriId);

ALTER TABLE gambar_bukus
    ADD CONSTRAINT gambar_bukus_gambarbukubukuid_foreign FOREIGN KEY (GambarBukuBukuId) REFERENCES bukus (BukuId);

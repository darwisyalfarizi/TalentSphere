-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 08, 2025 at 11:37 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `talent_sphere2`
--

-- --------------------------------------------------------

--
-- Table structure for table `absensi`
--

CREATE TABLE `absensi` (
  `kd_absensi` varchar(10) NOT NULL,
  `kd_karyawan` varchar(10) NOT NULL,
  `tanggal` date NOT NULL,
  `status` enum('Hadir','Izin','Sakit','Alpa') NOT NULL DEFAULT 'Hadir',
  `keterangan` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `absensi`
--

INSERT INTO `absensi` (`kd_absensi`, `kd_karyawan`, `tanggal`, `status`, `keterangan`) VALUES
('ABS-001', 'KRW-001', '2025-06-01', 'Hadir', 'hadir'),
('ABS-002', 'KRW-002', '2025-06-01', 'Izin', 'ke djp'),
('ABS-003', 'KRW-001', '2025-06-08', 'Hadir', 'hadir '),
('ABS-004', 'KRW-001', '2025-05-01', 'Hadir', 'hadir'),
('ABS-005', 'KRW-003', '2025-05-01', 'Hadir', 'hadir'),
('ABS-006', 'KRW-001', '2025-05-31', 'Alpa', 'alpa'),
('ABS-007', 'KRW-001', '2025-05-29', 'Izin', 'izin'),
('ABS-008', 'KRW-003', '2025-07-02', 'Izin', 'ke djp'),
('ABS-009', 'KRW-002', '2025-07-02', 'Hadir', 'bener'),
('ABS-010', 'KRW-004', '2025-07-02', 'Hadir', 'hadir');

-- --------------------------------------------------------

--
-- Table structure for table `cuti`
--

CREATE TABLE `cuti` (
  `kd_cuti` varchar(10) NOT NULL,
  `kd_karyawan` varchar(10) NOT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_selesai` date NOT NULL,
  `keterangan` text,
  `status` enum('Menunggu','Disetujui','Ditolak') NOT NULL DEFAULT 'Menunggu'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cuti`
--

INSERT INTO `cuti` (`kd_cuti`, `kd_karyawan`, `tanggal_mulai`, `tanggal_selesai`, `keterangan`, `status`) VALUES
('CTI-001', 'KRW-001', '2025-06-01', '2025-06-08', 'rehat', 'Menunggu'),
('CTI-002', 'KRW-002', '2025-06-03', '2025-06-07', 'operasi', 'Disetujui'),
('CTI-003', 'KRW-002', '2025-06-12', '2025-06-25', 'tess', 'Disetujui'),
('CTI-004', 'KRW-001', '2025-07-01', '2025-07-16', 'oke', 'Disetujui'),
('CTI-005', 'KRW-001', '2025-07-01', '2025-07-10', '', 'Menunggu'),
('CTI-006', 'KRW-001', '2025-07-02', '2025-07-17', 'hm', 'Ditolak'),
('CTI-007', 'KRW-003', '2025-07-06', '2025-07-06', 'konser bmth di jkt', 'Menunggu'),
('CTI-008', 'KRW-002', '2025-07-06', '2025-07-06', 'tes', 'Disetujui'),
('CTI-009', 'KRW-004', '2025-07-06', '2025-07-06', 'nonton dj khaleed', 'Menunggu'),
('CTI-010', 'KRW-002', '2025-07-05', '2025-07-06', 'panggilan job di jawa timur di masjid al hidayah', 'Menunggu');

-- --------------------------------------------------------

--
-- Table structure for table `departemen`
--

CREATE TABLE `departemen` (
  `id_departemen` int(11) NOT NULL,
  `nama_departemen` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departemen`
--

INSERT INTO `departemen` (`id_departemen`, `nama_departemen`) VALUES
(1, 'Technology'),
(2, 'Marketing'),
(3, 'Product');

-- --------------------------------------------------------

--
-- Table structure for table `detail_gaji`
--

CREATE TABLE `detail_gaji` (
  `kd_detail` varchar(10) NOT NULL,
  `kd_slip` varchar(10) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  `is_tambah` tinyint(1) NOT NULL COMMENT '1 untuk tambahan, 0 untuk pengurangan',
  `jumlah` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_gaji`
--

INSERT INTO `detail_gaji` (`kd_detail`, `kd_slip`, `jenis`, `deskripsi`, `is_tambah`, `jumlah`) VALUES
('DTL-001', 'SLP-001', 'BPJS', 'bpj sehat', 0, '150000.00'),
('DTL-002', 'SLP-001', 'Bonus', 'projek mobile', 1, '500000.00'),
('DTL-003', 'SLP-002', 'Transport', 'uang transportasi', 1, '200000.00'),
('DTL-004', 'SLP-001', 'tstingg', 'testingg', 1, '350000.00'),
('DTL-005', 'SLP-001', 'tes', 'asss', 1, '1000.00'),
('DTL-006', 'SLP-004', 'Uang Pinjaman', 'minjam uang', 0, '1000000.00');

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `id_jabatan` int(11) NOT NULL,
  `nama_jabatan` varchar(100) NOT NULL,
  `gaji_pokok` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `nama_jabatan`, `gaji_pokok`) VALUES
(1, 'Senior', '8000000.00'),
(2, 'Junior', '5000000.00');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `kd_karyawan` varchar(10) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `no_ktp` varchar(20) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` text NOT NULL,
  `jabatan_id` int(11) DEFAULT NULL,
  `departemen_id` int(11) DEFAULT NULL,
  `status` enum('Aktif','Tidak Aktif') NOT NULL DEFAULT 'Aktif',
  `tanggal_masuk` date NOT NULL,
  `tanggal_mulai_kontrak` date NOT NULL,
  `tanggal_berakhir_kontrak` date NOT NULL,
  `status_kontrak` enum('Aktif','Berakhir') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`kd_karyawan`, `nama`, `no_ktp`, `no_hp`, `alamat`, `jabatan_id`, `departemen_id`, `status`, `tanggal_masuk`, `tanggal_mulai_kontrak`, `tanggal_berakhir_kontrak`, `status_kontrak`) VALUES
('KRW-001', 'M Darwisy Alfarizi', '36789001233', '082134598764', 'Jalan Merdeka No.56, Bandung, Jawa Baratt', 1, 1, 'Tidak Aktif', '2025-06-02', '2025-06-03', '2025-07-03', 'Berakhir'),
('KRW-002', 'Fatur', '36789001235', '082134598766', 'Jalan Inspeksi Kalimalang No.57, Bekasi, Jawa Barat', 2, 1, 'Aktif', '2025-06-01', '2025-06-02', '2025-07-02', 'Aktif'),
('KRW-003', 'Haikal', '36728733219', '6287812421', 'depok', 2, 2, 'Aktif', '2025-07-01', '2025-07-03', '2025-07-31', 'Aktif'),
('KRW-004', 'Decofra', '364252523432', '628425984', 'Condet', 1, 2, 'Aktif', '2025-07-08', '2025-07-24', '2025-08-21', 'Aktif');

-- --------------------------------------------------------

--
-- Table structure for table `rekrutmen`
--

CREATE TABLE `rekrutmen` (
  `kd_rekrutmen` varchar(10) NOT NULL,
  `nama_pelamar` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telepon` bigint(20) DEFAULT NULL,
  `posisi` varchar(100) NOT NULL,
  `status` enum('Wawancara','Diterima','Ditolak') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rekrutmen`
--

INSERT INTO `rekrutmen` (`kd_rekrutmen`, `nama_pelamar`, `email`, `telepon`, `posisi`, `status`) VALUES
('RKT-001', 'Deco', 'deco@gmail.com', 62812345691, 'Data Analyst', 'Diterima'),
('RKT-002', 'Khoirul', 'khoirul@gmail.com', 628912441242, 'Front End', 'Wawancara');

-- --------------------------------------------------------

--
-- Table structure for table `slip_gaji`
--

CREATE TABLE `slip_gaji` (
  `kd_slip` varchar(10) NOT NULL,
  `kd_karyawan` varchar(10) NOT NULL,
  `periode` date NOT NULL,
  `gaji_pokok` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `slip_gaji`
--

INSERT INTO `slip_gaji` (`kd_slip`, `kd_karyawan`, `periode`, `gaji_pokok`) VALUES
('SLP-001', 'KRW-001', '2025-06-28', '8000000.00'),
('SLP-002', 'KRW-002', '2025-06-28', '8000000.00'),
('SLP-004', 'KRW-002', '2025-07-03', '5000000.00');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('Admin','HRD') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `role`) VALUES
(1, 'admin', '$2a$10$I1vNu58hmArPBXaQiCBwgOPsPJy4ECQb.vvgxtVaO9SI7SdfIDzTK', 'Admin'),
(2, 'hrd', '$2a$10$zS7hdp6NCLGrAp1uqCQ9UOXcYM5fvBAzPjcZrF4yyaYDAha9KLCLa', 'HRD'),
(3, 'tes', '$2a$10$aW/Y5/EOpSgd3DZxQJl7KOwz.ePAfM.MoB5dPKtv45iiNZNkJoi/S', 'HRD'),
(4, 'jaka', '$2a$10$6epHXHOKbpGpygy0eeQyVuZImcFCG9GJHkejDGbbZRGXrVseZM8Zu', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absensi`
--
ALTER TABLE `absensi`
  ADD PRIMARY KEY (`kd_absensi`),
  ADD KEY `kd_karyawan` (`kd_karyawan`);

--
-- Indexes for table `cuti`
--
ALTER TABLE `cuti`
  ADD PRIMARY KEY (`kd_cuti`),
  ADD KEY `kd_karyawan` (`kd_karyawan`);

--
-- Indexes for table `departemen`
--
ALTER TABLE `departemen`
  ADD PRIMARY KEY (`id_departemen`);

--
-- Indexes for table `detail_gaji`
--
ALTER TABLE `detail_gaji`
  ADD PRIMARY KEY (`kd_detail`),
  ADD KEY `detail_gaji_ibfk_1` (`kd_slip`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id_jabatan`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`kd_karyawan`),
  ADD KEY `jabatan_id` (`jabatan_id`),
  ADD KEY `departemen_id` (`departemen_id`);

--
-- Indexes for table `rekrutmen`
--
ALTER TABLE `rekrutmen`
  ADD PRIMARY KEY (`kd_rekrutmen`),
  ADD KEY `email` (`email`);

--
-- Indexes for table `slip_gaji`
--
ALTER TABLE `slip_gaji`
  ADD PRIMARY KEY (`kd_slip`),
  ADD KEY `kd_karyawan` (`kd_karyawan`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `departemen`
--
ALTER TABLE `departemen`
  MODIFY `id_departemen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id_jabatan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absensi`
--
ALTER TABLE `absensi`
  ADD CONSTRAINT `absensi_ibfk_1` FOREIGN KEY (`kd_karyawan`) REFERENCES `karyawan` (`kd_karyawan`);

--
-- Constraints for table `cuti`
--
ALTER TABLE `cuti`
  ADD CONSTRAINT `cuti_ibfk_1` FOREIGN KEY (`kd_karyawan`) REFERENCES `karyawan` (`kd_karyawan`);

--
-- Constraints for table `detail_gaji`
--
ALTER TABLE `detail_gaji`
  ADD CONSTRAINT `detail_gaji_ibfk_1` FOREIGN KEY (`kd_slip`) REFERENCES `slip_gaji` (`kd_slip`) ON DELETE CASCADE;

--
-- Constraints for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `karyawan_ibfk_1` FOREIGN KEY (`jabatan_id`) REFERENCES `jabatan` (`id_jabatan`),
  ADD CONSTRAINT `karyawan_ibfk_2` FOREIGN KEY (`departemen_id`) REFERENCES `departemen` (`id_departemen`);

--
-- Constraints for table `slip_gaji`
--
ALTER TABLE `slip_gaji`
  ADD CONSTRAINT `slip_gaji_ibfk_1` FOREIGN KEY (`kd_karyawan`) REFERENCES `karyawan` (`kd_karyawan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

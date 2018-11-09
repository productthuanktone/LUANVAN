-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 09, 2018 lúc 07:47 PM
-- Phiên bản máy phục vụ: 10.1.35-MariaDB
-- Phiên bản PHP: 7.2.9

SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `vtnn`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `binhluan`
--

CREATE TABLE IF NOT EXISTS `binhluan` (
  `MABINHLUAN` int(11) NOT NULL AUTO_INCREMENT,
  `MAKHACHHANG` int(11) DEFAULT NULL,
  `MANHANVIEN` int(11) DEFAULT NULL,
  `MASANPHAM` int(11) DEFAULT NULL,
  `NOIDUNG` varchar(300) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MABINHLUAN`),
  KEY `FK_RELATIONSHIP_12` (`MANHANVIEN`),
  KEY `FK_RELATIONSHIP_13` (`MASANPHAM`),
  KEY `FK_RELATIONSHIP_17` (`MAKHACHHANG`)
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE IF NOT EXISTS `chitiethoadon` (
  `MACHITIETHOADONG` int(11) NOT NULL AUTO_INCREMENT,
  `MAHOADON` int(11) DEFAULT NULL,
  `MACHITIETSANPHAM` int(11) DEFAULT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `TONGGIA` double DEFAULT NULL,
  `MOTA` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`MACHITIETHOADONG`),
  KEY `FK_RELATIONSHIP_21` (`MACHITIETSANPHAM`),
  KEY `FK_RELATIONSHIP_22` (`MAHOADON`)
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE IF NOT EXISTS `chitietphieunhap` (
  `MACHITIETPHIEUNHAP` int(11) NOT NULL AUTO_INCREMENT,
  `MACHITIETSANPHAM` int(11) DEFAULT NULL,
  `MAPHIEUNHAP` int(11) DEFAULT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `TONGGIA` double DEFAULT NULL,
  PRIMARY KEY (`MACHITIETPHIEUNHAP`),
  KEY `FK_RELATIONSHIP_19` (`MAPHIEUNHAP`),
  KEY `FK_RELATIONSHIP_20` (`MACHITIETSANPHAM`)
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietsanpham`
--

CREATE TABLE IF NOT EXISTS `chitietsanpham` (
  `MACHITIETSANPHAM` int(11) NOT NULL AUTO_INCREMENT,
  `MADONVITINH` int(11) DEFAULT NULL,
  `MANHASANXUAT` int(11) DEFAULT NULL,
  `MASANPHAM` int(11) DEFAULT NULL,
  `MAHINH` int(11) DEFAULT NULL,
  `MAGIA` int(11) DEFAULT NULL,
  `MAKHUYENMAI` int(11) DEFAULT NULL,
  `MADANHMUC` int(11) DEFAULT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  PRIMARY KEY (`MACHITIETSANPHAM`),
  KEY `FK_RELATIONSHIP_1` (`MADONVITINH`),
  KEY `FK_RELATIONSHIP_2` (`MAGIA`),
  KEY `FK_RELATIONSHIP_23` (`MAKHUYENMAI`),
  KEY `FK_RELATIONSHIP_24` (`MAHINH`),
  KEY `FK_RELATIONSHIP_25` (`MADANHMUC`),
  KEY `FK_RELATIONSHIP_3` (`MASANPHAM`),
  KEY `FK_RELATIONSHIP_5` (`MANHASANXUAT`)
) ;

--
-- Đang đổ dữ liệu cho bảng `chitietsanpham`
--

INSERT INTO `chitietsanpham` (`MACHITIETSANPHAM`, `MADONVITINH`, `MANHASANXUAT`, `MASANPHAM`, `MAHINH`, `MAGIA`, `MAKHUYENMAI`, `MADANHMUC`, `SOLUONG`) VALUES
(1, 1, 1, 1, 1, 1, 1, NULL, 600),
(2, 1, 2, 2, 2, 2, 1, NULL, 34);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhmucsanpham`
--

CREATE TABLE IF NOT EXISTS `danhmucsanpham` (
  `MADANHMUC` int(11) NOT NULL AUTO_INCREMENT,
  `TENDANHMUC` varchar(30) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MADANHMUC`)
) ;

--
-- Đang đổ dữ liệu cho bảng `danhmucsanpham`
--

INSERT INTO `danhmucsanpham` (`MADANHMUC`, `TENDANHMUC`, `ISDELETE`, `DELETEID`, `TIMEDELETE`, `CREATEID`, `TIMECREATE`, `UPDATEID`, `TIMEUPDATE`) VALUES
(1, 'Thuốc Trừ Sâu', 0, 0, NULL, 0, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donvitinh`
--

CREATE TABLE IF NOT EXISTS `donvitinh` (
  `MADONVITINH` int(11) NOT NULL AUTO_INCREMENT,
  `TENDONVITINH` varchar(10) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MADONVITINH`)
) ;

--
-- Đang đổ dữ liệu cho bảng `donvitinh`
--

INSERT INTO `donvitinh` (`MADONVITINH`, `TENDONVITINH`, `ISDELETE`, `DELETEID`, `TIMEDELETE`, `CREATEID`, `TIMECREATE`, `UPDATEID`, `TIMEUPDATE`) VALUES
(1, 'Chai', 0, 0, NULL, 0, NULL, 0, NULL),
(2, 'Bao', 0, 0, NULL, 0, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `gia`
--

CREATE TABLE IF NOT EXISTS `gia` (
  `MAGIA` int(11) NOT NULL AUTO_INCREMENT,
  `GIA` float DEFAULT NULL,
  `NGAYCAPNHAT` datetime DEFAULT NULL,
  PRIMARY KEY (`MAGIA`)
) ;

--
-- Đang đổ dữ liệu cho bảng `gia`
--

INSERT INTO `gia` (`MAGIA`, `GIA`, `NGAYCAPNHAT`) VALUES
(1, 600000, '2018-11-03 00:00:00'),
(2, 450000, '2018-11-06 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hinh`
--

CREATE TABLE IF NOT EXISTS `hinh` (
  `MAHINH` int(11) NOT NULL AUTO_INCREMENT,
  `HINH` varchar(100) DEFAULT NULL,
  `LOAIHINH` int(11) DEFAULT NULL,
  PRIMARY KEY (`MAHINH`)
) ;

--
-- Đang đổ dữ liệu cho bảng `hinh`
--

INSERT INTO `hinh` (`MAHINH`, `HINH`, `LOAIHINH`) VALUES
(1, 'nouvo.jpg', 1),
(2, 'AMATER-150SC-2.jpg', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE IF NOT EXISTS `hoadon` (
  `MAHOADON` int(11) NOT NULL AUTO_INCREMENT,
  `MANHANVIEN` int(11) DEFAULT NULL,
  `MAKHACHHANG` int(11) DEFAULT NULL,
  `TINTTRANG` int(11) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MAHOADON`),
  KEY `FK_RELATIONSHIP_14` (`MAKHACHHANG`),
  KEY `FK_RELATIONSHIP_9` (`MANHANVIEN`)
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE IF NOT EXISTS `khachhang` (
  `MAKHACHHANG` int(11) NOT NULL AUTO_INCREMENT,
  `HOTEN` varchar(50) DEFAULT NULL,
  `GIOITINH` tinyint(1) DEFAULT NULL,
  `DIACHI` varchar(200) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `SODIENTHOAI` int(11) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MAKHACHHANG`)
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE IF NOT EXISTS `khuyenmai` (
  `MAKHUYENMAI` int(11) NOT NULL AUTO_INCREMENT,
  `TENKHUYENMAI` varchar(30) DEFAULT NULL,
  `THOIGIANBATDAU` datetime DEFAULT NULL,
  `THOIGIANKETTHUC` datetime DEFAULT NULL,
  `MOTA` varchar(300) DEFAULT NULL,
  `PHANTRAM` int(11) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MAKHUYENMAI`)
) ;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`MAKHUYENMAI`, `TENKHUYENMAI`, `THOIGIANBATDAU`, `THOIGIANKETTHUC`, `MOTA`, `PHANTRAM`, `ISDELETE`, `DELETEID`, `TIMEDELETE`, `CREATEID`, `TIMECREATE`, `UPDATEID`, `TIMEUPDATE`) VALUES
(1, 'Tết Dương Lịch', '2018-11-03 00:00:00', '2018-11-08 00:00:00', 'Tết an khang', 10, 0, 0, NULL, 0, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE IF NOT EXISTS `nhanvien` (
  `MANHANVIEN` int(11) NOT NULL AUTO_INCREMENT,
  `HOTEN` varchar(50) DEFAULT NULL,
  `GIOITINH` tinyint(1) DEFAULT NULL,
  `DIACHI` varchar(200) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `SODIENTHOAI` int(11) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MANHANVIEN`)
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhasanxuat`
--

CREATE TABLE IF NOT EXISTS `nhasanxuat` (
  `MANHASANXUAT` int(11) NOT NULL AUTO_INCREMENT,
  `TENNHASANXUAT` varchar(100) DEFAULT NULL,
  `DIACHI` varchar(200) DEFAULT NULL,
  `SODIENTHOAI` int(11) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MANHASANXUAT`)
) ;

--
-- Đang đổ dữ liệu cho bảng `nhasanxuat`
--

INSERT INTO `nhasanxuat` (`MANHASANXUAT`, `TENNHASANXUAT`, `DIACHI`, `SODIENTHOAI`, `EMAIL`, `ISDELETE`, `DELETEID`, `TIMEDELETE`, `CREATEID`, `TIMECREATE`, `UPDATEID`, `TIMEUPDATE`) VALUES
(1, 'Sông Giang', 'Trà Vinh', 1216324199, 'songgiang@gmail.com', 0, 0, NULL, 0, NULL, 0, NULL),
(2, 'Công ty Cổ phần nông dược TSC', 'Hồ Chí Minh', 1216324199, 'tsc@gmail.com', 0, 0, NULL, 0, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE IF NOT EXISTS `phieunhap` (
  `MAPHIEUNHAP` int(11) NOT NULL AUTO_INCREMENT,
  `MANHANVIEN` int(11) DEFAULT NULL,
  `MANHASANXUAT` int(11) DEFAULT NULL,
  `MOTA` varchar(300) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MAPHIEUNHAP`),
  KEY `FK_RELATIONSHIP_10` (`MANHASANXUAT`),
  KEY `FK_RELATIONSHIP_18` (`MANHANVIEN`)
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE IF NOT EXISTS `sanpham` (
  `MASANPHAM` int(11) NOT NULL AUTO_INCREMENT,
  `TENSANPHAM` varchar(100) DEFAULT NULL,
  `MOTA` varchar(300) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MASANPHAM`)
) ;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MASANPHAM`, `TENSANPHAM`, `MOTA`, `ISDELETE`, `DELETEID`, `TIMEDELETE`, `CREATEID`, `TIMECREATE`, `UPDATEID`, `TIMEUPDATE`) VALUES
(1, 'NOUVO', 'Khi sâu tiếp xúc hoặc ăn phải thuốc sẽ lập tức xuất hiện trạng thái tê liệt, không ăn, không hoạt động, không có khả năng phá hại cây trồng, sau đó từ 2-4 ngày, sâu sẽ chết', 0, 0, NULL, 0, NULL, 0, NULL),
(2, 'AMATER 150SC– ĐẶC TRỊ SÂU RẦY', ' Đặc trị sâu cuốn lá và nhện gié trên lúa. Ngoài ra còn phòng trừ tốt sâu vẽ bùa, sâu xanh, sâu tơ, sâu khoang trên rau màu và cây ăn trái.', 0, 0, NULL, 0, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE IF NOT EXISTS `taikhoan` (
  `MATAIKHOAN` int(11) NOT NULL AUTO_INCREMENT,
  `MANHANVIEN` int(11) DEFAULT NULL,
  `MAKHACHHANG` int(11) DEFAULT NULL,
  `TENDANNHAP` varchar(30) DEFAULT NULL,
  `MATKHAU` varchar(30) DEFAULT NULL,
  `MATKHAU2` varchar(30) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  `QUYEN` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`MATAIKHOAN`),
  KEY `FK_RELATIONSHIP_16` (`MAKHACHHANG`),
  KEY `FK_RELATIONSHIP_8` (`MANHANVIEN`)
) ;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  ADD CONSTRAINT `FK_RELATIONSHIP_12` FOREIGN KEY (`MANHANVIEN`) REFERENCES `nhanvien` (`MANHANVIEN`),
  ADD CONSTRAINT `FK_RELATIONSHIP_13` FOREIGN KEY (`MASANPHAM`) REFERENCES `sanpham` (`MASANPHAM`),
  ADD CONSTRAINT `FK_RELATIONSHIP_17` FOREIGN KEY (`MAKHACHHANG`) REFERENCES `khachhang` (`MAKHACHHANG`);

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `FK_RELATIONSHIP_21` FOREIGN KEY (`MACHITIETSANPHAM`) REFERENCES `chitietsanpham` (`MACHITIETSANPHAM`),
  ADD CONSTRAINT `FK_RELATIONSHIP_22` FOREIGN KEY (`MAHOADON`) REFERENCES `hoadon` (`MAHOADON`);

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `FK_RELATIONSHIP_19` FOREIGN KEY (`MAPHIEUNHAP`) REFERENCES `phieunhap` (`MAPHIEUNHAP`),
  ADD CONSTRAINT `FK_RELATIONSHIP_20` FOREIGN KEY (`MACHITIETSANPHAM`) REFERENCES `chitietsanpham` (`MACHITIETSANPHAM`);

--
-- Các ràng buộc cho bảng `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  ADD CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`MADONVITINH`) REFERENCES `donvitinh` (`MADONVITINH`),
  ADD CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`MAGIA`) REFERENCES `gia` (`MAGIA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_23` FOREIGN KEY (`MAKHUYENMAI`) REFERENCES `khuyenmai` (`MAKHUYENMAI`),
  ADD CONSTRAINT `FK_RELATIONSHIP_24` FOREIGN KEY (`MAHINH`) REFERENCES `hinh` (`MAHINH`),
  ADD CONSTRAINT `FK_RELATIONSHIP_25` FOREIGN KEY (`MADANHMUC`) REFERENCES `danhmucsanpham` (`MADANHMUC`),
  ADD CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`MASANPHAM`) REFERENCES `sanpham` (`MASANPHAM`),
  ADD CONSTRAINT `FK_RELATIONSHIP_5` FOREIGN KEY (`MANHASANXUAT`) REFERENCES `nhasanxuat` (`MANHASANXUAT`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_RELATIONSHIP_14` FOREIGN KEY (`MAKHACHHANG`) REFERENCES `khachhang` (`MAKHACHHANG`),
  ADD CONSTRAINT `FK_RELATIONSHIP_9` FOREIGN KEY (`MANHANVIEN`) REFERENCES `nhanvien` (`MANHANVIEN`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_RELATIONSHIP_10` FOREIGN KEY (`MANHASANXUAT`) REFERENCES `nhasanxuat` (`MANHASANXUAT`),
  ADD CONSTRAINT `FK_RELATIONSHIP_18` FOREIGN KEY (`MANHANVIEN`) REFERENCES `nhanvien` (`MANHANVIEN`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `FK_RELATIONSHIP_16` FOREIGN KEY (`MAKHACHHANG`) REFERENCES `khachhang` (`MAKHACHHANG`),
  ADD CONSTRAINT `FK_RELATIONSHIP_8` FOREIGN KEY (`MANHANVIEN`) REFERENCES `nhanvien` (`MANHANVIEN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

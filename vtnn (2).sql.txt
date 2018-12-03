-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 03, 2018 lúc 03:23 PM
-- Phiên bản máy phục vụ: 10.1.35-MariaDB
-- Phiên bản PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

CREATE TABLE `binhluan` (
  `MABINHLUAN` int(11) NOT NULL,
  `MAKHACHHANG` int(11) DEFAULT NULL,
  `MANHANVIEN` int(11) DEFAULT NULL,
  `MASANPHAM` int(11) DEFAULT NULL,
  `NOIDUNG` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MACHITIETHOADON` int(11) NOT NULL,
  `MAHOADON` int(11) DEFAULT NULL,
  `MACHITIETSANPHAM` int(11) DEFAULT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `TONGGIA` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MACHITIETHOADON`, `MAHOADON`, `MACHITIETSANPHAM`, `SOLUONG`, `TONGGIA`) VALUES
(1, 57, 2, 7, 3150000),
(2, 57, 1, 4, 2400000),
(3, 58, 2, 50, 45000000),
(4, 59, NULL, 3, 234000),
(5, 60, 1, 5, 390000),
(6, 61, 2, 3, 1350000),
(7, 61, 1, 4, 312000),
(8, 62, 1, 1, 78000),
(9, 62, 2, 1, 22500000),
(10, 63, 2, 4, 1800000),
(11, 64, 1, 2, 156000),
(12, 64, 2, 2, 900000),
(13, 65, 1, 1, 78000),
(14, 65, 2, 4, 1800000),
(15, 66, 2, 1, 405000),
(16, 67, 1, 6, 444600),
(17, 67, 2, 1, 405000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MACHITIETPHIEUNHAP` int(11) NOT NULL,
  `MACHITIETSANPHAM` int(11) DEFAULT NULL,
  `MAPHIEUNHAP` int(11) DEFAULT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `TONGGIA` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietsanpham`
--

CREATE TABLE `chitietsanpham` (
  `MACHITIETSANPHAM` int(11) NOT NULL,
  `MADONVITINH` int(11) DEFAULT NULL,
  `MANHASANXUAT` int(11) DEFAULT NULL,
  `MASANPHAM` int(11) DEFAULT NULL,
  `MAHINH` int(11) DEFAULT NULL,
  `MAGIA` int(11) DEFAULT NULL,
  `MAKHUYENMAI` int(11) DEFAULT NULL,
  `MADANHMUC` int(11) DEFAULT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietsanpham`
--

INSERT INTO `chitietsanpham` (`MACHITIETSANPHAM`, `MADONVITINH`, `MANHASANXUAT`, `MASANPHAM`, `MAHINH`, `MAGIA`, `MAKHUYENMAI`, `MADANHMUC`, `SOLUONG`, `ISDELETE`) VALUES
(1, 1, 2, 1, 1, 21, 2, 1, 24, 0),
(2, 1, 2, 2, 2, 2, 1, 1, 23, 0),
(4, 1, 2, 2, 2, 1, 1, 2, 600, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhmucsanpham`
--

CREATE TABLE `danhmucsanpham` (
  `MADANHMUC` int(11) NOT NULL,
  `TENDANHMUC` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `danhmucsanpham`
--

INSERT INTO `danhmucsanpham` (`MADANHMUC`, `TENDANHMUC`, `ISDELETE`, `DELETEID`, `TIMEDELETE`, `CREATEID`, `TIMECREATE`, `UPDATEID`, `TIMEUPDATE`) VALUES
(1, 'Thuốc Trừ Sâu', 0, 0, NULL, 0, NULL, 0, NULL),
(2, 'Phân Bón Lúa', 0, 0, NULL, 0, NULL, 0, NULL),
(3, 'Thuốc Trị Bệnh', 0, 0, NULL, 0, NULL, 0, NULL),
(4, 'Thuốc Trị rầy', 0, 0, NULL, 0, NULL, 0, NULL),
(5, 'Máy Móc, Trang Thiết Bị', 0, 0, NULL, 0, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donvitinh`
--

CREATE TABLE `donvitinh` (
  `MADONVITINH` int(11) NOT NULL,
  `TENDONVITINH` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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

CREATE TABLE `gia` (
  `MAGIA` int(11) NOT NULL,
  `GIA` float DEFAULT NULL,
  `NGAYCAPNHAT` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `gia`
--

INSERT INTO `gia` (`MAGIA`, `GIA`, `NGAYCAPNHAT`) VALUES
(1, 600000, '2018-11-03 00:00:00'),
(2, 450000, '2018-11-06 00:00:00'),
(3, 600000, '2018-11-23 07:56:24'),
(5, 600000, '2018-11-23 08:01:10'),
(6, 600000, '2018-11-23 08:03:01'),
(7, 600000, '2018-11-23 08:04:06'),
(8, 600000, '2018-11-23 08:05:02'),
(9, 450000, '2018-11-23 08:08:14'),
(10, 450000, '2018-11-23 08:11:26'),
(11, 450000, '2018-11-23 08:11:51'),
(12, 450000, '2018-11-23 08:12:14'),
(13, 450000, '2018-11-23 08:12:40'),
(14, 450000, '2018-11-23 08:13:08'),
(15, 450000, '2018-11-23 08:14:54'),
(16, 450000, '2018-11-23 08:15:24'),
(17, 450000, '2018-11-23 21:04:34'),
(19, 490000, '2018-11-23 21:05:14'),
(20, 70000, '2018-11-23 21:36:20'),
(21, 78000, '2018-11-23 21:37:48');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hinh`
--

CREATE TABLE `hinh` (
  `MAHINH` int(11) NOT NULL,
  `HINH` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOAIHINH` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hinh`
--

INSERT INTO `hinh` (`MAHINH`, `HINH`, `LOAIHINH`) VALUES
(1, '15ede7c2c7552d0b7444.jpg', 1),
(2, 'AMATER-150SC-2.jpg', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MAHOADON` int(11) NOT NULL,
  `MANHANVIEN` int(11) DEFAULT NULL,
  `MAKHACHHANG` int(11) DEFAULT NULL,
  `TINHTRANG` int(11) DEFAULT NULL,
  `HINHTHUCGIAOHANG` int(11) NOT NULL,
  `TENKHACHHANG` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SODIENTHOAI` int(18) NOT NULL,
  `DIACHIGIAOHANG` text COLLATE utf8_unicode_ci NOT NULL,
  `TONGGIA` float NOT NULL,
  `MOTA` text COLLATE utf8_unicode_ci NOT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MAHOADON`, `MANHANVIEN`, `MAKHACHHANG`, `TINHTRANG`, `HINHTHUCGIAOHANG`, `TENKHACHHANG`, `SODIENTHOAI`, `DIACHIGIAOHANG`, `TONGGIA`, `MOTA`, `ISDELETE`, `TIMECREATE`) VALUES
(47, NULL, 1, 1, 1, 'Nguyá»?n VÄ?n Thuáº­n', 121632419, 'Binh ChÃ¡nh HCM', 0, '', 0, '2018-11-14 18:29:01'),
(48, NULL, 1, 1, 1, 'Nguyá»?n VÄ?n Thuáº­n', 121632419, 'Binh ChÃ¡nh HCM', 0, '', 0, '2018-11-14 18:38:17'),
(49, NULL, 1, 2, 0, 'Nguyen Hoang Anh', 1263241992, 'Phuoc Long Bac Lieu', 0, '', 0, '2018-11-14 18:41:53'),
(50, NULL, 1, 2, 0, 'Nguyen Hoang Anh', 1216324199, 'Binh ChÃ¡nh HCM VN', 0, '', 0, '2018-11-14 19:25:05'),
(51, NULL, 1, 1, 1, 'Cao Hoang Anh', 1216324199, '', 0, '', 0, '2018-11-14 19:26:59'),
(52, NULL, 1, 2, 0, 'Tran Binh Trong', 1216324199, 'Binh ChÃ¡nh HCM VN', 0, '', 0, '2018-11-14 19:30:55'),
(53, NULL, 1, 1, 1, 'Tran Binh Trong', 1216324199, 'Binh ChÃ¡nh HCM VN', 3300000, '', 0, '2018-11-14 19:32:49'),
(54, NULL, 1, 1, 0, 'Nguyen Cao Chi Dung', 9030365, '', 450000, '', 0, '2018-11-15 00:21:37'),
(55, NULL, 1, 1, 1, 'Nguyá»?n VÄ?n Thuáº­n', 1216324199, 'Binh ChÃ¡nh HCM', 450000, 'Ra roi', 0, '2018-11-15 21:21:23'),
(56, NULL, 1, 2, 1, 'Nguyá»?n VÄ?n Thuáº­n', 1216324199, 'Binh ChÃ¡nh HCM', 0, '', 0, '2018-11-15 21:32:25'),
(57, NULL, 1, 2, 1, 'Nguyen Van Thuan', 1216324199, 'Binh ChÃ¡nh HCM', 5550000, 'Giao Hang Nhanh', 0, '2018-11-21 06:39:35'),
(58, NULL, NULL, 1, 0, 'Nguyễn Văn Linh', 796854125, 'Thạnh Phước, Giồng Giềng, Kiên Giang', 45000000, 'Giao ngày 12/12/2018', 0, '2018-12-03 18:50:02'),
(59, NULL, NULL, 0, 1, 'Nguyễn Văn Mạnh', 796854125, 'Thạnh Phước, Giồng Giềng, Kiên Giang', 234000, 'Giao ngày 16/15/2018', 0, '2018-12-03 18:59:37'),
(60, NULL, NULL, 1, 1, 'Nguyễn Văn An', 796854129, 'Thạnh Phước, Giồng Giềng, Kiên Giang', 390000, 'Giao hàng trước 4/12/2018', 0, '2018-12-03 19:06:51'),
(61, NULL, NULL, 1, 1, 'Nguyễn Văn Tùng', 796894129, 'Thạnh Phước, Giồng Giềng, Kiên Giang', 1662000, '', 0, '2018-12-03 19:07:43'),
(62, NULL, NULL, 1, 1, 'Nguyễn Văn Hải', 796857125, 'Thạnh Phước, Giồng Giềng, Kiên Giang', 22578000, 'Giao hàng nhanh', 0, '2018-12-03 20:15:52'),
(63, NULL, NULL, 1, 1, 'Nguyễn Văn Hoàng', 796854125, 'Thạnh Phước, Giồng Giềng, Kiên Giang', 1800000, '', 0, '2018-12-03 20:42:35'),
(64, NULL, NULL, 1, 1, 'Nguyễn Văn Có', 796858125, 'Thạnh Phước, Giồng Giềng, Kiên Giang', 1056000, '', 0, '2018-12-03 20:43:46'),
(65, NULL, 1, 1, 1, 'Nguyễn Văn Thuận', 1216324199, 'Binh Chánh HCM', 1878000, '', 0, '2018-12-03 21:08:37'),
(66, NULL, 1, 0, 1, 'Nguyễn Văn Thuận', 1216324199, 'Binh Chánh HCM', 405000, '', 0, '2018-12-03 21:13:17'),
(67, NULL, 1, 1, 1, 'Nguyễn Văn Thuận', 1216324199, 'Binh Chánh HCM', 849600, 'Giao hàng nhanh', 0, '2018-12-03 21:14:39');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKHACHHANG` int(11) NOT NULL,
  `HOTEN` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GIOITINH` tinyint(1) DEFAULT NULL,
  `DIACHI` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMAIL` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SODIENTHOAI` int(18) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MAKHACHHANG`, `HOTEN`, `GIOITINH`, `DIACHI`, `EMAIL`, `SODIENTHOAI`, `ISDELETE`, `DELETEID`, `TIMEDELETE`, `CREATEID`, `TIMECREATE`, `UPDATEID`, `TIMEUPDATE`) VALUES
(1, 'Nguyễn Văn Thuận', 1, 'Binh Chánh HCM', 'thuan@gmail.com', 1216324199, 0, 0, NULL, 0, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MAKHUYENMAI` int(11) NOT NULL,
  `TENKHUYENMAI` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `THOIGIANBATDAU` datetime DEFAULT NULL,
  `THOIGIANKETTHUC` datetime DEFAULT NULL,
  `MOTA` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHANTRAM` int(11) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`MAKHUYENMAI`, `TENKHUYENMAI`, `THOIGIANBATDAU`, `THOIGIANKETTHUC`, `MOTA`, `PHANTRAM`, `ISDELETE`, `DELETEID`, `TIMEDELETE`, `CREATEID`, `TIMECREATE`, `UPDATEID`, `TIMEUPDATE`) VALUES
(1, 'Tết Dương Lịch', '2018-11-03 00:00:00', '2018-11-08 00:00:00', 'Tết an khang', 10, 0, 0, NULL, 0, NULL, 0, NULL),
(2, 'Vụ Đông Xuân', '2018-11-22 00:00:00', '2018-11-30 00:00:00', 'Đông xuân bội thu', 5, 0, 0, NULL, 0, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANHANVIEN` int(11) NOT NULL,
  `HOTEN` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GIOITINH` tinyint(1) DEFAULT NULL,
  `DIACHI` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMAIL` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SODIENTHOAI` int(18) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhasanxuat`
--

CREATE TABLE `nhasanxuat` (
  `MANHASANXUAT` int(11) NOT NULL,
  `TENNHASANXUAT` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DIACHI` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SODIENTHOAI` int(11) DEFAULT NULL,
  `EMAIL` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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

CREATE TABLE `phieunhap` (
  `MAPHIEUNHAP` int(11) NOT NULL,
  `MANHANVIEN` int(11) DEFAULT NULL,
  `MANHASANXUAT` int(11) DEFAULT NULL,
  `MOTA` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MASANPHAM` int(11) NOT NULL,
  `TENSANPHAM` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MOTA` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DELETEID` int(11) DEFAULT NULL,
  `TIMEDELETE` datetime DEFAULT NULL,
  `CREATEID` int(11) DEFAULT NULL,
  `TIMECREATE` datetime DEFAULT NULL,
  `UPDATEID` int(11) DEFAULT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MASANPHAM`, `TENSANPHAM`, `MOTA`, `ISDELETE`, `DELETEID`, `TIMEDELETE`, `CREATEID`, `TIMECREATE`, `UPDATEID`, `TIMEUPDATE`) VALUES
(1, 'NOUVO', 'là hỗn hợp hai hoạt chất đặc hiệu nhất hiện nay đối với Rệp sáp, Mọt đục cành, Sâu đục thân.', 0, 0, NULL, 0, NULL, 0, NULL),
(2, 'AMATER 150SC– ĐẶC TRỊ SÂU RẦY', ' Đặc trị sâu cuốn lá và nhện gié trên lúa. Ngoài ra còn phòng trừ tốt sâu vẽ bùa, sâu xanh, sâu tơ, sâu khoang trên rau màu và cây ăn trái.', 0, 0, NULL, 0, NULL, 0, NULL),
(3, 'dfdsdf', 'sdfsdf', 0, 0, NULL, 0, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MATAIKHOAN` int(11) NOT NULL,
  `MANHANVIEN` int(11) DEFAULT NULL,
  `MAKHACHHANG` int(11) DEFAULT NULL,
  `TENDANGNHAP` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MATKHAU` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MATKHAU2` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `QUYEN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`MATAIKHOAN`, `MANHANVIEN`, `MAKHACHHANG`, `TENDANGNHAP`, `MATKHAU`, `MATKHAU2`, `ISDELETE`, `QUYEN`) VALUES
(1, NULL, NULL, 'admin', 'admin', '123456', NULL, 0),
(2, NULL, 1, 'thuan@gmail.com', '123456', '123456', 0, 0),
(3, NULL, NULL, 'thuanadmin@gmail.com', '123456', '123456', 0, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  ADD PRIMARY KEY (`MABINHLUAN`),
  ADD KEY `FK_RELATIONSHIP_12` (`MANHANVIEN`),
  ADD KEY `FK_RELATIONSHIP_13` (`MASANPHAM`),
  ADD KEY `FK_RELATIONSHIP_17` (`MAKHACHHANG`);

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MACHITIETHOADON`),
  ADD KEY `FK_RELATIONSHIP_21` (`MACHITIETSANPHAM`),
  ADD KEY `FK_RELATIONSHIP_22` (`MAHOADON`);

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MACHITIETPHIEUNHAP`),
  ADD KEY `FK_RELATIONSHIP_19` (`MAPHIEUNHAP`),
  ADD KEY `FK_RELATIONSHIP_20` (`MACHITIETSANPHAM`);

--
-- Chỉ mục cho bảng `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  ADD PRIMARY KEY (`MACHITIETSANPHAM`),
  ADD KEY `FK_RELATIONSHIP_1` (`MADONVITINH`),
  ADD KEY `FK_RELATIONSHIP_2` (`MAGIA`),
  ADD KEY `FK_RELATIONSHIP_23` (`MAKHUYENMAI`),
  ADD KEY `FK_RELATIONSHIP_24` (`MAHINH`),
  ADD KEY `FK_RELATIONSHIP_25` (`MADANHMUC`),
  ADD KEY `FK_RELATIONSHIP_3` (`MASANPHAM`),
  ADD KEY `FK_RELATIONSHIP_5` (`MANHASANXUAT`);

--
-- Chỉ mục cho bảng `danhmucsanpham`
--
ALTER TABLE `danhmucsanpham`
  ADD PRIMARY KEY (`MADANHMUC`);

--
-- Chỉ mục cho bảng `donvitinh`
--
ALTER TABLE `donvitinh`
  ADD PRIMARY KEY (`MADONVITINH`);

--
-- Chỉ mục cho bảng `gia`
--
ALTER TABLE `gia`
  ADD PRIMARY KEY (`MAGIA`);

--
-- Chỉ mục cho bảng `hinh`
--
ALTER TABLE `hinh`
  ADD PRIMARY KEY (`MAHINH`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHOADON`),
  ADD KEY `FK_RELATIONSHIP_14` (`MAKHACHHANG`),
  ADD KEY `FK_RELATIONSHIP_9` (`MANHANVIEN`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MAKHACHHANG`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MAKHUYENMAI`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANHANVIEN`);

--
-- Chỉ mục cho bảng `nhasanxuat`
--
ALTER TABLE `nhasanxuat`
  ADD PRIMARY KEY (`MANHASANXUAT`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MAPHIEUNHAP`),
  ADD KEY `FK_RELATIONSHIP_10` (`MANHASANXUAT`),
  ADD KEY `FK_RELATIONSHIP_18` (`MANHANVIEN`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MASANPHAM`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MATAIKHOAN`),
  ADD KEY `FK_RELATIONSHIP_16` (`MAKHACHHANG`),
  ADD KEY `FK_RELATIONSHIP_8` (`MANHANVIEN`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  MODIFY `MABINHLUAN` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  MODIFY `MACHITIETHOADON` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  MODIFY `MACHITIETPHIEUNHAP` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  MODIFY `MACHITIETSANPHAM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `danhmucsanpham`
--
ALTER TABLE `danhmucsanpham`
  MODIFY `MADANHMUC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `donvitinh`
--
ALTER TABLE `donvitinh`
  MODIFY `MADONVITINH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `gia`
--
ALTER TABLE `gia`
  MODIFY `MAGIA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `hinh`
--
ALTER TABLE `hinh`
  MODIFY `MAHINH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MAHOADON` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MAKHACHHANG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `MAKHUYENMAI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MANHANVIEN` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nhasanxuat`
--
ALTER TABLE `nhasanxuat`
  MODIFY `MANHASANXUAT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MAPHIEUNHAP` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MASANPHAM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `MATAIKHOAN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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

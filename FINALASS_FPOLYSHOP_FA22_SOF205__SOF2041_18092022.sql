CREATE DATABASE FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041
USE FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041
GO
-- ChucVu
CREATE TABLE ChucVu(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL
)
GO
-- CuaHang
CREATE TABLE CuaHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
ThanhPho NVARCHAR(50) DEFAULT NULL,
QuocGia NVARCHAR(50) DEFAULT NULL
)
GO
-- NhanVien
CREATE TABLE NhanVien(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30) DEFAULT NULL,
TenDem NVARCHAR(30) DEFAULT NULL,
Ho NVARCHAR(30) DEFAULT NULL,
GioiTinh NVARCHAR(10) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
MatKhau VARCHAR(MAX) DEFAULT NULL,
IdCH UNIQUEIDENTIFIER,
IdCV UNIQUEIDENTIFIER,
IdGuiBC UNIQUEIDENTIFIER,
TrangThai INT DEFAULT 0
)
GO
-- KhachHang
CREATE TABLE KhachHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
TenDem NVARCHAR(30) DEFAULT NULL,
Ho NVARCHAR(30) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
ThanhPho NVARCHAR(50) DEFAULT NULL,
QuocGia NVARCHAR(50) DEFAULT NULL,
MatKhau VARCHAR(MAX) DEFAULT NULL
)
GO
--HoaDon
CREATE TABLE HoaDon(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdKH UNIQUEIDENTIFIER,
IdNV UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
NgayTao DATE DEFAULT NULL,
NgayThanhToan DATE DEFAULT NULL,
NgayShip DATE DEFAULT NULL,
NgayNhan DATE DEFAULT NULL,
TinhTrang INT DEFAULT 0,
TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
)
GO
CREATE TABLE GioHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdKH UNIQUEIDENTIFIER,
IdNV UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
NgayTao DATE DEFAULT NULL,
NgayThanhToan DATE DEFAULT NULL,
TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
TinhTrang INT DEFAULT 0
)
GO
-- SanPham
CREATE TABLE SanPham(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- NSX
CREATE TABLE NSX(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- MauSac
CREATE TABLE MauSac(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- DongSP
CREATE TABLE DongSP(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- ChiTietSP
CREATE TABLE ChiTietSP(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdSP UNIQUEIDENTIFIER,
IdNsx UNIQUEIDENTIFIER,
IdMauSac UNIQUEIDENTIFIER,
IdDongSP UNIQUEIDENTIFIER,
NamBH INT DEFAULT NULL,
MoTa NVARCHAR(50) DEFAULT NULL,
SoLuongTon INT,
GiaNhap DECIMAL(20,0) DEFAULT 0,
GiaBan DECIMAL(20,0) DEFAULT 0,
)

GO
-- HoaDonChiTiet
CREATE TABLE HoaDonChiTiet(
IdHoaDon UNIQUEIDENTIFIER,
IdChiTietSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
CONSTRAINT PK_HoaDonCT PRIMARY KEY (IdHoaDon,IdChiTietSP),
CONSTRAINT FK1 FOREIGN KEY(IdHoaDon) REFERENCES HoaDon(Id),
CONSTRAINT FK2 FOREIGN KEY(IdChiTietSP) REFERENCES ChiTietSP(Id),
)
GO
CREATE TABLE GioHangChiTiet(
IdGioHang UNIQUEIDENTIFIER,
IdChiTietSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
DonGiaKhiGiam DECIMAL(20,0) DEFAULT 0,
CONSTRAINT PK_GioHangCT PRIMARY KEY (IdGioHang,IdChiTietSP),
CONSTRAINT FK1_IdGioHang FOREIGN KEY(IdGioHang) REFERENCES GioHang(Id),
CONSTRAINT FK2_IdChiTietSP FOREIGN KEY(IdChiTietSP) REFERENCES ChiTietSP(Id),
)
GO
--TẠO QUAN HỆ GIỮA CÁC BẢNG
--NhanVien - CuaHang
ALTER TABLE NhanVien ADD FOREIGN KEY (IdCH) REFERENCES CuaHang(Id)
--NhanVien - ChucVu
ALTER TABLE NhanVien ADD FOREIGN KEY (IdCV) REFERENCES ChucVu(Id)
--NhanVien - GuiBaoCao
ALTER TABLE NhanVien ADD FOREIGN KEY (IdGuiBC) REFERENCES NhanVien(Id)
-- HoaDon - KhachHang
ALTER TABLE HoaDon ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id)
-- GioHang - KhachHang
ALTER TABLE GioHang ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id)
-- HoaDon - NhanVien
ALTER TABLE HoaDon ADD FOREIGN KEY (IdNV) REFERENCES NhanVien(Id)
-- ChiTietSP - SanPham
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdSP) REFERENCES SanPham(Id)
-- ChiTietSP - NSX
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdNsx) REFERENCES Nsx(Id)
-- ChiTietSP - MauSac
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdMauSac) REFERENCES MauSac(Id)
-- ChiTietSP - DongSP
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdDongSP) REFERENCES DongSP(Id)
insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH01',N'Nam',N'Phương',N'Đặng','08/30/2003','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH02',N'Hải',N'Văn',N'Nguyễn','10/03/1983','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH03',N'Đạt',N'Văn',N'Nguyễn','11/01/1993','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH04',N'Anh',N'Đức',N'Nguyễn','12/10/1974','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH05',N'Long',N'Hoàng',N'Nguyễn','06/15/1997','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH06',N'Thắng',N'Đại',N'Dương','04/18/1996','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH07',N'Tuấn',N'Anh',N'Tô','05/24/2005','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH08',N'Hiệp',N'Hoàng',N'Nguyễn','11/29/1970','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH09',N'Hà',N'Việt',N'Hoàng','12/31/1969','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH010',N'Trọng',N'Phạm',N'Lê','01/30/1991','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH011',N'Việt',N'Trọng',N'Nguyễn','02/28/1990','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH012',N'Trường',N'Văn',N'Võ','08/26/1978','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH013',N'Cường',N'Xuân',N'Trần','09/24/1967','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH014',N'Hằng',N'Thị',N'Nguyễn','10/27/1989','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH015',N'Hoa',N'Thị',N'Phan','07/20/1998','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH016',N'Trầm',N'Thị',N'Bùi','08/15/1997','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH017',N'Lương',N'Hiền',N'Nguyễn','11/10/1999','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH018',N'Mai',N'Thị',N'Nguyễn','09/11/2002','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH019',N'Nga',N'Thị',N'Lê','08/18/2001','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
  insert into KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values('KH020',N'Hồng',N'Thị',N'Phan','04/29/2000','0986434589',N'360 Giải Phóng, Hoàng Mai',N'Hà Nội',N'Việt Nam','1234')
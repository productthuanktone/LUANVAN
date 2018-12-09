package com.nguyenvanthuan.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.ChiTietHoaDon;
import com.nguyenvanthuan.entity.ChiTietSanPham;
import com.nguyenvanthuan.entity.GioHang;
import com.nguyenvanthuan.entity.HoaDon;
import com.nguyenvanthuan.entity.KhachHang;
import com.nguyenvanthuan.entity.TaiKhoan;
import com.nguyenvanthuan.service.ChiTietSanPhamService;
import com.nguyenvanthuan.service.HoaDonService;
import com.nguyenvanthuan.service.KhachHangSevice;
import com.nguyenvanthuan.service.TaiKhoanSevice;

@Controller
@RequestMapping("giohang/")
@SessionAttributes("giohang,tendangnhap")
public class GioHangController {
	@Autowired
	HoaDonService hoadonservice;
	@Autowired
	SessionFactory sesionFactory;
	@Autowired
	TaiKhoanSevice taikhoanSV;
	@Autowired
	KhachHangSevice khachhangservice;
	@Autowired
	ChiTietSanPhamService chitietsanphamservice;

	@Autowired
	private JavaMailSender mailSender2;

	@GetMapping
	@Transactional
	public String GioHang(ModelMap modelMap, HttpSession httpSession) {
		if (null != httpSession.getAttribute("giohang")) {
			@SuppressWarnings("unchecked")
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluonggiohang", listgiohang.size());
			modelMap.addAttribute("giohang", listgiohang);
		}
		String tendangnhap = (String) httpSession.getAttribute("tendangnhap");
		if (null != tendangnhap) {
			TaiKhoan taiKhoan = taikhoanSV.laytaikhoan(tendangnhap);
			modelMap.addAttribute("taikhoan", taiKhoan);
		} else {
			TaiKhoan taiKhoan = null;
			modelMap.addAttribute("taikhoan", taiKhoan);
		}

		return "giohang";
	}

	@PostMapping
	@Transactional
	public String MuaHang(@RequestParam String tenkhachhang, @RequestParam int sodienthoai,
			@RequestParam int hinhthucgiaohang, @RequestParam String diachigiaohang, @RequestParam String mota,
			HttpSession httpSession, ModelMap modelMap) throws MessagingException {
		System.out.println(tenkhachhang);
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			Set<ChiTietHoaDon> chiTietHoaDons = new HashSet<>();
			float tonghoadon = 0;
			for (GioHang gioHang : listgiohang) {
				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
				ChiTietSanPham chiTietSanPham = chitietsanphamservice.chiTietSanPham(gioHang.getMachitietsanpham());
				chiTietHoaDon.setSOLUONG(gioHang.getSoluong());
				float tonggia1 = gioHang.getGia() * gioHang.getSoluong();
				chiTietHoaDon.setTONGGIA(tonggia1);
				chiTietHoaDon.setChiTietSanPham(chiTietSanPham);
				chiTietHoaDons.add(chiTietHoaDon);
				tonghoadon = tonghoadon + tonggia1;

			}
			// Set<ChiTietHoaDon> chiTietHoaDons=new HashSet<>();
			// ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
			// chiTietHoaDon.setSOLUONG(1);
			// chiTietHoaDon.setTONGGIA(1);
			// chiTietHoaDon.setMACHITIETSANPHAM(1);
			//
			// ChiTietHoaDon chiTietHoaDon1 = new ChiTietHoaDon();
			// chiTietHoaDon1.setSOLUONG(2);
			// chiTietHoaDon1.setTONGGIA(2);
			// chiTietHoaDon1.setMACHITIETSANPHAM(2);
			//
			// chiTietHoaDons.add(chiTietHoaDon);
			// chiTietHoaDons.add(chiTietHoaDon1);

			String tendangnhap = (String) httpSession.getAttribute("tendangnhap");
			if (null != tendangnhap) {
				TaiKhoan taiKhoan = taikhoanSV.laytaikhoan(tendangnhap);
				int makhachhang = taiKhoan.getKhachhang().getMAKHACHHANG();
				KhachHang khachHang = khachhangservice.khachhang(makhachhang);
				HoaDon hoaDon = new HoaDon();
				hoaDon.setHINHTHUCGIAOHANG(hinhthucgiaohang);
				hoaDon.setDIACHIGIAOHANG(diachigiaohang);
				hoaDon.setMOTA(mota);
				hoaDon.setTIMECREATE((date));
				hoaDon.setKhachhang(khachHang);
				hoaDon.setTENKHACHHANG(tenkhachhang);
				hoaDon.setSODIENTHOAI(sodienthoai);
				hoaDon.setChitiethoadon(chiTietHoaDons);
				hoaDon.setTONGGIA(tonghoadon);
				if (hoadonservice.ThemHoaDon(hoaDon)) {
					System.out.println("Them TC");
					httpSession.removeAttribute("giohang");
					String thanhcong = "Đặt Hàng Thành Công!";
					// Sent email start
					MimeMessage mimeMessage = mailSender2.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
					SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String htmlMsg = "<div style='width:500px;     background-color: #97d6e859;'><h3>"
							+ khachHang.getHOTEN() + " thân mến!</h3>"
							+ "<p style='width:500px;'>Yêu cầu đặt hàng cho đơn hàng của bạn đã được tiếp nhận và đang chờ xử lý, thời gian đặt hàng là "
							+ dt.format(date)
							+ " với hình thức thanh toán là Thanh toán khi nhận hàng. Chúng tôi sẽ tiếp tục cập nhật với bạn về trạng thái tiếp theo của đơn hàng.</p>"
							+ "<h2 style='text-align:center;'>Chi tiết đơn hàng</h2>"
							+ "<table class=\"table\" style=\"border: 1px solid black; border-collapse: collapse; width: 500px\">\r\n"
							+ "		  <thead class=\"thead-dark\">\r\n"
							+ "			<tr style=\"background-color: #CDDC39;\">\r\n"
							+ "			  <th scope=\"col\" style=\"border: 1px solid black;width:30px;\">#</th>\r\n"
							+ "			  <th scope=\"col\" style=\"border: 1px solid black;\">Tên sản phẩm</th>\r\n"
							+ "			  <th scope=\"col\"style=\"border: 1px solid black;\">Số lượng</th>\r\n"
							+ "			  <th scope=\"col\" style=\"border: 1px solid black;\">Giá</th>\r\n"
							+ "			  <th scope=\"col\" style=\"border: 1px solid black;\">Thành tiền</th>\r\n"
							+ "			</tr>\r\n" + "		  </thead>\r\n" + "		  <tbody>\r\n";
					float tongtien = 0;
					int stt = 1;
					for (GioHang gioHang : listgiohang) {
						htmlMsg = htmlMsg + "			<tr>\r\n"
								+ "			  <th scope=\"row\" style=\"border: 1px solid black; width:5px;\">" + stt++
								+ "</th>\r\n" + "			  <td style=\'border: 1px solid black;\'>"
								+ gioHang.getTensanpham() + "</td>\r\n"
								+ "			  <td style=\"border: 1px solid black;\">" + gioHang.getSoluong()
								+ "</td>\r\n" + "			  <td style=\"border: 1px solid black;\">"
								+ gioHang.getGia() + "</td>\r\n"
								+ "			  <td style=\"border: 1px solid black;\">"
								+ gioHang.getGia() * gioHang.getSoluong() + "</td>\r\n" + "			</tr>\r\n";
						tongtien = tongtien + gioHang.getGia() * gioHang.getSoluong();
					}
					htmlMsg = htmlMsg + "<tr> " + "<td colspan='4'style='border: 1px solid black;'>" + "Tổng tiền: "
							+ "</td>" + "<td style='border: 1px solid black; color:red;'>" + tongtien + " VNĐ</td>"
							+ "</tr></tbody>" + "</table>";
					Calendar calendar = Calendar.getInstance();

					calendar.roll(calendar.DAY_OF_MONTH, 3);
					SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
					htmlMsg = htmlMsg + "<p>Đơn hàng sẽ được giao vào ngày " + dt1.format(calendar.getTime())
							+ ".<br>Địa chỉ giao hàng của bạn: " + khachHang.getDIACHI() +".<hr></p>";
			
					mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");
					helper.setTo(khachHang.getEMAIL());
					helper.setSubject("Doanh nghiệp Hương Lúa đã nhận đơn hàng của bạn #" + date.getTime() + "");
					mailSender2.send(mimeMessage);
					// sent email end
					String tendangnhap1 = (String) httpSession.getAttribute("tendangnhap");
					if (null != tendangnhap1) {
						TaiKhoan taiKhoan1 = taikhoanSV.laytaikhoan(tendangnhap);
						modelMap.addAttribute("taikhoan", taiKhoan1);
					} else {
						TaiKhoan taiKhoan1 = null;
						modelMap.addAttribute("taikhoan", taiKhoan1);
					}
					modelMap.addAttribute("tc", thanhcong);

				} else {
					System.out.println("Them TB");
					String thatbai = "Đặt Hàng không Thành Công!";
					modelMap.addAttribute("tc", thatbai);
				}
			} else {
				System.out.println(tenkhachhang);
				HoaDon hoaDon = new HoaDon();
				hoaDon.setHINHTHUCGIAOHANG(hinhthucgiaohang);
				hoaDon.setDIACHIGIAOHANG(diachigiaohang);
				hoaDon.setMOTA(mota);
				hoaDon.setTIMECREATE((date));
				hoaDon.setTENKHACHHANG(tenkhachhang);
				hoaDon.setSODIENTHOAI(sodienthoai);
				hoaDon.setChitiethoadon(chiTietHoaDons);
				hoaDon.setTONGGIA(tonghoadon);
				if (hoadonservice.ThemHoaDon(hoaDon)) {
					System.out.println("Them TC");
					httpSession.removeAttribute("giohang");
					String thanhcong = "Đặt Hàng Thành Công!";
					// Sent email start
					MimeMessage mimeMessage = mailSender2.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
					String htmlMsg = "	<h1>Danh sách Sản Phẩm</h1>	<table class=\"table\" style=\"border: 1px solid black; border-collapse: collapse; width: 500px\">\r\n"
							+ "		  <thead class=\"thead-dark\">\r\n"
							+ "			<tr style=\"background-color: #CDDC39;\">\r\n"
							+ "			  <th scope=\"col\" style=\"border: 1px solid black;width:30px;\">#</th>\r\n"
							+ "			  <th scope=\"col\" style=\"border: 1px solid black;\">Tên sản phẩm</th>\r\n"
							+ "			  <th scope=\"col\"style=\"border: 1px solid black;\">Số lượng</th>\r\n"
							+ "			  <th scope=\"col\" style=\"border: 1px solid black;\">Giá</th>\r\n"
							+ "			  <th scope=\"col\" style=\"border: 1px solid black;\">Thành tiền</th>\r\n"
							+ "			</tr>\r\n" + "		  </thead>\r\n" + "		  <tbody>\r\n";
					float tongtien = 0;
					int stt = 0;
					for (GioHang gioHang : listgiohang) {
						htmlMsg = htmlMsg + "			<tr>\r\n"
								+ "			  <th scope=\"row\" style=\"border: 1px solid black; width:5px;\">" + stt++
								+ "</th>\r\n" + "			  <td style=\'border: 1px solid black;\'>"
								+ gioHang.getTensanpham() + "</td>\r\n"
								+ "			  <td style=\"border: 1px solid black;\">" + gioHang.getSoluong()
								+ "</td>\r\n" + "			  <td style=\"border: 1px solid black;\">"
								+ gioHang.getGia() + "</td>\r\n"
								+ "			  <td style=\"border: 1px solid black;\">"
								+ gioHang.getGia() * gioHang.getSoluong() + "</td>\r\n" + "			</tr>\r\n";

						tongtien = tongtien + gioHang.getGia() * gioHang.getSoluong();
					}
					htmlMsg = htmlMsg + "<tr> " + "<td colspan='4'style='border: 1px solid black;'>" + "Tổng tiền: "
							+ "</td>" + "<td style='border: 1px solid black; color:red;'>" + tongtien + " VNĐ</td>"
							+ "</tr></tbody>" + "</table>";
					mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");
					helper.setTo("thuanb1401193@student.ctu.edu.vn");
					helper.setSubject("Doanh nghiệp Hương Lúa đã nhận đơn hàng của bạn!");
					mailSender2.send(mimeMessage);
					// sent email end
					String tendangnhap1 = (String) httpSession.getAttribute("tendangnhap");
					if (null != tendangnhap1) {
						TaiKhoan taiKhoan1 = taikhoanSV.laytaikhoan(tendangnhap);
						modelMap.addAttribute("taikhoan", taiKhoan1);
					} else {
						TaiKhoan taiKhoan1 = null;
						modelMap.addAttribute("taikhoan", taiKhoan1);
					}
					modelMap.addAttribute("tc", thanhcong);

				} else {
					System.out.println("Them TB");
					String thatbai = "Đặt Hàng không Thành Công!";
					modelMap.addAttribute("tc", thatbai);
				}
			}

		}
		// @RequestParam float tonggia,

		return "giohang";
	}
}

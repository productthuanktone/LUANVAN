package com.nguyenvanthuan.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenvanthuan.entity.ChiTietHoaDon;
import com.nguyenvanthuan.entity.GioHang;
import com.nguyenvanthuan.entity.HoaDon;
import com.nguyenvanthuan.service.ChiTietHoaDonService;
import com.nguyenvanthuan.service.ChiTietSanPhamService;
import com.nguyenvanthuan.service.HoaDonService;

@Controller
@RequestMapping("hoadon/")
@SessionAttributes("tendangnhap")
public class HoaDonController {
	@Autowired
	HoaDonService hoadonService;
	@Autowired
	ChiTietHoaDonService chitiethoadonService;
	@Autowired
	ChiTietSanPhamService chitietsanphamservice;
	@Autowired
	private JavaMailSender mailSender2;

	@GetMapping
	public String getHoaDon(ModelMap modelMap) {
		List<HoaDon> listhoadon = hoadonService.listHoaDon();
		modelMap.addAttribute("hoadon", listhoadon);
		return "hoadon";
	}

	@GetMapping("{id}")
	public String chitiethoadon(ModelMap modelMap, @PathVariable int id) {
		List<ChiTietHoaDon> chitiethoadons = chitiethoadonService.listchitiethoadonid(id);
		HoaDon hoaDon = hoadonService.hoaDonid(id);
		modelMap.addAttribute("listchitiet", chitiethoadons);
		modelMap.addAttribute("hoadon", hoaDon);
		return "chitiethoadon";
	}

	@GetMapping("duyenhoadon/{tinhtrang}/{id}")
	public String XuLyHoaDon(ModelMap modelMap, @PathVariable int id, @PathVariable int tinhtrang)
			throws MessagingException {
		if (tinhtrang == 1) {
			if (kiemtrasoluong(id)) {
				List<ChiTietHoaDon> chiTietHoaDonlist = chitiethoadonService.listchitiethoadonid(id);
				for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonlist) {
					int soluongmoi = Math
							.abs(chiTietHoaDon.getSOLUONG() - chiTietHoaDon.getChiTietSanPham().getSOLUONG());
					System.out.println(soluongmoi);
					chitietsanphamservice.updatesoluongsanpham(chiTietHoaDon.getChiTietSanPham().getMACHITIETSANPHAM(),
							soluongmoi);
				}
				hoadonService.SaveHoaDon(tinhtrang, id);
				return "redirect:/hoadon/";
			} else {
				String hethang = "Số lượng trong kho không đủ đáp ứng.";
				modelMap.addAttribute("hethang", hethang);
				List<ChiTietHoaDon> chitiethoadons = chitiethoadonService.listchitiethoadonid(id);
				HoaDon hoaDon = hoadonService.hoaDonid(id);
				modelMap.addAttribute("listchitiet", chitiethoadons);
				modelMap.addAttribute("hoadon", hoaDon);
				return "chitiethoadon";
			}
		} else {
			hoadonService.SaveHoaDon(tinhtrang, id);
			HoaDon hoaDon = hoadonService.hoaDonid(id);
			List<ChiTietHoaDon> chitiethoadons = chitiethoadonService.listchitiethoadonid(id);
			MimeMessage mimeMessage = mailSender2.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String htmlMsg = "<div style='width:500px;     background-color: #97d6e859;'><h3>"
					+ hoaDon.getKhachhang().getHOTEN() + " thân mến!</h3>"
					+ "<p style='width:500px;'>Đơn hàng đã được hủy theo yêu cầu của bạn. Chi tiết sản phẩm được liệt kê bên dưới. "
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
			for (ChiTietHoaDon chiTietHoaDon : chitiethoadons) {
				htmlMsg = htmlMsg + "			<tr>\r\n"
						+ "			  <th scope=\"row\" style=\"border: 1px solid black; width:5px;\">" + stt++
						+ "</th>\r\n" + "			  <td style=\'border: 1px solid black;\'>"
						+ chiTietHoaDon.getChiTietSanPham().getSanpham().getTENSANPHAM() + "</td>\r\n"
						+ "			  <td style=\"border: 1px solid black;\">" + chiTietHoaDon.getSOLUONG()
						+ "</td>\r\n" + "			  <td style=\"border: 1px solid black;\">"
						+ chiTietHoaDon.getChiTietSanPham().getGia().getGIA() + "</td>\r\n"
						+ "			  <td style=\"border: 1px solid black;\">"
						+ chiTietHoaDon.getChiTietSanPham().getGia().getGIA() * chiTietHoaDon.getSOLUONG() + "</td>\r\n"
						+ "			</tr>\r\n";
				tongtien = tongtien + chiTietHoaDon.getChiTietSanPham().getGia().getGIA() * chiTietHoaDon.getSOLUONG();
			}
			htmlMsg = htmlMsg + "<tr> " + "<td colspan='4'style='border: 1px solid black;'>" + "Tổng tiền: " + "</td>"
					+ "<td style='border: 1px solid black; color:red;'>" + tongtien + " VNĐ</td>" + "</tr></tbody>"
					+ "</table>";
			mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");
			helper.setTo(hoaDon.getKhachhang().getEMAIL());
			helper.setSubject("Sản phẩm thuộc đơn hàng đã được hủy trên hệ thống!");
			mailSender2.send(mimeMessage);
		}
		return "redirect:/hoadon/";

	}

	public boolean kiemtrasoluong(int id) {
		List<ChiTietHoaDon> chiTietHoaDonlist = chitiethoadonService.listchitiethoadonid(id);
		int tong = 0;
		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonlist) {
			if (chiTietHoaDon.getSOLUONG() > chiTietHoaDon.getChiTietSanPham().getSOLUONG()) {
				tong = tong + 1;
			}
		}
		if (tong == 0) {
			return true;
		} else {
			return false;
		}
	}
}
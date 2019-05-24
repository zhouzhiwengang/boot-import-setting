package com.zzg.report;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import net.sf.jasperreports.engine.JasperRunManager;

@Controller
@RequestMapping("/api/jdbc")
public class JDBCController {
	@RequestMapping("/{reportName}")
	public void getReportByParam(@PathVariable("reportName") final String reportName, HttpServletResponse response) {
		ServletOutputStream sosRef = null;
		// jdbc 连接获取
		try {
			String url = "jdbc:mysql://192.168.1.73:3306/boot-setting?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "digipower");

			// 获取文件流
			ClassPathResource resource = new ClassPathResource("jaspers" + File.separator + reportName + ".jasper");
			InputStream jasperStream = resource.getInputStream();

			sosRef = response.getOutputStream();

			JasperRunManager.runReportToPdfStream(jasperStream, sosRef, null, conn);
			response.setContentType("application/pdf");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sosRef.flush();
				sosRef.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

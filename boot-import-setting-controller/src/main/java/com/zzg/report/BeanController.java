package com.zzg.report;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzg.entity.Column;

import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/api/bean")
public class BeanController {
	@RequestMapping("/{reportName}")
	public void getReportByParam(@PathVariable("reportName") final String reportName, HttpServletResponse response) {
		ServletOutputStream sosRef = null;
		// bean 连接获取
		try {
			List<Column> list = new ArrayList<Column>();
			// for(int i = 1; i <= 100; i++) {
			// Column column = new Column();
			// column.setSid("sid:" + i);
			// column.setName("name is :" + i);
			// list.add(column);
			// }

			for (int i = 1; i <= 100; i++) {
				Column column = new Column();
				column.setSid("sid:" + i);
				if (i % 2 == 0) {
					column.setName("a");
				} else {
					column.setName("b");
				}

				list.add(column);
			}

			// 获取文件流
			ClassPathResource resource = new ClassPathResource("jaspers" + File.separator + reportName + ".jasper");
			InputStream jasperStream = resource.getInputStream();

			sosRef = response.getOutputStream();

			JasperRunManager.runReportToPdfStream(jasperStream, sosRef, null, new JRBeanCollectionDataSource(list));
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

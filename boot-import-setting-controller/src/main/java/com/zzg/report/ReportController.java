package com.zzg.report;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperRunManager;

@Controller
@RequestMapping("/api/report")
public class ReportController {
	@RequestMapping("/{reportName}")
	public void getReportByParam(@PathVariable("reportName") final String reportName, HttpServletResponse response) {
		// try{
		// 参数填充
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("title", "参数");
		parameters.put("date", "2019-05-23");
		parameters.put("name", "周志刚");
		parameters.put("age", "28");
		parameters.put("dept", " 研发中心");
		parameters.put("gender", "码农");
		ServletOutputStream sosRef = null;
		try {
			// 获取文件流
			ClassPathResource resource = new ClassPathResource("jaspers" + File.separator + reportName + ".jasper");
			InputStream jasperStream = resource.getInputStream();

			sosRef = response.getOutputStream();

			JasperRunManager.runReportToPdfStream(jasperStream, sosRef, parameters, new JREmptyDataSource());
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

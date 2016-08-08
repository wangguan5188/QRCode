package com.omnipotent.servlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.omnipotent.utils.MatrixToImageWriter;
import com.omnipotent.utils.StringUtil;

/**
 * 生成二维码图片
 * 
 * @author zhangtb
 * @date 2016年4月18日 下午6:37:38
 * @since 1.0.0
 */
public class QRCode extends HttpServlet {

	private static final long serialVersionUID = -6093422212742428689L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String url = "https://www.baidu.com";
			if(StringUtils.isNotBlank(url)) {
				// 参数组装
				String text = url + "/s?word=json";
				int width = StringUtil.toInt(request.getParameter("width"), 150);
				int height = StringUtil.toInt(request.getParameter("height"), 150);
				// 二维码的图片格式
				String format = "jpg";
				Hashtable hints = new Hashtable();
				// 内容所使用编码
				hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
				BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
				// 生成二维码图片，输出到文件
				// System.out.println("File.separator = " + File.separator);
				// File outputFile = new File("d:" + File.separator + "new.jpg");
				// MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
				
				// 生成二维码图片，输出到页面
				OutputStream stream = response.getOutputStream();
				MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
			}
		} catch (Exception e) {
			// logger.error("生成二维码时发生异常：", e);
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {
		String text = "http://www.baidu.com?a=13weweffwfwef&b3wef3wewefwefwfwef=2&c=3wefwwfwef";
		int width = 300;
		int height = 300;
		// 二维码的图片格式
		String format = "jpg";
		Hashtable hints = new Hashtable();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		// 生成二维码
		System.out.println("File.separator = " + File.separator);
		File outputFile = new File("d:" + File.separator + "new.jpg");
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
	}

}

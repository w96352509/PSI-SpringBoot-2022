package com.study.springmvc.service;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.study.springmvc.entity.Product;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class LineNotify {

	// 純訊息
	public void send(Product product) throws IOException {
		// 1. 要發送的資料
		String message = String.format("商品名稱: %s\n商品特價: %d", product.getName(), product.getPrice());
		// 2. 存取權杖(也稱為:授權 Token)
		String token = "CJLu9T7cLWYdFCkTPcqQ3l2a22Mx7mGO5sAqu9MKXf2";
		// 3. Line Notify 的發送位置
		String lineNotifyUrl = "https://notify-api.line.me/api/notify";
		// 4. 發送前設定
		// -------------------------------------------------------------------------
		// 發送文字
		byte[] postData = ("message=" + message).getBytes("UTF-8");
		// 發送文字 + 縮略圖 + 網路圖片
		// String picurl = "https://image.cache.u-car.com.tw/articleimage_1091049.jpg";
		// byte[] postData = ("message=" + message +
		// "&stickerPackageId=1&stickerId=113&imageThumbnail=" + picurl +
		// "&imageFullsize=" + picurl).getBytes("UTF-8");

		int postDataLength = postData.length;
		URL url = new URL(lineNotifyUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Bearer " + token); // 一定要加
		conn.setRequestProperty("charset", "utf-8"); // 可以不用加
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); // 可以不用加
		conn.setRequestProperty("Content-Length", Integer.toString(postDataLength)); // 可以不用加
		conn.setUseCaches(false);
		// 5. 訊息發送
		// ---------------------------------------------------------------------------
		try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
			wr.write(postData);
			wr.flush();
		}
		// 6. 回應資料
		// ---------------------------------------------------------------------------
		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			int statusCode = conn.getResponseCode();
			System.out.println(statusCode);
		}
	}

	// 純訊息 + 圖片
	public void sendImage(Product product, String filename) throws Exception {
		// 1. 要發送的資料
		String message = String.format("商品名稱: %s\n商品特價: %d", product.getName(), product.getPrice());
		// 2. 存取權杖(也稱為:授權 Token)
		String token = "CJLu9T7cLWYdFCkTPcqQ3l2a22Mx7mGO5sAqu9MKXf2";
		// 3. Line Notify 的發送位置
		String lineNotifyUrl = "https://notify-api.line.me/api/notify";
		// 4. 上傳檔案
		File file = new File("C:\\Users\\vic\\Desktop\\複習檔案\\PSI\\圖片\\" + filename);
		System.out.println(file);
		// 5. 發送前設定
		// -------------------------------------------------------------------------
		// 標頭檔
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", "Bearer " + token);
		HttpPostMultipart multipart = new HttpPostMultipart(lineNotifyUrl, "utf-8", headers);
		// post參數
		multipart.addFormField("message", message);
		// 上傳文件
		multipart.addFilePart("imageFile", file);
		// 返回信息
		String response = multipart.finish();
		System.out.println(response);
	}
}

<%@ page contentType="image/jpeg"
	import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"
	pageEncoding="utf-8"%>
<%
	//设置页面不缓存
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);

	//谁定初始值
	//验证码源 
	String codeList = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	//验证码图片高 
	final int height = 20;
	//验证码长度 
	final int fontNum = 4;
	//验证码图片宽度 
	int width = 13 * fontNum + 12;

	// 在内存中创建图象
	BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	// 获取图形上下文
	Graphics g = image.getGraphics();
	//生成随机类
	Random random = new Random();
	// 设定背景色
	g.setColor(getRandColor(200, 250));
	g.fillRect(0, 0, width, height);
	// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
	for (int i = 0; i > 155; i++) {
		g.setColor(getRandColor(140, 200));
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int x1 = random.nextInt(12);
		int y1 = random.nextInt(12);
		g.drawLine(x, y, x + x1, y + y1);
	}
	//设定字体
	g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	// 取随机产生的认证码(4位数字)
	StringBuffer rand = new StringBuffer();
	for (int i = 0; i < fontNum; i++) {
		int irand = random.nextInt(codeList.length());
		String strRand = codeList.substring(irand, irand + 1);
		rand.append(strRand);
		 // 将认证码显示到图象中
		g.setColor(new Color(20 + random.nextInt(110), 20 + random
				.nextInt(110), 20 + random.nextInt(110)));
		g.drawString(strRand, 13 * i + 6, 16);
	}
	// 图象生效
	g.dispose();
	//输出图像到页面
	ImageIO.write(image, "JPEG", response.getOutputStream());
	out.clear();
	out = pageContext.pushBody();
	session.setAttribute("rand", rand.toString());
%>
<%!Color getRandColor(int fc, int bc) {
		//给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}%>


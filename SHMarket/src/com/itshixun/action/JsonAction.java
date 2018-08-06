package com.itshixun.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class JsonAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private String result;

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 处理ajax请求
	 */
	public String excuteAjax() {
		try {

			// 获取数据
			String remail = request.getParameter("email");

			int _code = (int) (Math.random() * 9000 + 1000);
			String code = String.valueOf(_code);
			// Math.random() * (max - min) + min; 大于等于min 小于max

			SendEmail email = new SendEmail();
			email.setReceiveMailAccount(remail);
			email.setInfo(code);
			try {
				email.Send();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 将数据存储在map里，再转换成json类型数据
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", code);
			JSONObject json = JSONObject.fromObject(map);// 将map对象转换成json类型数据
			result = json.toString();// 给result赋值，传递给页面
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public class SendEmail {
		// 发件人的邮箱和密码
		private final String myEmailAccount = "1136260155@qq.com";
		private final String myEmailPassword = "zbimuzevzctmjabi";

		// 收件人邮箱
		private String receiveMailAccount = null;
		// 信息内容
		private String info = null;

		public void setReceiveMailAccount(String receiveMailAccount) {
			this.receiveMailAccount = receiveMailAccount;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		// 发件人邮箱的SMTP服务器地址
		private String myEmailSMTPServer = "smtp.qq.com";

		public void Send() throws Exception {
			// 1.
			Properties props = new Properties(); // 参数配置
			props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
			props.setProperty("mail.smtp.host", myEmailSMTPServer); // 发件人的邮箱的
																	// SMTP
																	// 服务器地址
			props.setProperty("mail.smtp.auth", "true"); // 需要请求认证

			final String smtpPort = "465";
			props.setProperty("mail.smtp.port", smtpPort);
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.socketFactory.port", smtpPort);

			// 2. 根据配置创建会话对象, 用于和邮件服务器交互
			Session session = Session.getDefaultInstance(props);
			session.setDebug(true); // 设置为debug模式, 可以查看详细的发送 log

			// 3. 创建一封邮件
			MimeMessage message = createMessage(session, myEmailAccount, receiveMailAccount, info);

			// 4. 根据 Session 获取邮件传输对象
			Transport transport = session.getTransport();

			// 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
			transport.connect(myEmailAccount, myEmailPassword);

			// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients()
			// 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
			transport.sendMessage(message, message.getAllRecipients());

			// 7. 关闭连接
			transport.close();
		}

		public MimeMessage createMessage(Session session, String sendMail, String receiveMail, String info)
				throws Exception {
			// 1. 创建一封邮件
			MimeMessage message = new MimeMessage(session);

			// 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
			message.setFrom(new InternetAddress(sendMail, "跳蚤市场", "UTF-8"));

			// 3. To: 收件人（可以增加多个收件人、抄送、密送）
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "xx用户", "UTF-8"));

			// 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
			message.setSubject("跳蚤市场欢迎小哥哥和小姐姐", "UTF-8");

			// 5. Content:
			// 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
			message.setContent("【您的验证码】:" + info, "text/html;charset=UTF-8");

			// 6. 设置发件时间
			message.setSentDate(new Date());

			// 7. 保存设置
			message.saveChanges();

			return message;
		}

	}

}

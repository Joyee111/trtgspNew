package com.sinosoft.filter;

import com.sinosoft.base.Constants;
import com.sinosoft.user.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginFilter extends HttpServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String url=request.getServletPath();
        String contextPath=request.getContextPath();
        if(url.equals("")) url+="/";
        if(url.startsWith("/")&&!url.contains("/index.html")&&!url.endsWith("shirologin.html")
                &&!url.endsWith("loginError.html")&&!url.endsWith("slogout.html")){//若访问后台资源 过滤到login
            User user= (User) session.getAttribute(Constants.LOCAL_USER);
            if(user==null){//转入管理员登陆页面
                java.io.PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<script>");
                out.println("window.open ('"+contextPath+"/index.html?errorMessage=session timeout','_top')");
                out.println("</script>");
                out.println("</html>");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

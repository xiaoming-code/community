package life.majiang.community;

import life.majiang.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/**")
public class MyFilter implements Filter
{
    @Autowired
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("过滤器处理中...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy()
    {

    }
}

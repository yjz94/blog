package cn.fishland.blog.filter;


import org.apache.log4j.Logger;
import org.slf4j.spi.LoggerFactoryBinder;

import javax.servlet.*;
import java.io.IOException;

/**
 * 权限过滤，所有访问后台管理API都会被过滤
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/20 10:46 下午
 */
public class AuthorityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Logger logger = Logger.getLogger(AuthorityFilter.class);
        logger.info("AuthorityFilter run...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

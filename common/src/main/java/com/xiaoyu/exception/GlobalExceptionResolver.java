package com.xiaoyu.exception;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.domain.AjaxMessageEntity;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;

/**
 * @author shkstart@create 2019-09-30 23:48
 */
public class GlobalExceptionResolver extends SimpleMappingExceptionResolver {

    private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    private final static BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

    private final static TemplateHashModel staticModels = wrapper.getStaticModels();

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        //如果是页面请求
        if (!(request.getHeader("accept").contains("application/json") || (request.getHeader("X-Requested-With") != null && request
                .getHeader("X-Requested-With").contains("XMLHttpRequest")))) {
            // 如果不是异步请求
            LOGGER.error("请求页面出现异常,跳转到错误页面", ex);
            ModelAndView modelAndView = new ModelAndView("error");
//            modelAndView.addObject(CoreCommonCode.TEXTUTIL,registerTmplateModel(CoreCommonCode.TEXTUTILClCLASS));
//            Locale locale = LocaleContextHolder.getLocale();
//            modelAndView.addObject(CoreCommonCode.LANG, locale.getLanguage()+"-"+locale.getCountry());
//            modelAndView.addObject(CoreCommonCode.CONSTANTCLASSUTIL,registerTmplateModel(CoreCommonCode.CONSTANTCLASSUTILCLASS));
            return modelAndView;
        } else {

            try {
                LOGGER.error("请求json出现异常",ex);
                AjaxMessageEntity<Map> ajaxMessageEntity=new AjaxMessageEntity<Map>();
                if(ex instanceof DefinitionException){
                    DefinitionException DefinitionException=(DefinitionException)ex;
                    ajaxMessageEntity.setMessager(1, DefinitionException.getExceptionMsg());
                }else{
                    ajaxMessageEntity.setMessager(1, "请求出错");
                }
                response.setContentType("application/json;charset=UTF-8");
                writer = response.getWriter();
                writer.write(JSON.toJSONString(ajaxMessageEntity));
//                writer.flush();
            } catch (IOException e) {
                LOGGER.error("请求出现异常",e);
            } finally{
                if(writer!=null){
                    writer.close();
                }
            }

        }
        return null;
    }

}

/**
 * @Title: DynamicDataSourceAspect.java
 * @Package com.xingyun.xyb2b.admin.db
 * @Description: TODO(用一句话描述该文件做什么)
 * @author bond
 * @date 2016年9月2日 上午11:04:16
 * @company 版权所有 深圳市天行云供应链有限公司
 * @version V1.0
 */
package db;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author bond
 * @ClassName: DynamicDataSourceAspect
 * @Description: 数据源AOP, 实现数据源切换
 * @Order(-10) 设置优先级, 保证该AOP在@Transactional之前执行
 * @date 2016年9月2日 上午11:04:16
 */
@Aspect
@Order(-10)
@Component
public class DynamicDataSourceAspect {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    /**
     * @return void    返回类型
     * @throws
     * @Title: dbCut
     * @Description:
     * @author Administrator
     */
    @Pointcut("execution(* com.xingyun.linkiebuy.*.service..*.*(..))")
    public void dbCut() {
    }

    /**
     * @param @param  point
     * @param @throws Throwable  参数说明
     * @return void    返回类型
     * @throws
     * @Title: changeDataSource
     * @Description: 在方法执行之前进行执行：
     * @author Administrator
     */
    @Before("dbCut()")
    public void changeDataSource(JoinPoint point) throws Throwable {
        MethodSignature ms = (MethodSignature) point.getSignature();
        String methodName = ms.getMethod().getName();
        if (methodName.startsWith("insert") || methodName.startsWith("save") || methodName.startsWith("delete")
                || methodName.startsWith("update") || methodName.startsWith("modify") || methodName.startsWith("add")) {
            logger.info("捕获到方法 " + methodName + "切换数据源至【master】");
            // 找到的话，那么设置到动态数据源上下文中。
            DbContextHolder.setDataSourceType("master");
        } else {
            logger.info("捕获到方法 " + methodName + "切换数据源至【slave】");
            DbContextHolder.setDataSourceType("slave");
        }
    }

}

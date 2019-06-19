/**
 * @Title: RoutingDataSource.java
 * @Package com.xingyun.xyb2b.admin.db
 * @Description: TODO(用一句话描述该文件做什么)
 * @author bond
 * @date 2016年9月2日 上午10:55:24
 * @company 版权所有 深圳市天行云供应链有限公司
 * @version V1.0
 */
package db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName: RoutingDataSource
 * @Description: 动态切换数据源
 * @author bond
 * @date 2016年9月2日 上午10:55:24
 *
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    /** (non-Javadoc)
     * @see AbstractRoutingDataSource#determineCurrentLookupKey()
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDataSourceType();
    }
}

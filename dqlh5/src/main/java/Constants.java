/**
 * 常量参数
 * 
 * @author cunxing
 *
 */
public interface Constants {

    String WEB_OPEN_URL="http://localhost:9999";

    String ENCRYPT_KEY="12345678";

    String UTF8 = "UTF-8";

    /**
     * 动网Id
     */
    long DW_ID = 45423;

    /**
     * redis库 分配
     */
    int REDIS_DBINDEX_MYBATIS = 5;// 基础数据bean映射缓存（即mybatis的二级缓存）

    int REDIS_DBINDEX = 6;// 本项目中用到的除mybatis二级缓存的其他缓存

    /**
     * 系统应用ID 用于区分权限配置信息
     */
    int SYS_APP_ID = 1;// 1分销系统，参考ds0库中的sys_app表

    String DS0 = "ds0";

    String DS2 = "ds2";

    String APP = "app";

    String DATE_FMT = "yyyy-MM-dd";

    String DATE_TIME_FMT = "yyyy-MM-dd HH:mm:ss";

    String DATE_HOUR_MINUTE_FMT = "yyyy-MM-dd HH:mm";

    String HOUR_MINUTE_FMT = "HH:mm";

    String YEAR_MONTH_FMT = "yyyy-MM";

    String YEAR_MONTH_ZN_FMT = "yyyy年MM月";

    String MONTH_DAY_FMT = "MM月dd日";

    String SESSION_FORCE_LOGOUT_KEY = "forceLogout";

    public static final Long APP_ID = 1L;

    public static final String APP_SECRET = "F3D59C3912C2AFCCE1E55EE55BB0D26C";

    public static final String APP_DES_SECRET = "F3D59C39";

    public static final Long PRODCUT_SET_ID = 1L;

}

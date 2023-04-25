package com.jfinal.cur.config;

import com.jfinal.config.*;
import com.jfinal.cur.model._MappingKit;
import com.jfinal.cur.routes.FrontRoutes;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/3/31 17:26
 */
public class CurConfig extends JFinalConfig {

    /**
     * 启动入口，运行此 main 方法可以启动项目，此 main 方法可以放置在任意的 Class 类定义中，不一定要放于此
     * @param args
     */
    public static void main(String[] args) {
        UndertowServer.start(CurConfig.class);
    }

    static Prop prop;

    static void loadConfig() {
        if(prop == null){
            prop = PropKit.useFirstFound("demo-config-dev.txt");
        }
    }

    public static DruidPlugin createDruidPlugin() {
        loadConfig();
        return new DruidPlugin(prop.get("jdbcUrl"), prop.get("user"), prop.get("password"));
    }

    /**
     * 配置常量
     * @param constants
     */
    @Override
    public void configConstant(Constants constants) {
        loadConfig();
        constants.setDevMode(prop.getBoolean("devMode", false));
        //支持 Controller、Interceptor、Validator 之中使用 @Inject 注入业务层，并且自动实现 AOP
        constants.setInjectDependency(true);
        // 配置对超类中的属性进行注入
        constants.setInjectSuperClass(true);
    }

    /**
     * 配置路由
     * @param routes
     */
    @Override
    public void configRoute(Routes routes) {
        routes.scan("com.jfinal.cur.");
        routes.add(new FrontRoutes());
    }

    /**
     * 配置模板引擎
     * @param engine
     */
    @Override
    public void configEngine(Engine engine) {
        engine.addSharedFunction("/common/commonIndex.html");
        engine.addSharedFunction("/common/commonHome.html");
    }

    /**
     * 配置插件
     * @param plugins
     */
    @Override
    public void configPlugin(Plugins plugins) {
        //配置Druid数据库连接池插件
        DruidPlugin druidPlugin = new DruidPlugin(prop.get("jdbcUrl"), prop.get("user"), prop.get("password"));
        plugins.add(druidPlugin);

        //配置ActiveRecord插件
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);
        plugins.add(activeRecordPlugin);

        //所有映射在MappingKit自动完成
        _MappingKit.mapping(activeRecordPlugin);
        plugins.add(activeRecordPlugin);
    }

    /**
     * 配置拦截器
     * @param interceptors
     */
    @Override
    public void configInterceptor(Interceptors interceptors) {
    }

    /**
     * 配置处理器
     * @param handlers
     */
    @Override
    public void configHandler(Handlers handlers) {

    }
}
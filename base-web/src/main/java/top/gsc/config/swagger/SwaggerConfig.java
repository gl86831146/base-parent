package top.gsc.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger UI 配置类，用于自定义 API 文档的配置信息。
 */
@Configuration
public class SwaggerConfig {

    /**
     * 自定义 OpenAPI 配置信息。
     *
     * @return OpenAPI 实例，包含 API 文档的配置信息。
     */
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("通用权限管理系统API") // API 文档标题
                        .contact(new Contact()
                                .name("gsc") // 联系人姓名
                                .email("2813314009@qq.com")) // 联系人邮箱
                        .version("1.0") // API 版本
                        .description("通用权限管理系统接口文档") // API 文档描述
                        .license(new License()
                                .name("Apache 2.0") // 许可证名称
                                .url("http://doc.xiaominfo.com"))); // 许可证 URL
    }
}

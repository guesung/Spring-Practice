package news;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class NewsWebConfig implements WebMvcConfigurer {
  @Value("${news.img.dir}") /* @ annotaino을 이용하여 Application.yml에 접근 가능 */
  private String imgDir;     /* 위에서 얻어온 값이 imgDir에 저장됨 */

  @Override
  public void addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry registry) { /* WebMvcConfigurer 인터페이스의 addResourceHandlers 메서드를 오버라이딩 */
    registry.addResourceHandler("/img/**").addResourceLocations("file:" + imgDir);
  }
  /*    코드 설명 : /img/** 경로로 들어오는 요청을 file: + imgDir 경로로 매핑  */
}

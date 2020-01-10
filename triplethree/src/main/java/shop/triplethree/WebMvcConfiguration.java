package shop.triplethree;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class WebMvcConfiguration {
@Bean
public CommonsMultipartResolver multipartResolver() {
	CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	commonsMultipartResolver.setDefaultEncoding("UTF-8");
	commonsMultipartResolver.setMaxUploadSizePerFile(5*1024*124);
	return commonsMultipartResolver;
}
}

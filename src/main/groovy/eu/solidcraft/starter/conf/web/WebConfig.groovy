package eu.solidcraft.starter.conf.web

import groovy.transform.TypeChecked
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.json.MappingJackson2JsonView
import org.thymeleaf.spring4.SpringTemplateEngine
import org.thymeleaf.spring4.view.ThymeleafViewResolver
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import org.thymeleaf.templateresolver.ITemplateResolver

@TypeChecked
@Configuration
@EnableWebMvc
class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController('/error').setViewName('error')
    }

    @Override
    void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler('/images/**').addResourceLocations('classpath:/public/images/')
        registry.addResourceHandler('/css/**').addResourceLocations('classpath:/public/css/')
        registry.addResourceHandler('/js/**').addResourceLocations('classpath:/public/js/')
        registry.addResourceHandler('/assets/**').addResourceLocations('classpath:/public/assets/')
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.
                mediaTypes(['json': MediaType.APPLICATION_JSON, 'html':MediaType.TEXT_HTML]).
                defaultContentType(MediaType.TEXT_HTML)

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver thymeleafViewResolver = createThymeleafViewResolver()
        registry.enableContentNegotiation(true, new MappingJackson2JsonView())
        registry.viewResolver(thymeleafViewResolver)
    }

    private ThymeleafViewResolver createThymeleafViewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver()
        thymeleafViewResolver.setCharacterEncoding('UTF-8')
        thymeleafViewResolver.setOrder(1)
        thymeleafViewResolver.setTemplateEngine(createTemplateEngine())
        return thymeleafViewResolver
    }

    private SpringTemplateEngine createTemplateEngine() {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine()
        springTemplateEngine.setTemplateResolver(createTemplateResolver())
        return springTemplateEngine
    }

    private ClassLoaderTemplateResolver createTemplateResolver() {
        ITemplateResolver templateResolver = new ClassLoaderTemplateResolver()
        templateResolver.setPrefix('templates/')
        templateResolver.setSuffix('.html')
        templateResolver.setTemplateMode('HTML5')
        templateResolver.setCharacterEncoding('UTF-8')
        templateResolver.setCacheable(false)
        return templateResolver
    }

}

package com.sj.webflow.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

	@Autowired
	private WebConfig webMvcConfig;

	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		return getFlowDefinitionRegistryBuilder(flowBuilderServices())
				.addFlowLocation("/WEB-INF/flows/pizza-flow.xml", "pizza")
				.addFlowLocation("/WEB-INF/flows/cust-flow.xml", "pizza/customer")
				.addFlowLocation("/WEB-INF/flows/orderFlow.xml", "pizza/order")
				.addFlowLocation("/WEB-INF/flows/payment-flow.xml", "pizza/payment")
				.build();
	}

	@Bean
	public FlowExecutor flowExecutor() {
		return getFlowExecutorBuilder(flowRegistry()).build();
	}

	@Bean
	public FlowBuilderServices flowBuilderServices() {
		return getFlowBuilderServicesBuilder().setViewFactoryCreator(mvcViewFactoryCreator()).setDevelopmentMode(true)
				.build();
	}

	@Bean
	public MvcViewFactoryCreator mvcViewFactoryCreator() {
		MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
		factoryCreator.setViewResolvers(Collections.singletonList(this.webMvcConfig.viewResolver()));
		factoryCreator.setUseSpringBeanBinding(true);
		return factoryCreator;
	}
}

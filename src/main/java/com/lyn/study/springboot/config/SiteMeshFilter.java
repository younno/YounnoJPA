package com.lyn.study.springboot.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SiteMeshFilter extends ConfigurableSiteMeshFilter {
	 
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
       builder.addDecoratorPath("/*", "/layout/main.jsp");
    }
}


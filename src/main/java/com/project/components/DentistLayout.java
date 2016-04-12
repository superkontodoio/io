package com.project.components;

import com.google.common.collect.ImmutableMap;
import com.project.pages.Index;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.func.Tuple;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Layout component for pages of application test-project.
 */
@Import(module="bootstrap/collapse")
public class DentistLayout
{
  @Inject
  private ComponentResources resources;

  /**
   * The page title, for the <title> element and the <h1> element.
   */
  @Property
  @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
  private String title;

  @Property
  private String pageName;

  @Property
  @Inject
  @Symbol(SymbolConstants.APPLICATION_VERSION)
  private String appVersion;



}

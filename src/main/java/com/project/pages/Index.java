package com.project.pages;


import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.HttpError;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.slf4j.Logger;

import java.util.Date;

/**
 * Start page of application.
 */
public class Index
{
  @Inject
  private Logger logger;

  @InjectPage
  private About about;

  @Inject
  private Block block;


  @Log
  void onComplete()
  {
    logger.info("Complete call on Index page");
  }
}

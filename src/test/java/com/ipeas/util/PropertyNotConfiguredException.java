// COPYRIGHT HEADER
//------------------------------------------------------------
// Copyright 2014 Time Warner Cable, Inc.
//
//
// This module contains unpublished, confidential, proprietary
// material.  The use and dissemination of this material are
// governed by a license.  The above copyright notice does not
// evidence any actual or intended publication of this material.
//
// Created:
// File: PropertyNotConfiguredException.java
//------------------------------------------------------------
// COPYRIGHT END

package com.ipeas.util;

/**
 * Exception to denote the invalid configuration of properties defined in
 * glueserver.properties file.
 * 
 */
public class PropertyNotConfiguredException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message = null;

	public PropertyNotConfiguredException() {
		super();
	}

	public PropertyNotConfiguredException(String message) {
		super(message);
		this.message = message;
	}

	public PropertyNotConfiguredException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
